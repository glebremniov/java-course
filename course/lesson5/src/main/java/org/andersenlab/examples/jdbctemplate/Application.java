package org.andersenlab.examples.jdbctemplate;

public class Application {
  public static void main(String[] args) {
    var jdbcTemplate = new JdbcTemplate("jdbc:h2:~/testdb;INIT=RUNSCRIPT FROM 'classpath:schema.sql'", "sa", "");
    var userExtractor = new UserExtractor();

    // Пример запроса
    var user = jdbcTemplate.query("SELECT * FROM test_users WHERE id = 1", userExtractor);
    System.out.println("User: " + user);

    String name = jdbcTemplate.query("SELECT name FROM test_users WHERE id = 1", rs -> {
      if (rs.next()) {
        return rs.getString("name");
      }
      return null;
    });
    System.out.println("Name: " + name);

    // Пример обновления
    int updateCount = jdbcTemplate.update("UPDATE test_users SET name = 'Doe John' WHERE id = 1");
    System.out.println("Update count: " + updateCount);
  }
}
