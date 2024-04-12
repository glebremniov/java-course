package com.andersenlab.lesson2.orderpaymentservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

  @Mock
  PaymentProcessor paymentProcessor;

  @InjectMocks
  OrderService orderService;

  @Test
  @DisplayName("Order Creation With Payment Success")
  void testOrderCreationWithSuccessfulPayment() {
    // Given
    double orderAmount = 500.0;
    when(paymentProcessor.processPayment(any(Order.class))).thenReturn(true);

    // When
    Order newOrder = orderService.createOrder(orderAmount);

    // Then
    verify(paymentProcessor).processPayment(any(Order.class));
    assertThat(newOrder.isPaid()).isTrue();
    assertThat(newOrder.getAmount()).isEqualTo(orderAmount);
  }

  @Test
  @DisplayName("Order Creation With Payment Failure")
  void testOrderCreationWithFailedPayment() {
    // Given
    double orderAmount = 1500.0;  // this should fail as per our PaymentProcessor logic
    when(paymentProcessor.processPayment(any(Order.class))).thenReturn(false);

    // When
    Order newOrder = orderService.createOrder(orderAmount);

    // Then
    verify(paymentProcessor).processPayment(any(Order.class));
    assertThat(newOrder.isPaid()).isFalse();
  }
}
