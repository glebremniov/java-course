# Индексы

[..](./README.md)

### Что такое индексы в SQL?

Индексы в SQL — это специальные структуры данных, используемые для ускорения операций выборки, а также улучшения производительности запросов, вставки, обновления и удаления данных. Индексы создаются на основе одного или нескольких столбцов таблицы и позволяют базе данных более эффективно искать и извлекать данные.

### Типы индексов в SQL

1. **Кластерный индекс**:
   - У каждой таблицы может быть только один кластерный индекс.
   - Данные физически упорядочиваются на диске в соответствии с кластерным индексом.
   - Поиск по кластерному индексу быстрее, так как строка данных может быть найдена в процессе поиска индекса.

2. **Некластерный индекс**:
   - Таблица может иметь множество некластерных индексов.
   - Не изменяет физический порядок строк, а создаёт отдельную структуру данных, где хранятся ключевые значения и указатели на соответствующие строки.

3. **Составной индекс**:
   - Индекс, созданный на основе двух или более столбцов.
   - Полезен, когда запросы включают условия по нескольким столбцам.

4. **Уникальный индекс**:
   - Обеспечивает уникальность значений в столбце или комбинации столбцов.
   - Полезен для поддержания целостности данных.

5. **Полнотекстовый индекс**:
   - Используется для улучшения производительности запросов полнотекстового поиска.
   - Оптимизирован для поиска слов в текстовых столбцах.

### Преимущества и недостатки индексов

**Преимущества**:
- **Ускорение выборки данных**: Операции чтения данных выполняются быстрее за счет уменьшения количества строк, которые необходимо сканировать.
- **Эффективность выполнения запросов**: Индексы позволяют выполнять сложные запросы, использующие условия, сортировку и группировку, быстрее.

**Недостатки**:
- **Замедление операций записи**: Каждая операция вставки, обновления или удаления данных требует времени на обновление индексов.
- **Дополнительное использование дискового пространства**: Индексы требуют дополнительного места на диске.
- **Сложность управления**: Необходимость в тщательном планировании и поддержании актуальности индексов.

### Создание индексов

Создать индекс можно с помощью команды `CREATE INDEX`:

```sql
-- Создание простого некластерного индекса
CREATE INDEX idx_lastname ON Employees (LastName);

-- Создание уникального индекса
CREATE UNIQUE INDEX idx_email ON Users (Email);

-- Создание кластерного индекса
CREATE CLUSTERED INDEX idx_empid ON Employees (EmployeeID);
```

### Примеры использования индексов

- **Индексы в интернет-магазинах**: Использование индексов на столбцах, часто участвующих в фильтрации, например, `ProductCategory` или `Price`, поможет ускорить поиск и вывод товаров по категориям и ценам.
- **Финансовые системы**:

Кластерный индекс на `AccountNumber` улучшит производительность операций, связанных с конкретными банковскими счетами.
- **Системы управления пользователями**: Уникальный индекс на `Email` гарантирует, что каждый электронный адрес в системе будет уникален.

Индексы особенно полезны в системах с большим объемом данных и высокими требованиями к производительности запросов. Однако, их использование должно быть сбалансировано с потребностями приложения, особенно в части операций записи данных.
