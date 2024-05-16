package org.andersenlab.lesson8.user;

import org.andersenlab.lesson8.auth.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toEntity(RegisterRequest source) {
    return User.builder()
        .firstname(source.firstname())
        .lastname(source.lastname())
        .email(source.email())
        .role(source.role())
        .build();
  }
}
