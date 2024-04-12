[..](./README.md)

AssertJ is a library for assertion in Java tests that provides a rich and intuitive interface for writing assertions. This makes test code more readable and maintainable. AssertJ is a popular alternative to the standard JUnit assertions due to its power and flexibility. Here are the main features of AssertJ:

### 1. Fluent Assertion API
AssertJ uses a fluent API or method chaining, which allows assertions to be chained together, making them more expressive and easier to read:
```java
assertThat(frodo.getName()).isEqualTo("Frodo");
```

### 2. Support for Various Data Types
- **Primitive types and objects**: AssertJ offers assertions to check values of primitive types and objects.
- **Collections and arrays**: AssertJ has powerful capabilities for checking the contents of collections and arrays.
- **Exceptions**: Enables easy checking of exceptions being thrown.
- **Date and time**: Assertions to work with the new Date and Time API in Java 8.

### 3. Assertions for Collections
AssertJ provides a rich set of assertions for testing collections, allowing you to check size, elements, element order, and even conditions for each element:
```java
assertThat(Arrays.asList("one", "two", "three"))
  .hasSize(3)
  .contains("one", "two")
  .doesNotContain("four");
```

### 4. Assertions for Strings
String assertions in AssertJ allow you to check content, starts, ends, regex matches, and more:
```java
assertThat("Gandalf the Grey").startsWith("Gandalf").endsWith("Grey")
  .matches("Gandalf the .*");
```

### 5. Integration with Exceptions
AssertJ simplifies testing methods that are expected to throw exceptions through its assertions for exceptions:
```java
assertThatThrownBy(() -> { throw new Exception("boom!"); })
  .isInstanceOf(Exception.class)
  .hasMessageContaining("boom");
```

### 6. Assertions for Dates and Times
AssertJ makes it easy to test the Date and Time API in Java 8, checking dates, times, and their combinations:
```java
assertThat(LocalDate.of(2017, 1, 1)).isBefore(LocalDate.of(2017, 1, 2));
```

### 7. Custom Assertions
AssertJ allows the creation of custom assertions that meet the specific requirements of your project or domain, extending the basic functionality provided by assertions.

### 8. Assertions for Files
File and path verification is also possible with AssertJ, allowing checks on file existence, content, and other attributes:
```java
assertThat(Paths.get("status.txt")).exists().isReadable();
```

### 9. Working with JSON
AssertJ offers assertions for testing JSON data through additional modules, which can be integrated to extend its basic capabilities.

### 10. Soft Assertions
Soft assertions allow multiple assertions in one test block, collecting all errors and presenting them at the end of the test execution:
```java
SoftAssertions softly = new SoftAssertions();
softly.assertThat(1).isEqualTo(1);
softly.assertThat(1).isNotEqualTo(1); // This will not stop the test execution
softly.assertAll(); // This will report all failures at once
```

AssertJ is a powerful tool for enhancing the quality and maintenance of tests, making assertions more visual and easier to understand.
