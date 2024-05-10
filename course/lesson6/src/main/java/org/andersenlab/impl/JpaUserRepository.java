package org.andersenlab.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import org.andersenlab.config.EntityManagerConfig;
import org.andersenlab.entity.User;
import org.andersenlab.repository.UserRepository;

public class JpaUserRepository implements UserRepository {

  @PersistenceContext
  private final EntityManager entityManager;

  public JpaUserRepository() {
    entityManager = EntityManagerConfig.getEntityManager();
  }

  @Override
  public boolean existsByUsername(String username) {
    return entityManager.createQuery("from User where username = :username")
        .setParameter("username", username)
        .getSingleResult() != null;
  }

  @Override
  public List<User> findAll() {
    return entityManager.createQuery("from User", User.class)
        .getResultList();
  }

  @Override
  public void save(User user) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(user);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  @Override
  public Optional<User> findById(Long id) {
    return Optional.ofNullable(entityManager.find(User.class, id));
  }

  @Override
  public void update(User user) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(user);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

  @Override
  public void delete(User user) {
    try {
      entityManager.getTransaction().begin();
      entityManager.remove(user);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }
}
