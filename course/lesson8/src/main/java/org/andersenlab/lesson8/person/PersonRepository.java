package org.andersenlab.lesson8.person;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

  Optional<PersonEntity> findByUsername(String username);

  Optional<PersonEntity> findByUsernameIgnoreCase(String username);

  List<PersonEntity> findDistinctByFirstNameOrderByFirstNameAsc(String firstName);

  @Query("from Person p where p.active = 1")
  List<PersonEntity> findAllActive();

  @Query(
      value = "SELECT * FROM persons p WHERE p.active = 1",
      nativeQuery = true
  )
  List<PersonEntity> findAllActiveNative();

}
