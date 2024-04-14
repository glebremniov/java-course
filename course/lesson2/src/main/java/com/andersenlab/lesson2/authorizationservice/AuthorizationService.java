package com.andersenlab.lesson2.authorizationservice;

import java.util.Optional;
import java.util.UUID;

public class AuthorizationService {

  private final UserRepository repository;

  public AuthorizationService(UserRepository repository) {
    this.repository = repository;
  }

  public boolean isAuthorized(UUID id, Operation operation) {
    var user = repository.getById(id);

    return Optional.ofNullable(user)
        .map(User::allowedOperations)
        .filter(operations -> operations.contains(operation))
        .isPresent();
  }

}
