package examples.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LifecycleHooksTest {

  private static int beforeAllInvoked = 0;
  private int beforeEachTestInvoked = 0;

  @BeforeAll
  static void setup() {
    beforeAllInvoked++;
    System.out.println("Before all tests.");
  }

  @BeforeEach
  void init() {
    beforeEachTestInvoked++;
    System.out.println("Before each test.");
  }

  @Test
  void test1() {
    System.out.println("Test 1 executing.");
    assertEquals(1, beforeEachTestInvoked);
  }

  @Test
  void test2() {
    System.out.println("Test 2 executing.");
    assertEquals(1, beforeEachTestInvoked);
  }

  @AfterEach
  void tearDown() {
    System.out.println("After each test.");
  }

  @AfterAll
  static void done() {
    System.out.println("After all tests.");
    assertEquals(1, beforeAllInvoked);
  }
}
