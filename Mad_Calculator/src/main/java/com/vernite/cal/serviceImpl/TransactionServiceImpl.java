package com.vernite.cal.serviceImpl;

import com.itextpdf.text.Document;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vernite.cal.model.*;
import com.vernite.cal.repository.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.TransactionDetailsDto;

@Service
public class TransactionServiceImpl {

	@Autowired
	private TbalancesRepository tbalancesRepository;

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
		Cardx byCard = cardxRepository.findByNumberx(cardNumber);

		Caccounts caccounts = byCard.getCaccounts();
		Optional<Cstatements> cycledates = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate,
				byCard.getCaccounts());
		List<TransactionDetailsDto> transactionDetails = new ArrayList<>();
		Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalanceData(cycledates.get().getSerno(),
				caccounts.getSerno());
		tbalances.ifPresent(tbalancesList -> {
			for (Tbalances t : tbalancesList) {
				TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
				if (t.getOutstandingamount().compareTo(BigDecimal.ZERO) < 0) {
					if (t.getTrxnserno() != null) {
						transactionDetail.setOutstandingamount(t.getOutstandingamount().abs());
						transactionDetail.setAmount(t.getAmount().abs());
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
						transactionDetails.add(transactionDetail);
					}
				}
			}
		});
		generatePdf(transactionDetails);
		return transactionDetails;

	}

	public byte[] downloadPdf(String cardNumber, Date cycleDate) {
		List<TransactionDetailsDto> transactionInfo = getTransactionByDate(cardNumber, cycleDate);
		return generatePdf(transactionInfo);
	}

	public byte[] generatePdf(List<TransactionDetailsDto> transactionDetails) {
		try {
			Document document = new Document(PageSize.A4);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();

			PdfPTable table = new PdfPTable(4);

			// Add table headers

			table.addCell("Amount");
			table.addCell("Outstanding Amount");
			table.addCell("Minimum Pay Percentage");
			table.addCell("Amount Contribution in MAD");

			// Add transaction details to the table
			for (TransactionDetailsDto transaction : transactionDetails) {
				table.addCell(transaction.getAmount().toString());
				table.addCell(
						transaction.getOutstandingamount() != null ? String.valueOf(transaction.getOutstandingamount())
								: "0");
				table.addCell(
						transaction.getMinpaypercentage() != null ? String.valueOf(transaction.getMinpaypercentage())
								: "0");
				table.addCell(transaction.getMadAmount() != null ? String.valueOf(transaction.getMadAmount()) : "0");
			}

			// Add table to the document
			document.add(table);

			// Close the document
			document.close();

			// Return the generated PDF content as byte array
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	 public byte[] downloadExcel(String cardNumber, Date cycleDate) {
	        List<TransactionDetailsDto> transactionInfo = getTransactionByDate(cardNumber, cycleDate);
	        return generateExcel(transactionInfo);
	    }

	    public byte[] generateExcel(List<TransactionDetailsDto> transactionDetails) {
	        try {
	            Workbook workbook = new XSSFWorkbook();
	            
	            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("statements");            
	           
	            // Create a bold font
	            Font headerFont = workbook.createFont();
	            headerFont.setBold(true);
	            headerFont.setColor(IndexedColors.BLUE.getIndex()); // Set the color to blue

	            // Create a cell style with the bold font
	            CellStyle headerCellStyle = workbook.createCellStyle();
	            headerCellStyle.setFont(headerFont);

	            
	            Row headerRow = sheet.createRow(0);
	            headerRow.createCell(0).setCellValue("Amount");
	            headerRow.createCell(1).setCellValue("Outstanding Amount");
	            headerRow.createCell(2).setCellValue("Minimum Pay Percentage");
	            headerRow.createCell(3).setCellValue("Amount Contribution in MAD");

	            int rowNum = 1;
	            for (TransactionDetailsDto transaction : transactionDetails) {
	                Row row = sheet.createRow(rowNum++);
	                row.createCell(0).setCellValue(transaction.getAmount().toString());
	                row.createCell(1).setCellValue(transaction.getOutstandingamount() != null ? String.valueOf(transaction.getOutstandingamount()) : "0");
	                row.createCell(2).setCellValue(transaction.getMinpaypercentage() != null ? String.valueOf(transaction.getMinpaypercentage()) : "0");
	                row.createCell(3).setCellValue(transaction.getMadAmount() != null ? String.valueOf(transaction.getMadAmount()) : "0");
	            }

	            
	            for (int i = 0; i < 4; i++) {
	                sheet.autoSizeColumn(i);
	            }

	            // Write the workbook content to a byte array
	            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	            workbook.write(byteArrayOutputStream);
	            workbook.close();

	            return byteArrayOutputStream.toByteArray();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
