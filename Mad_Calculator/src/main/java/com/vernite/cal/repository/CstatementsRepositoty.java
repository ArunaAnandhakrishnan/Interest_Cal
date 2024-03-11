package com.vernite.cal.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cstatements;

public interface CstatementsRepositoty extends JpaRepository<Cstatements, Long> {

Optional<Cstatements> findByCycledateAndCaccounts(Date cycleDate,Caccounts caccounts);
Optional<Cstatements> findByCycledate(Date cycleDate);

}
