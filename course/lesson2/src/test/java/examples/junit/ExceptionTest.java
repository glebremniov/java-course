package examples.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

  @Test
  void exceptionTesting() {
    Exception exception = assertThrows(NumberFormatException.class, () -> {
      Integer.parseInt("One");
    });

    assertEquals("For input string: \"One\"", exception.getMessage());
  }
}
