# Stream API

[..](./README.md)

Stream API в Java — это современный API, представленный в Java 8, который позволяет выразительно и эффективно обрабатывать наборы данных (обычно коллекции) с помощью высокоуровневых операций над потоками данных. Он предоставляет функциональный подход к обработке данных, основанный на использовании лямбда-выражений.

### Основные особенности Stream API:
- **Не хранит данные**: Stream API не хранит данные, с которыми работает. Он оперирует исходными коллекциями и массивами в виде источников данных.
- **Не изменяет исходные данные**: Все операции с данными через Stream API являются "non-mutating", то есть не изменяют исходные коллекции.
- **Ленивость операций**: Многие операции с потоками (фильтрация, преобразования и другие) являются ленивыми, что означает, что они выполняются только тогда, когда это действительно необходимо (например, когда нужно получить конечный результат).
- **Поддержка параллельной обработки**: Stream API может прозрачно выполнять операции параллельно, что упрощает написание многопоточного кода.

### Примеры использования Stream API

#### 1. Фильтрация и подсчёт
Отфильтровать список строк по определённому критерию и подсчитать количество элементов, удовлетворяющих этому критерию:

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

#### 2. Преобразование элементов
Использовать `map` для преобразования каждого элемента списка (например, преобразовать строки в их длины):

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

#### 3. Сортировка
Отсортировать список элементов с использованием заданного компаратора:

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

#### 4. Суммирование элементов
Суммировать числа в списке:

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

#### 5. Поиск элементов
Найти первый элемент в потоке, удовлетворяющий определённому условию:

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

### Примеры создания потоков в Stream API
В Java Stream API предоставляет несколько способов создания потоков (streams). Вот основные методы, которые можно использовать для создания стримов:

#### 1. Из коллекций
Самый распространенный способ создания стрима — из коллекций, поддерживающих интерфейс `Collection` (например, из `List` или `Set`):

```java
import java.util.List;
import java.util.stream.Stream;

List<String> myList = List.of("apple", "banana", "pear", "kiwi", "orange");
Stream<String> stream = myList.stream();
```

#### 2. Из массивов
Вы можете создать стрим непосредственно из массивов с помощью статического метода `Arrays.stream()`:

```java
import java.util.Arrays;
import java.util.stream.Stream;

String[] array = {"apple", "banana", "pear", "kiwi", "orange"};
Stream<String> stream = Arrays.stream(array);
```

#### 3. Из стримов примитивных типов
Для примитивных типов данных (int, long, double) существуют специализированные стримы (`IntStream`, `LongStream`, `DoubleStream`), которые можно создавать через соответствующие методы в классах `Arrays` или `Stream`:

```java
import java.util.stream.IntStream;

IntStream intStream = IntStream.range(1, 10); // стрим целых чисел от 1 до 9
```

#### 4. Из других источников
Стримы можно создавать из различных источников, включая строки, файлы, или генерируя их на основе функций:

- Использование `Stream.of()`:
  ```java
  Stream<String> stream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
  ```

- Генерация стрима с помощью `Stream.generate()` или `Stream.iterate()`:
  ```java
  Stream<Double> randomNumbers = Stream.generate(Math::random);
  Stream<Integer> numbers = Stream.iterate(0, n -> n + 1);
  ```

#### 5. Из файла
Создать стрим из строк файла можно с помощью методов в классе `Files`:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

try (Stream<String> lines = Files.lines(Paths.get("path/to/file.txt"))) {
    lines.forEach(System.out::println);
}
```

#### 6. С помощью Builder
Можно использовать `Stream.builder()` для создания стрима вручную:

```java
Stream.Builder<String> builder = Stream.builder();
Stream<String> stream = builder.add("apple").add("banana").add("pear").build();
```

Эти методы предоставляют гибкость для создания стримов из практически любого набора данных, поддерживая как статические, так и динамические источники данных в Java-приложениях.

### Методы map() и flatMap()

В Java Stream API методы `map` и `flatMap` используются для преобразования элементов потока. Однако они работают немного по-разному и предназначены для различных задач.

### Метод `map`
Метод `map` применяется к каждому элементу потока и возвращает новый поток, где каждый элемент был преобразован с помощью предоставленной функции. Этот метод используется, когда вам нужно преобразовать элементы одного потока в элементы другого типа или просто изменить их.

**Пример:**
Преобразование списка строк в список их длин.

```java
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World", "Java", "Stream");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(Collectors.toList());
        System.out.println(wordLengths);  // Выведет [5, 5, 4, 6]
    }
}
```

### Метод `flatMap`
Метод `flatMap` также применяется к каждому элементу потока, но каждый элемент может быть преобразован в любое количество других элементов (включая ноль). В отличие от `map`, который возвращает поток объектов, `flatMap` может "сплющивать" несколько потоков в один поток. Этот метод часто используется для работы с потоками, которые содержат коллекции или массивы, преобразуя их в один поток элементов.

**Пример:**
Преобразование списка списков чисел в один список чисел.

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
        System.out.println(allNumbers);  // Выведет [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
```

**Основное отличие:**
- `map` принимает функцию, которая принимает один элемент и возвращает один элемент.
- `flatMap` принимает функцию, которая принимает один элемент и возвращает поток элементов, который затем сплющивается в один поток.

Таким образом, `flatMap` подходит для случаев, когда каждый элемент входного потока связан с коллекцией элементов, и вы хотите объединить все эти коллекции в один поток. В то время как `map` подходит для простого преобразования каждого элемента в другой элемент.
