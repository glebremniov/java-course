package com.andersenlab.lesson2.authorizationservice;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

  private final Map<UUID, User> storage = new ConcurrentHashMap<>();

  public int count() {
    return storage.size();
  }

  public Collection<User> list() {
    return storage.values();
  }

  public User getById(UUID id) {
    Objects.requireNonNull(id, "User id must be not null");
    return storage.get(id);
  }

  public User save(User user) {
    Objects.requireNonNull(user, "user must be not null");

    if (storage.containsKey(user.id())) {
      throw new RuntimeException("User with specified");
    }

    return Optional.ofNullable(storage.putIfAbsent(user.id(), user))
        .orElse(user);
  }

  public boolean delete(UUID id) {
    Objects.requireNonNull(id, "User id must be not null");

    return storage.remove(id) != null;
  }

}
