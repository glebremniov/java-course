# Serialization in Java

[..](./README.md)

### 1. Explanation of Serialization and Deserialization:
Serialization and deserialization are processes used to convert data structures or objects into a format that can be stored (e.g., in a file or memory) or transmitted (e.g., over network connections), and then back into their original state.

#### Serialization
Serialization is the process of converting an object into a stream of bytes or a format that can be easily stored or transmitted. For example, in programming, an object can be converted to a JSON or XML format for transmission over a network or for saving in a file. The goal of serialization is to preserve the state of an object so that it can be recreated later.

#### Deserialization
Deserialization is the reverse process, where data in the format created during serialization is converted back into an object or data structure. This allows a program to restore an object from its serialized state.

#### Use Cases
1. **Network Communication**: Objects can be serialized at one end of a connection and deserialized at the other, allowing different applications to exchange data seamlessly.
2. **State Preservation**: Serialization is used to save the state of a program in a file, which can then be loaded to resume execution from the same point.
3. **Remote Procedure Calls (RPC)**: In RPC methods, objects are serialized to transmit requests and responses between clients and servers.

Serialization and deserialization are widely used in programming and are crucial for handling various data formats and structures across different programming languages.

### 2. Examples in Java:
In Java, serialization and deserialization of objects are often carried out using the `Serializable` interface. This interface does not contain methods; it serves as a marker indicating that a class can be serialized.

#### Example of a Class for Serialization
Here's an example of a simple class that can be serialized:

```java
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private transient int age; // the transient field will not be serialized

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

#### Serialization of an Object
To serialize a `User` object, you can use the following code:

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

#### Deserialization of an Object
For deserialization, the following code can be used:

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
            System.out.println("Age: " + user.getAge()); // Age will not be output because it was marked as transient
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

This code demonstrates the serialization and deserialization process of a `User` object. Note that the `age` field will not be serialized due to the `transient` modifier, and its value will be `0` after deserialization, default for the `int` type.
