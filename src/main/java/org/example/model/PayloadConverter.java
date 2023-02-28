package org.example.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

@Converter(autoApply = true)
public class PayloadConverter implements AttributeConverter<Map<String,Object>, String> {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        try {
            if (attribute == null) {
                //throw new NullPointerException("Нет данных для бд");
                return "";
            }
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        try {
            if (dbData == null) {
                throw new NullPointerException("Нет данных в бд");
            }
            return objectMapper.readValue(dbData, new TypeReference<Map<String, Object>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
