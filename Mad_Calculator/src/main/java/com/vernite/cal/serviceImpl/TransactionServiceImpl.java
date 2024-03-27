package com.vernite.cal.serviceImpl;

import com.itextpdf.text.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.model.*;
import com.vernite.cal.repository.*;
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

    public TransactionServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

//    public List<TransactionDetailsDto> getTransactionByDate(String cardNumber, Date cycleDate) {
//        Cardx byCard = cardxRepository.findByNumberx(cardNumber);
//
//        Caccounts caccounts = byCard.getCaccounts();
//        Optional<Cstatements> cycledates = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate,
//                byCard.getCaccounts());
////Optional<List<Cstatements>> cstatementList = cstatementsRepositoty.findBySerNo(cycledates.get().getSerno());
//        List<TransactionDetailsDto> transactionDetails = new ArrayList<>();
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//        Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalanceData(cycledates.get().getSerno(), caccounts.getSerno());
//        tbalances.ifPresent(tbalancesList -> {
//            for (Tbalances t : tbalancesList) {
//                TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
//                if (t.getOutstandingamount().compareTo(BigDecimal.ZERO) < 0) {
//                    if (t.getTrxnserno() != null) {
//                        Optional<Ctransactions> ctransactionDatas = ctransactionsRepository.findById(t.getTrxnserno());
//                        Ctransactions ctransaction = ctransactionDatas.get();
//                        transactionDetail.setDescription(ctransaction.getI048TextData());
//                        LocalDateTime localDateTime = ctransaction.getI013TrxnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                        LocalDate localDate = localDateTime.toLocalDate();
//                        String outputDateStr = outputFormatter.format(localDate);
//                        transactionDetail.setTransactionDate(outputDateStr);
//                        transactionDetail.setTransactionAmount(ctransaction.getI004AmtTrxn());
//                        transactionDetail.setBillingAmount(ctransaction.getI006AmtBill());
//                        transactionDetail.setRecType(ctransaction.getTrxntypes().getRectype());
//                        transactionDetail.setTransactionCurrency(ctransaction.getI049CurTrxn());
//                        transactionDetail.setBillingCurrency(ctransaction.getI051CurBill());
//                        transactionDetail.setOutstandingamount(t.getOutstandingamount());
//
//                        if (t.getMinpaypercentage() == null) {
//                            Optional<Products> product = productsRepository.findById(caccounts.getProduct());
//                            Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
//                            Optional<Profiles> profiles = profilesRepository.findById(mprofileacct.get().getProfiles().getSerno());
//                            Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
//                            transactionDetail.setMinpaypercentage(csetting.get().getMinpaypercentage());
//                        } else if (t.getMinpaypercentage() == 100) {
//                            transactionDetail.setMinpaypercentage(t.getMinpaypercentage());
//                        }
//
//                        transactionDetails.add(transactionDetail);
//                    } else if (t.getTrxnserno() == null) {
//                        Tbalances lastFoundBalance = null;
//                        Long currentSerno = t.getSerno();
//                        Long foundSerno = 0L;
//                        int size = 0;
//                        int firstNextBalance = 0;
//                        while (t.getTrxnserno() == null) {
//                            List<Tbalances> nextBalances = tbalancesRepository.findByNextbalanceserno(currentSerno);
//                            if (firstNextBalance == 0) {
//                                firstNextBalance = nextBalances.size();
//                            }
//                            if (!nextBalances.isEmpty()) {
//                                int secondSize = 0;
//                                for (Tbalances nextBalance : nextBalances) {
//                                    // Found trxnserno, store it in lastFoundBalance
//                                    if (foundSerno != nextBalance.getSerno() && nextBalance.getTrxnserno() != null) {
//                                        Optional<Ctransactions> ctransactions = ctransactionsRepository.findById(nextBalance.getTrxnserno());
//                                        Ctransactions ctransaction = ctransactions.get();
//                                        transactionDetail.setDescription(ctransaction.getI048TextData());
//                                        LocalDateTime localDateTime = ctransaction.getI013TrxnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                                        LocalDate localDate = localDateTime.toLocalDate();
//                                        String outputDateStr = outputFormatter.format(localDate);
//                                        transactionDetail.setTransactionDate(outputDateStr);
//                                        transactionDetail.setTransactionAmount(ctransaction.getI004AmtTrxn());
//                                        transactionDetail.setBillingAmount(ctransaction.getI006AmtBill());
//                                        transactionDetail.setRecType(ctransaction.getTrxntypes().getRectype());
//                                        transactionDetail.setTransactionCurrency(ctransaction.getI049CurTrxn());
//                                        transactionDetail.setBillingCurrency(ctransaction.getI051CurBill());
//                                        transactionDetail.setOutstandingamount(t.getOutstandingamount());
//
//                                        if (t.getMinpaypercentage() == null) {
//                                            Optional<Products> product = productsRepository.findById(caccounts.getProduct());
//                                            Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
//                                            Optional<Profiles> profiles = profilesRepository.findById(mprofileacct.get().getProfiles().getSerno());
//                                            Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
//                                            transactionDetail.setMinpaypercentage(csetting.get().getMinpaypercentage());
//
//                                        } else if (t.getMinpaypercentage() == 100) {
//                                            transactionDetail.setMinpaypercentage(t.getMinpaypercentage());
//                                        }
//                                        foundSerno = nextBalance.getSerno();
//                                        transactionDetails.add(transactionDetail);
//                                        lastFoundBalance = nextBalance;
//                                        secondSize++;
//                                        if (nextBalances.size() == secondSize) {
//                                            size++;
//                                            break;
//                                        }
//                                    } else if (nextBalance.getTrxnserno() == null) {
//                                        currentSerno = nextBalance.getSerno();
//                                        Long foundNewSerno = 0L;
//                                        int nextBalanceDataSize = 0;
//                                        int thirdSize = 0;
//                                        if (nextBalances.size() > 1 && nextBalance.getTrxnserno() == null) {
//                                            while (t.getTrxnserno() == null) {
//                                                List<Tbalances> nextBalanceData = tbalancesRepository.findByNextbalanceserno(currentSerno);
//                                                for (Tbalances data : nextBalanceData) {
//                                                    if (nextBalanceDataSize == 0) {
//                                                        nextBalanceDataSize = nextBalanceData.size();
//                                                    }
//                                                    if (foundNewSerno != data.getSerno() && data.getTrxnserno() != null) {
//                                                        Optional<Ctransactions> ctransactions = ctransactionsRepository.findById(data.getTrxnserno());
//                                                        Ctransactions ctransaction = ctransactions.get();
//                                                        transactionDetail.setDescription(ctransaction.getI048TextData());
//                                                        LocalDateTime localDateTime = ctransaction.getI013TrxnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                                                        LocalDate localDate = localDateTime.toLocalDate();
//                                                        String outputDateStr = outputFormatter.format(localDate);
//                                                        transactionDetail.setTransactionDate(outputDateStr);
//                                                        transactionDetail.setTransactionAmount(ctransaction.getI004AmtTrxn());
//                                                        transactionDetail.setBillingAmount(ctransaction.getI006AmtBill());
//                                                        transactionDetail.setRecType(ctransaction.getTrxntypes().getRectype());
//                                                        transactionDetail.setTransactionCurrency(ctransaction.getI049CurTrxn());
//                                                        transactionDetail.setBillingCurrency(ctransaction.getI051CurBill());
//                                                        transactionDetail.setOutstandingamount(t.getOutstandingamount());
//
//                                                        if (t.getMinpaypercentage() == null) {
//                                                            Optional<Products> product = productsRepository.findById(caccounts.getProduct());
//                                                            Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
//                                                            Optional<Profiles> profiles = profilesRepository.findById(mprofileacct.get().getProfiles().getSerno());
//                                                            Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
//                                                            transactionDetail.setMinpaypercentage(csetting.get().getMinpaypercentage());
//
//                                                        } else if (t.getMinpaypercentage() == 100) {
//                                                            transactionDetail.setMinpaypercentage(t.getMinpaypercentage());
//                                                        }
//                                                        foundNewSerno = data.getSerno();
//                                                        transactionDetails.add(transactionDetail);
//                                                        lastFoundBalance = nextBalance;
//                                                        thirdSize++;
//
//                                                    } else if (nextBalance.getTrxnserno() == null) {
//                                                        currentSerno = data.getSerno();
//                                                        break;
//                                                    }
//                                                }
//                                                if (nextBalanceDataSize == thirdSize) {
//                                                    secondSize++;
//                                                    break;
//                                                }
//                                            }
//
//                                        }
//                                    }
//                                }
//                                if(secondSize == nextBalances.size() ){
//                                    size++;
//                                    break;
//                                }
//                            }
//
//                            if (size == firstNextBalance) {
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        });
//        generatePdf(transactionDetails);
//        return transactionDetails;
//
//    }

    public List<TransactionDetailsDto> getTransactionByDate(String cardNumber, Date cycleDate) {
        try {
            String date = convertDateOne(cycleDate);
            Cardx byCard = cardxRepository.findByNumberx(cardNumber);

            Caccounts caccounts = byCard.getCaccounts();
            Optional<Cstatements> cycledates = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate,
                    byCard.getCaccounts());
            List<TransactionDetailsDto> transactionDetails = new ArrayList<>();
            Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalanceData(cycledates.get().getSerno(),
                    caccounts.getSerno());

            // double overlimit = cycledates.get().getCreditlimit() - cycledates.get().getClosingbalance();
            tbalances.ifPresent(tbalancesList -> {
                for (Tbalances t : tbalancesList) {
                    TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
                    if (t.getOutstandingamount().compareTo(BigDecimal.ZERO) < 0) {
                        if (t.getTrxnserno() != null) {
                            transactionDetail.setOutstandingamount(t.getOutstandingamount().abs());
                            transactionDetail.setAmount(t.getAmount().abs());
                            transactionDetail.setTrxnSerno(t.getTrxnserno());
                            if (t.getMinpaypercentage() == null) {
                                Optional<Products> product = productsRepository.findById(caccounts.getProduct());
                                Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
                                Optional<Profiles> profiles = profilesRepository
                                        .findById(mprofileacct.get().getProfiles().getSerno());
                                Optional<Cstmtsettings> csetting = cstatementSettingsRepository
                                        .findByProfiles(profiles.get());
                                transactionDetail.setMinpaypercentage(csetting.get().getMinpaypercentage());
                            } else if (t.getMinpaypercentage() == 100) {
                                transactionDetail.setMinpaypercentage(t.getMinpaypercentage());
                            }
                            BigDecimal madAmount = (t.getOutstandingamount().multiply(BigDecimal
                                    .valueOf(transactionDetail.getMinpaypercentage()).divide(BigDecimal.valueOf(100))));
                            transactionDetail.setMadAmount(madAmount.abs());
                            transactionDetail.setCycleDate(date);
                            if (cycledates.get().getClosingbalance() < 0) {
                                double calculateOverLimitAmount = Math.abs(cycledates.get().getCreditlimit()) - Math.abs(cycledates.get().getClosingbalance());
                                if (calculateOverLimitAmount < 0) {
                                    transactionDetail.setOverLimitAmount(Math.abs(calculateOverLimitAmount));
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
                }
            });
            if (transactionDetails.isEmpty()) {
                TransactionDetailsDto dt = new TransactionDetailsDto();
                dt.setOverDueAmount(Math.abs(cycledates.get().getOverdueamount()));
                if (cycledates.get().getClosingbalance() < 0) {
                    double calculateOverLimitAmount = Math.abs(cycledates.get().getCreditlimit()) - Math.abs(cycledates.get().getClosingbalance());
                    if (calculateOverLimitAmount < 0) {
                        dt.setOverLimitAmount(Math.abs(calculateOverLimitAmount));
                    } else {
                        dt.setOverLimitAmount(0.0);
                    }
                } else {
                    dt.setOverLimitAmount(0.0);
                }

                //dt.setOverLimitAmount(Math.abs(cycledates.get().getCreditlimit() - cycledates.get().getClosingbalance()));
                dt.setCycleDate(date);
                transactionDetails.add(dt);
            }
            // generatePdf(transactionDetails);
            return transactionDetails;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] downloadPDF(String cardNumber, Date cycleDate) throws ParseException {
        List<TransactionDetailsDto> transactionInfo = getTransactionByDate(cardNumber, cycleDate);
        StatementResponse response = statementServiceImpl.getStatementDetails(cardNumber, cycleDate);
        for (TransactionDetailsDto transaction : transactionInfo) {
            transaction.setMad(response.getMad());
        }
        return generatePDF(transactionInfo);
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

            // Create table
            PdfPTable table = new PdfPTable(8); // 8 columns
            table.setWidthPercentage(100);

            if (transactionDetails.size() <= 1) {
                // Add note
                PdfPCell noteCell = new PdfPCell(new Paragraph("Note: *Transaction details are not available for the selected statement -" + cycleDate));
                noteCell.setColspan(8); // Merge cells for the note
                //-------------------
                com.itextpdf.text.Font redFont = new com.itextpdf.text.Font();
                redFont.setColor(BaseColor.RED);
                Paragraph noteParagraph = new Paragraph("Note: *Transaction details are not available for the selected statement -" + cycleDate, redFont);
                noteParagraph.setAlignment(Element.ALIGN_CENTER);
                noteCell.addElement(noteParagraph);
                //-----------
                table.addCell(noteCell);
            } else {
                // Add note
                PdfPCell noteCell = new PdfPCell(new Paragraph("Note: *Selected statement transaction details -" + cycleDate));
                noteCell.setColspan(8); // Merge cells for the note
                // noteCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                // noteCell.setBackgroundColor(BaseColor.GREEN);
                //---------------
                com.itextpdf.text.Font redFont = new com.itextpdf.text.Font();
                redFont.setColor(BaseColor.GREEN);
                Paragraph noteParagraph = new Paragraph("Note: *Selected statement transaction details -" + cycleDate, redFont);
                noteParagraph.setAlignment(Element.ALIGN_CENTER);
                noteCell.addElement(noteParagraph);
                //----------------------
                table.addCell(noteCell);
            }
            // Add headers
            String[] headers = {"Trxn Serno", "Amount", "Outstanding Amount", "Minimum Pay Percentage", "Amount Contribution in MAD", "Over Due Amount", "Over Limit Amount", "MAD"};
            // Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, Color.BLACK);

            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Add data rows
//            for (TransactionDetailsDto transaction : transactionDetails) {
//                table.addCell(transaction.getTrxnSerno() != null ? String.valueOf(transaction.getTrxnSerno()) : "");
//                table.addCell(transaction.getAmount() != null ? transaction.getAmount().toString() : "");
//                table.addCell(transaction.getOutstandingamount() != null ? transaction.getOutstandingamount().toString() : "");
//                table.addCell(transaction.getMinpaypercentage() != null ? transaction.getMinpaypercentage().toString() : "");
//                table.addCell(transaction.getMadAmount() != null ? transaction.getMadAmount().toString() : "");
////                table.addCell(transaction.getOverDueAmount() != null ? transaction.getOverDueAmount().toString() : "");
////                table.addCell(transaction.getOverLimitAmount() != null ? transaction.getOverLimitAmount().toString() : "");
////                table.addCell(transaction.getMad() != null ? transaction.getMad().toString() : "");
//                table.addCell(""); // Empty cell
//                table.addCell(""); // Empty cell
//                table.addCell(""); // Empty cell
//            }

            for (int i = 0; i < transactionDetails.size(); i++) {
                TransactionDetailsDto transaction = transactionDetails.get(i);
                PdfPCell cell1 = new PdfPCell(new Paragraph(transaction.getTrxnSerno() != null ? String.valueOf(transaction.getTrxnSerno()) : ""));
                PdfPCell cell2 = new PdfPCell(new Paragraph(transaction.getAmount() != null ? transaction.getAmount().toString() : ""));
                PdfPCell cell3 = new PdfPCell(new Paragraph(transaction.getOutstandingamount() != null ? transaction.getOutstandingamount().toString() : ""));
                PdfPCell cell4 = new PdfPCell(new Paragraph(transaction.getMinpaypercentage() != null ? transaction.getMinpaypercentage().toString() : ""));
                PdfPCell cell5 = new PdfPCell(new Paragraph(transaction.getMadAmount() != null ? transaction.getMadAmount().toString() : ""));

                PdfPCell cell6, cell7, cell8;
                if (i == 0) { // Set values only in the first row
                    cell6 = new PdfPCell(new Paragraph(transaction.getOverDueAmount() != null ? transaction.getOverDueAmount().toString() : ""));
                    cell7 = new PdfPCell(new Paragraph(transaction.getOverLimitAmount() != null ? transaction.getOverLimitAmount().toString() : ""));
                    cell8 = new PdfPCell(new Paragraph(transaction.getMad() != null ? transaction.getMad().toString() : ""));
                } else {
                    cell6 = new PdfPCell(new Paragraph(""));
                    cell7 = new PdfPCell(new Paragraph(""));
                    cell8 = new PdfPCell(new Paragraph(""));
                }

                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell8.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                table.addCell(cell7);
                table.addCell(cell8);
            }
            document.add(table);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
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
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("statements");

            // Create a bold font
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex()); // Set the color to blue

            // Create a cell style with the bold font for headers
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

            // Create a cell style for data with center alignment
            CellStyle dataCellStyle = workbook.createCellStyle();
            dataCellStyle.setAlignment(HorizontalAlignment.CENTER);

            // Create a cell style for note with red font color
            CellStyle noteCellStyle = workbook.createCellStyle();
            Font noteFont = workbook.createFont();
            noteFont.setColor(IndexedColors.RED.getIndex());
            noteCellStyle.setFont(noteFont);
            noteCellStyle.setAlignment(HorizontalAlignment.CENTER);

            // Create header row and set cell values with header cell style
            Row headerRow = sheet.createRow(1); // Shifted header row down by one to accommodate the note
            String[] headers = {"Trxn Serno", "  Amount  ", "  Outstanding Amount  ", " Minimum Pay Percentage ", " Amount Contribution in MAD ", " Over Due Amount ", " Over Limit Amount ", "    MAD    "};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerCellStyle);
                // Optionally, set column width manually based on data length
                sheet.setColumnWidth(i, headers[i].length() * 256); // Adjust 256 based on your preference for column width
            }

            // Create note row above the header and set cell value with note cell style
            Row noteRow = sheet.createRow(0);
            Cell noteCell = noteRow.createCell(0);
            String cycleDate = null;
            for (TransactionDetailsDto transactionDetailsDto : transactionDetails) {
                cycleDate = transactionDetailsDto.getCycleDate();
            }
            if (transactionDetails.size() <= 1) {
                noteFont.setColor(IndexedColors.RED.getIndex());
                noteCell.setCellValue("Note: *Transaction details are not available for the selected statement -" + cycleDate);
                noteCell.setCellStyle(noteCellStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1)); // Merge cells for the note
            } else {

                noteFont.setColor(IndexedColors.GREEN.getIndex());
                noteCell.setCellValue("Note: *Selected statement transaction details -" + cycleDate);
                noteCell.setCellStyle(noteCellStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1)); // Merge cells for the note
            }
            // Populate data rows
            int rowNum = 2; // Start from the third row after the note and header
            for (TransactionDetailsDto transaction : transactionDetails) {
                Row row = sheet.createRow(rowNum++);
                if (transaction.getTrxnSerno() == null) {
                    row.createCell(0).setCellValue("");
                } else {
                    row.createCell(0).setCellValue(transaction.getTrxnSerno());
                }
                if (transaction.getAmount() == null) {
                    row.createCell(1).setCellValue("");
                } else {
                    row.createCell(1).setCellValue(transaction.getAmount().toString());
                }
                if (transaction.getOutstandingamount() == null) {
                    row.createCell(2).setCellValue("");
                } else {
                    row.createCell(2).setCellValue(transaction.getOutstandingamount() != null ? transaction.getOutstandingamount().toString() : "0");

                }
                if (transaction.getMinpaypercentage() == null) {
                    row.createCell(3).setCellValue("");

                } else {
                    row.createCell(3).setCellValue(transaction.getMinpaypercentage() != null ? transaction.getMinpaypercentage().toString() : "0");
                }
                row.createCell(4).setCellValue(transaction.getMadAmount() != null ? transaction.getMadAmount().toString() : "0");

                // Set only one value in the last three columns
                if (rowNum == 3) { // Assuming you want to set the value only in the third row (after the header and note)
                    row.createCell(5).setCellValue(transaction.getOverDueAmount() != null ? transaction.getOverDueAmount().toString() : "0");
                    row.createCell(6).setCellValue(transaction.getOverLimitAmount() != null ? transaction.getOverLimitAmount().toString() : "0");
                    row.createCell(7).setCellValue(transaction.getMad() != null ? transaction.getMad().toString() : "0");
                } else {
                    row.createCell(5).setCellValue("");
                    row.createCell(6).setCellValue("");
                    row.createCell(7).setCellValue("");
                }

                // Apply data cell style to data rows
                for (Cell cell : row) {
                    cell.setCellStyle(dataCellStyle);
                }
            }

            // Write the workbook content to a byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);
            workbook.close();

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
