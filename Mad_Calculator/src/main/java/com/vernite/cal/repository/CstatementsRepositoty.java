package com.vernite.cal.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Cstatements;
import java.util.List;

public interface CstatementsRepositoty extends JpaRepository<Cstatements, Long> {

	// public Cstatements findByCycledate(String date);

	public Optional<Cstatements> findByCycledate(Date date);

	
}
