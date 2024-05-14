package com.vernite.cal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.itextpdf.text.DocumentException;
import com.vernite.cal.dto.CardDetailsDto;
import com.vernite.cal.model.CAddresses;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.People;
import com.vernite.cal.repository.AccountRepository;
import com.vernite.cal.repository.AddressRepository;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.dto.TransactionDetailsDto;
import com.vernite.cal.serviceImpl.AccountServiceImpl;
import com.vernite.cal.serviceImpl.StatementServiceImpl;
import com.vernite.cal.serviceImpl.TransactionServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    PeopleRepository peopleRepository;
    @Autowired
    private StatementServiceImpl statementServiceImpl;
    @Autowired
    CardxRepository cardxRepository;
    @Autowired
    private TransactionServiceImpl transactionServiceImpl;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/card")
    public ResponseEntity<CardDetailsResponse> fetchCardDetails(@RequestBody CardDetailsDto cardDetails) throws ValidationException, ParseException {
        String data = null;
        try {
            CardDetailsResponse response = null;

            if (cardDetails.getCardNumber() != null) {

                Cardx cardDetail = cardxRepository.findByNumberx(cardDetails.getCardNumber());
                response = new CardDetailsResponse();
                if (cardDetails == null || cardDetails.equals("")) {
                    throw new Exception();

                } else {
                    data = "Card Number: "+cardDetails.getCardNumber();
                    response = accountServiceImpl.getCardDeatils(cardDetails.getCardNumber());
                }
            } else if (cardDetails.getCardSerno() != null) {

                Cardx cardDetail = cardxRepository.findBySerno(cardDetails.getCardSerno());
                if (cardDetails == null || cardDetails.equals("")) {
                    throw new Exception();

                } else {
                    data = "Card Serno: "+ cardDetails.getCardSerno();
                    response = accountServiceImpl.getCardSernoDetails(cardDetails.getCardSerno());
                }
            } else if (cardDetails.getMobileNo() != null) {
                List<CAddresses> cAddresses = addressRepository.findByMobile(cardDetails.getMobileNo());
                if (!cAddresses.isEmpty()) {
                    data = "Mobile Number: "+ cardDetails.getMobileNo();
                    response = accountServiceImpl.getCardDetailsByMobile(cardDetails.getMobileNo());
                }
            } else if (cardDetails.getCustIdNumber() != null) {
                People cardDetail = peopleRepository.findByCustidnumber(cardDetails.getCustIdNumber());
                if (cardDetails == null || cardDetails.equals("")) {
                    throw new Exception();

                } else {
                    data = "Customer Id: "+ cardDetails.getCustIdNumber();
                    response = accountServiceImpl.getCardSernoDetails(cardDetails.getCardSerno());
                }
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ValidationException("Card details not found for this" + data);
        }
    }


    @GetMapping("/statement/{numberx}")
    public StatementResponse getState(@PathVariable String numberx,
                                      @RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate) throws ParseException {
        StatementResponse details = statementServiceImpl.getStatementDetails(numberx, cycleDate);
        return details;
    }

    @GetMapping("/transaction/{cardNumber}")
    public ResponseEntity<List<TransactionDetailsDto>> getTransaction(@PathVariable String cardNumber,
                                                                      @RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate) throws SQLException {
        List<TransactionDetailsDto> detailsDto = transactionServiceImpl.getTransactionByDate(cardNumber, cycleDate);
        return new ResponseEntity<List<TransactionDetailsDto>>(detailsDto, HttpStatus.OK);

    }

    @GetMapping("/downloadPdf/{cardNumber}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable String cardNumber,
                                              @RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate) throws SQLException, ParseException, DocumentException, IOException {
        byte[] downloadPDF = transactionServiceImpl.downloadPDF(cardNumber, cycleDate);
        //---------------------
        String date = StatementServiceImpl.convertDateOne(cycleDate);
        //-------------------
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "Statement_Cycle_Date_" + date + ".pdf");
        headers.setContentLength(downloadPDF.length);
        return new ResponseEntity<>(downloadPDF, headers, HttpStatus.OK);

    }

    @GetMapping("/downloadExcel/{cardNumber}")
    public ResponseEntity<byte[]> downloadExcel(@PathVariable String cardNumber,
                                                @RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate) throws ParseException {
        byte[] excelData = transactionServiceImpl.downloadExcel(cardNumber, cycleDate);

        String date = StatementServiceImpl.convertDateOne(cycleDate);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // Setting content type to octet-stream for Excel
        headers.setContentDispositionFormData("attachment", "Statement_Cycle_Date_" + date + ".xlsx"); // Change filename extension to
        // .xlsx
        headers.setContentLength(excelData.length);

        return new ResponseEntity<>(excelData, headers, HttpStatus.OK);
    }

}
