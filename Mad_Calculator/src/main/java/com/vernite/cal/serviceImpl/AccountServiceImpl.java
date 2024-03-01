package com.vernite.cal.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.dto.StatementResponse;
import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.Cstatements;
import com.vernite.cal.model.Cstmtsettings;
import com.vernite.cal.model.Mprofileacct;
import com.vernite.cal.model.Products;
import com.vernite.cal.model.Profiles;
import com.vernite.cal.repository.AccountRepository;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.repository.CstatementSettingsRepository;
import com.vernite.cal.repository.CstatementsRepositoty;
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
	private CstatementsRepositoty cstatementsRepositoty;

	@Autowired
	private ProfilesRepository profilesRepository;

	@Autowired
	private CstatementSettingsRepository cstatementSettingsRepository;

	@Autowired
	private MprofileAcctRepository mprofileAcctRepository;

	public StatementResponse getStatement(String date) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

		Date parse = simpleDateFormat.parse(date);

		Cstatements statementsData = cstatementsRepositoty.findByCycledate(parse);

//		statementsData.get().getOverdueamount();
//		
//		statementsData.get().getTotaldebits();

		StatementResponse st = new StatementResponse();

		return st;
	}

	public StatementResponse getStatementDetails(Long numberx) {

		Optional<Cstatements> byId = cstatementsRepositoty.findById(numberx);
		byId.get().getTotaldebits();
		byId.get().getTotalcredits();
		byId.get().getOverdueamount();
		byId.get().getPrintduedate();
		byId.get().getMindueamount();
		byId.get().getClosingbalance();
		byId.get().getDuedate();

		StatementResponse st = new StatementResponse();
		st.setTotalcredits(byId.get().getTotalcredits());
		st.setTotaldebits(byId.get().getTotaldebits());
		st.setOverdueamount(byId.get().getOverdueamount());
		st.setPrintduedate(byId.get().getPrintduedate());
		st.setMindueamount(byId.get().getMindueamount());
		st.setClosingbalance(byId.get().getClosingbalance());
		st.setDuedate(byId.get().getDuedate());

		return st;
	}

	public CardDetailsResponse getNumberx(String numberx) {

		Cardx byCard = cardxRepository.findByNumberx(numberx);
		Caccounts caccounts = byCard.getCaccounts();

		caccounts.setStgeneral(byCard.getCaccounts().getStgeneral());
		caccounts.setTransactorhistory(byCard.getCaccounts().getTransactorhistory());
		caccounts.setNumberx(byCard.getCaccounts().getNumberx());

		Long product = caccounts.getProduct();
		Optional<Products> productData = productsRepository.findById(product);
		String productName = productData.get().getName();
		
		//--------------------

		
		
//		Optional<Mprofileacct> mprofilesData = mprofileAcctRepository.findById(product);
//		Products products = mprofilesData.get().getProducts();
//
//		Long productSerno = products.getSerno();
//
//		Optional<Profiles> profilesData = profilesRepository.findById(productSerno);
//		String description = profilesData.get().getDescription();
//
//		Optional<Cstmtsettings> cstmtSettingsData = cstatementSettingsRepository.findById(product);
//		Long minpaypercentage = cstmtSettingsData.get().getMinpaypercentage();

		// -----------------------

		CardDetailsResponse c = new CardDetailsResponse();

		c.setNumberx(caccounts.getNumberx());
		c.setStgeneral(caccounts.getStgeneral());
		c.setTransactorhistory(caccounts.getTransactorhistory());

		c.setName(productName);
//		c.setDescription(description);
//		c.setMinpaypercentage(minpaypercentage);

		return c;
	}

	public String getDiscription(Long serno) {
		Optional<Profiles> findById = profilesRepository.findById(serno);
		return findById.get().getDescription();
	}

}
