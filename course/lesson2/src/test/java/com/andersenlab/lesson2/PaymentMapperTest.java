package com.andersenlab.lesson2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentMapperTest {

  private final PaymentMapper mapper = new PaymentMapper();

  @ParameterizedTest
  @ValueSource(doubles = {100.0, 0.0, 999.99})
  void should_ReturnPayment_When_GivenValidOrder(double amount) {
    // Given
    var order = new Order(amount);
    var expected = new Payment(amount);

    // When
    var actual = mapper.fromOrder(order);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void should_Throw_When_GivenNullableOrder() {
    // Given
    Order nullableOrder = null;

    // When -> Then
    assertThatExceptionOfType(NullPointerException.class)
        .isThrownBy(() -> mapper.fromOrder(nullableOrder))
        .withMessage("order must be not null")
        .withNoCause();
  }
}
