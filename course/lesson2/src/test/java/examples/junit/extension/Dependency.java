package examples.junit.extension;

public class Dependency {

  private boolean isConfigured;

  public void configure() {
    isConfigured = true;
    System.out.println("Dependency configured!");
  }

  public void cleanUp() {
    isConfigured = false;
    System.out.println("Dependency cleaned up!");
  }

  public boolean isConfigured() {
    return isConfigured;
  }
}
