# Properties

[..](./README.md)

Java properties files, known as `.properties`, represent a simple format for storing data, typically used to store configuration parameters. These are text files utilized in Java applications for external configuration management, allowing changes without the need to recompile the code.

### Structure of `.properties` Files
`.properties` files contain key-value pairs where each pair is separated by an equals sign `=`. Keys are unique within the file. Comments can be added, starting the line with a `#` or `!` character. Here's an example of a `.properties` file content:

```
# This is a comment
database.host=localhost
database.user=root
database.password=secret
timeout=100
```

### Example of Using a `.properties` File in Java
The `Properties` class from the `java.util` package is used to work with `.properties` files in Java. This class provides methods for reading from a file and saving changes back to a file.

#### Reading from a `.properties` File
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
        int timeout = Integer.parseInt(props.getProperty("timeout", "30")); // Set default value if the property is missing

        System.out.println("Host: " + host);
        System.out.println("User: " + user);
        System.out.println("Password: " + password);
        System.out.println("Timeout: " + timeout);
    }
}
```

#### Saving to a `.properties` File
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

### Advantages of Using `.properties`
- **Simplicity and Readability**: `.properties` files are easy to read and edit.
- **Flexibility**: Application parameters can be changed without recompiling the code.
- **Separation**: Allows separating configuration data from the executable code, which simplifies settings management.

`.properties` files are widely used in Java to manage configuration settings such as database connection parameters, logging settings, and other parameters that might need to be changed without altering the program's source code.
