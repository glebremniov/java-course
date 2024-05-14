package org.andersenlab.springbootdemo.greeting.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface GreetingApi {

  @PostMapping("/greeting")
  ResponseEntity<GreetingResponse> greet(@RequestBody GreetingRequest request);

}
