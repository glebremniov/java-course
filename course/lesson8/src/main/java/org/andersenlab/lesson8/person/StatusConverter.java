package org.andersenlab.lesson8.person;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Status status) {
    return status.getValue();
  }

  @Override
  public Status convertToEntityAttribute(Integer dbData) {
    return Status.fromValue(dbData);
  }
}
