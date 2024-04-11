package examples.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasicFeaturesTest {

  @Test
  void simpleTest() {
    assertEquals(20, 10 + 10, "Optional assertion message");
  }

  @Test
  void truthTest() {
    assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- to avoid constructing complex messages unnecessarily.");
  }
}
