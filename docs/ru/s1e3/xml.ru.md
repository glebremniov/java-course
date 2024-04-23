# XML

[..](./README.md)

XML (eXtensible Markup Language или Расширяемый язык разметки) — это язык разметки, определяющий набор правил для кодирования документов в формате, который удобен как для чтения человеком, так и для машинной обработки. Основные цели XML заключаются в простоте, общности и удобстве использования в Интернете. XML применяется в основном для обмена структурированными данными между различными информационными системами, особенно через Интернет, а также используется для кодирования документов и сериализации данных.

### Структура XML
Данные в XML организованы в виде древовидной структуры и состоят из нескольких ключевых компонентов:
1. **Элементы**: Определяются тегами, элемент может содержать текст, другие элементы или их комбинацию. Элемент начинается с начального тега и заканчивается конечным тегом.
2. **Атрибуты**: Предоставляют дополнительную информацию об элементах. Атрибуты определяются внутри начального тега элемента.
3. **Текст**: Содержимое, записанное между начальным и конечным тегами элемента.
4. **Узлы**: Каждый фрагмент данных в документе XML считается узлом, включая элементы, атрибуты, текст и даже комментарии.
5. **Пролог**: Необязательное объявление в начале документа XML, указывающее версию XML и кодировку символов.

### Пример документа XML
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

### Работа с XML в Java
Java предоставляет несколько API для работы с данными XML, включая DOM, SAX и StAX. Ниже приведены краткие описания и примеры использования этих API:

#### 1. DOM (Document Object Model)
- **Описание**: DOM создаёт в памяти древовидное представление документа XML, позволяя полноценно доступаться к структуре данных.
- **Применение**: Лучше всего подходит, когда вам нужен многократный доступ или модификация частей XML-документа.

**Пример использования**:
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
            System.out.println("Имя сотрудника: " + name);
        }
    }
}
```

#### 2. SAX (Simple API for XML)
- **Описание**: SAX — это последовательный, управляемый событиями механизм доступа к XML-документам.
- **Применение**: Лучше всего подходит для больших XML-файлов, когда вам нужно только проч

итать данные, не сохраняя их.

**Пример использования**:
```java
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SaxExample extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            System.out.println("Найдено имя сотрудника");
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        System.out.println("Имя: " + new String(ch, start, length));
    }
}
```

#### 3. StAX (Streaming API for XML)
- **Описание**: StAX — это потоковая модель анализа XML, предоставляющая API как на основе курсора, так и на основе итераторов.
- **Применение**: Эффективно для больших файлов, когда вам нужно как читать, так и записывать данные.

**Пример использования**:
```java
import javax.xml.stream.*;

public class StaxExample {
    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("company.xml"));

        while(reader.hasNext()) {
            if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                if (reader.getLocalName().equals("name")) {
                    System.out.println("Имя сотрудника: " + reader.getElementText());
                }
            }
        }
    }
}
```

XML остаётся мощным инструментом для обмена данными и конфигурации благодаря своей гибкости, широкой поддержке в различных программных средах и распространённому использованию в устаревших системах.
