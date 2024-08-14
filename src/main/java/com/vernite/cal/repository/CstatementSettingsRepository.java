package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Cstmtsettings;
import com.vernite.cal.model.Profiles;

import java.util.List;
import java.util.Optional;


public interface CstatementSettingsRepository extends JpaRepository<Cstmtsettings, Long> {

	public Cstmtsettings findByMinpaypercentage(Long minpaypercentage);

	public Optional<Cstmtsettings> findByProfiles(Profiles profiles);
}
