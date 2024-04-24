# Optional

[..](./README.md)

`Optional` в Java — это контейнерный класс, введенный в Java 8, который может содержать или не содержать значение. Этот класс предназначен для представления возможного отсутствия значения и используется как альтернатива возвращению `null` из методов. Использование `Optional` помогает избежать `NullPointerException` и делает код более ясным в плане обработки ситуаций, когда значения может не быть.

### Основные принципы использования `Optional`:

1. **Избегание `null`**: `Optional` является способом явного выражения того, что значение может отсутствовать, что помогает уменьшить вероятность `NullPointerException`.

2. **Читаемость кода**: Использование `Optional` улучшает читаемость кода, поскольку делает очевидным намерение разработчика по отношению к значениям, которые могут быть или не быть.

3. **Функциональный стиль**: `Optional` предлагает методы для выполнения условных действий в функциональном стиле, таких как `map`, `flatMap`, `filter`, и другие.

### Примеры методов `Optional`:

- **`Optional.of(value)`**: Создает `Optional` с ненулевым значением. Если значение `null`, то будет выброшено `NullPointerException`.

- **`Optional.empty()`**: Создает пустой `Optional` объект.

- **`Optional.ofNullable(value)`**: Создает `Optional` объект, который может содержать `null`.

- **`isPresent()`**: Возвращает `true`, если в `Optional` есть значение.

- **`isEmpty()`**: Возвращает `true`, если в `Optional` нет значения (добавлен в Java 11).

- **`get()`**: Возвращает значение, если оно есть, или выбрасывает `NoSuchElementException`, если значение отсутствует.

- **`orElse(defaultValue)`**: Возвращает значение, если оно есть, или `defaultValue`, если значение отсутствует.

- **`orElseGet(supplier)`**: Возвращает значение, если оно есть, или результат выполнения `supplier`, если значение отсутствует.

- **`orElseThrow(exceptionSupplier)`**: Возвращает значение, если оно есть, или выбрасывает исключение, созданное `exceptionSupplier`, если значение отсутствует.

### Пример использования `Optional`:

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");

        // Печать значения, если оно присутствует
        optional.ifPresent(System.out::println);

        // Пример использования orElse
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Default Name");
        System.out.println(name);  // Выведет "Default Name"

        // Пример использования orElseThrow
        try {
            String anotherName = Optional.ofNullable(nullName)
                                         .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

Использование `Optional` в Java помогает улучшить надежность программы, избегая ошибок, связанных с `null`, и способствует написанию кода, который легче понять и поддерживать.

В Java метод `Optional.or()` представляет собой довольно новую возможность, добавленную в Java 9. Он позволяет вам предоставить альтернативный `Optional` в случае, если исходный `Optional` оказался пустым. Это может быть особенно полезно в сценариях, где нужно предоставить запасной вариант или продолжить цепочку операций с `Optional`.

### Пример использования `Optional.or()`

Представим ситуацию, в которой у нас есть метод, который может возвращать значение по умолчанию или продолжать выполнение других операций, если первый `Optional` оказался пустым.

Допустим, у нас есть методы для получения пользователя из базы данных по идентификатору, а также метод для получения значения по умолчанию, если пользователь не найден:

```java
import java.util.Optional;

public class OptionalOrExample {

    public static void main(String[] args) {
        // Получение пользователя по ID
        Optional<String> user = getUserById(1);

        // Если пользователь не найден, пытаемся получить значение по умолчанию
        String result = user.or(() -> getDefaultUser())
                            .get(); // Используем get(), потому что уверены, что один из Optional содержит значение

        System.out.println(result); // Выводит имя пользователя или имя пользователя по умолчанию
    }

    private static Optional<String> getUserById(int id) {
        // Представим, что пользователь с ID 1 не найден
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

В этом примере, если метод `getUserById()` возвращает пустой `Optional`, то метод `or()` позволяет нам перейти к другому методу `getDefaultUser()`, который возвращает `Optional` с пользователем по умолчанию. Это обеспечивает гладкое выполнение без необходимости проверки на `null` или условных операторов.

Метод `or()` может быть полезен в сложных условиях, когда вам нужно обеспечить непрерывное выполнение операций с множеством возможных источников данных или запасных вариантов. Это помогает поддерживать чистоту и читаемость кода, сводя к минимуму проверки на `null` и вложенные условные конструкции.
