package com.vernite.cal.serviceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.repository.CstatementsRepositoty;

public class StatementServiceImpl {

	@Autowired
	private CstatementsRepositoty cstatementsRepositoty;

	public StatementResponse getStatementDetails(String date) throws ParseException {

		LocalDate parsedDate = LocalDate.parse(date);
		// 17-05-55

		Optional<Cstatements> byCycledate = cstatementsRepositoty.findByCycledate(parsedDate);

		byCycledate.get().getTotalcredits();
		byCycledate.get().getTotaldebits();
		byCycledate.get().getTotalcredits();
		byCycledate.get().getOverdueamount();
		byCycledate.get().getPrintduedate();
		byCycledate.get().getMindueamount();
		byCycledate.get().getClosingbalance();
		byCycledate.get().getDuedate();

		StatementResponse st = new StatementResponse();
		st.setTotalcredits(byCycledate.get().getTotalcredits());
		st.setTotaldebits(byCycledate.get().getTotaldebits());
		st.setOverdueamount(byCycledate.get().getOverdueamount());
		st.setPrintduedate(byCycledate.get().getPrintduedate());
		st.setMindueamount(byCycledate.get().getMindueamount());
		st.setClosingbalance(byCycledate.get().getClosingbalance());
		st.setDuedate(byCycledate.get().getDuedate());

		return st;
	}

//	public StatementResponse getStatement(String date) throws ParseException {
//
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm-dd-yyyy");
//		// 17-05-55
//
//		Date parse = simpleDateFormat.parse(date);
//
//		Cstatements statementsData = cstatementsRepositoty.findByCycledate(parse);
////		if (statementsData == null) {
////
////			throw new com.vernite.cal.exception.BadRequestException("statement data not found");
////		}
//
//		statementsData.getTotaldebits();
//
//		statementsData.getTotalcredits();
//		statementsData.getOverdueamount();
//		statementsData.getPrintduedate();
//		statementsData.getMindueamount();
//		statementsData.getClosingbalance();
//		statementsData.getDuedate();
//
//		StatementResponse st = new StatementResponse();
//
//		st.setTotalcredits(statementsData.getTotalcredits());
//		st.setTotaldebits(statementsData.getTotaldebits());
//		st.setClosingbalance(statementsData.getClosingbalance());
//		st.setMindueamount(statementsData.getMindueamount());
//		st.setPrintduedate(statementsData.getPrintduedate());
//		st.setDuedate(statementsData.getDuedate());
//
//		return st;
//	}
}
