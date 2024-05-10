package org.andersenlab.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConfig {

  private final static EntityManagerFactory emf = Persistence
      .createEntityManagerFactory("com.andersen.lesson6");

  public static EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}
