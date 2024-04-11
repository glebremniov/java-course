package com.andersenlab.lesson2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PaymentProcessorTest {

  private final PaymentProcessor paymentProcessor = new PaymentProcessor();

  @ParameterizedTest
  @MethodSource(value = "testParams")
  @DisplayName("Ensure Payment Processor is Called Correctly")
  void ensurePaymentProcessorInteraction(double orderAmount, boolean expected) {
    // Given
    Order mockOrder = mock(Order.class);
    when(mockOrder.getAmount()).thenReturn(orderAmount);

    // When
    boolean actual = paymentProcessor.processPayment(mockOrder);

    // Then
    assertThat(actual).isEqualTo(expected);
    verify(mockOrder).getAmount();  // Then that getAmount was called on the order
  }

  private static Stream<Arguments> testParams() {
    return Stream.of(
        Arguments.of(100.0, true),
        Arguments.of(999.99, true),
        Arguments.of(0.0, false),
        Arguments.of(-0.0, false),
        Arguments.of(-100.0, false),
        Arguments.of(1000.0, false),
        Arguments.of(Double.MAX_VALUE, false)
    );
  }

}
