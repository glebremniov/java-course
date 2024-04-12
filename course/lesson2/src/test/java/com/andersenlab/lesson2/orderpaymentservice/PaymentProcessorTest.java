package com.andersenlab.lesson2.orderpaymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaymentProcessorTest {

  @Mock
  private OrderValidator validator;

  @Mock
  private PaymentPublisher publisher;

  @Mock
  private PaymentMapper mapper;

  @InjectMocks
  private PaymentProcessor paymentProcessor;

  @Test
  void should_ProcessPayment_When_GivenValidOrder() {
    // Given
    var order = new Order(100.0);
    var payment = new Payment(100.0);
    when(validator.validate(order)).thenReturn(true);
    when(mapper.fromOrder(order)).thenReturn(payment);

    // When
    var actual = paymentProcessor.processPayment(order);

    // Then
    assertThat(actual).isTrue();
    verify(validator).validate(order);
    verify(mapper).fromOrder(order);
    verify(publisher).publish(payment);
  }

  @Test
  void should_DoNothing_When_GivenInvalidOrder() {
    // Given
    var order = new Order(5000.0);
    when(validator.validate(order)).thenReturn(false); // <- order is marked as invalid

    // When
    var actual = paymentProcessor.processPayment(order);

    // Then
    assertThat(actual).isFalse();
    verify(validator).validate(order);
    verify(mapper, never()).fromOrder(order);
    verifyNoInteractions(publisher);
  }
}
