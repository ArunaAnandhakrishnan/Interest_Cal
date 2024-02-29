package com.vernite.cal.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import oracle.sql.TIMESTAMP;

@Entity
public class Cstatements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serno;

	@ManyToOne
	@JoinColumn(name = "caccserno", nullable = false)
	private Caccounts caccounts;

	@OneToMany(mappedBy = "cstatements", cascade = CascadeType.ALL)
	private List<Tbalances> tbalanceList;

//	private Integer caccserno;

	private Long institution_id;
	// serno NUMBER(10) not null,
	private Long partitionkey;
//	private Long caccserno;
	private Long batchserno;
	private Date cycledate;
	private Date prevbillingdate;
	private Date billingdate;
	private String generatedatetime;
	private Timestamp lastprintdate;
	private Long printcount;
	private Long closingbalance;
	private Long openingbalance;
	private Long averagedailybalance;
	private Long paidinfullbalance;
	private Long mindueamount;
	private Long overdueamount;
	private Long wishtopay;
	private Long mindueamountwaived;
	private Long cycleactivity;
	private Long totalcredits;
	private Long totaldebits;
	private Long totalpayments;
	private Long totalcreditsbyduedate;
	private Long totalinterest;
	private Long excessinterest;
	private Long pendinginterest;
	private Long returnedpayments;
	private Long backdatedcredits;
	private Long backdateddebits;
	private Long backdatedpayments;
	private Long backdatedreturnedpayments;
	private Long excesspaymentamount;
	private Long latepaymentfee;
	private Long instalmentclosingbalance;
	private Long instalmentclosingbalprincipal;
	private Long instalmentopeningbalance;
	private Long creditlimit;
	private Long overduecycles;
	private Long overdueage;
	private Long paymentindicator;
	private Long currency;
	private Date duedate;
	private Date printduedate;
	private Date overduedate;
	private Date currentoverduedate;
	private Date cureoverduedate;
	private String stgeneral;
	private Long collectorcase;
	private Long coltypeserno;
	private Long repaymentplanserno;
	private Long repaymentplanpartitionkey;
	private Long repaymentplancycle;
	private Long mbhagreementserno;
	private Timestamp mbhagreementexpirydate;
	private Long aprbalance;
	private Long aprpastdue;
	private Long aprcash;
	private Long aprinstalments;
	private Long numofmonthstopayoffwithminamt;
	private Long pmntamttopayoffin12months;
	private String reason;
	private Long sequence;
	private Long cycledays;
	private Long pushcounter;
	private TIMESTAMP pushedbillingdate;
	private TIMESTAMP pushedprintduedate;
	private Long prevstmtserno;
	private Long prevstmtpartitionkey;
	private Long recalcallowed;
	private Long recalcmindueamount;
	private Long recalcoverdueamount;
	private Long recalccycleactivity;
	private Long recalcoverduecycles;
	private Long recalcoverdueage;
	private TIMESTAMP recalcoverduedate;
	private TIMESTAMP recalccurrentoverduedate;
	private Long recalcpaymentindicator;
	private Long recalcclosingbalance;
	private Long recalcaveragedailybalance;
	private Long recalcpaidinfullbalance;
	private Long recalctotalcredits;
	private Long recalctotalpayments;
	private Long recalctotalcreditsbyduedate;
	private Long recalctotalinterest;
	private Long recalcexcessinterest;
	private Long recalcexcesspaymentamount;
	private TIMESTAMP recalccureoverduedate;
	private Long converted;

	

}
