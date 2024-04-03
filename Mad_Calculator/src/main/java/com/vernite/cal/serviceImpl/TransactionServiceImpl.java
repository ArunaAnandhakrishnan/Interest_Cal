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
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            // double overlimit = cycledates.get().getCreditlimit() -
            // cycledates.get().getClosingbalance();
            tbalances.ifPresent(tbalancesList -> {
                for (Tbalances t : tbalancesList) {
                    TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
                    transactionDetail.setAccountNo(caccounts.getNumberx());
                    transactionDetail.setCardNo(maskCardNumber(cardNumber));
                    transactionDetail.setOutstandingamount(t.getOutstandingamount().abs());
                    transactionDetail.setAmount(t.getAmount().abs());
                    transactionDetail.setTrxnSerno(t.getTrxnserno());
                    if (t.getMinpaypercentage() == null) {
                        Optional<Products> product = productsRepository.findById(caccounts.getProduct());
                        Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
                        Optional<Profiles> profiles = profilesRepository
                                .findById(mprofileacct.get().getProfiles().getSerno());
                        Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
                        transactionDetail.setMinpaypercentage(csetting.get().getMinpaypercentage());
                    } else if (t.getMinpaypercentage() == 100) {
                        transactionDetail.setMinpaypercentage(t.getMinpaypercentage());
                    }
                    BigDecimal madAmount = (t.getOutstandingamount().multiply(BigDecimal
                            .valueOf(transactionDetail.getMinpaypercentage()).divide(BigDecimal.valueOf(100))));
                    transactionDetail.setMadAmount(madAmount.abs());
                    transactionDetail.setCycleDate(date);
                    if (cycledates.get().getClosingbalance() < 0) {
                        double calculateOverLimitAmount = Math.abs(cycledates.get().getCreditlimit())
                                - Math.abs(cycledates.get().getClosingbalance());
                        if (calculateOverLimitAmount < 0) {
                            transactionDetail.setOverLimitAmount(
                                    Double.parseDouble(decimalFormat.format(Math.abs(calculateOverLimitAmount))));
                        } else {
                            transactionDetail.setOverLimitAmount(0.0);
                        }
                    } else {
                        transactionDetail.setOverLimitAmount(0.0);
                    }
                    transactionDetail.setOverDueAmount(Math.abs(cycledates.get().getOverdueamount()));
                    transactionDetails.add(transactionDetail);

                }
            });
            if (transactionDetails.isEmpty()) {
                TransactionDetailsDto dt = new TransactionDetailsDto();
                dt.setCardNo(maskCardNumber(cardNumber));
                dt.setAccountNo(caccounts.getNumberx());
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
            PdfPTable noteTable = new PdfPTable(1);
            PdfPCell noteCell = new PdfPCell(
                    new Paragraph("Note: *Selected statement transaction details -" + cycleDate));
            noteCell.setBorder(0); // Remove border
            noteCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            noteTable.addCell(noteCell);
            document.add(noteTable);

            // Add space between tables
            document.add(new Paragraph("\n")); // Empty paragraph

            PdfPTable cardTable = new PdfPTable(2);
            cardTable.setWidthPercentage(100);
            cardTable.setWidths(new float[]{1, 1});

            // Add headers
            String[] secondaryHeader = {"Account No", "Mask Card Number"};
            for (String header : secondaryHeader) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cardTable.addCell(cell);
            }
            TransactionDetailsDto getAmountData = transactionDetails.get(0);
            cardTable.addCell(
                    getAmountData.getAccountNo() != null ? getAmountData.getAccountNo().toString() : "");
            cardTable.addCell(
                    getAmountData.getCardNo() != null ? getAmountData.getCardNo().toString() : "");

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
            secondaryTable.addCell(
                    firstTransaction.getOverDueAmount() != null ? firstTransaction.getOverDueAmount().toString() : "");
            secondaryTable.addCell(
                    firstTransaction.getOverLimitAmount() != null ? firstTransaction.getOverLimitAmount().toString()
                            : "");
            secondaryTable.addCell(firstTransaction.getMad() != null ? firstTransaction.getMad().toString() : "");

            document.add(secondaryTable);

            // Add space between tables
            document.add(new Paragraph("\n")); // Empty paragraph or

            // Create main table
            PdfPTable mainTable = new PdfPTable(5); // 8 columns
            mainTable.setWidthPercentage(100);

            // Add headers
            String[] headers = {"Trxn Serno", "Amount", "Outstanding Amount", "Minimum Pay Percentage",
                    "Amount Contribution in MAD"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mainTable.addCell(cell);
            }

            // Add data rows
            for (TransactionDetailsDto transaction : transactionDetails) {
                mainTable.addCell(transaction.getTrxnSerno() != null ? String.valueOf(transaction.getTrxnSerno()) : "");
                mainTable.addCell(transaction.getAmount() != null ? transaction.getAmount().toString() : "");
                mainTable.addCell(
                        transaction.getOutstandingamount() != null ? transaction.getOutstandingamount().toString()
                                : "");
                mainTable.addCell(
                        transaction.getMinpaypercentage() != null ? transaction.getMinpaypercentage().toString() : "");
                mainTable.addCell(transaction.getMadAmount() != null ? transaction.getMadAmount().toString() : "");

            }
            
            

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

//	public byte[] generateExcel(List<TransactionDetailsDto> transactionDetails) {
//		try {
//			Workbook workbook = new XSSFWorkbook();
//			Sheet sheet = workbook.createSheet("statements");
//
//			// Create a bold font
//			Font headerFont = workbook.createFont();
//			headerFont.setBold(true);
//			headerFont.setColor(IndexedColors.BLUE.getIndex()); // Set the color to blue
//
//			// Create a cell style with the bold font for headers
//			CellStyle headerCellStyle = workbook.createCellStyle();
//			headerCellStyle.setFont(headerFont);
//			headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//			// Create a cell style for data with center alignment
//			CellStyle dataCellStyle = workbook.createCellStyle();
//			dataCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//			// Create a cell style for note with red font color
//			CellStyle noteCellStyle = workbook.createCellStyle();
//			Font noteFont = workbook.createFont();
//			noteFont.setColor(IndexedColors.RED.getIndex());
//			noteCellStyle.setFont(noteFont);
//			noteCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//			// Create header row and set cell values with header cell style
//			Row headerRow = sheet.createRow(1); // Shifted header row down by one to accommodate the note
//			String[] headers = { "Trxn Serno", "  Amount  ", "  Outstanding Amount  ", " Minimum Pay Percentage ",
//					" Amount Contribution in MAD ", " Over Due Amount ", " Over Limit Amount ", "    MAD    " };
//			for (int i = 0; i < headers.length; i++) {
//				Cell cell = headerRow.createCell(i);
//				cell.setCellValue(headers[i]);
//				cell.setCellStyle(headerCellStyle);
//				// Optionally, set column width manually based on data length
//				sheet.setColumnWidth(i, headers[i].length() * 256); // Adjust 256 based on your preference for column
//																	// width
//			}
//
//			// Create note row above the header and set cell value with note cell style
//			Row noteRow = sheet.createRow(0);
//			Cell noteCell = noteRow.createCell(0);
//			String cycleDate = null;
//			for (TransactionDetailsDto transactionDetailsDto : transactionDetails) {
//				cycleDate = transactionDetailsDto.getCycleDate();
//			}
//			if (transactionDetails.size() <= 1) {
//				noteFont.setColor(IndexedColors.RED.getIndex());
//				noteCell.setCellValue(
//						"Note: *Transaction details are not available for the selected statement -" + cycleDate);
//				noteCell.setCellStyle(noteCellStyle);
//				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1)); // Merge cells for the note
//			} else {
//
//				noteFont.setColor(IndexedColors.GREEN.getIndex());
//				noteCell.setCellValue("Note: *Selected statement transaction details -" + cycleDate);
//				noteCell.setCellStyle(noteCellStyle);
//				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1)); // Merge cells for the note
//			}
//			// Populate data rows
//			int rowNum = 2; // Start from the third row after the note and header
//			for (TransactionDetailsDto transaction : transactionDetails) {
//				Row row = sheet.createRow(rowNum++);
//				if (transaction.getTrxnSerno() == null) {
//					row.createCell(0).setCellValue("");
//				} else {
//					row.createCell(0).setCellValue(transaction.getTrxnSerno());
//				}
//				if (transaction.getAmount() == null) {
//					row.createCell(1).setCellValue("");
//				} else {
//					row.createCell(1).setCellValue(transaction.getAmount().toString());
//				}
//				if (transaction.getOutstandingamount() == null) {
//					row.createCell(2).setCellValue("");
//				} else {
//					row.createCell(2)
//							.setCellValue(transaction.getOutstandingamount() != null
//									? transaction.getOutstandingamount().toString()
//									: "0");
//
//				}
//				if (transaction.getMinpaypercentage() == null) {
//					row.createCell(3).setCellValue("");
//
//				} else {
//					row.createCell(3)
//							.setCellValue(transaction.getMinpaypercentage() != null
//									? transaction.getMinpaypercentage().toString()
//									: "0");
//				}
//				row.createCell(4)
//						.setCellValue(transaction.getMadAmount() != null ? transaction.getMadAmount().toString() : "0");
//
//				// Set only one value in the last three columns
//				if (rowNum == 3) { // Assuming you want to set the value only in the third row (after the header
//									// and note)
//					row.createCell(5).setCellValue(
//							transaction.getOverDueAmount() != null ? transaction.getOverDueAmount().toString() : "0");
//					row.createCell(6)
//							.setCellValue(transaction.getOverLimitAmount() != null
//									? transaction.getOverLimitAmount().toString()
//									: "0");
//					row.createCell(7)
//							.setCellValue(transaction.getMad() != null ? transaction.getMad().toString() : "0");
//				} else {
//					row.createCell(5).setCellValue("");
//					row.createCell(6).setCellValue("");
//					row.createCell(7).setCellValue("");
//				}
//
//				// Apply data cell style to data rows
//				for (Cell cell : row) {
//					cell.setCellStyle(dataCellStyle);
//				}
//			}
//
//			
//			
//			
//			// Write the workbook content to a byte array
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			workbook.write(byteArrayOutputStream);
//			workbook.close();
//
//			return byteArrayOutputStream.toByteArray();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}



//    public byte[] generateExcel(List<TransactionDetailsDto> transactionDetails) {
//        try {
//            Workbook workbook = new XSSFWorkbook();
//            Sheet sheet = workbook.createSheet("statements");
//
//            // Create a bold font
//            Font headerFont = workbook.createFont();
//            headerFont.setBold(true);
//            headerFont.setColor(IndexedColors.BLUE.getIndex()); // Set the color to blue
//
//            // Create a cell style with the bold font for headers
//            CellStyle headerCellStyle = workbook.createCellStyle();
//            headerCellStyle.setFont(headerFont);
//            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//            // Create a cell style for data with center alignment
//            CellStyle dataCellStyle = workbook.createCellStyle();
//            dataCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//            // Create a cell style for note with red font color
//            CellStyle noteCellStyle = workbook.createCellStyle();
//            Font noteFont = workbook.createFont();
//            noteFont.setColor(IndexedColors.RED.getIndex());
//            noteCellStyle.setFont(noteFont);
//            noteCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//            // Create header row and set cell values with header cell style
//            Row headerRow = sheet.createRow(1); // Shifted header row down by one to accommodate the note
//            String[] headers = {"Trxn Serno", "  Amount  ", "  Outstanding Amount  ", " Minimum Pay Percentage ",
//                    " Amount Contribution in MAD "};
//            for (int i = 0; i < headers.length; i++) {
//                Cell cell = headerRow.createCell(i);
//                cell.setCellValue(headers[i]);
//                cell.setCellStyle(headerCellStyle);
//                // Optionally, set column width manually based on data length
//                sheet.setColumnWidth(i, headers[i].length() * 256); // Adjust 256 based on your preference for column width
//            }
//
//            // Create note row above the header and set cell value with note cell style
//            Row noteRow = sheet.createRow(0);
//            Cell noteCell = noteRow.createCell(0);
//            String cycleDate = null;
//            for (TransactionDetailsDto transactionDetailsDto : transactionDetails) {
//                cycleDate = transactionDetailsDto.getCycleDate();
//            }
//            if (transactionDetails.size() <= 1) {
//                noteFont.setColor(IndexedColors.RED.getIndex());
//                noteCell.setCellValue(
//                        "Note: *Transaction details are not available for the selected statement -" + cycleDate);
//                noteCell.setCellStyle(noteCellStyle);
//                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1)); // Merge cells for the note
//            } else {
//
//                noteFont.setColor(IndexedColors.GREEN.getIndex());
//                noteCell.setCellValue("Note: *Selected statement transaction details -" + cycleDate);
//                noteCell.setCellStyle(noteCellStyle);
//                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1)); // Merge cells for the note
//            }
//
//            // Populate data rows for the main table
//            int rowNum = 2; // Start from the third row after the note and header
//            for (TransactionDetailsDto transaction : transactionDetails) {
//                Row row = sheet.createRow(rowNum++);
//                if (transaction.getTrxnSerno() == null) {
//                    row.createCell(0).setCellValue("");
//                } else {
//                    row.createCell(0).setCellValue(transaction.getTrxnSerno());
//                }
//                if (transaction.getAmount() == null) {
//                    row.createCell(1).setCellValue("");
//                } else {
//                    row.createCell(1).setCellValue(transaction.getAmount().toString());
//                }
//                if (transaction.getOutstandingamount() == null) {
//                    row.createCell(2).setCellValue("");
//                } else {
//                    row.createCell(2).setCellValue(transaction.getOutstandingamount().toString());
//                }
//                if (transaction.getMinpaypercentage() == null) {
//                    row.createCell(3).setCellValue("");
//                } else {
//                    row.createCell(3).setCellValue(transaction.getMinpaypercentage().toString());
//                }
//                row.createCell(4).setCellValue(transaction.getMadAmount() != null ? transaction.getMadAmount().toString() : "");
//                // Apply data cell style to data rows
//                for (Cell cell : row) {
//                    cell.setCellStyle(dataCellStyle);
//                }
//            }
//
//            // Write the workbook content to a byte array
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            workbook.write(byteArrayOutputStream);
//            workbook.close();
//
//            return byteArrayOutputStream.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public byte[] generateExcel(List<TransactionDetailsDto> transactionDetails) {
//        try (Workbook workbook = new XSSFWorkbook()) {
//            Sheet sheet = workbook.createSheet("statements");
//
//            // Create styles and fonts
//            Font headerFont = workbook.createFont();
//            headerFont.setBold(true);
//            headerFont.setColor(IndexedColors.BLUE.getIndex());
//
//            CellStyle headerCellStyle = workbook.createCellStyle();
//            headerCellStyle.setFont(headerFont);
//            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//
//            CellStyle dataCellStyle = workbook.createCellStyle();
//            dataCellStyle.setAlignment(HorizontalAlignment.CENTER);
//
//            CellStyle noteCellStyle = workbook.createCellStyle();
//            Font noteFont = workbook.createFont();
//            noteCellStyle.setAlignment(HorizontalAlignment.CENTER);
//            noteCellStyle.setFont(noteFont);
//
//            // Create note row
//            Row noteRow = sheet.createRow(0);
//            Cell noteCell = noteRow.createCell(0);
//            String cycleDate = transactionDetails.isEmpty() ? "Default Date" : transactionDetails.get(0).getCycleDate();
//            noteCell.setCellValue(transactionDetails.size() <= 1 ?
//                    "Note: *Transaction details are not available for the selected statement - " + cycleDate :
//                    "Note: *Selected statement transaction details - " + cycleDate);
//            noteCell.setCellStyle(noteCellStyle);
//            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4)); // Merge cells for the note
//
//            // Create Table 1 (Account No and Mask Card No)
//            Row table1HeaderRow = sheet.createRow(1);
//            String[] table1Headers = {"			Account No			", "		Mask Card No		"};
//            for (int i = 0; i < table1Headers.length; i++) {
//                Cell cell = table1HeaderRow.createCell(i);
//                cell.setCellValue(table1Headers[i]);
//                cell.setCellStyle(headerCellStyle);
//            }
//            Row table1DataRow = sheet.createRow(2);
//            table1DataRow.createCell(0).setCellValue(transactionDetails.get(0).getAccountNo());
//            table1DataRow.createCell(1).setCellValue(transactionDetails.get(0).getCardNo());
//            for (Cell cell : table1DataRow) {
//                cell.setCellStyle(dataCellStyle); // Center-align data in Table 1
//            }
//            // Create Table 2 (Overdue Amount, Overlimit Amount, MAD)
//            Row table2HeaderRow = sheet.createRow(4);
//            String[] table2Headers = {"			Overdue Amount			", "	Overlimit Amount	", "		MAD			"};
//            for (int i = 0; i < table2Headers.length; i++) {
//                Cell cell = table2HeaderRow.createCell(i);
//                cell.setCellValue(table2Headers[i]);
//                cell.setCellStyle(headerCellStyle);
//            }
//            Row table2DataRow = sheet.createRow(5);
//            table2DataRow.createCell(0).setCellValue(transactionDetails.get(0).getOverDueAmount());
//            table2DataRow.createCell(1).setCellValue(transactionDetails.get(0).getOverLimitAmount());
//            table2DataRow.createCell(2).setCellValue(transactionDetails.get(0).getMad()!= null ? transactionDetails.get(0).getMad().toString() : "");
//            for (Cell cell : table2DataRow) {
//                cell.setCellStyle(dataCellStyle); // Center-align data in Table 1
//            }
//
//            // Create Table 3 (Transaction Details)
//            Row table3HeaderRow = sheet.createRow(7);
//            String[] table3Headers = {"		Trxn Serno		", "	Amount	 ", "	Outstanding Amount	", "	Minimum Pay Percentage	", "	Amount Contribution in MAD	"};
//            for (int i = 0; i < table3Headers.length; i++) {
//                Cell cell = table3HeaderRow.createCell(i);
//                cell.setCellValue(table3Headers[i]);
//                cell.setCellStyle(headerCellStyle);
//            }
//            int rowNum = 8; // Start row for Table 3 data
//            for (TransactionDetailsDto transaction : transactionDetails) {
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellValue(Objects.toString(transaction.getTrxnSerno(), ""));
//                row.createCell(1).setCellValue(Objects.toString(transaction.getAmount(), ""));
//                row.createCell(2).setCellValue(Objects.toString(transaction.getOutstandingamount(), ""));
//                row.createCell(3).setCellValue(Objects.toString(transaction.getMinpaypercentage(), ""));
//                row.createCell(4).setCellValue(Objects.toString(transaction.getMadAmount(), ""));
//                for (Cell cell : row) {
//                    cell.setCellStyle(dataCellStyle);
//                }
//            }
//
//
//            // Write workbook content to byte array
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            workbook.write(byteArrayOutputStream);
//            return byteArrayOutputStream.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

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
            String[] table1Headers = {"Account No", "Mask Card No"};
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
            table2DataRow.createCell(2).setCellValue(transactionDetails.get(0).getMad()!= null ? transactionDetails.get(0).getMad().toString() : "");
            for (Cell cell : table2DataRow) {
                cell.setCellStyle(dataCellStyle); // Center-align data in Table 2
            }
            for (int i = 0; i < table2Headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Create Table 3 (Transaction Details)
            Row table3HeaderRow = sheet.createRow(7);
            String[] table3Headers = {"Trxn Serno", "Amount", "Outstanding Amount", "Minimum Pay Percentage", "Amount Contribution in MAD"};
            for (int i = 0; i < table3Headers.length; i++) {
                Cell cell = table3HeaderRow.createCell(i);
                cell.setCellValue(table3Headers[i]);
                cell.setCellStyle(headerCellStyle);
            }
            int rowNum = 8; // Start row for Table 3 data
            for (TransactionDetailsDto transaction : transactionDetails) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(Objects.toString(transaction.getTrxnSerno(), ""));
                row.createCell(1).setCellValue(Objects.toString(transaction.getAmount(), ""));
                row.createCell(2).setCellValue(Objects.toString(transaction.getOutstandingamount(), ""));
                row.createCell(3).setCellValue(Objects.toString(transaction.getMinpaypercentage(), ""));
                row.createCell(4).setCellValue(Objects.toString(transaction.getMadAmount(), ""));
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
