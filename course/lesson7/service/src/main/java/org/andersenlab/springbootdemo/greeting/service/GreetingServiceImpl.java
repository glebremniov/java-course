package org.andersenlab.springbootdemo.greeting.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

  private static final String GREETING_TEMPLATE = "Hello %s";

  @Override
  public GreetingOutput greet(GreetingInput input) {
    return Optional.ofNullable(input)
        .map(GreetingInput::value)
        .map(GREETING_TEMPLATE::formatted)
        .map(GreetingOutput::new)
        .orElseThrow();
  }
}
