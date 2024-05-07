package org.andersenlab.examples.jdbctemplate;

import java.sql.*;

public class JdbcTemplate {
  private final String url;
  private final String username;
  private final String password;

  public JdbcTemplate(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public <T> T query(String sql, ResultSetExtractor<T> extractor) {
    try (Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      return extractor.extractData(rs);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int update(String sql) {
    try (Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement()) {
      return stmt.executeUpdate(sql);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @FunctionalInterface
  public interface ResultSetExtractor<T> {
    T extractData(ResultSet rs) throws SQLException;
  }
}
