package examples.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleTypesTest {

  @Test
  void testSimpleAssertions() {
    int actual = 5 + 5;

    assertThat(actual).isEqualTo(10);
    assertThat(actual).isBetween(9, 11);
    assertThat(actual).isGreaterThan(9);
  }
}
