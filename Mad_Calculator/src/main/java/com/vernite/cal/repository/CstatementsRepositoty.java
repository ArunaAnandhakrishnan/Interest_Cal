package com.vernite.cal.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Cstatements;

public interface CstatementsRepositoty extends JpaRepository<Cstatements, Long> {

	public List<Cstatements> findByCycledate(Date cycledate);
}
