package examples.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTests {

  @ParameterizedTest
  @ValueSource(strings = { "radar", "madam", "racecar" })
  void palindromes(String candidate) {
    assertTrue(isPalindrome(candidate));
  }

  private boolean isPalindrome(String input) {
    return new StringBuilder(input).reverse().toString().equals(input);
  }
}
