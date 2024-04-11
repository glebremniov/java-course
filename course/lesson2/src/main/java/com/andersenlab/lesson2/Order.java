package com.andersenlab.lesson2;

public class Order {
  private final double amount;
  private boolean paid;

  /**
   * Constructs a new Order with the specified amount.
   *
   * @param amount the amount of the order
   */
  public Order(double amount) {
    this.amount = amount;
    this.paid = false;
  }

  /**
   * Returns the amount of the order.
   *
   * @return the amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Returns whether the order is paid or not.
   *
   * @return true if paid, false otherwise
   */
  public boolean isPaid() {
    return paid;
  }

  /**
   * Sets the paid status of the order.
   *
   * @param paid the new paid status
   */
  public void setPaid(boolean paid) {
    this.paid = paid;
  }
}
