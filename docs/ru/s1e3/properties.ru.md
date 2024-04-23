# Properties

[..](./README.md)

Файлы свойств в Java, известные как `.properties`, представляют собой простой формат хранения данных, который используется для хранения конфигурационных параметров. Это текстовые файлы, которые используются в Java-приложениях для внешнего управления настройками, которые можно изменять без перекомпиляции кода.

### Структура файла `.properties`
Файлы `.properties` содержат пары ключ-значение, где каждая пара разделена символом равенства `=`. Ключи уникальны в пределах файла. Комментарии можно добавлять, начиная строку с символа `#` или `!`. Вот пример содержимого файла `.properties`:

```
# Это комментарий
database.host=localhost
database.user=root
database.password=secret
timeout=100
```

### Пример использования файла `.properties` в Java
Для работы с файлами `.properties` в Java используется класс `Properties` из пакета `java.util`. Этот класс предоставляет методы для чтения из файла и сохранения изменений в файл.

#### Чтение из файла `.properties`
```java
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String host = props.getProperty("database.host");
        String user = props.getProperty("database.user");
        String password = props.getProperty("database.password");
        int timeout = Integer.parseInt(props.getProperty("timeout", "30")); // Устанавливаем значение по умолчанию, если свойство отсутствует

        System.out.println("Host: " + host);
        System.out.println("User: " + user);
        System.out.println("Password: " + password);
        System.out.println("Timeout: " + timeout);
    }
}
```

#### Сохранение в файл `.properties`
```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SaveProperties {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("database.host", "localhost");
        props.setProperty("database.user", "root");
        props.setProperty("database.password", "secret");
        props.setProperty("timeout", "100");

        try (FileOutputStream out = new FileOutputStream("config.properties")) {
            props.store(out, "Database Configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Преимущества использования `.properties`
- **Простота и читаемость**: Файлы `.properties` легко читать и редактировать.
- **Гибкость**: Параметры приложения можно изменять без перекомпиляции кода.
- **Разделение**: Позволяет отделять конфигурационные данные от исполнительного кода, что упрощает управление настройками.

Файлы `.properties` широко используются в Java для управления конфигурационными настройками, такими как параметры подключения к базам данных, настройки логирования и другие параметры, которые могут потребоваться изменить без изменения исходного кода программы.
