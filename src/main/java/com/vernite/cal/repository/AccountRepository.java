package com.vernite.cal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cstatements;

public interface AccountRepository extends JpaRepository<Caccounts, Long> {

	public Caccounts findByNumberx(String numberx);

	public Caccounts findBySerno(Long serno);

//	public Caccounts findByCstatements(List<Cstatements> byCycledate);
	

}
