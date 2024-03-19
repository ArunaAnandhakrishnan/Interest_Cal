package com.vernite.cal.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	public ResponseEntity<CardDetailsResponse> fetchCardDetails(@PathVariable String numberx) throws ParseException {
		CardDetailsResponse response = accountServiceImpl.getCardDeatils(numberx);
		return new ResponseEntity<CardDetailsResponse>(response, HttpStatus.OK);

	}

	@GetMapping("/statement/{numberx}")
	public StatementResponse getState(@PathVariable String numberx, @RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate)
			throws ParseException {
		StatementResponse details = statementServiceImpl.getStatementDetails(numberx,cycleDate);
		return details;
	}

	@GetMapping("/transaction/{cardNumber}")
	public ResponseEntity<List<TransactionDetailsDto>> getTransaction(@PathVariable String cardNumber,
																@RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate) throws SQLException {
		List<TransactionDetailsDto> detailsDto = transactionServiceImpl.getTransactionByDate(cardNumber,cycleDate);
		return new ResponseEntity<List<TransactionDetailsDto>>(detailsDto, HttpStatus.OK);

	}
	@GetMapping("/downloadPdf/{cardNumber}")
	public ResponseEntity<byte[]> downloadPdf(@PathVariable String cardNumber,
																	  @RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate) throws SQLException {
		byte[] detailsDto = transactionServiceImpl.downloadPdf(cardNumber,cycleDate);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "transaction_details.pdf");
		headers.setContentLength(detailsDto.length);
		return new ResponseEntity<byte[]>(detailsDto, headers, HttpStatus.OK);

	}

}
