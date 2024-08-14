package com.vernite.cal.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "MAD_CONFIGURATION_DETAILS")
public class MadConfigurationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = LongListConverter.class)
    private List<Long> serno;

    private Boolean overLimitAmount;
    private Boolean overDueAmount;
    private Long minAmountCapping;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getSerno() {
        return serno;
    }

    public void setSerno(List<Long> serno) {
        this.serno = serno;
    }

    public Boolean getOverLimitAmount() {
        return overLimitAmount;
    }

    public void setOverLimitAmount(Boolean overLimitAmount) {
        this.overLimitAmount = overLimitAmount;
    }

    public Boolean getOverDueAmount() {
        return overDueAmount;
    }

    public void setOverDueAmount(Boolean overDueAmount) {
        this.overDueAmount = overDueAmount;
    }

    public Long getMinAmountCapping() {
        return minAmountCapping;
    }

    public void setMinAmountCapping(Long minAmountCapping) {
        this.minAmountCapping = minAmountCapping;
    }

    // Custom converter class
    @Converter
    public static class LongListConverter implements AttributeConverter<List<Long>, String> {

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public String convertToDatabaseColumn(List<Long> attribute) {
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error converting list to JSON string", e);
            }
        }

        @Override
        public List<Long> convertToEntityAttribute(String dbData) {
            try {
                return objectMapper.readValue(dbData, List.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error converting JSON string to list", e);
            }
        }
    }
}
