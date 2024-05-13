package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.CAddresses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<CAddresses, Long> {

	
	List<CAddresses> findByMobile(String mobile);
    @Query(value = "Select * from CADDRESSES where mobile =:mobile", nativeQuery = true)
    CAddresses findByMobileNo(@Param("mobile") String mobile);
   // CAddresses findByMobileOrderByLimit1(String mobile);
   CAddresses findTop1ByMobileOrderByMobile(String mobile);

}
