package com.vernite.cal.serviceImpl;

import com.vernite.cal.dto.ConfigurationDto;
import com.vernite.cal.model.MadConfigurationDetails;
import com.vernite.cal.repository.ConfigurationRepository;
import com.vernite.cal.service.ConfigurationService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
    @Autowired
    ConfigurationRepository configurationRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public MadConfigurationDetails getConfiguration() {
        Optional<MadConfigurationDetails> config = configurationRepository.findById(1L);
        if (config.isPresent()) {
            return config.get();
        }
        return null;
    }
    @Override
    @Transactional
    public void saveConfiguration(ConfigurationDto configDto) {
        MadConfigurationDetails config = configurationRepository.findById(1L).orElse(new MadConfigurationDetails());
        config.setId(1L);
        config.setSerno(configDto.getSerno());
        config.setOverLimitAmount(configDto.getOverLimitAmount());
        config.setOverDueAmount(configDto.getOverDueAmount());
        config.setMinAmountCapping(configDto.getMinAmountCapping());
        configurationRepository.save(config);
    }
}
