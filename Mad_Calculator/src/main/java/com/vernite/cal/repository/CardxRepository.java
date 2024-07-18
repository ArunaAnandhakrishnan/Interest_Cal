package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Caccounts;
import com.vernite.cal.model.Cardx;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardxRepository extends JpaRepository<Cardx, Long> {

	public Cardx findByNumberx(String numberx);

	public Cardx findBySerno(Long serno);

	Cardx findByPeopleserno(Long serno);

	@Query(value = "SELECT c.numberx FROM cardx cx JOIN caccounts c ON cx.caccserno = c.serno WHERE cx.peopleserno = :serno", nativeQuery = true)
	List<String> findByPeople(@Param("serno") Long serno);

	public Cardx findByCaccounts(Caccounts caccounts);
	@Query(value = "select numberx from caccounts where serno in (select caccserno from cardx where peopleserno in (select rowserno from caddresslinks cl where cl.addressserno in (select serno from caddresses where mobile =:mobileNo )))", nativeQuery = true)
	List<String> findByPeoplesSerno(@Param("mobileNo") String mobileNo);
}
