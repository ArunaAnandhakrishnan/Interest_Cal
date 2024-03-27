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

        Date printduedate = byCycledate.get().getPrintduedate();
        String printDueDates = null;
        if (printduedate != null) {
            printDueDates = convertDateOne(printduedate);
        }
        Date duedate = byCycledate.get().getDuedate();

        String dueDates = null;
        if (duedate != null) {
            dueDates = convertDateTwo(duedate);
        }

        BigDecimal mad = madCalculation(cardNumber, cycleDate);
        if (mad.compareTo(BigDecimal.valueOf(100)) < 0) {
            mad = BigDecimal.valueOf(100);
        }
        StatementResponse st = new StatementResponse();
        st.setStGeneral(byCycledate.get().getStgeneral());
        st.setTotalcredits(byCycledate.get().getTotalcredits());
        st.setTotaldebits(byCycledate.get().getTotaldebits());
        st.setOverdueamount(Math.abs(byCycledate.get().getOverdueamount()));

        st.setPrintduedate(printDueDates);
        st.setDuedate(dueDates);

        st.setMindueamount(Math.abs(byCycledate.get().getMindueamount()));
        st.setTad(Math.abs(byCycledate.get().getClosingbalance()));
        st.setOpeningbalance(Math.abs(byCycledate.get().getOpeningbalance()));
        st.setOverduecycles(byCycledate.get().getOverduecycles());
        st.setMad(mad);
        if (byCycledate.get().getClosingbalance() < 0) {
            double calculateOverLimitAmount = Math.abs(byCycledate.get().getCreditlimit()) - Math.abs(byCycledate.get().getClosingbalance());
            if (calculateOverLimitAmount < 0) {
                st.setOverLimitAmount(Math.abs(calculateOverLimitAmount));
            } else {
                st.setOverLimitAmount(0.0);
            }
        } else {
            st.setOverLimitAmount(0.0);
        }


        return st;
    }

    public BigDecimal madCalculation(String cardNumber, Date cycleDate) {
        Cardx byCard = cardxRepository.findByNumberx(cardNumber);
        Caccounts caccounts = byCard.getCaccounts();
        Optional<Cstatements> statements = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate, caccounts);

        Double overLimitAmount = statements.get().getCreditlimit() - Math.abs(statements.get().getClosingbalance());
        BigDecimal outStandingAmount = BigDecimal.ZERO;
        BigDecimal madAmount = BigDecimal.ZERO;
        BigDecimal overDueAmount = BigDecimal.valueOf(statements.get().getOverdueamount());
        BigDecimal overLimit = BigDecimal.ZERO;
        if (overLimitAmount < 0) {
            overLimit = BigDecimal.valueOf(overLimitAmount);
        } else {
            overLimit = BigDecimal.ZERO;
        }
        BigDecimal closingBalance = BigDecimal.valueOf(statements.get().getClosingbalance());
        Optional<Products> product = productsRepository.findById(caccounts.getProduct());
        Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
        Optional<Profiles> profiles = profilesRepository.findById(mprofileacct.get().getProfiles().getSerno());
        Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
        Long minPayPercentage = csetting.get().getMinpaypercentage();
        Double minper = (double) (minPayPercentage / 100);
        if (statements.get().getOverdueamount() < 0) {
            Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalance(statements.get().getSerno(),
                    caccounts.getSerno());
            for (Tbalances tbalancedata : tbalances.get()) {
                if (tbalancedata.getMinpaypercentage() != null) {
                    if (tbalancedata.getMinpaypercentage() == 100 && tbalancedata.getTrxnserno() != null) {
                        outStandingAmount = outStandingAmount.add(tbalancedata.getOutstandingamount());
                    }
                }
            }

//			BigDecimal v = (closingBalance.subtract((overDueAmount.add(overLimit).add(outStandingAmount)).multiply(BigDecimal.valueOf(minPayPercentage)).divide(BigDecimal.valueOf(100))))
//					.add((overDueAmount.add(overLimit).add(outStandingAmount)));
            BigDecimal v = (closingBalance.abs().subtract(overDueAmount.abs().add(overLimit.abs()).add(outStandingAmount.abs())))
                    .multiply(BigDecimal.valueOf(minper))
                    .add(overDueAmount.abs().add(overLimit.abs()).add(outStandingAmount.abs()));

            madAmount = v.abs();
        } else if (statements.get().getOverdueamount() == 0) {
            Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalance(statements.get().getSerno(),
                    caccounts.getSerno());
            for (Tbalances tbalancedata : tbalances.get()) {
                if (tbalancedata.getMinpaypercentage() == null) {
                    minPayPercentage = csetting.get().getMinpaypercentage();
                } else if (tbalancedata.getMinpaypercentage() == 100) {
                    minPayPercentage = tbalancedata.getMinpaypercentage();
                }
                outStandingAmount = outStandingAmount.add(tbalancedata.getOutstandingamount().abs()
                        .multiply(BigDecimal.valueOf(minPayPercentage)).divide(BigDecimal.valueOf(100)));
            }
            madAmount = outStandingAmount;
        }

        return madAmount;
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
