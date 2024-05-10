package org.andersenlab.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<ID, ENTITY> {

  List<ENTITY> findAll();

  void save(ENTITY entity);

  Optional<ENTITY> findById(ID id);

  void update(ENTITY entity);

  void delete(ENTITY entity);

  default void deleteById(ID id) {
    findById(id).ifPresent(this::delete);
  }

}
