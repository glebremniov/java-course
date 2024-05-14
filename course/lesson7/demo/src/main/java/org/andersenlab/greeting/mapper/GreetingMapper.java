package org.andersenlab.greeting.mapper;

import org.andersenlab.springbootdemo.greeting.service.GreetingInput;
import org.andersenlab.springbootdemo.greeting.service.GreetingOutput;
import org.andersenlab.springbootdemo.greeting.api.GreetingRequest;
import org.andersenlab.springbootdemo.greeting.api.GreetingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GreetingMapper {

  @Mapping(source = "name", target = "value")
  GreetingInput fromRequest(GreetingRequest source);

  @Mapping(source = "value", target = "message")
  GreetingResponse toResponse(GreetingOutput source);

}
