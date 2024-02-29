package com.vernite.cal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Caccounts;

public interface AccountRepository extends JpaRepository<Caccounts, Long> {

	public Caccounts findByNumberx(String numberx);

	public List<Caccounts> findBySerno(Long serno);

}
