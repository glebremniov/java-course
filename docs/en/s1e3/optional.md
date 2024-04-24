# Optional

[..](./README.md)

`Optional` in Java is a container class introduced in Java 8 that can contain a value or not. This class is designed to represent the possible absence of a value and is used as an alternative to returning `null` from methods. Using `Optional` helps avoid `NullPointerException` and makes the code clearer in terms of handling situations where there might not be a value.

### Key Principles of Using `Optional`:

1. **Avoiding `null`**: `Optional` is a way of explicitly expressing that a value might be absent, which helps reduce the likelihood of `NullPointerException`.

2. **Code Readability**: Using `Optional` improves code readability as it makes the developer's intention clear regarding values that may or may not be present.

3. **Functional Style**: `Optional` offers methods for performing conditional actions in a functional style, such as `map`, `flatMap`, `filter`, and others.

### Examples of `Optional` Methods:

- **`Optional.of(value)`**: Creates an `Optional` with a non-null value. If the value is `null`, it throws a `NullPointerException`.

- **`Optional.empty()`**: Creates an empty `Optional` object.

- **`Optional.ofNullable(value)`**: Creates an `Optional` object that may contain `null`.

- **`isPresent()`**: Returns `true` if there is a value present in the `Optional`.

- **`isEmpty()`**: Returns `true` if there is no value present in the `Optional` (added in Java 11).

- **`get()`**: Returns the value if present, or throws a `NoSuchElementException` if the value is absent.

- **`orElse(defaultValue)`**: Returns the value if present, or `defaultValue` if the value is absent.

- **`orElseGet(supplier)`**: Returns the value if present, or the result of executing `supplier` if the value is absent.

- **`orElseThrow(exceptionSupplier)`**: Returns the value if present, or throws an exception created by `exceptionSupplier` if the value is absent.

### Example of Using `Optional`:

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");

        // Print the value if it is present
        optional.ifPresent(System.out::println);

        // Example of using orElse
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Default Name");
        System.out.println(name);  // Outputs "Default Name"

        // Example of using orElseThrow
        try {
            String anotherName = Optional.ofNullable(nullName)
                                         .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

Using `Optional` in Java helps improve program reliability by avoiding `null`-related errors and contributes to writing code that is easier to understand and maintain.

In Java, the `Optional.or()` method is a relatively new feature added in Java 9. It allows you to provide an alternative `Optional` in case the original `Optional` turns out to be empty. This can be particularly useful in scenarios where you need to provide a fallback or continue a chain of operations with `Optional`.

### Example of Using `Optional.or()`

Imagine a situation where we have a method that might return a default value or continue other operations if the first `Optional` turns out to be empty.

Suppose we have methods for retrieving a user from the database by ID, as well as a method for obtaining a default value if the user is not found:

```java
import java.util.Optional;

public class OptionalOrExample {

    public static void main(String[] args) {
        // Retrieving a user by ID
        Optional<String> user = getUserById(1);

        // If no user is found, try to get a default user
        String result = user.or(() -> getDefaultUser())
                            .get(); // Using get(), because we are sure one of the Optionals contains a value

        System.out.println(result); // Prints the name of the user or the default user name
    }

    private static Optional<String> getUserById(int id) {
        // Let's pretend the user with ID 1 is not found
        if (id == 1) {
            return Optional.empty();
        } else {
            return Optional.of("John Doe");
        }
    }

    private static Optional<String> getDefaultUser() {
        return Optional.of("Default User");
    }
}
```

In this example, if the `getUserById()` method returns an empty `Optional`, the `or()` method allows us to switch to another method, `getDefaultUser()`, which returns an `Optional` of a default user. This ensures smooth execution without the need for `null` checks or conditional statements.

The `or()` method can be useful in complex conditions where you need to ensure the continuation of operations with multiple possible data sources or fallback options. It helps maintain code cleanliness and readability, minimizing `null` checks and nested conditional constructs.
