# Сериализация в Java

[..](./README.md)

Сериализация и десериализация — это процессы, используемые для преобразования структур данных или объектов в формат, который может быть сохранён (например, в файл или память) или передан (например, через сетевые соединения), и обратно в исходное состояние.

### Сериализация
Сериализация — это процесс преобразования объекта в поток байтов или в формат, который можно легко сохранить или передать. Например, в программировании объект может быть преобразован в формат JSON или XML для передачи по сети или для сохранения в файле. Цель сериализации — сохранить состояние объекта так, чтобы его можно было воссоздать позже.

### Десериализация
Десериализация — это обратный процесс, при котором данные в формате, созданном во время сериализации, преобразуются обратно в объект или структуру данных. Это позволяет программе восстановить объект из его сериализованного состояния.

### Примеры использования
1. **Сетевое взаимодействие**: объекты могут быть сериализованы на одном конце соединения и десериализованы на другом, что позволяет различным приложениям обмениваться данными воедино.
2. **Сохранение состояния**: сериализация используется для сохранения состояния программы в файле, чтобы затем можно было загрузить это состояние и продолжить выполнение с того же места.
3. **Удалённый вызов процедур (RPC)**: в методах RPC объекты сериализуются для передачи запросов и ответов между клиентом и сервером.

Сериализация и десериализация широко используются в программировании и важны для работы с различными форматами данных и структурами в разных языках программирования.

В Java сериализация и десериализация объектов часто осуществляются с использованием интерфейса `Serializable`. Этот интерфейс не содержит методов, он служит лишь маркером, указывающим, что класс может быть сериализован.

### Пример класса для сериализации

Вот пример простого класса, который может быть сериализован:

```java
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private transient int age; // transient - поле не будет сериализовано

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

### Сериализация объекта

Чтобы сериализовать объект `User`, можно использовать следующий код:

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) {
        User user = new User("John Doe", 30);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(user);
            System.out.println("Object has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Десериализация объекта

Для десериализации объекта используется следующий код:

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        User user = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))) {
            user = (User) in.readObject();
            System.out.println("Object has been deserialized");
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge()); // Возраст не будет выведен, так как он был помечен как transient
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

Этот код демонстрирует процесс сериализации и десериализации объекта `User`. Обратите внимание, что поле `age` не будет сериализовано из-за модификатора `transient`, и после десериализации его значение будет равно `0`, по умолчанию для типа `int`.
