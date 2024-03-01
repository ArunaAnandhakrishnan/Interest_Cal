package com.vernite.cal.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.service.AccountService;
import com.vernite.cal.serviceImpl.AccountServiceImpl;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountServiceImpl accountServiceImpl;

//	@GetMapping("/statements/{date}")
//	public List<Cstatements> getStatements(@PathVariable String date) throws ParseException {
//		return accountServiceImpl.getStatement(date);
//	}

	@GetMapping("/num/{numberx}")
	public CardDetailsResponse getCardData(@PathVariable String numberx) {
		CardDetailsResponse detailsResponse = accountServiceImpl.getNumberx(numberx);
		return detailsResponse;

	}

	@GetMapping("/stat/{numberx}")
	public StatementResponse getState(@PathVariable Long numberx) {
		StatementResponse statementDetails = accountServiceImpl.getStatementDetails(numberx);
		return statementDetails;
	}

	@GetMapping("/profile/{serno}")
	public ResponseEntity<String> getDesc(@PathVariable Long serno) {
		String discription = accountServiceImpl.getDiscription(serno);
		return new ResponseEntity<>(discription, HttpStatus.OK);

	}

}
