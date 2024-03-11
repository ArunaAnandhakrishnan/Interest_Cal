package com.vernite.cal.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Cstatements;

public interface CstatementsRepositoty extends JpaRepository<Cstatements, Long> {

public Optional<Cstatements> findByCycledate(Date date);

	//public Optional<Cstatements> findByCaccounts(Long serno);

}
