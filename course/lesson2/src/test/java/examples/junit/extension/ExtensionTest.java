package examples.junit.extension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ConditionalOnEnvironmentExtension.class, DependencyExtension.class})
class ExtensionTest {

  @Test
  void test1(Dependency dependency) {
    assertTrue(dependency.isConfigured());
    assertNotNull(dependency);
  }

  @Test
  @RunOnlyForPreProd
  void test2(Dependency dependency) {
    assertNotNull(dependency);
  }

}
