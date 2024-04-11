package examples.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing specifications")
class DisplayNameAndDisabledTest {

  @Test
  @DisplayName("Test #1")
  void test1() {
    // Given
    var a = 2;
    var b = 3;
    var expected = 5;

    // When
    var actual = a + b;

    // Then
    assertEquals(expected, actual);
  }

  @Disabled
  @Test
  @DisplayName("Test #2 (disabled)")
  void disabledTest() {
    assertEquals(10, 5 + 5);
  }
}
