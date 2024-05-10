package org.andersenlab.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.andersenlab.config.HibernateConfig;
import org.andersenlab.entity.User;
import org.andersenlab.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Slf4j
public class HibernateUserRepository implements UserRepository {

  private final SessionFactory sessionFactory;

  public HibernateUserRepository() {
    var configuration = HibernateConfig.getConfig();
    this.sessionFactory = configuration.buildSessionFactory();
  }


  @Override
  public void save(User user) {
    withTransaction(session -> session.persist(user));
  }

  @Override
  public List<User> findAll() {
    try {
      return withSession(session -> session.createQuery("from User", User.class).list());
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  @Override
  public Optional<User> findById(Long id) {
    try {
      return withSession(session -> Optional.ofNullable(session.get(User.class, id)));
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  @Override
  public void update(User user) {
    withTransaction(session -> session.merge(user));
  }

  @Override
  public void delete(User user) {
    withTransaction(session -> session.remove(user));
  }

  @Override
  public boolean existsByUsername(String username) {
    final var query = "select 1 from User where username = :username";

    try {
      return withSession(session ->
          Optional.ofNullable(session.createSelectionQuery(query, Integer.class)
                  .setParameter("username", username)
                  .setMaxResults(1)
                  .uniqueResult())
              .isPresent()
      );
    } catch (Exception e) {
      return false;
    }
  }

  protected Session getSession() {
    return sessionFactory.openSession();
  }

  private <E> E withSession(Function<Session, E> function) throws Exception {
    try (var session = getSession()) {
      return function.apply(session);
    } catch (Exception e) {
      log.error(e.getLocalizedMessage(), e);
      throw e;
    }
  }

  private void withTransaction(Consumer<Session> action) {
    Transaction transaction = null;

    try (var session = getSession()) {
      transaction = session.beginTransaction();

      action.accept(session);

      transaction.commit();
    } catch (Exception e) {
      rollback(transaction, e);
    }
  }

  private void rollback(Transaction transaction, Exception e) {
    if (transaction != null) {
      transaction.rollback();
    }

    log.error(e.getLocalizedMessage(), e);
  }

}
