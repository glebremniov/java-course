package org.andersenlab.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.andersenlab.entity.Device;
import org.andersenlab.entity.Resource;
import org.andersenlab.entity.User;
import org.andersenlab.entity.Vehicle;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HibernateConfig {

  private static final Configuration CONFIGURATION;

  static {
    CONFIGURATION = new Configuration();
    CONFIGURATION.addAnnotatedClass(User.class);
    CONFIGURATION.addAnnotatedClass(Resource.class);
    CONFIGURATION.addAnnotatedClass(Device.class);
    CONFIGURATION.addAnnotatedClass(Vehicle.class);
    CONFIGURATION.configure();
  }

  public static Configuration getConfig() {
    return CONFIGURATION;
  }

}
