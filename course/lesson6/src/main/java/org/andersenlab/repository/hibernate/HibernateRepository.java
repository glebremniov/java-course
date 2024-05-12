package org.andersenlab.repository.hibernate;

import jakarta.persistence.EntityTransaction;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.andersenlab.repository.CrudRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Slf4j
public abstract class HibernateRepository<ENTITY, ID>
    implements CrudRepository<ID, ENTITY> {

  private final Class<ENTITY> entityClass;

  protected HibernateRepository(Class<ENTITY> entityClass) {
    this.entityClass = entityClass;
  }

  protected abstract Session getSession();

  @Override
  public void save(ENTITY entity) {
    withTransaction(session -> session.persist(entity));
  }

  @Override
  public List<ENTITY> findAll() {
    try {
      final var query = "from %s".formatted(entityClass.getSimpleName());
      return withSession(session -> session.createQuery(query, entityClass).list());
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  @Override
  public Optional<ENTITY> findById(ID id) {
    try {
      return withSession(session -> Optional.ofNullable(session.get(entityClass, id)));
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  @Override
  public void update(ENTITY entity) {
    withTransaction(session -> session.merge(entity));
  }

  @Override
  public void delete(ENTITY entity) {
    withTransaction(session -> session.remove(entity));
  }

  protected <E> E withSession(Function<Session, E> function) {
    try (var session = getSession()) {
      return function.apply(session);
    } catch (Exception e) {
      log.error(e.getLocalizedMessage(), e);
      throw e;
    }
  }

  protected void withTransaction(Consumer<Session> action) {
    Transaction transaction = null;

    try (var session = getSession()) {
      transaction = session.beginTransaction();

      action.accept(session);

      transaction.commit();
    } catch (Exception e) {
      rollback(transaction, e);
      throw e;
    }
  }

  private void rollback(Transaction txn, Exception e) {
    log.error(e.getLocalizedMessage(), e);

    Optional.ofNullable(txn)
        .ifPresent(EntityTransaction::rollback);
  }

}
