package com.vernite.cal.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.repository.CstatementsRepositoty;

@Service
public class StatementServiceImpl {

	@Autowired
	private CstatementsRepositoty cstatementsRepositoty;
	@Autowired
	private CardxRepository cardxRepository;

	public StatementResponse getStatementDetails(String cardNumber, Date cycleDate) throws ParseException {

		Cardx byCard = cardxRepository.findByNumberx(cardNumber);
		Caccounts caccounts = byCard.getCaccounts();
		Optional<Cstatements> byCycledate = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate,
				byCard.getCaccounts());

		byCycledate.get().getTotalcredits();
		byCycledate.get().getTotaldebits();
		byCycledate.get().getOverdueamount();

		Date printduedate = byCycledate.get().getPrintduedate();

		String printDueDate = convertDateOne(printduedate);

		byCycledate.get().getMindueamount();
		byCycledate.get().getClosingbalance();
		Date duedate = byCycledate.get().getDuedate();

		String dueDate = convertDateTwo(duedate);

		byCycledate.get().getOpeningbalance();
		byCycledate.get().getOverduecycles();

		StatementResponse st = new StatementResponse();

		st.setTotalcredits(byCycledate.get().getTotalcredits());
		st.setTotaldebits(byCycledate.get().getTotaldebits());
		st.setOverdueamount(byCycledate.get().getOverdueamount());
		// st.setPrintduedate(byCycledate.get().getPrintduedate());

		st.setPrintduedate(printDueDate);
		st.setMindueamount(byCycledate.get().getMindueamount());
		st.setClosingbalance(byCycledate.get().getClosingbalance());

		// st.setDuedate(byCycledate.get().getDuedate());
		st.setDuedate(dueDate);
		st.setOpeningbalance(byCycledate.get().getOpeningbalance());
		st.setOverduecycles(byCycledate.get().getOverduecycles());

		return st;
	}

	public static String convertDateOne(Date inputDate) throws ParseException {
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM-dd-yyyy");
		return outputDateFormat.format(inputDate);
	}

	public static String convertDateTwo(Date inputDate) throws ParseException {
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM-dd-yyyy");
		return outputDateFormat.format(inputDate);
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
