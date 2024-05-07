package org.andersenlab.examples;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

  private static final String JDBC_URL = "jdbc:h2:~/testdb;INIT=RUNSCRIPT FROM 'classpath:schema.sql'";
  private static final String USER = "sa";
  private static final String PASSWORD = "";

  public static void main(String[] args) {
    TransactionExample example = new TransactionExample();

    System.out.println("Пример 1");
    example.runTransaction(true);

    System.out.println("Пример 2");
    example.runTransaction(false);
  }

  public void runTransaction(boolean shouldFailTransaction) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
      // Отключаем auto-commit, чтобы управлять транзакцией вручную
      conn.setAutoCommit(false);

      try {
        // Добавление данных в таблицу
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO accounts (user_name, balance) VALUES (?, ?)")) {
          stmt.setString(1, "John Doe");
          stmt.setBigDecimal(2, new BigDecimal("1000.00"));
          stmt.executeUpdate();
        }

        // Имитация ошибки (например, некорректное обновление)
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE user_name = ?")) {
          stmt.setBigDecimal(1, new BigDecimal("1200.00")); // Сумма больше баланса
          stmt.setString(2, "John Doe");
          stmt.executeUpdate();

          // Проверяем условие, которое приведет к откату
          if (shouldFailTransaction) {
            throw new RuntimeException("Недостаточно средств на счете");
          }
        }

        // Если все операции успешны, коммитим транзакцию
        conn.commit();
        System.out.println("Транзакция успешно выполнена и зафиксирована.");
      } catch (Exception e) {
        // Произошла ошибка, выполняем откат всех изменений
        conn.rollback();
        System.out.println("Транзакция откачена: " + e.getMessage());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
