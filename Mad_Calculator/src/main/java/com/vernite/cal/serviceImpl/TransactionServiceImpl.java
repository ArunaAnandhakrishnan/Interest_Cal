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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.TransactionDetailsDto;
import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.model.Ctransactions;
import com.vernite.cal.model.Tbalances;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.repository.CstatementsRepositoty;
import com.vernite.cal.repository.CtransactionsRepository;
import com.vernite.cal.repository.TbalancesRepository;
import com.vernite.cal.repository.TrxntypesRepository;

@Service
public class TransactionServiceImpl {

    @Autowired
    private CtransactionsRepository ctransactionsRepository;

    @Autowired
    private TbalancesRepository tbalancesRepository;

    @Autowired
    private TrxntypesRepository trxntypesRepository;
    @Autowired
    private CstatementsRepositoty cstatementsRepositoty;

    @Autowired
    private CardxRepository cardxRepository;
    private final ObjectMapper objectMapper;

    public TransactionServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<TransactionDetailsDto> getTransactionByDate(String cardNumber, Date cycleDate) {
        Cardx byCard = cardxRepository.findByNumberx(cardNumber);

        Caccounts caccounts = byCard.getCaccounts();
        Optional<Cstatements> cycledates = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate,
                byCard.getCaccounts());
//Optional<List<Cstatements>> cstatementList = cstatementsRepositoty.findBySerNo(cycledates.get().getSerno());
        List<TransactionDetailsDto> transactionDetails = new ArrayList<>();
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalanceData(cycledates.get().getSerno(), caccounts.getSerno());
        tbalances.ifPresent(tbalancesList -> {
            for (Tbalances t : tbalancesList) {
                TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
                if (t.getOutstandingamount().compareTo(BigDecimal.ZERO) < 0) {
                    if (t.getTrxnserno() != null) {
                        Optional<Ctransactions> ctransactionDatas = ctransactionsRepository.findById(t.getTrxnserno());
                        Ctransactions ctransaction = ctransactionDatas.get();
                        transactionDetail.setDescription(ctransaction.getI048TextData());
                        LocalDateTime localDateTime = ctransaction.getI013TrxnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                        LocalDate localDate = localDateTime.toLocalDate();
                        String outputDateStr = outputFormatter.format(localDate);
                        transactionDetail.setTransactionDate(outputDateStr);
                        transactionDetail.setTransactionAmount(ctransaction.getI004AmtTrxn());
                        transactionDetail.setBillingAmount(ctransaction.getI006AmtBill());
                        transactionDetail.setRecType(ctransaction.getTrxntypes().getRectype());
                        transactionDetail.setTransactionCurrency(ctransaction.getI049CurTrxn());
                        transactionDetail.setBillingCurrency(ctransaction.getI051CurBill());
                        transactionDetail.setOutstandingamount(t.getOutstandingamount());

                        if (t.getMinpaypercentage() == null) {

                        } else if (t.getMinpaypercentage() == 100) {
                            transactionDetail.setMinpaypercentage(t.getMinpaypercentage());
                        }

                        transactionDetails.add(transactionDetail);
                    } else if (t.getTrxnserno() == null) {
                        Tbalances lastFoundBalance = null;
                        Long currentSerno = t.getSerno();
                        Long foundSerno = 0L;
                        int size = 0;

                        while (t.getTrxnserno() == null) {
                            List<Tbalances> nextBalances = tbalancesRepository.findByNextbalanceserno(currentSerno);
                            if (!nextBalances.isEmpty()) {
                                for (Tbalances nextBalance : nextBalances) {
                                    if (nextBalance.getTrxnserno() != null) {
                                        // Found trxnserno, store it in lastFoundBalance
                                        if (foundSerno != nextBalance.getSerno()) {
                                            Optional<Ctransactions> ctransactions = ctransactionsRepository.findById(nextBalance.getTrxnserno());
                                            Ctransactions ctransaction =ctransactions.get();
                                            transactionDetail.setDescription(ctransaction.getI048TextData());
                                            LocalDateTime localDateTime = ctransaction.getI013TrxnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                                            LocalDate localDate = localDateTime.toLocalDate();
                                            String outputDateStr = outputFormatter.format(localDate);
                                            transactionDetail.setTransactionDate(outputDateStr);
                                            transactionDetail.setTransactionAmount(ctransaction.getI004AmtTrxn());
                                            transactionDetail.setBillingAmount(ctransaction.getI006AmtBill());
                                            transactionDetail.setRecType(ctransaction.getTrxntypes().getRectype());
                                            transactionDetail.setTransactionCurrency(ctransaction.getI049CurTrxn());
                                            transactionDetail.setBillingCurrency(ctransaction.getI051CurBill());
                                            transactionDetail.setOutstandingamount(t.getOutstandingamount());

                                            if (t.getMinpaypercentage() == null) {

                                            } else if (t.getMinpaypercentage() == 100) {
                                                transactionDetail.setMinpaypercentage(t.getMinpaypercentage());
                                            }
                                            foundSerno = nextBalance.getSerno();
                                            transactionDetails.add(transactionDetail);
                                            lastFoundBalance = nextBalance;
                                            size++;
                                            // Break out of the loop
                                            break;
                                        }
                                    }
                                    if(nextBalance.getTrxnserno() == null) {
                                        currentSerno = nextBalance.getSerno();
                                    }
                                }
                            }

                            if(size == nextBalances.size() ){
                                break;
                            }
                        }
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

            PdfPTable table = new PdfPTable(9);

            // Add table headers
            table.addCell("Description");
            table.addCell("Transaction Date");
            table.addCell("Transaction Amount");
            table.addCell("Transaction Currency");
            table.addCell("Billing Amount");
            table.addCell("Billing Currency");
            table.addCell("Record Type");
            table.addCell("Outstanding Amount");
            table.addCell("Minimum Pay Percentage");

            // Add transaction details to the table
            for (TransactionDetailsDto transaction : transactionDetails) {
                table.addCell(transaction.getDescription());
                table.addCell(transaction.getTransactionDate());
                table.addCell(transaction.getTransactionAmount().toString());
                table.addCell(transaction.getTransactionCurrency());
                table.addCell(transaction.getBillingAmount().toString());
                table.addCell(transaction.getBillingCurrency());
                table.addCell(transaction.getRecType());
                table.addCell(transaction.getOutstandingamount() != null ? String.valueOf(transaction.getOutstandingamount()) : "0");
                table.addCell(transaction.getMinpaypercentage() != null ? String.valueOf(transaction.getMinpaypercentage()) : "0");
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

}
