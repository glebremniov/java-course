package com.andersenlab.lesson2.orderpaymentservice;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class PaymentPublisherTest {

  private final PaymentPublisher publisher = new PaymentPublisher();

  @Test
  void should_Throw_When_GivenNullablePayment() {
    // Given
    Payment nullablePayment = null;

    // When -> Then
    assertThatExceptionOfType(NullPointerException.class)
        .isThrownBy(() -> publisher.publish(nullablePayment))
        .withMessage("payment must be not null")
        .withNoCause();
  }

}
