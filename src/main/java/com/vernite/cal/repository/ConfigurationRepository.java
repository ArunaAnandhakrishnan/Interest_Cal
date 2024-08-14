package com.vernite.cal.repository;

import com.vernite.cal.model.MadConfigurationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<MadConfigurationDetails, Long> {

}