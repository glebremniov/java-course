package com.andersenlab.lesson2.orderpaymentservice;

public class OrderService {

  private final PaymentProcessor paymentProcessor;

  /**
   * Constructs an OrderService with the specified PaymentProcessor.
   *
   * @param paymentProcessor the payment processor
   */
  public OrderService(PaymentProcessor paymentProcessor) {
    this.paymentProcessor = paymentProcessor;
  }

  /**
   * Creates an order with the given amount and processes payment for it.
   *
   * @param amount the amount of the new order
   * @return the created order
   */
  public Order createOrder(double amount) {
    Order newOrder = new Order(amount);
    boolean paymentConfirmed = paymentProcessor.processPayment(newOrder);

    if (paymentConfirmed) {
      newOrder.setPaid(true);
    }

    return newOrder;
  }
}
