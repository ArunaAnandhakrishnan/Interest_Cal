package com.vernite.cal.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.vernite.cal.model.*;
import com.vernite.cal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.service.AccountService;

import oracle.net.aso.m;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CardxRepository cardxRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private ProfilesRepository profilesRepository;

	@Autowired
	private MprofileAcctRepository mprofileAcctRepository;

	@Autowired
	private CstatementsRepositoty cstatementsRepositoty;

	@Autowired
	private CstatementSettingsRepository cstatementSettingsRepository;

	@Autowired
	CaddresslinksRepository caddresslinksRepository;
	@Autowired
	PeopleRepository peopleRepository;

	public CardDetailsResponse getCardSernoDetails(Long cardSerno) throws ParseException {

		Cardx byCardSerno = cardxRepository.findBySerno(cardSerno);
		CardDetailsResponse cardDetails = getCardDeatils(byCardSerno.getNumberx());
		return cardDetails;
	}
	public CardDetailsResponse getByPeopleSernoDetails(Long cardSerno) throws ParseException {

		Cardx byCardSerno = cardxRepository.findByPeopleserno(cardSerno);
		CardDetailsResponse cardDetails = getCardDeatils(byCardSerno.getNumberx());
		return cardDetails;
	}


	public CardDetailsResponse getCardDetailsByMobile(String mobileNo) throws ParseException {
		CAddresses addressInfo = new CAddresses();
		List<CAddresses> addressDetails = addressRepository.findByMobile(mobileNo);
		if (addressDetails.size() >= 1) {
			addressInfo = addressRepository.findTop1ByMobileOrderByMobile(mobileNo);
		} else if (addressDetails.size() <= 1) {
			addressInfo = addressRepository.findByMobileNo(mobileNo);
		}
		Caddresslinks caddresslinks = caddresslinksRepository.findByAddressserno(addressInfo.getSerno());
		Cardx cardx = cardxRepository.findByPeopleserno((long)caddresslinks.getRowserno());
		CardDetailsResponse cardDetails = getCardDeatils(cardx.getNumberx());
		return cardDetails;
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
