package com.andersenlab.lesson2.orderpaymentservice;

public class PaymentProcessor {

  private final OrderValidator validator;
  private final PaymentPublisher publisher;
  private final PaymentMapper mapper;

  public PaymentProcessor(OrderValidator validator, PaymentPublisher publisher, PaymentMapper mapper) {
    this.validator = validator;
    this.publisher = publisher;
    this.mapper = mapper;
  }

  /**
   * Processes payment for the given order.
   *
   * @param order the order
   * @return true if payment is successful, false otherwise
   */
  public boolean processPayment(Order order) {
    if (!validator.validate(order)) {
      return false;
    }

    var payment = mapper.fromOrder(order);
    publisher.publish(payment);
    return true;
  }
}
