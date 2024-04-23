# XML

[..](./README.md)

XML (eXtensible Markup Language) is a markup language that defines a set of rules for encoding documents in a format that is both human-readable and machine-readable. The design goals of XML emphasize simplicity, generality, and usability across the Internet. It is primarily used to facilitate the sharing of structured data across different information systems, particularly via the Internet, and is used both to encode documents and to serialize data.

### XML Structure
XML data is organized in a tree-like structure and is made up of several key components:
1. **Elements**: Defined by tags, an element can contain text, other elements, or a mixture of both. Elements start with a start tag and end with an end tag.
2. **Attributes**: Provide additional information about elements. Attributes are defined within the start tag of an element.
3. **Text**: The content written between the start and end tags of an element.
4. **Nodes**: Every piece of data in an XML document is considered a node, including elements, attributes, text, and even comments.
5. **Prolog**: Optional declaration at the beginning of the XML document, specifying XML version and character encoding.

### Example of an XML Document
```xml
<?xml version="1.0" encoding="UTF-8"?>
<company>
    <employee id="1">
        <name>John Doe</name>
        <email>john.doe@example.com</email>
        <department>Human Resources</department>
    </employee>
    <employee id="2">
        <name>Jane Smith</name>
        <email>jane.smith@example.com</email>
        <department>Finance</department>
    </employee>
</company>
```

### Working with XML in Java
Java provides several APIs to work with XML data, including DOM, SAX, and StAX. Below are brief explanations and example usages of these APIs:

#### 1. DOM (Document Object Model)
- **Description**: DOM creates an in-memory tree representation of the XML document, allowing full access to the data structure.
- **Use Case**: Best used when you need to access or modify parts of the XML document repeatedly.

**Example Usage**:
```java
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlExample {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("company.xml"));

        NodeList employees = document.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Element employee = (Element) employees.item(i);
            String name = employee.getElementsByTagName("name").item(0).getTextContent();
            System.out.println("Employee Name: " + name);
        }
    }
}
```

#### 2. SAX (Simple API for XML)
- **Description**: SAX is an event-driven, serial-access mechanism for accessing XML documents.
- **Use Case**: Best for large XML files where you only need to read the data without storing it.

**Example Usage**:
```java
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SaxExample extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            System.out.println("Found an Employee Name");
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        System.out.println("Name: " + new String(ch, start, length));
    }
}
```

#### 3. StAX (Streaming API for XML)
- **Description**: StAX is a streaming model for XML parsing, providing both cursor-based and iterator-based APIs.
- **Use Case**: Effective for large files where you need to both read and write data.

**Example Usage**:
```java
import javax.xml.stream.*;

public class StaxExample {
    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("company.xml"));

        while(reader.hasNext()) {
            if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                if (reader.getLocalName().equals("name")) {
                    System.out.println("Employee Name: " + reader.getElementText());
                }
            }
        }
    }
}
```

XML remains a powerful tool for data interchange and configuration due to its flexibility, extensive support across programming environments, and widespread use in legacy systems.
