package examples.junit.extension;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ConditionalOnEnvironmentExtension implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    if (context.getTestInstance().isEmpty()) {
      return ConditionEvaluationResult.enabled("Not a test method context");
    }

    if (context.getRequiredTestMethod().getAnnotation(RunOnlyForPreProd.class) == null) {
      return ConditionEvaluationResult.enabled("Not annotated with RunOnlyForPreProd");
    }

    var environment = System.getenv().get("Environment");
    if ("PreProd".equals(environment)) {
      return ConditionEvaluationResult.enabled("Pre prod environment");
    }

    return ConditionEvaluationResult.disabled("Not a pre prod environment");
  }
}
