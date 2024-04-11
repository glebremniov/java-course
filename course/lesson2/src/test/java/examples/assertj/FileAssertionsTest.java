package examples.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class FileAssertionsTest {

  @Test
  void testFileAssertions() {
    var path = Paths.get("src/test/resources/test.txt");

    assertThat(path).exists()
        .isRegularFile()
        .hasContent("test content\n")
        .hasFileName("test.txt");

    assertThat(Files.isReadable(path)).isTrue();
  }
}
