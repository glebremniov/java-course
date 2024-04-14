package com.andersenlab.lesson2.authorizationservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthorizationServiceTest {

  private static final UUID USER_ID = UUID.fromString("445fdbab-eefe-4fa8-904f-acd18668bed5");

  @Mock
  private UserRepository repository;

  @InjectMocks
  private AuthorizationService service;

  @Nested
  class HappyPath {

    @ParameterizedTest
    @EnumSource(Operation.class)
    void should_ReturnTrue_When_UserExistsAndHasAllPermissions(Operation op) {
      // Given
      var user = new User(USER_ID, EnumSet.allOf(Operation.class));
      // Simulate that given user exist with all operations
      when(repository.getById(USER_ID)).thenReturn(user);

      // When
      var actual = service.isAuthorized(USER_ID, op);

      // Then
      assertThat(actual)
          .isTrue();
    }

    @ParameterizedTest
    @EnumSource(Operation.class)
    void should_ReturnTrue_When_UserExistsAndHasOnlyGivenPermissions(Operation op) {
      // Given
      var user = new User(USER_ID, EnumSet.of(op));
      // Simulate that given user exist with the given operation
      when(repository.getById(USER_ID)).thenReturn(user);

      // When
      var actual = service.isAuthorized(USER_ID, op);

      // Then
      assertThat(actual)
          .isTrue();
    }
  }

  @Nested
  class UnhappyPath {

    @ParameterizedTest
    @EnumSource(Operation.class)
    void should_ReturnFalse_When_UserExistsButWithNoPermissions(Operation op) {
      // Given
      var otherOperations = getAllOperationsExcluding(op);
      var user = new User(USER_ID, otherOperations);
      // Simulate that given user exist but with some operations but not the given one
      when(repository.getById(USER_ID)).thenReturn(user);

      // When
      var actual = service.isAuthorized(USER_ID, op);

      // Then
      assertThat(actual)
          .isFalse();
    }

    @ParameterizedTest
    @EnumSource(Operation.class)
    void should_ReturnFalse_When_UserExistsButWithoutGivenPermission(Operation op) {
      // Given
      var user = new User(USER_ID, EnumSet.noneOf(Operation.class));
      // Simulate that given user exists but with no operations
      when(repository.getById(USER_ID)).thenReturn(user);

      // When
      var actual = service.isAuthorized(USER_ID, op);

      // Then
      assertThat(actual)
          .isFalse();
    }

    @Test
    void should_ReturnFalse_When_UserNotFound() {
      // Given
      // Simulate that given user doesn't exist
      when(repository.getById(USER_ID)).thenReturn(null);

      // When
      var actual = service.isAuthorized(USER_ID, Operation.READ);

      // Then
      assertThat(actual)
          .isFalse();
    }

    private static EnumSet<Operation> getAllOperationsExcluding(Operation op) {
      // All operation - given operation = rest operations
      var otherOperations = Arrays.stream(Operation.values())
          .filter(Predicate.not(operation -> operation.equals(op)))
          .collect(Collectors.toSet());

      return EnumSet.copyOf(otherOperations);
    }
  }
}
