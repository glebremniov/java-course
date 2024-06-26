# HTTP/HTTPS

[..](./README.md)

HTTP (HyperText Transfer Protocol) - это протокол передачи данных, который используется для отправки и получения информации в сети Интернет. Это то, что позволяет браузеру загружать веб-страницы, изображения, видео и другие ресурсы с веб-серверов.

Пример HTTP-запроса:

```
GET /index.html HTTP/1.1
Host: www.example.com
```

Пример HTTP-ответа:

```
HTTP/1.1 200 OK
Date: Mon, 25 Apr 2024 12:00:00 GMT
Content-Type: text/html
Content-Length: 127

<!DOCTYPE html>
<html>
<head>
<title>Пример страницы</title>
</head>
<body>
<h1>Привет, мир!</h1>
<p>Это пример веб-страницы.</p>
</body>
</html>
```

Различия между HTTP и HTTPS заключаются в безопасности. HTTPS (HyperText Transfer Protocol Secure) - это защищенная версия протокола HTTP, использующая шифрование для защиты передаваемых данных, что делает их недоступными для прочтения посторонними лицами.

## Версии протокола HTTP
Существует несколько версий протокола HTTP, каждая из которых имеет свои особенности и улучшения по сравнению с предыдущими версиями. Вот некоторые из наиболее распространенных версий и их основные различия:

1. **HTTP/0.9**: Это была оригинальная версия HTTP, которая использовалась в начале развития Всемирной паутины. Она была довольно простой и поддерживала только метод GET для запросов и передачу HTML-документов без заголовков.

2. **HTTP/1.0**: Это была первая полноценная версия протокола HTTP, введенная в 1996 году. Она добавила поддержку различных методов запроса (GET, POST, HEAD), заголовков запроса и ответа, а также возможность передачи различных типов контента.

3. **HTTP/1.1**: Это следующая и наиболее широко используемая версия протокола HTTP. Введена в 1999 году, она представила ряд улучшений по сравнению с HTTP/1.0, таких как поддержка постоянного соединения (keep-alive), кэширование, поддержка пайплайнинга (pipeline), что позволяет отправлять несколько запросов без ожидания ответов и другие оптимизации для улучшения производительности.

4. **HTTP/2**: Введенный в 2015 году, HTTP/2 был разработан для решения некоторых ограничений HTTP/1.1 и улучшения производительности веб-приложений. Основные изменения включают мультиплексирование (одновременную передачу нескольких запросов и ответов через одно соединение), сжатие заголовков, приоритеты запросов и другие оптимизации.

5. **HTTP/3**: Это последняя версия протокола HTTP, разрабатываемая на основе протокола QUIC (Quick UDP Internet Connections). Она была разработана для улучшения производительности и безопасности передачи данных в сети. Основные изменения включают использование UDP вместо TCP для более быстрой передачи данных и уменьшения задержек.

Это основные версии протокола HTTP, каждая из которых вносит свои улучшения и изменения для оптимизации передачи данных в сети.

## Методы HTTP запросов

В протоколе HTTP существует несколько методов запроса, которые определяют тип действия, которое клиент хочет выполнить над ресурсом на сервере. Вот наиболее распространенные методы запроса:

1. **GET**: Используется для запроса содержимого ресурса. Этот метод должен быть безопасным, исходя из спецификации HTTP, то есть он не должен изменять состояние сервера или данных на нем. Пример использования: получение HTML-страницы или изображения.

2. **POST**: Используется для отправки данных на сервер для обработки или сохранения. Этот метод может изменять состояние сервера или данных на нем. Например, отправка данных из формы на веб-сайте.

3. **PUT**: Используется для загрузки содержимого на сервер. Он заменяет текущее содержимое ресурса на содержимое, отправленное клиентом. Например, загрузка файла на сервер.

4. **DELETE**: Используется для удаления указанного ресурса на сервере. Например, удаление файла или записи из базы данных.

5. **PATCH**: Используется для частичного обновления ресурса на сервере. Этот метод отправляет инструкции о том, как изменить ресурс, не затрагивая остальную часть его содержимого. Например, изменение одного поля записи в базе данных.

6. **HEAD**: Аналогичен методу GET, но сервер отвечает только заголовками ответа без тела сообщения. Этот метод используется для получения метаданных о ресурсе без загрузки его содержимого. Например, проверка доступности ресурса или получение его размера.

7. **OPTIONS**: Используется для запроса информации о возможностях сервера или параметрах конфигурации ресурса. Например, определение доступных методов запроса или поддерживаемых заголовков.

8. **TRACE**: Этот метод просто возвращает входящий запрос обратно клиенту. Он используется для диагностики и отладки запросов, чтобы можно было увидеть, как они изменяются в процессе передачи по сети.

Это основные методы запроса в протоколе HTTP. Каждый из них выполняет определенную функцию при взаимодействии клиента с сервером.

## Заголовки (Headers)

Заголовки HTTP используются для передачи дополнительной информации о запросах и ответах между клиентом (например, браузером) и сервером. Вот несколько общих заголовков, которые могут встречаться в запросах и ответах:

### Заголовки запроса (Request Headers):
1. **Host**: Содержит имя хоста, к которому отправляется запрос.
2. **User-Agent**: Идентифицирует агента пользователя (браузер или приложение), отправляющего запрос.
3. **Accept**: Указывает типы контента, которые клиент готов принять от сервера.
4. **Content-Type**: Определяет тип содержимого тела запроса (например, "application/json" для JSON-данных).
5. **Authorization**: Используется для передачи учетных данных для аутентификации на сервере.
6. **Cookie**: Передает куки, сохраненные на клиентской стороне, серверу.

### Заголовки ответа (Response Headers):
1. **Content-Type**: Определяет тип содержимого тела ответа (например, "text/html" для HTML-страницы).
2. **Content-Length**: Указывает длину содержимого тела ответа в байтах.
3. **Cache-Control**: Определяет, как клиент или прокси должны кэшировать ответ.
4. **Date**: Содержит дату и время генерации ответа сервером.
5. **Set-Cookie**: Устанавливает куки на стороне клиента для последующих запросов к серверу.
6. **Location**: Используется для перенаправления клиента на другой URL.

Это только несколько из множества возможных заголовков, которые могут использоваться в HTTP-запросах и ответах. Каждый заголовок выполняет свою уникальную функцию и позволяет клиенту и серверу обмениваться дополнительной информацией, необходимой для правильной обработки запросов и ответов.

## HTTP коды ответов

Статусы ответа HTTP сообщают клиенту о результате выполнения его запроса. Вот некоторые из наиболее распространенных статусов ответа:

1. **1xx (Информационные)**: Эти статусы обозначают, что запрос получен и обрабатывается, и клиент должен продолжать ожидать ответа.

    - **100 Continue**: Сервер готов продолжать выполнение запроса.
    - **101 Switching Protocols**: Сервер согласен переключить протоколы, запрашиваемые клиентом.

2. **2xx (Успешные)**: Эти статусы указывают, что запрос клиента был успешно принят, понят и обработан сервером.

    - **200 OK**: Запрос выполнен успешно.
    - **201 Created**: Ресурс был успешно создан на сервере.
    - **204 No Content**: Запрос выполнен успешно, но ответ не содержит содержимого (например, при обработке запроса без тела).

3. **3xx (Перенаправления)**: Эти статусы указывают, что дополнительные действия со стороны клиента необходимы для завершения запроса.

    - **301 Moved Permanently**: Ресурс был перемещен на постоянной основе на новый URL.
    - **302 Found**: Ресурс временно перемещен на другой URL.
    - **304 Not Modified**: Ресурс не был изменен с момента последнего запроса.

4. **4xx (Ошибки клиента)**: Эти статусы указывают на ошибку со стороны клиента.

    - **400 Bad Request**: Запрос не может быть обработан из-за неправильного синтаксиса или другой ошибки со стороны клиента.
    - **401 Unauthorized**: Клиент не авторизован для доступа к ресурсу.
    - **404 Not Found**: Запрашиваемый ресурс не найден на сервере.

5. **5xx (Ошибки сервера)**: Эти статусы указывают на ошибку со стороны сервера.

    - **500 Internal Server Error**: Внутренняя ошибка сервера.
    - **503 Service Unavailable**: Сервер временно не может обрабатывать запросы из-за перегрузки или обслуживания.

Это лишь некоторые из возможных статусов ответа HTTP. Каждый из них сообщает клиенту о различных аспектах выполнения его запроса и может быть использован для принятия соответствующих действий клиентом или разработчиком веб-приложения.

## Идемпотентность запросов

Идемпотентность запросов в протоколе HTTP означает, что повторное выполнение одного и того же запроса не изменяет состояние сервера или данных на нем. Другими словами, если один и тот же запрос отправлен несколько раз, результат будет одинаковым, как если бы запрос был отправлен только один раз.

Это свойство важно для безопасной работы сетевых приложений, особенно в контексте обработки ошибок, потери соединения и повторной отправки запросов.

Некоторые методы запросов HTTP по умолчанию являются идемпотентными, например:
- GET: Получение содержимого ресурса.
- HEAD: Получение заголовков ответа для ресурса.
- PUT: Замена или создание ресурса по указанному URI.
- DELETE: Удаление ресурса.

Другие методы, такие как POST, могут быть идемпотентными, но это зависит от конкретной реализации сервера и приложения. Например, если запрос POST используется для создания новой записи в базе данных, повторное выполнение запроса может привести к созданию дубликатов, поэтому такие запросы часто не являются строго идемпотентными.

Идемпотентность запросов позволяет обеспечить надежность и предсказуемость взаимодействия клиента и сервера в условиях нестабильной сети или других проблем, которые могут привести к повторной отправке запросов.
