package com.vernite.cal.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.AccountDto;
import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.model.Products;
import com.vernite.cal.model.Profiles;
import com.vernite.cal.repository.AccountRepository;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.repository.CstatementSettingsRepository;
import com.vernite.cal.repository.CstatementsRepositoty;
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
	private CstatementsRepositoty cstatementsRepositoty;

	@Autowired
	private ProfilesRepository profilesRepository;

	@Autowired
	private CstatementSettingsRepository cstatementSettingsRepository;

	@Override
	public List<Cstatements> getStatement(String date) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parse = simpleDateFormat.parse(date);

		List<Cstatements> findByCycledate = cstatementsRepositoty.findByCycledate(parse);

		return findByCycledate;
	}

	public CardDetailsResponse fetchCardDetails(String numberx) {

		CardDetailsResponse cardResponse = new CardDetailsResponse();

		List<Caccounts> findAllaccount = accountRepository.findAll();
		List<Products> productList = productsRepository.findAll();
		cardResponse.setProductsList(productList);
		cardResponse.setCaccountsList(findAllaccount);

		return cardResponse;
	}

	public AccountDto convertAccountToAccountDto(Caccounts caccounts) {
		AccountDto accountDto = new AccountDto();
		accountDto.setNumberx(caccounts.getNumberx());
		accountDto.setStgeneral(caccounts.getStgeneral());
		accountDto.setTransactorhistory(caccounts.getTransactorhistory());
		return accountDto;
	}

	public List<Caccounts> getAccount(long serno) {
		List<Caccounts> all = accountRepository.findAll();
		return all;
	}

	public CardDetailsResponse getCards(String numberx) {

		Caccounts caccounts = new Caccounts();
		Cardx cardx = new Cardx();
		Products products = new Products();

		caccounts = accountRepository.findByNumberx(numberx);
		cardx = cardxRepository.findByNumberx(numberx);
		products = productsRepository.findByName(numberx);

		CardDetailsResponse detailsResponse = new CardDetailsResponse();

		detailsResponse.setSerno(caccounts.getSerno());

		detailsResponse.setStgeneral(caccounts.getStgeneral());
		detailsResponse.setTransactorhistory(caccounts.getTransactorhistory());
		detailsResponse.setName(caccounts.getNumberx());

		detailsResponse.setName(products.getName());

		return detailsResponse;
	}

}
