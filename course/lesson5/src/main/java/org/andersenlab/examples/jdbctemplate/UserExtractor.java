package org.andersenlab.examples.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.andersenlab.examples.jdbctemplate.JdbcTemplate.ResultSetExtractor;

public class UserExtractor implements ResultSetExtractor<User> {

  @Override
  public User extractData(ResultSet rs) throws SQLException {
    if (rs.next()) {
      var id = rs.getLong("id");
      var name = rs.getString("name");
      var age = rs.getInt("age");

      return new User(id, name, age);
    }

    return null;
  }
}
