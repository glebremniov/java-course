package com.andersenlab.lesson2.orderpaymentservice;

import java.util.Objects;

public class PaymentMapper {

  public Payment fromOrder(Order source) {
    Objects.requireNonNull(source, "order must be not null");
    return new Payment(source.getAmount());
  }

}
