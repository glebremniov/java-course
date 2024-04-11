package com.andersenlab.lesson2;

public class PaymentProcessor {

  /**
   * Processes payment for the given order.
   *
   * @param order the order
   * @return true if payment is successful, false otherwise
   */
  public boolean processPayment(Order order) {
    // Simulate payment processing logic
    double amount = order.getAmount();
    return amount > 0 && amount < 1000;  // Assume orders under $1000 are always processed successfully
  }
}
