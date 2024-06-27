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
   // CAddresses findByMobileOrderByLimit1(String mobile);
   @Query(value = "SELECT * FROM CADDRESSES WHERE mobile LIKE %:mobile%", nativeQuery = true)
   List<CAddresses> findByMobileNo(@Param("mobile") String mobile);
    // CAddresses findByMobileOrderByLimit1(String mobile);
    @Query(value = "SELECT * FROM (SELECT * FROM CADDRESSES WHERE mobile LIKE %:mobile% ORDER BY mobile) WHERE ROWNUM = 1", nativeQuery = true)
    CAddresses findTop1ByMobileLikeOrderByMobile(@Param("mobile") String mobile);
   CAddresses findTop1ByMobileOrderByMobile(String mobile);

}
