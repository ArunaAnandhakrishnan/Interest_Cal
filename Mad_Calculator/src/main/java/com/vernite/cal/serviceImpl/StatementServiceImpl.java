package com.vernite.cal.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.repository.CstatementsRepositoty;

@Service
public class StatementServiceImpl {

	@Autowired
	private CstatementsRepositoty cstatementsRepositoty;

	public StatementResponse getStatementDetails(Date cycleDate) throws ParseException {

		Optional<Cstatements> byCycledate = cstatementsRepositoty.findByCycledate(cycleDate);

		byCycledate.get().getTotalcredits();
		byCycledate.get().getTotaldebits();
		byCycledate.get().getTotalcredits();
		byCycledate.get().getOverdueamount();
		byCycledate.get().getPrintduedate();
		byCycledate.get().getMindueamount();
		byCycledate.get().getClosingbalance();
		byCycledate.get().getDuedate();
		byCycledate.get().getOpeningbalance();

		StatementResponse st = new StatementResponse();
		
		st.setTotalcredits(byCycledate.get().getTotalcredits());
		st.setTotaldebits(byCycledate.get().getTotaldebits());
		st.setOverdueamount(byCycledate.get().getOverdueamount());
		st.setPrintduedate(byCycledate.get().getPrintduedate());
		st.setMindueamount(byCycledate.get().getMindueamount());
		st.setClosingbalance(byCycledate.get().getClosingbalance());
		st.setDuedate(byCycledate.get().getDuedate());
		st.setOpeningbalance(byCycledate.get().getOpeningbalance());

		return st;
	}

	public Cstatements getStatementByNumberx(Long numberx) {

		Optional<Cstatements> findById = cstatementsRepositoty.findById(numberx);

		if (findById.isPresent()) {
			Cstatements statement = findById.get();
			Long serno = statement.getSerno();

			Date date = statement.getCycledate();

			if (findById.equals(date)) {

				Optional<Cstatements> statements = cstatementsRepositoty.findById(serno);

				return statement;
			} else {

				return null;
			}
		} else {

			return null;
		}

	}

}
