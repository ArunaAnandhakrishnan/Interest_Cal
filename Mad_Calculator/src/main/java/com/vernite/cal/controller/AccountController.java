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

	@GetMapping("/statements/{date}")
	public List<Cstatements> getStatements(@PathVariable String date) throws ParseException {
		return accountServiceImpl.getStatement(date);
	}

	@GetMapping("/card/{numberx}")
	public ResponseEntity<CardDetailsResponse> getCardNumberx(@PathVariable String numberx) {
		CardDetailsResponse cardDetails = accountServiceImpl.fetchCardDetails(numberx);
		return new ResponseEntity<CardDetailsResponse>(cardDetails, HttpStatus.OK);
	}

	@GetMapping("/account/{serno}")
	public List<Caccounts> getAllAcoount(@PathVariable long serno) {
		List<Caccounts> account = accountServiceImpl.getAccount(serno);
		return account;
	}

//	public ResponseEntity<CardDetailsResponse> getNumber(@PathVariable String numberx) {
//		// CardResponseDto cardDetails = accountServiceImpl.fetchCardDetails(numberx);
//
//		CardDetailsResponse response = accountServiceImpl.getCard(numberx);
//
//		if (response != null) {
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/cardd/{numberx}")
	public ResponseEntity<CardDetailsResponse> getNumberx(@PathVariable String numberx) {
		CardDetailsResponse cardDetails = accountServiceImpl.getCards(numberx);
		return new ResponseEntity<CardDetailsResponse>(cardDetails, HttpStatus.OK);
	}

}
