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

	@Query(value = "SELECT cx.caccserno FROM cardx cx JOIN caccounts c ON cx.caccserno = c.serno WHERE cx.peopleserno = :serno", nativeQuery = true)
	List<String> findByPeople(@Param("serno") Long serno);

	public Cardx findByCaccounts(Caccounts caccounts);

}
