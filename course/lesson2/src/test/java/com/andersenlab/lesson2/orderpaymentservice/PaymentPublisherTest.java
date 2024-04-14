package com.andersenlab.lesson2.orderpaymentservice;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class PaymentPublisherTest {

  private final PaymentPublisher publisher = new PaymentPublisher();

  @Test
  void should_Pass_When_GivenNonNullPayment() {
    // Given
    var payment = new Payment(100.0);

    // When -> Expected
    assertDoesNotThrow(() -> publisher.publish(payment));
  }

  @Test
  void should_ThrowNPE_When_GivenNullablePayment() {
    // Given
    Payment nullablePayment = null;

    // When -> Then
    assertThatExceptionOfType(NullPointerException.class)
        .isThrownBy(() -> publisher.publish(nullablePayment))
        .withMessage("payment must be not null")
        .withNoCause();
  }

}
