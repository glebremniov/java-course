# JSON

[..](./README.md)

JSON (JavaScript Object Notation) — это лёгкий формат обмена данными, который легко читается и пишется людьми, а также легко анализируется и генерируется машинами. JSON основан на подмножестве языка программирования JavaScript, но является полностью независимым от языка и может использоваться практически с любым программным обеспечением.

JSON обычно используется для сериализации и передачи структурированных данных по сети, особенно в веб-программировании между клиентскими и серверными приложениями.

### Структура JSON
JSON строится на двух структурах:
1. **Коллекция пар ключ/значение** (часто называется "объект" в других языках). В JSON это представляется в виде фигурных скобок `{ ... }`.
2. **Упорядоченный список значений** (часто называется "массив" в других языках). В JSON это представляется в виде квадратных скобок `[ ... ]`.

### Пример JSON
```json
{
  "name": "John Doe",
  "age": 30,
  "isEmployee": true,
  "addresses": [
    {"street": "123 Main St", "city": "Anytown"},
    {"street": "456 Maple St", "city": "Hometown"}
  ]
}
```

### Работа с JSON в Java
В Java для работы с JSON можно использовать различные библиотеки. Самыми популярными из них являются `Jackson` и `Google Gson`. Вот как можно работать с этими библиотеками:

#### Использование Gson
Для работы с Gson сначала нужно добавить зависимость в ваш проект. Если вы используете Maven, добавьте следующее в файл `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.6</version>
</dependency>
```

Пример сериализации и десериализации с Gson:

```java
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Сериализация
        User user = new User("John Doe", 30);
        String json = gson.toJson(user);
        System.out.println(json);

        // Десериализация
        User userFromJson = gson.fromJson(json, User.class);
        System.out.println(userFromJson.getName());
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

#### Использование Jackson
Для использования Jackson добавьте следующие зависимости в `pom.xml`:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
```

Пример сериализации и десериализации с Jackson:

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Сериализация
        User user = new User("John Doe", 30);
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        // Десериализация
        User userFromJson = mapper.readValue(json, User.class);
        System.out.println(userFromJson.getName());
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

Обе библиотеки предоставляют простой и удобный API для сериализации объектов в JSON и обратной десериализации из JSON в объекты Java. Выбор между Gson и Jackson зависит от личных предпочтений и специфических требований проекта.
