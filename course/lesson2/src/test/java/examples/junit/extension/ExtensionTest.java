package examples.junit.extension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ConditionalOnEnvironmentExtension.class, DependencyExtension.class})
class ExtensionTest {

  @Test
  void test1(Dependency dependency) {
    assertNotNull(dependency);
  }

  @Test
  @RunOnlyForPreProd
  void test2(Dependency dependency) {
    assertNotNull(dependency);
  }

}
