package com.andersenlab.lesson2.orderpaymentservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderValidatorTest {

  private final OrderValidator validator = new OrderValidator();

  @ParameterizedTest
  @MethodSource(value = "testParams")
  void should_ReturnCorrectValue_When_GivenAmount(double orderAmount, boolean expected) {
    // Given
    Order order = new Order(orderAmount);

    // When
    boolean actual = validator.validate(order);

    // Then
    assertThat(actual).isEqualTo(expected);
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
