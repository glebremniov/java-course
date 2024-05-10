package org.andersenlab.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.andersenlab.entity.User;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HibernateConfig {

  private static final Configuration CONFIGURATION;

  static {
    CONFIGURATION = new Configuration();
    CONFIGURATION.addAnnotatedClass(User.class);
    CONFIGURATION.configure();
  }

  public static Configuration getConfig() {
    return CONFIGURATION;
  }

}
