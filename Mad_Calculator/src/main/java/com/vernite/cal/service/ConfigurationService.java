package com.vernite.cal.service;


import com.vernite.cal.dto.ConfigurationDto;
import com.vernite.cal.model.MadConfigurationDetails;

public interface ConfigurationService {
     MadConfigurationDetails getConfiguration();
     void saveConfiguration(ConfigurationDto configuration);
}
