package com.vernite.cal.serviceImpl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.vernite.cal.model.*;
import com.vernite.cal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.StatementResponse;

@Service
public class StatementServiceImpl {

	@Autowired
	private CstatementsRepositoty cstatementsRepositoty;
	@Autowired
	private TbalancesRepository tbalancesRepository;

	@Autowired
	private MprofileAcctRepository mprofileAcctRepository;

	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	ProfilesRepository profilesRepository;
	@Autowired
	CstatementSettingsRepository cstatementSettingsRepository;
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
		String printDueDateString = convertDateOne(printduedate);

		Date duedate = byCycledate.get().getDuedate();
		String dueDateString = convertDateTwo(duedate);

		double calculateOverLimitAmount = byCycledate.get().getCreditlimit()-byCycledate.get().getClosingbalance();

		byCycledate.get().getMindueamount();
		byCycledate.get().getClosingbalance();
		byCycledate.get().getOpeningbalance();
		byCycledate.get().getOverduecycles();
		BigDecimal mad = madCalculation(cardNumber, cycleDate);
		StatementResponse st = new StatementResponse();

		st.setTotalcredits(byCycledate.get().getTotalcredits());
		st.setTotaldebits(byCycledate.get().getTotaldebits());
		st.setOverdueamount(Math.abs(byCycledate.get().getOverdueamount()));

		st.setPrintduedate(printDueDateString);
		st.setDuedate(dueDateString);

		st.setMindueamount(Math.abs(byCycledate.get().getMindueamount()));
		st.setTad(Math.abs(byCycledate.get().getClosingbalance()));

		st.setOpeningbalance(Math.abs(byCycledate.get().getOpeningbalance()));
		st.setOverduecycles(byCycledate.get().getOverduecycles());
		st.setMad(mad);

		if (calculateOverLimitAmount < 0) {
			st.setOverLimitAmount(Math.abs(calculateOverLimitAmount));
		} else {
			st.setOverLimitAmount(0.0);
		}

		return st;
	}

	public BigDecimal madCalculation(String cardNumber, Date cycleDate) {
		Cardx byCard = cardxRepository.findByNumberx(cardNumber);
		Caccounts caccounts = byCard.getCaccounts();
		Optional<List<Cstatements>> statements = cstatementsRepositoty.findByAccounts(caccounts.getSerno());
		BigDecimal outStandingAmount = BigDecimal.ZERO;
		for (Cstatements statement : statements.get()) {
			Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalance(statement.getSerno(),
					caccounts.getSerno());
			for (Tbalances tbalancedata : tbalances.get()) {
				Long minPayPercentage = 0L;

				if (tbalancedata.getMinpaypercentage() == null) {
					Optional<Products> product = productsRepository.findById(caccounts.getProduct());
					Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
					Optional<Profiles> profiles = profilesRepository
							.findById(mprofileacct.get().getProfiles().getSerno());
					Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
					minPayPercentage = csetting.get().getMinpaypercentage();
				} else if (tbalancedata.getMinpaypercentage() == 100) {
					minPayPercentage = tbalancedata.getMinpaypercentage();
				}
				outStandingAmount = outStandingAmount.add(tbalancedata.getOutstandingamount().abs()
						.multiply(BigDecimal.valueOf(minPayPercentage)).divide(BigDecimal.valueOf(100)));
			}
		}

		return outStandingAmount;
	}

	public static String convertDateOne(Date inputDate) throws ParseException {
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return outputDateFormat.format(inputDate);
	}

	public static String convertDateTwo(Date inputDate) throws ParseException {
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
