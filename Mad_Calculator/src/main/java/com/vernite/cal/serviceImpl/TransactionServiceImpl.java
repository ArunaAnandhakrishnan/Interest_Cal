package com.vernite.cal.serviceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vernite.cal.dto.TransactionDetailsDto;
import com.vernite.cal.model.Ctransactions;
import com.vernite.cal.repository.CtransactionsRepository;

public class TransactionServiceImpl {

	@Autowired
	private CtransactionsRepository ctransactionsRepository;

	public TransactionDetailsDto getTransactionDetails(Long serno) throws SQLException {

		Optional<Ctransactions> transactionData = ctransactionsRepository.findById(serno);

		BigDecimal i004_amt_trxn = transactionData.get().getI004_amt_trxn();
		Date i013_trxn_date = transactionData.get().getI013_trxn_date();
		String i048_text_data = transactionData.get().getI048_text_data();

		BigDecimal i006_amt_bill = transactionData.get().getI006_amt_bill();

		TransactionDetailsDto dto = new TransactionDetailsDto();

		dto.setI004_amt_trxn(i004_amt_trxn);
		dto.setI048_text_data(i048_text_data);
		dto.setI013_trxn_date(i013_trxn_date);
		dto.setI048_text_data(i048_text_data);

		return dto;

	}
}
