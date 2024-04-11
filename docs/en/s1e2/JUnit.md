JUnit 5 is a modern testing framework for the Java programming language that succeeds JUnit 4 and offers significant improvements and new features for developers. Here are the main capabilities of JUnit 5 categorized by their functionality:

### 1. JUnit 5 Architecture
JUnit 5 consists of three main modules:

- **JUnit Platform**: The foundation that allows test frameworks to launch on the JVM. It provides the API for developing test engines.
- **JUnit Jupiter**: The module that provides the new API and its implementation for writing tests and extensions in JUnit 5.
- **JUnit Vintage**: The module for running tests written using JUnit 3 and 4 on the JUnit 5 platform.

### 2. Annotations
JUnit Jupiter introduces a number of new annotations, expanding testing capabilities:

- `@Test`: Indicates that a method is a test method.
- `@ParameterizedTest`: Indicates a parameterized test that runs multiple times with different parameters.
- `@RepeatedTest`: Specifies that a test should be executed multiple times.
- `@BeforeEach` / `@AfterEach`: Methods to run before and after each test, respectively.
- `@BeforeAll` / `@AfterAll`: Methods to run once before all tests and once after all tests in the current class.
- `@DisplayName`: Provides a human-readable name for the test or test class.
- `@Nested`: Allows organizing tests into nested structures for better organization and readability.
- `@Tag`: Provides the ability to classify tests into categories.
- `@Disabled`: Allows disabling a test or group of tests temporarily.

### 3. Assertions and Assumptions
JUnit Jupiter extends the set of assertions and provides more powerful ways to verify conditions:

- `Assertions.*`: Contains static methods for assertions (`assertEquals`, `assertTrue`, `assertAll` for grouped assertions, etc.).
- `Assumptions.*`: Allows making assumptions in tests (`assumeTrue`, which can abort the test if the condition is not met).

### 4. Extensions
JUnit Jupiter supports a mechanism for extensions through interfaces and annotations:

- Extensions can intervene in the test execution process at various stages: initialization, execution, exception handling, and finishing.
- Examples include `BeforeEachCallback`, `AfterEachCallback`, `BeforeAllCallback`, `AfterAllCallback`, `ParameterResolver`, etc.

### 5. Parameterized Tests and Argument Sources
JUnit Jupiter provides powerful tools for writing parameterized tests:

- `@ValueSource`, `@EnumSource`, `@MethodSource`, `@CsvSource`, `@CsvFileSource`, `@ArgumentsSource` allow specifying arguments for parameterized tests.

### 6. IDE and Build System Integration
JUnit 5 easily integrates with popular development environments (IDEs) such as IntelliJ IDEA, Eclipse, and build systems like Maven and Gradle, thanks to the use of the JUnit Platform.

These capabilities make JUnit 5 a flexible and powerful tool for developers, allowing for more precise control over the testing process, easier organization of tests, and more efficient use of test code.
