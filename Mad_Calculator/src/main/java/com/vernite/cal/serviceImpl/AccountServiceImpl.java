package com.vernite.cal.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.Products;
import com.vernite.cal.repository.AccountRepository;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.repository.CstatementSettingsRepository;
import com.vernite.cal.repository.CstatementsRepositoty;
import com.vernite.cal.repository.CtransactionsRepository;
import com.vernite.cal.repository.MprofileAcctRepository;
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
	private ProductsRepository productsRepository;

	@Autowired
	private ProfilesRepository profilesRepository;

	@Autowired
	private MprofileAcctRepository mprofileAcctRepository;

	public CardDetailsResponse getCardDeatils(String numberx) {

		Cardx byCard = cardxRepository.findByNumberx(numberx);
		Caccounts caccounts = byCard.getCaccounts();

		caccounts.setStgeneral(byCard.getCaccounts().getStgeneral());
		caccounts.setTransactorhistory(byCard.getCaccounts().getTransactorhistory());
		caccounts.setNumberx(byCard.getCaccounts().getNumberx());

		Long product = caccounts.getProduct();
		Optional<Products> productData = productsRepository.findById(product);
		String productName = productData.get().getName();

		// --------------------

		// profilesRepository.findByDescription()
//		Long serno = byCard.getSerno();
//		Optional<Mprofileacct> mprofileData = mprofileAcctRepository.findById(serno);

		// Profiles profiles = mprofileData.get().getProfiles();
		// String description = profiles.getDescription();

		// failed
//		Optional<Profiles> profileData = profilesRepository.findById(product);
//		String description = profileData.get().getDescription();

		// -----------------------

		CardDetailsResponse c = new CardDetailsResponse();

		c.setNumberx(caccounts.getNumberx());
		c.setStgeneral(caccounts.getStgeneral());
		c.setTransactorhistory(caccounts.getTransactorhistory());

		c.setName(productName);
		// c.setDescription(description);
//		c.setMinpaypercentage(minpaypercentage);

		return c;
	}

}
