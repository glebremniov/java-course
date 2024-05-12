package org.andersenlab.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.Optional;
import lombok.Getter;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class EntityManagerConfig {

  private final static EntityManagerFactory emf;
  @Getter
  private final static EntityManager entityManager;

  static {
    var datasourceConfig = new DataSourceConfig(
        getEnv("dbUrl", "jdbc:h2:~/test"),
        getEnv("dbUser", "sa"),
        getEnv("dbPassword", ""));
    
    var persistenceUnit = new DefaultPersistenceUnit(datasourceConfig);

    emf = new HibernatePersistenceProvider()
        .createContainerEntityManagerFactory(persistenceUnit, Collections.emptyMap());

    entityManager = emf.createEntityManager();
  }

  private static String getEnv(String key, String defaultValue) {
    return Optional.ofNullable(System.getenv(key))
        .orElse(defaultValue);
  }

}
