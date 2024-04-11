package examples.assertj;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JsonAssertionsTest {

  @Test
  void testJsonAssertions() {
    String json = "{\"name\":\"John\", \"age\":30}";

    assertThat(json).as("check JSON")
        .isNotEmpty()
        .contains("\"name\":\"John\"")
        .doesNotContain("unexpected");
  }
}
