package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.CAddresses;

public interface AddressRepository extends JpaRepository<CAddresses, Long> {

	
	public CAddresses findByMobile(String mobile);
}
