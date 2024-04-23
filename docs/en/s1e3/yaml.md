# YAML

[..](./README.md)

YAML (YAML Ain't Markup Language) is a human-readable data serialization format that can be used in conjunction with all programming languages and is often used for configuration files. YAML is particularly known for its readability and simplicity, making it a popular choice for settings, configuration management, and data storage for a variety of applications.

### YAML Structure
YAML is highly readable due to its ability to represent data structures in a format that mirrors the natural hierarchical relationships of the data. Key features include:
1. **Hierarchical data**: Data is structured into a tree-like format, making it suitable for representing complex configurations.
2. **Scalars (strings, integers, and booleans)**, lists (arrays), and associative arrays (hashes or dictionaries) are the primary data types represented in YAML.
3. **Indentation**: YAML uses indentation to denote structure; this allows for easy representation of data hierarchy without additional syntax.
4. **No quotes needed for strings**, unless the string includes reserved characters. This further enhances readability.

### YAML Example
Here’s a simple example of a YAML file:

```yaml
name: John Doe
age: 30
isEmployee: true
addresses:
  - street: 123 Main St
    city: Anytown
  - street: 456 Maple St
    city: Hometown
```

### Working with YAML in Java
To work with YAML in Java, one of the most commonly used libraries is `SnakeYAML`, which allows parsing and generating YAML data easily.

#### Adding SnakeYAML to Your Project
If you're using Maven, add this dependency to your `pom.xml` to start working with SnakeYAML:

```xml
<dependency>
    <groupId>org.yaml</groupId>
    <artifactId>snakeyaml</artifactId>
    <version>1.29</version>
</dependency>
```

#### Example of Using SnakeYAML
Here’s how you can serialize and deserialize data using SnakeYAML in Java:

```java
import org.yaml.snakeyaml.Yaml;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Creating an object
        Map<String, Object> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("age", 30);
        data.put("isEmployee", true);

        // Serialization
        Yaml yaml = new Yaml();
        String output = yaml.dump(data);
        System.out.println(output);

        // Deserialization
        String input = "name: Jane Doe\nage: 25\nisEmployee: false";
        Map<String, Object> loadedData = yaml.load(input);
        System.out.println(loadedData);
    }
}
```

In this example, a `Map` object representing a person's data is serialized into a YAML string. This string is then printed, followed by deserialization of a YAML formatted string back into a `Map`.

#### Advantages of YAML
- **Readability**: It is very easy to read and understand YAML files at a glance.
- **Flexibility**: YAML can easily represent complex data structures and hierarchical relationships.
- **Widely used**: YAML is commonly used in software development for configuration files, deployment scripts, and other scenarios where data serialization is required.

YAML, with its emphasis on simplicity and human readability, provides a powerful solution for configuration and data storage, particularly in environments where configuration management is critical.
