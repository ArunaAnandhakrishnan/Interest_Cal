package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Cstmtsettings;
import java.util.List;


public interface CstatementSettingsRepository extends JpaRepository<Cstmtsettings, Long> {

	public Cstmtsettings findByMinpaypercentage(Long minpaypercentage);
}
