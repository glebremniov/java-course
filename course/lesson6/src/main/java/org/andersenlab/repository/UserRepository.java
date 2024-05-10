package org.andersenlab.repository;

import org.andersenlab.entity.User;

public interface UserRepository extends CrudRepository<Long, User> {

  boolean existsByUsername(String username);

}
