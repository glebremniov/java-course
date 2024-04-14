package examples.junit.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class DependencyExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {

  private final Dependency dependency = new Dependency();

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    dependency.configure();
  }

  @Override
  public void afterAll(ExtensionContext extensionContext) {
    dependency.cleanUp();
  }

  @Override
  public boolean supportsParameter(
      ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {

    return parameterContext.getParameter().getType().equals(Dependency.class);
  }

  @Override
  public Object resolveParameter(
      ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {

    return dependency;
  }
}
