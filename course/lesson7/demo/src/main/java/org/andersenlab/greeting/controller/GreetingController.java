package org.andersenlab.greeting.controller;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.andersenlab.greeting.mapper.GreetingMapper;
import org.andersenlab.springbootdemo.greeting.api.GreetingApi;
import org.andersenlab.springbootdemo.greeting.api.GreetingRequest;
import org.andersenlab.springbootdemo.greeting.api.GreetingResponse;
import org.andersenlab.springbootdemo.greeting.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController implements GreetingApi {

  private final GreetingService service;
  private final GreetingMapper mapper;

  @Override
  public ResponseEntity<GreetingResponse> greet(GreetingRequest request) {
    return Optional.ofNullable(request)
        .map(mapper::fromRequest)
        .map(service::greet)
        .map(mapper::toResponse)
        .map(ResponseEntity::ok)
        .orElseThrow();
  }
}
