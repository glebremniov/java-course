package examples.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;

class RepeatedTests {

  @RepeatedTest(5)
  void repeatedTest() {
    assertEquals(2, Math.sqrt(4), "Should return the square root of the argument");
  }
}
