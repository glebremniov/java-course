package org.andersenlab.repository.jpa;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.andersenlab.repository.CrudRepository;

public abstract class JpaRepository<ENTITY, ID>
    implements CrudRepository<ID, ENTITY> {

  private final Class<ENTITY> entityClass;

  public JpaRepository(Class<ENTITY> type) {
    this.entityClass = type;
  }

  @Override
  public List<ENTITY> findAll() {
    final var query = "from %s".formatted(entityClass.getSimpleName());

    return getEntityManager()
        .createQuery(query, entityClass)
        .getResultList();
  }

  @Override
  public void save(ENTITY entity) {
    withTransaction(() -> getEntityManager()
        .persist(entity));
  }

  @Override
  public Optional<ENTITY> findById(ID id) {
    return Optional.ofNullable(getEntityManager().find(entityClass, id));
  }

  @Override
  public void update(ENTITY entity) {
    withTransaction(() -> getEntityManager().merge(entity));
  }

  @Override
  public void delete(ENTITY entity) {
    withTransaction(() -> getEntityManager().remove(entity));
  }

  protected abstract EntityManager getEntityManager();

  protected void withTransaction(Runnable action) {
    final var entityManager = getEntityManager();
    try {
      entityManager.getTransaction().begin();
      action.run();
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }

}
