package examples.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTests {

  static class StringUtils {

    public static boolean isBlank(String input) {
      return input == null || input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
      return new StringBuilder(input).reverse().toString().equals(input);
    }

  }

  @Nested
  class IsPalindrome {

    @ParameterizedTest
    @ValueSource(strings = {"radar", "madam", "racecar"})
    void palindromes(String candidate) {
      // When
      var actual = StringUtils.isPalindrome(candidate);
      // Then
      assertTrue(actual);
    }
  }

  @Nested
  class EnumSourceExampleTest {

    enum Color {
      RED, BLUE, GREEN
    }

    @ParameterizedTest
    @EnumSource(Color.class)
    void withEnumSource(Color color) {
      assertNotNull(color);
    }
  }

  @Nested
  class MethodSourceExampleTest {

    @ParameterizedTest
    @MethodSource("testParams")
    void withMethodSource(String input, boolean expected) {
      assertEquals(expected, StringUtils.isBlank(input));
    }

    private static Stream<Arguments> testParams() {
      return Stream.of(
          Arguments.of(null, true),
          Arguments.of("", true),
          Arguments.of("  ", true),
          Arguments.of("not blank", false)
      );
    }
  }

  @Nested
  class CsvSourceExampleTest {

    @ParameterizedTest
    @CsvSource({
        "test, TEST",
        "tEst, TEST",
        "Java, JAVA"
    })
    void withCsvSource(String input, String expected) {
      assertEquals(expected, input.toUpperCase());
    }
  }

  @Nested
  class ArgumentsSourceExampleTest {

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void withArgumentsSource(String argument) {
      assertTrue(argument.contains("a"));
    }

    static class CustomArgumentsProvider implements ArgumentsProvider {

      @Override
      public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of("apple", "banana").map(Arguments::of);
      }
    }
  }
}
