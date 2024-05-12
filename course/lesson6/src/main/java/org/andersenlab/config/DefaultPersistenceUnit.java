package org.andersenlab.config;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.andersenlab.entity.Device;
import org.andersenlab.entity.Resource;
import org.andersenlab.entity.User;
import org.andersenlab.entity.Vehicle;

@RequiredArgsConstructor
public class DefaultPersistenceUnit implements PersistenceUnitInfo {

  public static final String PERSISTENCE_UNIT_NAME = "default";
  private static final String PERSISTENCE_PROVIDER_CLASS_NAME =
      "org.hibernate.jpa.HibernatePersistenceProvider";

  private final DataSourceConfig datasourceConfig;
  
  private final List<String> managedClassNames = List.of(
      Device.class.getName(),
      Resource.class.getName(),
      User.class.getName(),
      Vehicle.class.getName()
  );

  @Override
  public String getPersistenceUnitName() {
    return PERSISTENCE_UNIT_NAME;
  }

  @Override
  public String getPersistenceProviderClassName() {
    return PERSISTENCE_PROVIDER_CLASS_NAME;
  }

  @Override
  public PersistenceUnitTransactionType getTransactionType() {
    return PersistenceUnitTransactionType.RESOURCE_LOCAL;
  }

  @Override
  public DataSource getJtaDataSource() {
    return datasourceConfig.getDataSource();
  }

  @Override
  public DataSource getNonJtaDataSource() {
    return null;
  }

  @Override
  public List<String> getMappingFileNames() {
    return List.of();
  }

  @Override
  public List<URL> getJarFileUrls() {
    return List.of();
  }

  @Override
  public URL getPersistenceUnitRootUrl() {
    return null;
  }

  @Override
  public List<String> getManagedClassNames() {
    return this.managedClassNames;
  }

  @Override
  public boolean excludeUnlistedClasses() {
    return false;
  }

  @Override
  public SharedCacheMode getSharedCacheMode() {
    return null;
  }

  @Override
  public ValidationMode getValidationMode() {
    return null;
  }

  @Override
  public Properties getProperties() {
    return null;
  }

  @Override
  public String getPersistenceXMLSchemaVersion() {
    return "";
  }

  @Override
  public ClassLoader getClassLoader() {
    return null;
  }

  @Override
  public void addTransformer(ClassTransformer transformer) {

  }

  @Override
  public ClassLoader getNewTempClassLoader() {
    return null;
  }
}
