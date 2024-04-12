package com.andersenlab.lesson2.orderpaymentservice;

import java.util.Optional;

public class OrderValidator {

  /**
   * Validates the given order.
   *
   * @param order the order
   * @return true if validation is successful, false otherwise
   */
  public boolean validate(Order order) {
    // To be valid order must
    // - be not null
    // - order.amount > 0.0
    // - order.amount < 1000.0
    return Optional.ofNullable(order)
        .map(Order::getAmount)
        .filter(amount -> amount > 0.0)
        .filter(amount -> amount < 1000.0)
        .isPresent();
  }

}
