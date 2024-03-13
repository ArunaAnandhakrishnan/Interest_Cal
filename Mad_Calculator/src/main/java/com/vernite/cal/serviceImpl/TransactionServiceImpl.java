package com.vernite.cal.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

//<<<<<<< Updated upstream
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
//=======
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
//		dto.setRectype(rectype);
//
//		return dto;
//
//	}
//	
////	private Date i013_trxn_date;
////	private String i048_text_data;
////	private BigDecimal i004_amt_trxn;
////	private BigDecimal i006_amt_bill;
////	
////	private BigDecimal outstandingamount;
////	private Long minpaypercentage;
////
////	private String rectype;
//	
//	public TransactionDetailsDto getTransactionByDate(Date cycleDate) {
//
//		Optional<Cstatements> cycledates = cstatementsRepositoty.findByCycledate(cycleDate);
//		
//		Optional<Tbalances> byId = tbalancesRepository.findById(cycledates.get().getSerno());
//		Long minpaypercentage = byId.get().getMinpaypercentage();
//		System.out.println(minpaypercentage);
//		
//		
//		
//
////		Long overDueAmount = cycledates.get().getOverdueamount();
////		System.out.println(overDueAmount);
//		
//		
//		
//
////		Optional<Ctransactions> transactionData = ctransactionsRepository.findById(statementSerno);
////		String i000MsgType = transactionData.get().getI000MsgType();
////		System.out.println(i000MsgType);
//
////		Optional<Tbalances> balanceData = tbalancesRepository.findById(statementSerno);
//>>>>>>> Stashed changes
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
		
		List<TransactionDetailsDto> transactionDetails = new ArrayList<>();
		
		List<Ctransactions> ctransactionsList = ctransactionsRepository.getByCaccounts(caccounts);
		for(Ctransactions trx : ctransactionsList) {
			TransactionDetailsDto transactionDetail = new TransactionDetailsDto();
			Ctransactions ctrx = new Ctransactions();
			
			transactionDetail.setDescription(trx.getI048TextData());
			transactionDetail.setTransactionDate(trx.getI013TrxnDate());
//			transactionDetail.setTransactionAmount(trx.getI004AmtTrxn());
//			transactionDetail.setBillingAmount(trx.getI006AmtBill());
			//transactionDetail.setRecType(trx.getTrxntypes().getRectype());
			transactionDetails.add(transactionDetail);
		}
		return transactionDetails;

	}
}
