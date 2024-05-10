package org.andersenlab;

import lombok.extern.slf4j.Slf4j;
import org.andersenlab.config.HibernateConfig;
import org.andersenlab.entity.User;
import org.andersenlab.impl.HibernateUserRepository;

@Slf4j
public class Main {

  public static void main(String[] args) {

    var userRepository = new HibernateUserRepository();

    var user = new User();

    user.setEmail("test@gmail.com");
    user.setUsername("testuser");

    log.info("Save user: {}", user);
    userRepository.save(user);

    log.info("Users: {}", userRepository.findAll());

    user.setName("Test User");
    log.info("Update user: {}", user);
    userRepository.update(user);

    log.info("Users after update: {}", userRepository.findAll());

    log.info("Exists before deletion: {}", userRepository.existsByUsername(user.getUsername()));
    userRepository.delete(user);
    log.info("Exists after deletion: {}", userRepository.existsByUsername(user.getUsername()));
  }

  private static void dummyExample() {
    var configuration = HibernateConfig.getConfig();

    try (var sessionFactory = configuration.buildSessionFactory()) {
      var session = sessionFactory.openSession();

      session.beginTransaction();

      var user = new User();

      user.setEmail("test123@gmail.com");
      user.setUsername("testuser123");

      session.persist(user);
      session.getTransaction().commit();
    }
  }
}
