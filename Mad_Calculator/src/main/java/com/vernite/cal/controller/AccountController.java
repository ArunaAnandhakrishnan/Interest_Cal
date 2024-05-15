package com.vernite.cal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.vernite.cal.model.CAddresses;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.People;
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
	private StatementServiceImpl statementServiceImpl;
	@Autowired
	CardxRepository cardxRepository;
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	PeopleRepository peopleRepository;

	@GetMapping("/card")
	public ResponseEntity<?> fetchCardDetails(@RequestParam(name = "cardNumber", required = false) String cardNumber,
			@RequestParam(name = "cardSerno", required = false) Long cardSerno,
			@RequestParam(name = "custIdNumber", required = false) String cusIdNumber,
			@RequestParam(name = "mobileNo", required = false) String mobileNo)

			throws ValidationException, ParseException {
		String data = null;
		try {
			CardDetailsResponse response = null;
			if (cardNumber != null) {
				Cardx cardDetail = cardxRepository.findByNumberx(cardNumber);
				response = new CardDetailsResponse();
				if (cardDetail == null || cardDetail.equals("")) {
					data = "Card Number: " + cardNumber;
					throw new ValidationException("Please enter a valid card number.");

				} else {

					response = accountServiceImpl.getCardDeatils(cardNumber);
				}
			} else if (cardSerno != null) {
				Cardx cardDetail = cardxRepository.findBySerno(cardSerno);
				if (cardDetail == null || cardDetail.equals("")) {
					data = "Card Serno: " + cardSerno;
					throw new ValidationException("Please enter a valid card serno.");

				} else {
					response = accountServiceImpl.getCardSernoDetails(cardSerno);
				}
			} else if (mobileNo != null) {

				// Validate mobile number length
				if (mobileNo.length() != 10) {
					throw new ValidationException("Mobile number must be exactly 10 digits long.");
				}

				List<CAddresses> cAddresses = addressRepository.findByMobile(mobileNo);
				if (!cAddresses.isEmpty()) {
					// Extract the last 10 digits of the mobile number after skipping the first two
					// digits
					String processedMobileNo = mobileNo;
					if (mobileNo.length() > 10) {
						processedMobileNo = mobileNo.substring(2); // Skip first two digits
						processedMobileNo = processedMobileNo.substring(processedMobileNo.length() - 10); // Take last																					// 10 digits
					}
					// ----------
					response = accountServiceImpl.getCardDetailsByMobile(mobileNo);
				} else {
					data = "Mobile Number: " + mobileNo;
					throw new Exception();
				}
			}

			else if (cusIdNumber != null) {
				People cardDetail = peopleRepository.findByCustIdNumber(cusIdNumber);
				if (cardDetail == null || cardDetail.equals("")) {
					data = " Customer Id: " + cusIdNumber;
					throw new ValidationException("Please enter a valid custmer ID number.");
				} else {
					response = accountServiceImpl.getByPeopleSernoDetails(cardDetail.getSerno());
				}
			}

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {

			if (ex.getMessage() != null) {
				throw new ValidationException(ex.getMessage());
			}
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
			@RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate)
			throws SQLException, ParseException, DocumentException, IOException {
		byte[] downloadPDF = transactionServiceImpl.downloadPDF(cardNumber, cycleDate);
		// ---------------------
		String date = StatementServiceImpl.convertDateOne(cycleDate);
		// -------------------
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
		headers.setContentDispositionFormData("attachment", "Statement_Cycle_Date_" + date + ".xlsx"); // Change
																										// filename
																										// extension to
		// .xlsx
		headers.setContentLength(excelData.length);

		return new ResponseEntity<>(excelData, headers, HttpStatus.OK);
	}

}
