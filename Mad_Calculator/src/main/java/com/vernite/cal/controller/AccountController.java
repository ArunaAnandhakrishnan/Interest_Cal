package com.vernite.cal.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	private StatementServiceImpl statementServiceImpl;

	@Autowired
	private TransactionServiceImpl transactionServiceImpl;

	@GetMapping("/card/{numberx}")
	public ResponseEntity<CardDetailsResponse> fetchCardDetails(@PathVariable String numberx) {
		CardDetailsResponse response = accountServiceImpl.getCardDeatils(numberx);
		return new ResponseEntity<CardDetailsResponse>(response, HttpStatus.OK);

	}

	@GetMapping("/statement")
	public StatementResponse getState(@RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate) throws ParseException {
		StatementResponse details = statementServiceImpl.getStatementDetails(cycleDate);
		return details;
	}

	@GetMapping("/transaction")
	public ResponseEntity<TransactionDetailsDto> getTransaction(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) throws SQLException {
		TransactionDetailsDto detailsDto = transactionServiceImpl.getTransactionByDate(date);
		return new ResponseEntity<TransactionDetailsDto>(detailsDto, HttpStatus.OK);

	}

}
