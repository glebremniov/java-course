# Stream API

[..](./README.md)

Stream API in Java is a modern API introduced in Java 8 that allows for expressive and efficient processing of data sets (usually collections) using high-level operations on data streams. It provides a functional approach to data processing, based on the use of lambda expressions.

### Key Features of Stream API:
- **Does not store data**: Stream API does not store the data it operates on. It operates on the original collections and arrays as sources of data.
- **Does not modify original data**: All data operations through the Stream API are "non-mutating", meaning they do not change the original collections.
- **Laziness of operations**: Many operations with streams (such as filtering, transformations, and others) are lazy, meaning they are executed only when truly necessary (e.g., when the final result needs to be obtained).
- **Supports parallel processing**: Stream API can transparently perform operations in parallel, simplifying the writing of multithreaded code.

### Examples of Using Stream API

#### 1. Filtering and Counting
Filter a list of strings by a certain criterion and count the number of elements that meet this criterion:

```java
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        long count = names.stream()
                          .filter(name -> name.startsWith("A"))
                          .count();
        System.out.println("Number of names starting with A: " + count);
    }
}
```

#### 2. Transforming Elements
Use `map` to transform each element in a list (for example, convert strings to their lengths):

```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        List<Integer> lengths = names.stream()
                                     .map(String::length)
                                     .toList();
        System.out.println("Lengths of names: " + lengths);
    }
}
```

#### 3. Sorting
Sort a list of elements using a given comparator:

```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        List<String> sortedNames = names.stream()
                                        .sorted()
                                        .toList();
        System.out.println("Sorted names: " + sortedNames);
    }
}
```

#### 4. Summing Elements
Sum the numbers in a list:

```java
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);
    }
}
```

#### 5. Finding Elements
Find the first element in the stream that meets a certain condition:

```java
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        String first = names.stream()
                            .filter(name -> name.startsWith("C"))
                            .findFirst()
                            .orElse("None");
        System.out.println("First name starting with C: " + first);
    }
}
```

### Creating Streams in Stream API
In Java, Stream API provides several ways to create streams. Here are the main methods you can use to create streams:

#### 1. From Collections
The most common way to create a stream is from collections that support the `Collection` interface (e.g., `List` or `Set`):

```java
import java.util.List;
import java.util.stream.Stream;

List<String> myList = List.of("apple", "banana", "pear", "kiwi", "orange");
Stream<String> stream = myList.stream();
```

#### 2. From Arrays
You can create a stream directly from arrays using the `Arrays.stream()` static method:

```java
import java.util.Arrays;
import java.util.stream.Stream;

String[] array = {"apple", "banana", "pear", "kiwi", "orange"};
Stream<String> stream = Arrays.stream(array);
```

#### 3. From Primitive Streams
For primitive data types (int, long, double), specialized streams (`IntStream`, `LongStream`, `DoubleStream`) exist, which can be created using the corresponding methods in the `Arrays` or `Stream` classes:

```java
import java.util.stream.IntStream;

IntStream intStream = IntStream.range(1, 10); // stream of integers from 1 to 9
```

#### 4. From Other Sources
Streams can be created from various sources, including strings, files, or generating them based on functions:

- Using `Stream.of()`:
  ```java
  Stream<String> stream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
  ```

- Generating a stream using `Stream.generate()` or `Stream.iterate()`:
  ```java
  Stream<Double> randomNumbers = Stream.generate(Math::random);
  Stream<Integer> numbers = Stream.iterate(0, n -> n + 1);
  ```

#### 5. From a File
You can create a stream from lines of a file using methods in the `Files` class:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

try (Stream<String> lines = Files.lines(Paths.get("path/to/file.txt"))) {
    lines.forEach(System.out::println);
}
```

#### 6. Using Builder
You can use `Stream.builder()` to manually create a stream:

```java
Stream.Builder<String> builder = Stream.builder();
Stream<String> stream = builder.add("apple").add("banana").add("pear").build();
```

These methods provide flexibility for creating streams from virtually any data source, supporting both static and dynamic data sources in Java applications.

### Methods map() and flatMap()

In Java Stream API, the methods `map` and `flatMap` are used to transform elements of a stream. However, they work slightly differently and are intended for different tasks.

### Method `map`
The `map` method is applied to each element of the stream and returns a new stream where each element has been transformed using the provided function. This method is used when you need to transform elements from one stream to elements of another type or simply change them.

**Example:**
Transforming a list of strings into a list of their lengths.

```java
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World", "Java", "Stream");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(Collectors.toList());
        System.out.println(wordLengths);  // Output: [5, 5, 4, 6]
    }
}
```

### Method `flatMap`
The `flatMap` method is also applied to each element of the stream, but each element can be transformed into any number of other elements (including zero). Unlike `map`, which returns a stream of objects, `flatMap` can "flatten" multiple streams into one stream. This method is often used to work with streams that contain collections or arrays, converting them into a single stream of elements.

**Example:**
Transforming a list of lists of numbers into a single list of numbers.

```java
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = List.of(
            List.of(1, 2),
            List.of(3, 4, 5),
            List.of(6, 7, 8, 9)
        );

        List<Integer> allNumbers = listOfLists.stream()
                                              .flatMap(List::stream)
                                              .collect(Collectors.toList());
        System.out.println(allNumbers);  // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
```

**Main Difference:**
- `map` takes a function that accepts one element and returns one element.
- `flatMap` takes a function that accepts one element and returns a stream of elements, which is then flattened into a single stream.

Thus, `flatMap` is suitable for cases where each element in the input stream is associated with a collection of elements, and you want to merge all these collections into one stream. While `map` is suitable for simply transforming each element into another element.
