package org.andersenlab.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

  private static final String JDBC_URL = "jdbc:h2:~/testdb;INIT=RUNSCRIPT FROM 'classpath:schema.sql'";
  private static final String USER = "sa";
  private static final String PASSWORD = "";

  public static void main(String[] args) {
    JDBCExample app = new JDBCExample();
    app.createUser("John Doe", "john.doe@example.com");
    app.readUsers();
    app.updateUser(1, "Johnny Doe", "johnny.doe@example.com");
    app.deleteUser(1);
  }

  public void createUser(String name, String email) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(name, email) VALUES(?, ?)")) {
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.executeUpdate();
      System.out.println("User created.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void readUsers() {
    try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, email FROM users")) {
      while (rs.next()) {
        System.out.println(rs.getInt("id") + ": " + rs.getString("name") + ", " + rs.getString("email"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateUser(int id, String name, String email) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("UPDATE users SET name = ?, email = ? WHERE id = ?")) {
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.setInt(3, id);
      stmt.executeUpdate();
      System.out.println("User updated.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteUser(int id) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
      stmt.setInt(1, id);
      stmt.executeUpdate();
      System.out.println("User deleted.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
