package com.vernite.cal.serviceImpl;

import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.model.*;
import com.vernite.cal.repository.*;
import com.vernite.cal.service.ConfigurationService;
import com.vernite.cal.service.InterestCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class InterestCalculateServiceImpl implements InterestCalculateService {
    @Autowired
    CardxRepository cardxRepository;
    @Autowired
    TbalancesRepository tbalancesRepository;
    @Autowired
    CstatementsRepositoty cstatementsRepositoty;
    @Autowired
    ConfigurationService configurationService;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    MprofileAcctRepository mprofileAcctRepository;
    @Autowired
    ProfilesRepository profilesRepository;
    @Autowired
    CstatementSettingsRepository cstatementSettingsRepository;
    @Override
    public Double getInterest(String cardNo, Date cycleDate, String cardType) {
        Cardx byCard = cardxRepository.findByNumberx(cardNo);
        Caccounts caccounts = byCard.getCaccounts();
        Optional<Cstatements> statements = cstatementsRepositoty.findByCycledateAndCaccounts(cycleDate, caccounts);
        MadConfigurationDetails config = configurationService.getConfiguration();
        Double overlimit = tbalancesRepository.getTbalanceData(caccounts.getSerno(), config.getSerno(),statements.get().getSerno());

        Double overLimitAmount = overlimit == null ? 0.0 : statements.get().getCreditlimit() - Math.abs(overlimit);
        BigDecimal closingBalance = BigDecimal.valueOf(statements.get().getClosingbalance());
        Optional<Products> product = productsRepository.findById(caccounts.getProduct());
        Optional<Mprofileacct> mprofileacct = mprofileAcctRepository.findByProducts(product);
        Optional<Profiles> profiles = profilesRepository.findById(mprofileacct.get().getProfiles().getSerno());
        Optional<Cstmtsettings> csetting = cstatementSettingsRepository.findByProfiles(profiles.get());
        Long minPayPercentage = csetting.get().getMinpaypercentage();
        BigDecimal outStandingAmount = BigDecimal.ZERO;
        Double overDue = 0.0;
        if (statements.get().getOverdueamount() < 0) {
            overDue = statements.get().getOverdueamount();
        } else if (statements.get().getOverdueamount() == 0) {
            overDue = 0.0;
        }
        if (overDue < 0 || overLimitAmount < 0) {
            Optional<List<Tbalances>> tbalances = tbalancesRepository.getTbalance(statements.get().getSerno(),
                    caccounts.getSerno());
            for (Tbalances tbalancedata : tbalances.get()) {
                if (tbalancedata.getMinpaypercentage() != null) {
                    if (tbalancedata.getMinpaypercentage() == 100 && tbalancedata.getTrxnserno() != null) {
                        outStandingAmount = outStandingAmount.add(tbalancedata.getOutstandingamount());
                    }
                }
            }

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
        }
        double rate = 0;
        if (cardType.equalsIgnoreCase("DISCOVER")) {
            rate = .01;
        } else if (cardType.equalsIgnoreCase("MASTERCARD")) {
            rate = .05;
        } else if (cardType.equalsIgnoreCase("VISA")) {
            rate = .10;
        }
        return rate * outStandingAmount.doubleValue();
    }
    public CardDetailsResponse getCardDeatils(String numberx) throws ParseException {

        Cardx byCard = cardxRepository.findByNumberx(numberx);
        Caccounts caccounts = byCard.getCaccounts();

        caccounts.setStgeneral(byCard.getCaccounts().getStgeneral());
        caccounts.setTransactorhistory(byCard.getCaccounts().getTransactorhistory());
        caccounts.setNumberx(byCard.getCaccounts().getNumberx());

        String stgeneralCardx = byCard.getStgeneral();
        String expirydatestatus = byCard.getExpirydatestatus();
        Long primarycard = byCard.getPrimarycard();

        Long product = caccounts.getProduct();
        Optional<Products> productData = productsRepository.findById(product);
        String productName = productData.get().getName();

        Products productsClass = byCard.getProducts();
        Long sernoProduct = productsClass.getSerno();

        // get discription
        Optional<Products> productDatas = productsRepository.findById(sernoProduct);
        // String description = productDatas.get().getDescription();

        Optional<Mprofileacct> mprofilesAcctData = mprofileAcctRepository.findByProducts(productDatas);

        Profiles profiles = mprofilesAcctData.get().getProfiles();

        Optional<Profiles> profilesData = profilesRepository.findById(profiles.getSerno());
        String description = profilesData.get().getDescription();

        Optional<Cstmtsettings> cstmtSettingsData = cstatementSettingsRepository.findByProfiles(profiles);
        Long minpaypercentage = cstmtSettingsData.get().getMinpaypercentage();
//		List<String> cycledate = new ArrayList<>();
//		List<Cstatements> cstatementsList = caccounts.getCstatementsList();
//		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		for (Cstatements statements : cstatementsList) {
//	        LocalDateTime localDateTime = statements.getCycledate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//			LocalDate localDate = localDateTime.toLocalDate();
//			String outputDateStr = outputFormatter.format(localDate);
//
//			cycledate.add(outputDateStr);
//		}

        List<String> cycledate = new ArrayList<>();
        List<Cstatements> cstatementsList = caccounts.getCstatementsList();
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Comparator<String> dateComparator = (date1, date2) -> {
            LocalDate ld1 = LocalDate.parse(date1, outputFormatter);
            LocalDate ld2 = LocalDate.parse(date2, outputFormatter);
            int yearComparison = Integer.compare(ld2.getYear(), ld1.getYear());
            if (yearComparison != 0) {
                return yearComparison;
            }
            int monthComparison = Integer.compare(ld2.getMonthValue(), ld1.getMonthValue());
            if (monthComparison != 0) {
                return monthComparison;
            }
            return Integer.compare(ld2.getDayOfMonth(), ld1.getDayOfMonth());
        };

        for (Cstatements statements : cstatementsList) {
            if (statements.getBillingdate() != null && statements.getGeneratedatetime() != null) {
                LocalDateTime localDateTime = statements.getCycledate().toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                LocalDate localDate = localDateTime.toLocalDate();
                String outputDateStr = outputFormatter.format(localDate);

                cycledate.add(outputDateStr);
            }
        }
        Collections.sort(cycledate, dateComparator);

        CardDetailsResponse c = new CardDetailsResponse();
        c.setNumberx(caccounts.getNumberx());
        c.setStgeneral(caccounts.getStgeneral());
        c.setTransactorhistory(caccounts.getTransactorhistory());
        c.setCycleDate(cycledate);
        c.setName(productName);
        c.setDescription(description);
        c.setMinpaypercentage(minpaypercentage);
        c.setPrimarycard(primarycard);
        c.setStgeneralCard(stgeneralCardx);
        c.setExpirydatestatus(expirydatestatus);

        return c;
    }

}
