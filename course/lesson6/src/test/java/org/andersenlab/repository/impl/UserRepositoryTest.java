package org.andersenlab.repository.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.andersenlab.entity.User;
import org.andersenlab.repository.UserRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserRepositoryTest {

  @ParameterizedTest
  @MethodSource("repositories")
  void dummyTest(UserRepository userRepository) {
    assertDoesNotThrow(() -> UserRepositoryTestUtil.dummyTest(userRepository));
  }

  private static Stream<Arguments> repositories() {
    return Stream.of(
        Arguments.of(new HibernateUserRepository()),
        Arguments.of(new JpaUserRepository())
    );
  }

  @Slf4j
  static class UserRepositoryTestUtil {

    public static void dummyTest(UserRepository repository) {
      var user = new User();

      user.setEmail("test@gmail.com");
      user.setUsername("testuser");

      log.info("Save user: {}", user);
      repository.save(user);

      log.info("Users: {}", repository.findAll());

      user.setName("Test User");
      log.info("Update user: {}", user);
      repository.update(user);

      log.info("Users after update: {}", repository.findAll());

      log.info("Exists before deletion: {}", repository.existsByUsername(user.getUsername()));

      repository.delete(user);
      log.info("Exists after deletion: {}", repository.existsByUsername(user.getUsername()));
    }
  }
}
