package com.andersenlab.lesson2.orderpaymentservice;

import java.util.Objects;

public class PaymentPublisher {

  public void publish(Payment payment) {
    Objects.requireNonNull(payment, "payment must be not null");
    System.out.println("Publish payment: " + payment.toString());
  }

}
