package org.andersenlab.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public record DataSourceConfig(String dbUrl, String dbUser, String dbPassword) {

  public DataSource getDataSource() {
    var dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(dbUrl);
    dataSource.setUsername(dbUser);
    dataSource.setPassword(dbPassword);
    return dataSource;
  }

}
