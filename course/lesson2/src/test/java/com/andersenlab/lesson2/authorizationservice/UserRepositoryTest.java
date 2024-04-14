package com.andersenlab.lesson2.authorizationservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.EnumSet;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserRepositoryTest {

  private static final UUID VALID_UUID = UUID.fromString("0691d20d-d791-419f-ac30-02521a9259d5");
  private final UserRepository repository = new UserRepository();

  @DisplayName("Test UserRepository.count() method")
  @Nested
  class Count {

    @Test
    void should_ReturnZero_When_NoUsers() {
      // When
      var actual = repository.count();

      // Then
      assertThat(actual).isZero();
    }

    @ParameterizedTest
    @MethodSource("users")
    void should_ReturnNumberOfStoredUsers_When_GivenUsers(Collection<User> users) {
      // Given
      users.forEach(repository::save);
      var expected = users.size();

      // When
      var actual = repository.count();

      // Then
      assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> users() {
      return Stream.of(0, 2, 10, 99)
          .map(UserTestUtils::generateUsers)
          .map(users -> Arguments.of(users.collect(Collectors.toSet())));
    }
  }

  @DisplayName("Test UserRepository.list() method")
  @Nested
  class List {

    @Test
    void should_ReturnEmptyCollection_When_NoUsersStored() {

      // When
      var actual = repository.list();

      // Then
      assertThat(actual)
          .isNotNull()
          .isEmpty();
    }

    @Test
    void should_ReturnUsers() {
      // Given
      var expected = UserTestUtils.generateUsers(10).toList();
      expected.forEach(repository::save);

      // When
      var actual = repository.list();

      // Then
      assertThat(actual).hasSameElementsAs(expected);
    }
  }

  @DisplayName("Test UserRepository.getById() method")
  @Nested
  class GetById {

    @Test
    void should_ReturnUser_WhenUserExists() {
      // Given
      var expected = repository.save(
          new User(VALID_UUID, EnumSet.of(Operation.READ))
      );

      // When
      var actual = repository.getById(VALID_UUID);

      // Then
      assertThat(actual)
          .isNotNull()
          .isEqualTo(expected);
    }

    @Test
    void should_ReturnNull_WhenUserNotExist() {
      // Given -> When
      var actual = repository.getById(VALID_UUID);

      // Then
      assertThat(actual).isNull();
    }
  }

  @DisplayName("Test UserRepository.save() method")
  @Nested
  class Save {
    // TODO

  }

  @DisplayName("Test UserRepository.delete() method")
  @Nested
  class Delete {
    // TODO
    
  }

  public static class UserTestUtils {

    public static User createUser() {
      return new User(UUID.randomUUID(), EnumSet.of(Operation.READ));
    }

    public static Stream<User> generateUsers(int limit) {
      return Stream.generate(UserTestUtils::createUser).limit(limit);
    }
  }
}
