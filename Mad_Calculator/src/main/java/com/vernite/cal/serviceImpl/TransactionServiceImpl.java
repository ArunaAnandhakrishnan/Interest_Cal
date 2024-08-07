package com.vernite.cal.serviceImpl;

import com.itextpdf.text.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.model.*;
import com.vernite.cal.repository.*;
import com.vernite.cal.service.ConfigurationService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.TransactionDetailsDto;

import static com.vernite.cal.serviceImpl.StatementServiceImpl.convertDateOne;

@Service
public class TransactionServiceImpl {

    @Autowired
    private TbalancesRepository tbalancesRepository;
    @Autowired
    StatementServiceImpl statementServiceImpl;
    @Autowired
    private MprofileAcctRepository mprofileAcctRepository;
    @Autowired
    private CstatementsRepositoty cstatementsRepositoty;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    ProfilesRepository profilesRepository;
    @Autowired
    CstatementSettingsRepository cstatementSettingsRepository;
    @Autowired
    private CardxRepository cardxRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ConfigurationService configurationService;

    public TransactionServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<TransactionDetailsDto> getTransactionByDate(String cardNumber, Date cycleDate) {
        try {
            String date = convertDateOne(cycleDate);
            Caccounts caccounts = accountRepository.findByNumberx(cardNumber);
            Caccounts caccounts1;
            Cardx byCard = null;
            if (caccounts != null) {
                byCard = cardxRepository.findByCaccounts(caccounts);
                caccounts1 = caccounts;
            } else if (caccounts == null) {
                byCard = cardxRepository.findByNumberx(cardNumber);
                caccounts1 = byCard.getCaccounts();
            } else {
                caccounts1 = new Caccounts();
            }
            String cardNo = byCard.getNumberx();
            Optional<Cstatements> cycledates = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate,
                    byCard.getCaccounts());
            List<TransactionDetailsDto> transactionDetails = new ArrayList<>();
//            Optional<List<Tbalances>> tbalancess = tbalancesRepository.getTbalanceData(cycledates.get().getSerno(),
//                    caccounts1.getSerno());
            MadConfigurationDetails config = configurationService.getConfiguration();
            Optional<List<Object[]>> tbalances = tbalancesRepository.getTbalanceDatas(cycledates.get().getSerno(),
                    caccounts1.getSerno());
            List<Long> trxnSernos = tbalancesRepository.getTrxnSerno(caccounts.getSerno(),config.getSerno());

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            tbalances.ifPresent(tbalancesList -> {
                for (Object[] t : tbalancesList) {
                    Long trxnserno = ((BigDecimal) t[0]) != null ? ((BigDecimal) t[0]).longValueExact() : null;
                    String recType = (String) t[1];
                    BigDecimal amount = (BigDecimal) t[2];
                    BigDecimal outstandingamount = (BigDecimal) t[3];
                    Long minPayPercentage = ((BigDecimal) t[4]) != null ? ((BigDecimal) t[4]).longValueExact() : null;
                    if (trxnserno != null) {
                        TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
                        transactionDetail.setAccountNo(caccounts1.getNumberx());
                        transactionDetail.setCardNo(maskCardNumber(cardNo));
                        transactionDetail.setOutstandingamount(outstandingamount);
                        transactionDetail.setAmount(amount);
                        transactionDetail.setTrxnSerno(trxnserno);
                        transactionDetail.setRecType(recType);
                        if (trxnSernos.contains(trxnserno)) {
                            transactionDetail.setIsOverlimitTrxnserno("YES");
                        }
                        else{
                            transactionDetail.setIsOverlimitTrxnserno("NO");
                        }
                        if (minPayPercentage == null) {
                            Optional<Products> product = productsRepository.findById(caccounts1.getProduct());
                            Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
                            Optional<Profiles> profiles = profilesRepository
                                    .findById(mprofileacct.get().getProfiles().getSerno());
                            Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
                            transactionDetail.setMinpaypercentage(csetting.get().getMinpaypercentage());
                        } else if (minPayPercentage == 100) {
                            transactionDetail.setMinpaypercentage(minPayPercentage);
                        }
                        BigDecimal madAmount = (outstandingamount.multiply(BigDecimal
                                .valueOf(transactionDetail.getMinpaypercentage()).divide(BigDecimal.valueOf(100))));
                        if (madAmount.compareTo(BigDecimal.valueOf(0.0)) == 0) {
                            madAmount = BigDecimal.valueOf(0);
                        }
                        if (madAmount.scale() > 0 && madAmount.stripTrailingZeros().scale() <= 0) {
                            madAmount = madAmount.setScale(0); // Remove decimal places
                        }

                        transactionDetail.setMadAmount(madAmount.abs());
                        transactionDetail.setCycleDate(date);
                        if (cycledates.get().getClosingbalance() < 0) {
                            MadConfigurationDetails configs = configurationService.getConfiguration();
                            Double overlimit = tbalancesRepository.getTbalanceData(caccounts.getSerno(),cycledates.get().getSerno(),configs.getSerno());
                            Double overLimitAmount = cycledates.get().getCreditlimit() - Math.abs(overlimit);

                            if (overLimitAmount < 0) {
                                transactionDetail.setOverLimitAmount(
                                        Double.parseDouble(decimalFormat.format(Math.abs(overLimitAmount))));
                            } else {
                                transactionDetail.setOverLimitAmount(0.0);
                            }
                        } else {
                            transactionDetail.setOverLimitAmount(0.0);
                        }
                        transactionDetail.setOverDueAmount(Math.abs(cycledates.get().getOverdueamount()));
                        transactionDetails.add(transactionDetail);

                    }
                }
            });
            if (transactionDetails.isEmpty()) {
                TransactionDetailsDto dt = new TransactionDetailsDto();
                dt.setCardNo(maskCardNumber(cardNumber));
                dt.setAccountNo(caccounts1.getNumberx());
                dt.setOverDueAmount(Math.abs(cycledates.get().getOverdueamount()));
                if (cycledates.get().getClosingbalance() < 0) {
                    double calculateOverLimitAmount = Math.abs(cycledates.get().getCreditlimit())
                            - Math.abs(cycledates.get().getClosingbalance());
                    if (calculateOverLimitAmount < 0) {
                        dt.setOverLimitAmount(
                                Double.parseDouble(decimalFormat.format(Math.abs(calculateOverLimitAmount))));
                    } else {
                        dt.setOverLimitAmount(0.0);
                    }
                } else {
                    dt.setOverLimitAmount(0.0);
                }
                dt.setCycleDate(date);

                transactionDetails.add(dt);
            }
            return transactionDetails;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public byte[] downloadPDF(String cardNumber, Date cycleDate) throws ParseException {
        List<TransactionDetailsDto> transactionInfo = getTransactionByDate(cardNumber, cycleDate);
        StatementResponse response = statementServiceImpl.getStatementDetails(cardNumber, cycleDate);
        for (TransactionDetailsDto transaction : transactionInfo) {
            transaction.setAccountNo(response.getAccountNo());
            transaction.setCardNo(maskCardNumber(response.getCardNo()));
            transaction.setMad(response.getMad());
        }
        return generatePDF(transactionInfo);
    }


//    public String maskCardNumber(String cardNumber) {
//        // Check if the card number is valid and has at least 4 characters
//        if (cardNumber != null && cardNumber.length() >= 4) {
//            // Get the length of the card number
//            int length = cardNumber.length();
//
//            // Get the last four characters of the card number
//            String lastFourDigits = cardNumber.substring(length - 4);
//
//            // Mask the remaining digits with asterisks
//            String maskedDigits = "*".repeat(length - 4);
//
//            // Combine the masked digits and the last four digits
//            return maskedDigits + lastFourDigits;
//        } else {
//            // Invalid card number, return empty string or handle the error as needed
//            return "";
//        }
//    }

    public String maskCardNumber(String cardNumber) {
        // Check if the card number is valid and has at least 8 characters
        if (cardNumber != null && cardNumber.length() >= 8) {
            // Get the length of the card number
            int length = cardNumber.length();

            // Get the first four characters of the card number
            String firstFourDigits = cardNumber.substring(0, 4);

            // Get the last four characters of the card number
            String lastFourDigits = cardNumber.substring(length - 4);

            // Mask the remaining digits with asterisks
            String maskedDigits = "*".repeat(length - 8);

            // Combine the masked digits, first four digits, and last four digits
            return firstFourDigits + maskedDigits + lastFourDigits;
        } else {
            // Invalid card number, return empty string or handle the error as needed
            return "";
        }
    }


    public byte[] generatePDF(List<TransactionDetailsDto> transactionDetails) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate());
        String cycleDate = null;

        for (TransactionDetailsDto transactionDetailsDto : transactionDetails) {
            cycleDate = transactionDetailsDto.getCycleDate();
        }

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            // Add a new line
            document.add(new Paragraph("\n"));

            // Add note
            if (transactionDetails.size() <= 1) {
                PdfPTable noteTable = new PdfPTable(1);
                PdfPCell noteCell = new PdfPCell(
                        new Paragraph("Note: *Transaction details are not available for the selected statement -" + cycleDate));
                noteCell.setBorder(0); // Remove border
                noteCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                noteTable.addCell(noteCell);
                document.add(noteTable);
            } else {
                PdfPTable noteTable = new PdfPTable(1);
                PdfPCell noteCell = new PdfPCell(
                        new Paragraph("Note: *Selected statement transaction details -" + cycleDate));
                noteCell.setBorder(0); // Remove border
                noteCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                noteTable.addCell(noteCell);
                document.add(noteTable);
            }
            // Add space between tables
            document.add(new Paragraph("\n")); // Empty paragraph

            PdfPTable cardTable = new PdfPTable(2);
            cardTable.setWidthPercentage(100);
            cardTable.setWidths(new float[]{1, 1});

            // Add headers
            String[] secondaryHeader = {"Account No", "Card No"};
            for (String header : secondaryHeader) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cardTable.addCell(cell);
            }
            TransactionDetailsDto getAmountData = transactionDetails.get(0);
            
         // Debug
//            System.out.println("Account No from DTO:------------------------- " + getAmountData.getAccountNo());
//            System.out.println("Card No from DTO:-----------------------------" + getAmountData.getCardNo());
            
            PdfPCell accountNoCell = new PdfPCell(new Paragraph(
                    getAmountData.getAccountNo() != null ? getAmountData.getAccountNo().toString() : ""));
            accountNoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cardTable.addCell(accountNoCell);
            
            PdfPCell cardNoCell = new PdfPCell(new Paragraph(
                    getAmountData.getCardNo() != null ? getAmountData.getCardNo().toString() : ""));
            cardNoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cardTable.addCell(cardNoCell);

            document.add(cardTable);

            // Add space between tables
            document.add(new Paragraph("\n")); // Empty paragraph or


            // Create secondary table for Over Due Amount, Over Limit Amount, and MAD
            PdfPTable secondaryTable = new PdfPTable(3);
            secondaryTable.setWidthPercentage(100);
            secondaryTable.setWidths(new float[]{1, 1, 1});

            // Add headers
            String[] secondaryHeaders = {"Over Due Amount", "Over Limit Amount", "MAD"};
            for (String header : secondaryHeaders) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                secondaryTable.addCell(cell);
            }

            // Add data row
            // Assuming the data is available in the first transactionDetailsDto
            TransactionDetailsDto firstTransaction = transactionDetails.get(0);
            PdfPCell overDueAmountCell = new PdfPCell(new Paragraph(
                    firstTransaction.getOverDueAmount() != null ? firstTransaction.getOverDueAmount().toString() : ""));
            overDueAmountCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            secondaryTable.addCell(overDueAmountCell);
            PdfPCell overLimitAmountCell = new PdfPCell(new Paragraph(
                    firstTransaction.getOverLimitAmount() != null ? firstTransaction.getOverLimitAmount().toString()
                            : ""));
            overLimitAmountCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            secondaryTable.addCell(overLimitAmountCell);
            PdfPCell madCell = new PdfPCell(new Paragraph(
                    firstTransaction.getMad() != null ? firstTransaction.getMad().toString() : ""));
            madCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            secondaryTable.addCell(madCell);

            document.add(secondaryTable);

            // Add space between tables
            document.add(new Paragraph("\n")); // Empty paragraph or

            // Create main table
            PdfPTable mainTable = new PdfPTable(7); // 8 columns
            mainTable.setWidthPercentage(100);

            // Add headers
            String[] headers = {"Trxn Serno","Rec Type", "Amount", "Outstanding Amount", "Minimum Pay Percentage",
                    "Amount Contribution in MAD","Eligible For OverLimit"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(cell);
            }

            // Add data rows
            for (TransactionDetailsDto transaction : transactionDetails) {
                PdfPCell trxnSernoCell = new PdfPCell(new Paragraph(
                        transaction.getTrxnSerno() != null ? String.valueOf(transaction.getTrxnSerno()) : ""));
                trxnSernoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(trxnSernoCell);
                
                PdfPCell rectType = new PdfPCell(new Paragraph(
                        transaction.getRecType() != null ? String.valueOf(transaction.getRecType()) : ""));
                rectType.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(rectType);

                PdfPCell amountCell = new PdfPCell(new Paragraph(
                        transaction.getAmount() != null ? transaction.getAmount().toString() : ""));
                amountCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(amountCell);

                PdfPCell outstandingAmountCell = new PdfPCell(new Paragraph(
                        transaction.getOutstandingamount() != null ? transaction.getOutstandingamount().toString()
                                : ""));
                outstandingAmountCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(outstandingAmountCell);

                PdfPCell minPayPercentageCell = new PdfPCell(new Paragraph(
                        transaction.getMinpaypercentage() != null ? transaction.getMinpaypercentage().toString() : ""));
                minPayPercentageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(minPayPercentageCell);

                PdfPCell madAmountCell = new PdfPCell(new Paragraph(
                        String.valueOf(transaction.getMadAmount() != null ? transaction.getMadAmount().toString() : 0)));
                madAmountCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(madAmountCell);
                
                PdfPCell eligibleForOverlimit = new PdfPCell(new Paragraph(
                        String.valueOf(transaction.getIsOverlimitTrxnserno() != null ? transaction.getIsOverlimitTrxnserno().toString() : 0)));
                eligibleForOverlimit.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(eligibleForOverlimit);
                
            }
            
//            isOverlimitTrxnserno

            document.add(mainTable);

        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }


    public byte[] downloadExcel(String cardNumber, Date cycleDate) throws ParseException {
        List<TransactionDetailsDto> transactionInfo = getTransactionByDate(cardNumber, cycleDate);
        StatementResponse response = statementServiceImpl.getStatementDetails(cardNumber, cycleDate);
        for (TransactionDetailsDto transaction : transactionInfo) {
            transaction.setMad(response.getMad());
        }
        return generateExcel(transactionInfo);
    }


    public byte[] generateExcel(List<TransactionDetailsDto> transactionDetails) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("statements");

            // Create styles and fonts
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
            headerCellStyle.setBorderBottom(BorderStyle.THIN);
            headerCellStyle.setBorderLeft(BorderStyle.THIN);
            headerCellStyle.setBorderRight(BorderStyle.THIN);
            headerCellStyle.setBorderTop(BorderStyle.THIN);

            CellStyle dataCellStyle = workbook.createCellStyle();
            dataCellStyle.setAlignment(HorizontalAlignment.CENTER);
            dataCellStyle.setBorderBottom(BorderStyle.THIN);
            dataCellStyle.setBorderLeft(BorderStyle.THIN);
            dataCellStyle.setBorderRight(BorderStyle.THIN);
            dataCellStyle.setBorderTop(BorderStyle.THIN);

            CellStyle noteCellStyle = workbook.createCellStyle();
            Font noteFont = workbook.createFont();
            noteCellStyle.setAlignment(HorizontalAlignment.CENTER);
            noteCellStyle.setFont(noteFont);

            // Create note row
            Row noteRow = sheet.createRow(0);
            Cell noteCell = noteRow.createCell(0);
            String cycleDate = transactionDetails.isEmpty() ? "Default Date" : transactionDetails.get(0).getCycleDate();
            noteCell.setCellValue(transactionDetails.size() <= 1 ?
                    "Note: *Transaction details are not available for the selected statement - " + cycleDate :
                    "Note: *Selected statement transaction details - " + cycleDate);
            noteCell.setCellStyle(noteCellStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4)); // Merge cells for the note

            // Create Table 1 (Account No and Mask Card No)
            Row table1HeaderRow = sheet.createRow(1);
            String[] table1Headers = {"Account No", "Card No"};
            for (int i = 0; i < table1Headers.length; i++) {
                Cell cell = table1HeaderRow.createCell(i);
                cell.setCellValue(table1Headers[i]);
                cell.setCellStyle(headerCellStyle);
            }
            Row table1DataRow = sheet.createRow(2);
            table1DataRow.createCell(0).setCellValue(transactionDetails.get(0).getAccountNo());
            table1DataRow.createCell(1).setCellValue(transactionDetails.get(0).getCardNo());
            for (Cell cell : table1DataRow) {
                cell.setCellStyle(dataCellStyle); // Center-align data in Table 1
            }
            for (int i = 0; i < table1Headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Create Table 2 (Overdue Amount, Overlimit Amount, MAD)
            Row table2HeaderRow = sheet.createRow(4);
            String[] table2Headers = {"Overdue Amount", "Overlimit Amount", "MAD"};
            for (int i = 0; i < table2Headers.length; i++) {
                Cell cell = table2HeaderRow.createCell(i);
                cell.setCellValue(table2Headers[i]);
                cell.setCellStyle(headerCellStyle);
            }
            Row table2DataRow = sheet.createRow(5);
            table2DataRow.createCell(0).setCellValue(transactionDetails.get(0).getOverDueAmount());
            table2DataRow.createCell(1).setCellValue(transactionDetails.get(0).getOverLimitAmount());
            table2DataRow.createCell(2).setCellValue(transactionDetails.get(0).getMad() != null ? transactionDetails.get(0).getMad().toString() : "");
            for (Cell cell : table2DataRow) {
                cell.setCellStyle(dataCellStyle); // Center-align data in Table 2
            }
            for (int i = 0; i < table2Headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Create Table 3 (Transaction Details)
            Row table3HeaderRow = sheet.createRow(9);
            String[] table3Headers = {"Trxn Serno","Rec Type", "Amount", "Outstanding Amount", "Minimum Pay Percentage", "Amount Contribution in MAD","Eligible For OverLimit"};
            for (int i = 0; i < table3Headers.length; i++) {
                Cell cell = table3HeaderRow.createCell(i);
                cell.setCellValue(table3Headers[i]);
                cell.setCellStyle(headerCellStyle);
            }
            int rowNum = 10; // Start row for Table 3 data
            for (TransactionDetailsDto transaction : transactionDetails) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(Objects.toString(transaction.getTrxnSerno(), ""));
                row.createCell(1).setCellValue(Objects.toString(transaction.getRecType(), ""));
                row.createCell(2).setCellValue(Objects.toString(transaction.getAmount(), ""));
                row.createCell(3).setCellValue(Objects.toString(transaction.getOutstandingamount(), ""));
                row.createCell(4).setCellValue(Objects.toString(transaction.getMinpaypercentage(), ""));
                row.createCell(5).setCellValue(Objects.toString(transaction.getMadAmount(), ""));
                row.createCell(6).setCellValue(Objects.toString(transaction.getIsOverlimitTrxnserno(), ""));
                for (Cell cell : row) {
                    cell.setCellStyle(dataCellStyle);
                }
            }
            for (int i = 0; i < table3Headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write workbook content to byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
