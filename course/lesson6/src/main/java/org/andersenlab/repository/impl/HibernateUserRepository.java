package org.andersenlab.repository.impl;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.andersenlab.config.HibernateConfig;
import org.andersenlab.entity.User;
import org.andersenlab.repository.UserRepository;
import org.andersenlab.repository.hibernate.HibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Slf4j
public class HibernateUserRepository
    extends HibernateRepository<User, Long>
    implements UserRepository {

  private final SessionFactory sessionFactory;

  public HibernateUserRepository() {
    super(User.class);
    var configuration = HibernateConfig.getConfig();
    this.sessionFactory = configuration.buildSessionFactory();
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

}
