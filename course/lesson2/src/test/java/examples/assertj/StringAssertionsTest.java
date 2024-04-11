package examples.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringAssertionsTest {

  @Test
  void testStringAssertions() {
    String actualString = "Game of Thrones";

    assertThat(actualString).startsWith("Game")
        .isNotBlank()
        .isNotEmpty()
        .endsWith("Thrones")
        .containsIgnoringCase("of")
        .doesNotContain("Ring")
        .isEqualToIgnoringCase("Game of Thrones");
  }
}
