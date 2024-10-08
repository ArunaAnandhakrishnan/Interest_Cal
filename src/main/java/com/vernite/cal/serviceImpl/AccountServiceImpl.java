package com.vernite.cal.serviceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.controller.ValidationException;
import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.model.CAddresses;
import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Caddresslinks;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.model.Cstmtsettings;
import com.vernite.cal.model.Mprofileacct;
import com.vernite.cal.model.Products;
import com.vernite.cal.model.Profiles;
import com.vernite.cal.repository.AccountRepository;
import com.vernite.cal.repository.AddressRepository;
import com.vernite.cal.repository.CaddresslinksRepository;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.repository.CstatementSettingsRepository;
import com.vernite.cal.repository.CstatementsRepositoty;
import com.vernite.cal.repository.MprofileAcctRepository;
import com.vernite.cal.repository.PeopleRepository;
import com.vernite.cal.repository.ProductsRepository;
import com.vernite.cal.repository.ProfilesRepository;
import com.vernite.cal.service.AccountService;

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
		cardDetails.setCardNumber(byCardSerno.getNumberx());
		return cardDetails;
	}

	public CardDetailsResponse getByPeopleSernoDetails(String cardSerno) throws ParseException {

		// Cardx byCardSerno = cardxRepository.findByPeopleserno(cardSerno);
		List<String> card = cardxRepository.findByCustId(cardSerno);

		CardDetailsResponse cardDetails = new CardDetailsResponse();
		cardDetails.setAccountNo(card);

		return cardDetails;
	}

	public CardDetailsResponse getCardDetailsByAccount(String accountNo) throws ParseException {
		List<String> list = Arrays.asList(accountNo.split(","));

		Caccounts byAccount = accountRepository.findByNumberx(accountNo);

		Cardx byCard = cardxRepository.findByCaccounts(byAccount);
		if (byCard == null) {
			throw new RuntimeException("Card not found for account: " + accountNo);
		}

		CardDetailsResponse cardDeatils = getCardDeatils(byCard.getNumberx());
		cardDeatils.setAccountNo(list);
		return cardDeatils;
	}

//	public CardDetailsResponse getCardDetailsByMobile(String mobileNo) throws ParseException, ValidationException {
//
////		// Extract the last 10 digits of the mobile number
//		if (mobileNo.length() > 10) {
//			mobileNo = mobileNo.substring(mobileNo.length() - 10);
//		}
//		
//
//		CAddresses addressInfo = new CAddresses();
//		List<CAddresses> addressDetails = addressRepository.findByMobile(mobileNo);
//		if (addressDetails.size() >= 1) {
//			addressInfo = addressRepository.findTop1ByMobileOrderByMobile(mobileNo);
//		} else if (addressDetails.size() <= 1) {
//			addressInfo = addressRepository.findByMobileNo(mobileNo);
//		}
//		Caddresslinks caddresslinks = caddresslinksRepository.findByAddressserno(addressInfo.getSerno());
//		Cardx cardx = cardxRepository.findByPeopleserno((long) caddresslinks.getRowserno());
//		CardDetailsResponse cardDetails = getCardDeatils(cardx.getNumberx());
//		cardDetails.setCardNumber(cardx.getNumberx());
//
//		return cardDetails;
//	}

	public CardDetailsResponse getCardDetailsByMobile(String mobileNo) throws ParseException, ValidationException {
		// Extract the last 10 digits of the mobile number if it is more than 10 digits
		if (mobileNo.length() > 10) {
			mobileNo = mobileNo.substring(mobileNo.length() - 10);
		}

		CAddresses addressInfo = new CAddresses();
		List<CAddresses> addressDetails = addressRepository.findByMobileNo(mobileNo);

		if (addressDetails.size() >= 1) {
			addressInfo = addressRepository.findTop1ByMobileLikeOrderByMobile(mobileNo);
		} else {
			// If no address found with the last 10 digits, handle the scenario
			// appropriately
			throw new ValidationException("No address found for the provided mobile number.");
		}
//	todo	Caddresslinks caddresslinks = caddresslinksRepository.findByAddressserno(addressInfo.getSerno());
//		List<String> card = cardxRepository.findByPeople((long) caddresslinks.getRowserno());
		List<String> cards = cardxRepository.findByPeoplesSerno(mobileNo);
		CardDetailsResponse cardDetails = new CardDetailsResponse();
		// cardDetails.setCardNumber(cardx.getNumberx());
		cardDetails.setAccountNo(cards);

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
