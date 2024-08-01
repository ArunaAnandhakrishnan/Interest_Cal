package com.vernite.cal.controller;


import com.vernite.cal.dto.ConfigurationDto;
import com.vernite.cal.model.MadConfigurationDetails;
import com.vernite.cal.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/configurations")
public class ConfigurationController {
    @Autowired
    ConfigurationService configurationService;
    @PostMapping(value = "/save_config")
    public ResponseEntity<?>  createConfiguration(@RequestBody ConfigurationDto configuration) {
          configurationService.saveConfiguration(configuration);
        return ResponseEntity.ok("Configuration saved successfully");
    }
    @GetMapping(value = "/get_config")
    public MadConfigurationDetails getConfiguration() {
        return configurationService.getConfiguration();
    }

}
