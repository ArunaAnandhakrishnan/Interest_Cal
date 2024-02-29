package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Cardx;
import java.util.List;

public interface CardxRepository extends JpaRepository<Cardx, Long> {

	public Cardx findByNumberx(String numberx);
	
	public List<Cardx> findBySerno(Long serno);
	

}
