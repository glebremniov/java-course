package examples.assertj;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ExceptionAssertionsTest {

  @Test
  void testExceptionAssertions() {
    assertThatThrownBy(() -> { throw new IllegalArgumentException("Bad argument"); })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Bad");

    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> { throw new IllegalArgumentException("Bad argument"); })
        .withMessage("%s argument", "Bad")
        .withNoCause();
  }
}
