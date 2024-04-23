# JSON

[..](./README.md)

### What is JSON?

JSON (JavaScript Object Notation) is a lightweight data interchange format that is easy for humans to read and write and easy for machines to parse and generate. JSON is based on a subset of the JavaScript programming language, but is completely language-independent and can be used with virtually any programming software.

JSON is commonly used to serialize and transmit structured data over a network, particularly in web programming between client and server applications.

### JSON Structure
JSON is built on two structures:
1. **A collection of key/value pairs** (often called an "object" in other languages). In JSON, this is represented by curly braces `{ ... }`.
2. **An ordered list of values** (often called an "array" in other languages). In JSON, this is represented by square brackets `[ ... ]`.

### JSON Example
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

### Working with JSON in Java
In Java, there are various libraries available for working with JSON. The most popular ones are `Jackson` and `Google Gson`. Here’s how you can work with these libraries:

#### Using Gson
To work with Gson, first, add the dependency to your project. If you're using Maven, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.6</version>
</dependency>
```

Example of serialization and deserialization with Gson:

```java
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Serialization
        User user = new User("John Doe", 30);
        String json = gson.toJson(user);
        System.out.println(json);

        // Deserialization
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

#### Using Jackson
To use Jackson, add the following dependencies to your `pom.xml`:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
```

Example of serialization and deserialization with Jackson:

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Serialization
        User user = new User("John Doe", 30);
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        // Deserialization
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

Both libraries provide a simple and convenient API for serializing objects into JSON and deserializing JSON back into Java objects. The choice between Gson and Jackson depends on personal preference and specific project requirements.
