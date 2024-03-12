package com.vernite.cal.serviceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.vernite.cal.model.*;
import com.vernite.cal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import com.vernite.cal.dto.TransactionDetailsDto;

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

//	public TransactionDetailsDto getTransactionDetails(Long serno) throws SQLException {
//
//		Optional<Ctransactions> transactionData = ctransactionsRepository.findById(serno);
//
////		BigDecimal i004_amt_trxn = transactionData.get().getI004_amt_trxn();
////		Date i013_trxn_date = transactionData.get().getI013_trxn_date();
////		String i048_text_data = transactionData.get().getI048_text_data();
////		BigDecimal i006_amt_bill = transactionData.get().getI006_amt_bill();
//
//		Optional<Tbalances> balanceData = tbalancesRepository.findById(serno);
//		BigDecimal outstandingamount = balanceData.get().getOutstandingamount();
//		Long minpaypercentage = balanceData.get().getMinpaypercentage();
//
//		Optional<Trxntypes> trxnTypesData = trxntypesRepository.findById(serno);
//		String rectype = trxnTypesData.get().getRectype();
//
//		TransactionDetailsDto dto = new TransactionDetailsDto();
//
////		dto.setI004_amt_trxn(i004_amt_trxn);
////		dto.setI048_text_data(i048_text_data);
////		dto.setI013_trxn_date(i013_trxn_date);
////		dto.setI048_text_data(i048_text_data);
//
//		dto.setMinpaypercentage(minpaypercentage);
//		dto.setOutstandingamount(outstandingamount);
//		dto.setRecType(rectype);
//
//		return dto;
//
//	}

	public List<TransactionDetailsDto> getTransactionByDate(String cardNumber,Date cycleDate) {
		Cardx byCard = cardxRepository.findByNumberx(cardNumber);
		Caccounts caccounts = byCard.getCaccounts();
		Optional<Cstatements> cycledates = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate,
				byCard.getCaccounts());
		Optional<Tbalances> byId = tbalancesRepository.findById(cycledates.get().getSerno());
	//	Optional<Ctransactions> transactionInfo = ctransactionsRepository.findByCaccount(caccounts.getSerno());
	Optional<Ctransactions> transactionInfo = ctransactionsRepository.findByCaccounts(caccounts);

		List<TransactionDetailsDto> transactionDetails = new ArrayList<>();
		TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
		return transactionDetails;

	}
}
