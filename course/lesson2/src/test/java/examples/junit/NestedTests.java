package examples.junit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestedTests {

  @Nested
  class InnerClass {

    @Test
    void innerTest1() {
      assertNotEquals(1, 2);
    }

    @Test
    void innerTest2() {
      assertThrows(ArithmeticException.class, () -> divide(1, 0));
    }

    private int divide(int a, int b) {
      return a / b;
    }
  }
}
