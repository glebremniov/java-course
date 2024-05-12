package org.andersenlab.repository.impl;

import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.Getter;
import org.andersenlab.config.EntityManagerConfig;
import org.andersenlab.entity.User;
import org.andersenlab.repository.jpa.JpaRepository;
import org.andersenlab.repository.UserRepository;

public class JpaUserRepository
    extends JpaRepository<User, Long>
    implements UserRepository {

  @Getter(AccessLevel.PROTECTED)
  private final EntityManager entityManager = EntityManagerConfig.getEntityManager();

  public JpaUserRepository() {
    super(User.class);
  }

  @Override
  public boolean existsByUsername(String username) {
    return !entityManager.createQuery("from User where username = :username")
        .setParameter("username", username)
        .getResultList()
        .isEmpty();
  }

}
