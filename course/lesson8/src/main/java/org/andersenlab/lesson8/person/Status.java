package org.andersenlab.lesson8.person;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Status {

  ACTIVE(1), DISABLED(0);

  private final int value;

  static Status fromValue(Number value) {
    return switch (value.intValue()) {
      case 0 -> DISABLED;
      case 1 -> ACTIVE;
      default -> throw new IllegalArgumentException();
    };
  }
}
