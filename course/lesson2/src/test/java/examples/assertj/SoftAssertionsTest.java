package examples.assertj;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class SoftAssertionsTest {

  @Test
  void testSoftAssertions() {
    SoftAssertions softAssertions = new SoftAssertions();

    //softAssertions.assertThat(1).isEqualTo(2); // This will not stop the test
    softAssertions.assertThat(1).isEqualTo(1);

    softAssertions.assertAll(); // This will collect and report all failures at once
  }
}
