# Lesson 15


#### ** Swagger **


Swagger (ныне известный как OpenAPI) — это инструментарий для разработки API, который используется для проектирования, создания, документирования и использования REST API.
Он включает в себя спецификацию OpenAPI, которая представляет собой формат файла, используемый для описания API.
Вот основные аспекты Swagger/OpenAPI:

1. **Спецификация OpenAPI**: Это формальное описание REST API, оформленное в виде JSON или YAML файла. Спецификация включает в себя информацию о путях (endpoints), операциях, входных и выходных данных, методах аутентификации и т.д.

2. **Swagger UI**: Это интерактивный интерфейс, который автоматически генерируется на основе файла спецификации OpenAPI. Он позволяет пользователям взаимодействовать с API прямо через браузер, отправлять запросы и получать ответы, что упрощает понимание и тестирование API.

3. **Swagger Editor**: Онлайн или локальный редактор для создания и редактирования спецификаций OpenAPI. Поддерживает автоматическое дополнение и валидацию, что упрощает процесс написания спецификации.

4. **Swagger Codegen**: Инструмент, который позволяет генерировать код клиентов, серверов и документации для API на основе файла спецификации OpenAPI. Поддерживает множество языков программирования и фреймворков.

Swagger - особый инструмент, автоматически документирующий интерфейс RESTful API вашего приложения.
Он помогает разработчикам создавать, документировать и проверять API.
Его достоинство заключается в том, что он позволяет не только изучить все эндпойнты приложения,
но и сразу же протестировать их в деле, отправить любой запрос и получить ответ.

Часть работы с REST API — это создание описаний работы API: информации о ресурсах, параметрах запросов, возвращаемых данных, конечных точках и других важных вещах. Чтобы автоматизировать это описание, сделать его структурированным и прозрачным, разработчики используют Swagger.

**Для чего нужен Swagger**


- **Упрощение разработки**: Спецификация OpenAPI обеспечивает четкое и единообразное описание API, что упрощает коммуникацию между членами команды и ускоряет процесс разработки.

- **Интерактивная документация**: Swagger UI предоставляет динамическую и интерактивную документацию API, что делает её более доступной для разработчиков и потенциальных пользователей API.

- **Генерация кода**: Способность Swagger Codegen создавать клиентский и серверный код из спецификации сокращает время и усилия, необходимые для начала работы с API.

- **Совместимость и стандартизация**: Спецификация OpenAPI является открытым стандартом, который обеспечивает совместимость и облегчает интеграцию с различными инструментами и фреймворками.

В общем, Swagger/OpenAPI предлагает набор инструментов, которые делают процесс разработки, тестирования и документирования REST API более простым и эффективным.


Разработчики API

●	Документация. Swagger позволяет автоматически создавать документацию для API на основе спецификации OpenAPI. Это включает в себя информацию о доступных методах, параметрах, типах данных и возвращаемых значениях.
●	Проверка совместимости. Swagger позволяет проверять совместимость API до его реализации, путем создания и валидации спецификации. Это позволяет обнаружить и исправить потенциальные проблемы дизайна и конфигурации API ещё до его запуска.
●	Генерация клиентского кода. Swagger позволяет автоматически генерировать клиентский код для различных языков программирования на основе спецификации OpenAPI. Это позволяет разработчикам быстро интегрировать API в свои приложения без необходимости вручную создавать и настраивать HTTP-запросы.
●	Продвижение API. Swagger предоставляет интерактивную документацию, которая может быть использована для рекламы и продвижения API. Разработчикам будет легко понять, как использовать API, а также его функциональность и возможности.
●	Улучшение командной работы. Swagger предоставляет единый и точный источник информации об API. Спецификация OpenAPI — стандартная форма описания API, которую может использовать вся команда для понимания функциональности и взаимодействия с API.

Важным преимуществом Swagger является его удобный интерфейс, который позволяет пользователям взаимодействовать с API напрямую в браузере. Они могут просмотреть доступные методы, параметры, примеры запросов и ответов, а также выполнить тестовые запросы прямо в интерфейсе Swagger.
Это упрощает процесс разработки и отладки API, а также улучшает понимание его функциональности для конечного пользователя.



Документация, сгенерированная с помощью Swagger, представляет собой интерактивную веб-страницу, которая описывает функциональность вашего API.

Вот пример того, как может выглядеть такая документация:

1. **Общая информация**: Документация начинается с общей информации о вашем API, такой как название, версия, описание и контактная информация.

2. **Маршруты (Endpoints)**: Каждый маршрут вашего API будет отображаться отдельно.

3. Например, если у вас есть маршрут для получения списка пользователей, это будет отображаться как отдельная секция в документации.

    - **Метод запроса**: Например, GET, POST, PUT, DELETE.
    - **Путь (Path)**: URL-адрес, который клиент должен использовать для доступа к этому маршруту.
    - **Параметры запроса**: Параметры, которые могут быть переданы через URL-адрес или тело запроса.
    - **Формат ответа (Response)**: Описание формата данных, который возвращает ваш API при успешном запросе.
    - **Примеры запросов и ответов**: Подробные примеры запросов и соответствующих ответов для каждого маршрута.

3. **Модели данных**: Если ваш API использует какие-либо структуры данных, такие как объекты или массивы, документация может содержать описание этих моделей данных, включая их поля и типы данных.

4. **Тестирование API**: Swagger UI обычно также предоставляет возможность прямого тестирования API прямо из документации. Пользователи могут отправлять запросы и просматривать ответы прямо на странице документации.


Аннотации Swagger используются для документирования и описания RESTful API в Spring Boot приложениях.
В современном Spring Boot Swagger реализован через библиотеку Springdoc OpenAPI.
Основные аннотации Swagger помогают описывать конечные точки API, их параметры, возможные ответы и прочие аспекты.

### Основные аннотации Swagger

1. **@Operation**
    - **Описание:** Используется для описания отдельной операции API (например, отдельного HTTP-запроса).
    - **Параметры:**
        - `summary`: краткое описание операции.
        - `description`: детальное описание операции.
        - `tags`: список тегов для группировки операций.
        - `responses`: возможные ответы на запрос.
    - **Пример:**
      ```java
      @Operation(summary = "Find manager by name", description = "Returns a manager by their name")
      ```

2. **@ApiResponse**
    - **Описание:** Используется для описания возможного ответа на запрос.
    - **Параметры:**
        - `responseCode`: код ответа HTTP (например, 200, 404).
        - `description`: описание ответа.
    - **Пример:**
      ```java
      @ApiResponse(responseCode = "200", description = "Found the manager")
      ```

3. **@ApiResponses**
    - **Описание:** Группирует несколько аннотаций `@ApiResponse`.
    - **Пример:**
      ```java
      @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Found the manager"),
          @ApiResponse(responseCode = "404", description = "Manager not found")
      })
      ```

4. **@Parameter**
    - **Описание:** Используется для описания параметра операции.
    - **Параметры:**
        - `name`: имя параметра.
        - `description`: описание параметра.
        - `required`: указывает, является ли параметр обязательным.
    - **Пример:**
      ```java
      @Parameter(name = "managerName", description = "Name of the manager", required = true)
      ```

### Примеры использования

#### Описание GET-метода с использованием аннотаций Swagger

```java
@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "Find manager by name", description = "Returns a manager by their name")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the manager"),
        @ApiResponse(responseCode = "404", description = "Manager not found")
    })
    @GetMapping("/{managerName}")
    public ResponseEntity<ManagerResponseDTO> findByManagerName(
            @Parameter(name = "managerName", description = "Name of the manager", required = true)
            @PathVariable String managerName) {
        return ResponseEntity.ok(managerService.findByManagerName(managerName));
    }
}
```

#### Описание POST-метода с использованием аннотаций Swagger

```java
@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "Create new manager", description = "Creates a new manager in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Manager created successfully"),
        @ApiResponse(responseCode = "400", description = "Manager already exists")
    })
    @PostMapping
    public ResponseEntity<ManagerCreateResponseDTO> createManager(
            @Parameter(description = "Manager create request data", required = true)
            @RequestBody ManagerCreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.createManager(request));
    }
}
```

### Дополнительные аннотации Swagger

- **@Schema**: используется для описания модели данных.
  ```java
  @Schema(description = "Manager create request data")
  public class ManagerCreateRequestDTO {
      @Schema(description = "Name of the manager", example = "James")
      private String managerName;
      @Schema(description = "Password of the manager", example = "password123")
      private String password;
      @Schema(description = "Email of the manager", example = "james@example.com")
      private String email;
  }
  ```

- **@RequestBody**: аннотация Spring, используемая для обозначения тела запроса в методах контроллеров. Swagger автоматически документирует параметры с этой аннотацией.

### Конфигурация Swagger

Для полной интеграции Swagger необходимо создать конфигурационный класс:

```java
package org.group40fs1workingproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My API")
                        .version("1.0")
                        .description("API documentation for my Spring Boot project"));
    }
}
```
Для того чтобы Swagger показывал пример значения, которое будет возвращено при ошибке, нужно использовать аннотацию @ExampleObject в @ApiResponse.
Это позволит вам указать пример значения, который будет отображаться в Swagger.

Вот как это можно сделать:

```java
package org.group40fs1workingproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.group40fs1workingproject.dto.managerDto.ManagerCreateRequestDTO;
import org.group40fs1workingproject.dto.managerDto.ManagerCreateResponseDTO;
import org.group40fs1workingproject.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "Create new manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Manager created successfully"),
            @ApiResponse(responseCode = "400", description = "Manager already exists",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "Manager already exists")))
    })
    @PostMapping
    public ResponseEntity<ManagerCreateResponseDTO> createManager(@RequestBody ManagerCreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.createManager(request));
    }
}
```

### Заключение

Аннотации Swagger позволяют детально документировать API, делая его понятным и доступным для разработчиков и пользователей.
С помощью таких аннотаций можно описывать параметры запросов, возможные ответы и модели данных, что существенно облегчает понимание и использование API.


## Отправка email по почте

## 00. Замечания и определения

* Транзакция - последовательность операций, которая должна выполняться либо полностью, либо не выполняться вообще
* На уровне БД реализуется с помощью команд `BEGIN` - начало транзакции, `COMMIT` - фиксация транзакции, `ROLLBACK` - откат изменений
* На уровне Spring-приложения можно использовать аннотацию `@Transactional`

## 01.  Реализовать функционал для создания ссылки подтверждения регистрации

* Создать модель `ConfirmationCode`
* Добавить зависимость в `pom.xml` - `spring-boot-starter-mail`
* Добавить нужные свойства в `applicaiton.yml`
* Реализовать класс `TemplateProjectMailSender`, который является оберткой над `JavaMailSender`
* На метод `send` класса `TemplateProjectMailSender` нужно повесить `@Async`, чтобы этот метод выполнялся в другом потоке (треде)
* В классе с mail-методом поставить аннотацию `@EnableAsync`

## Важные ссылки

* [Как получить пароль приложения](https://help.case.one/2022/07/11/%D0%BA%D0%B0%D0%BA-%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B8%D1%82%D1%8C-%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D1%8C-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-google/)
* [Получение пароля для вашего аккаунта](https://myaccount.google.com/apppasswords)
* [В целом про работу с SMTP Gmail](https://kinsta.com/blog/gmail-smtp-server/)


Freemarker — это шаблонизатор на Java, который помогает разработчикам генерировать HTML-страницы, конфигурационные файлы и другие текстовые форматы, используя шаблоны. Этот инструмент широко применяется для создания веб-страниц в Java-приложениях. Вот подробное описание работы с Freemarker для создания страниц в Java-приложении:

### Основы Freemarker

Freemarker не обрабатывает HTML сам по себе; он создаёт HTML-файлы на основе шаблонов, которые вы определяете. Шаблоны Freemarker написаны в собственном декларативном языке и содержат статический текст (который будет частью конечного документа) и директивы Freemarker, которые управляют созданием динамического контента.

### Компоненты Freemarker

1. **Шаблоны**: Шаблоны Freemarker (обычно с расширением `.ftl`) — это текстовые файлы, содержащие фиксированный текст и специальные конструкции для динамической вставки данных.

2. **Модель данных**: Данные, которые должны быть вставлены в шаблон, обычно представлены в виде карты (Map) или другой структуры данных в Java, которая передаётся в шаблонизатор при обработке.

3. **Конфигурация**: Объект Configuration в Freemarker управляет всеми аспектами поведения шаблонизатора, включая спецификации форматирования, локализацию и другие настройки.

### Пример работы с Freemarker

#### 1. Настройка

Перед использованием Freemarker в вашем проекте добавьте зависимость в ваш `pom.xml` или `build.gradle` файл:

```xml
<!-- Для Maven -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.31</version> <!-- Проверьте последнюю версию -->
</dependency>
```

```groovy
// Для Gradle
implementation 'org.freemarker:freemarker:2.3.31' // Проверьте последнюю версию
```

#### 2. Создание конфигурации

```java
import freemarker.template.Configuration;
import freemarker.template.Version;

Configuration cfg = new Configuration(new Version("2.3.31"));
cfg.setDirectoryForTemplateLoading(new File("/path/to/templates"));
cfg.setDefaultEncoding("UTF-8");
cfg.setLocale(Locale.US);
cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
```

#### 3. Подготовка модели данных

```java
Map<String, Object> root = new HashMap<>();
root.put("user", "John Doe");
List<String> messages = Arrays.asList("Your application is up and running.", "Enjoy Freemarker!");
root.put("messages", messages);
```

#### 4. Обработка шаблона

```java
/* Загрузите шаблон */
Template temp = cfg.getTemplate("test.ftl");

/* Соедините модель данных с шаблоном и выводите результаты */
try (Writer out = new OutputStreamWriter(System.out)) {
    temp.process(root, out);
}
```

#### 5. Шаблон test.ftl

```plaintext
<html>
<head>
  <title>Welcome</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Messages:</p>
  <ul>
  <#list messages as message>
    <li>${message}</li>
  <#list>
  </ul>
</body>
</html>
```

Этот пример демонстрирует базовый процесс создания HTML-страницы с использованием динамических данных.
Freemarker мощный и гибкий, поддерживающий сложные операции с данными и форматированием текста.

# Lesson 19


Freemarker — это шаблонизатор на Java, который помогает разработчикам генерировать HTML-страницы, конфигурационные файлы и другие текстовые форматы, используя шаблоны. Этот инструмент широко применяется для создания веб-страниц в Java-приложениях. Вот подробное описание работы с Freemarker для создания страниц в Java-приложении:

### Основы Freemarker

Freemarker не обрабатывает HTML сам по себе; он создаёт HTML-файлы на основе шаблонов, которые вы определяете. Шаблоны Freemarker написаны в собственном декларативном языке и содержат статический текст (который будет частью конечного документа) и директивы Freemarker, которые управляют созданием динамического контента.

### Компоненты Freemarker

1. **Шаблоны**: Шаблоны Freemarker (обычно с расширением `.ftl`) — это текстовые файлы, содержащие фиксированный текст и специальные конструкции для динамической вставки данных.

2. **Модель данных**: Данные, которые должны быть вставлены в шаблон, обычно представлены в виде карты (Map) или другой структуры данных в Java, которая передаётся в шаблонизатор при обработке.

3. **Конфигурация**: Объект Configuration в Freemarker управляет всеми аспектами поведения шаблонизатора, включая спецификации форматирования, локализацию и другие настройки.

### Пример работы с Freemarker

#### 1. Настройка

Перед использованием Freemarker в вашем проекте добавьте зависимость в ваш `pom.xml` или `build.gradle` файл:

```xml
<!-- Для Maven -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.31</version> <!-- Проверьте последнюю версию -->
</dependency>
```

```groovy
// Для Gradle
implementation 'org.freemarker:freemarker:2.3.31' // Проверьте последнюю версию
```

#### 2. Создание конфигурации

```java
import freemarker.template.Configuration;
import freemarker.template.Version;

Configuration cfg = new Configuration(new Version("2.3.31"));
cfg.setDirectoryForTemplateLoading(new File("/path/to/templates"));
cfg.setDefaultEncoding("UTF-8");
cfg.setLocale(Locale.US);
cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
```

#### 3. Подготовка модели данных

```java
Map<String, Object> root = new HashMap<>();
root.put("user", "John Doe");
List<String> messages = Arrays.asList("Your application is up and running.", "Enjoy Freemarker!");
root.put("messages", messages);
```

#### 4. Обработка шаблона

```java
/* Загрузите шаблон */
Template temp = cfg.getTemplate("test.ftl");

/* Соедините модель данных с шаблоном и выводите результаты */
try (Writer out = new OutputStreamWriter(System.out)) {
    temp.process(root, out);
}
```

#### 5. Шаблон test.ftl

```plaintext
<html>
<head>
  <title>Welcome</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Messages:</p>
  <ul>
  <#list messages as message>
    <li>${message}</li>
  <#list>
  </ul>
</body>
</html>
```

Этот пример демонстрирует базовый процесс создания HTML-страницы с использованием динамических данных.
Freemarker мощный и гибкий, поддерживающий сложные операции с данными и форматированием текста.


### Аспектно-ориентированное программирование (АОП)
Представляет собой парадигму, направленную на увеличение модульности приложений путем разделения сквозных задач.
Этот подход позволяет добавлять дополнительное поведение к существующему коду без необходимости его модификации.

или по другому:


Aspect-Oriented Programming (AOP) в Java представляет собой парадигму программирования, которая дополняет традиционное объектно-ориентированное программирование (ООП) путём добавления "аспектов".
Это позволяет инкапсулировать функциональность, которая не является основной для бизнес-логики, но необходима для поддержки системы, такую как логирование, безопасность, транзакционность и кэширование.


В основе АОП лежит идея о том, что можно "навешивать" дополнительную функциональность на методы и классы, не внося изменения в исходный код.
Это особенно важно, когда традиционные объектно-ориентированные методы не справляются с определенными задачами.
АОП предоставляет новые инструменты, увеличивая гибкость разработки и расширяя возможности для решения разнообразных задач.

### Применение АОП

Аспектно-ориентированное программирование применяется для решения сквозных задач, которые трудно выделить в отдельные модули. С помощью АОП такие задачи можно эффективно изолировать от основного кода. Например, это может быть политика безопасности, которая должна применяться консистентно ко всем частям приложения, как к существующим, так и к новым. В этом контексте политики безопасности могут развиваться и адаптироваться вместе с приложением.

Примеры использования АОП включают, но не ограничиваются, логирование и обработку исключений. Преимущества АОП в случае логирования:
- Легкость внедрения и удаления кода логирования через конфигурационные изменения.
- Централизация кода логирования в одном месте, упрощающая управление и обновление.
- Возможность добавления логирования к существующим и новым элементам приложения, что снижает вероятность ошибок.
- Уверенность в полном удалении трассировочного кода при удалении аспекта из конфигурации.

АОП также используется для кеширования и переиспользования функционала, что позволяет улучшить производительность и масштабируемость приложений.

### Основные понятия АОП

- **Совет (Advice)**: код, выполняемый в определенные моменты выполнения программы, например, до, после или вместо вызова метода.
- **Точка соединения (Join point)**: место в программе, где может быть применен совет.
- **Срез (Pointcut)**: набор точек соединения, определяющий, когда и где применяется совет.
- **Аспект (Aspect)**: модуль, реализующий сквозную функциональность, связывая советы с точками соединения.
- **Внедрение (Introduction)**: процесс, позволяющий добавлять новые методы или поля в существующие классы.
- **Плетение (Weaving)**: процесс, при котором аспекты интегрируются с другими компонентами программы, который может происходить на этапе компиляции, после компиляции или во время загрузки класса.


1. **Аспект (Aspect)**: Модуль, инкапсулирующий поведение (advice) и точки присоединения (pointcuts) в одном месте вне определения класса, на который это поведение влияет.

2. **Advice**: Код, который выполняется в определенных точках программы. Существует несколько типов advice:
    - **Before**: Выполняется до вызова метода.
    - **After**: Выполняется после вызова метода.
    - **After-returning**: Выполняется после успешного завершения метода.
    - **After-throwing**: Выполняется, если метод вызывает исключение.
    - **Around**: Заменяет метод, обеспечивая возможность выполнения дополнительного кода до и после вызова метода.

3. **Pointcut**: Выражение, определяющее моменты в программе, когда должны применяться advices. Pointcuts определяют "где" и "когда" в программе будет выполняться advice.

4. **Join Point**: Конкретная точка в программе, такая как вызов метода или обращение к переменной.

5. **Target Object**: Объект, к которому применяется аспект.

6. **Weaving**: Процесс, в котором аспекты интегрируются в целевую программу.


AspectJ является одной из популярных реализаций АОП, предоставляющей разнообразные инструменты для работы со сквозными задачами.
Эта технология позволяет разработчикам более эффективно управлять и модифицировать поведение приложений, улучшая их архитектурную чистоту и гибкость.


### Примеры:

1. **Логирование**:
    - **Aspect**:
      ```java
      @Aspect
      public class LoggingAspect {
          @Before("execution(* com.example.service.*.*(..))")
          public void logBefore(JoinPoint joinPoint) {
              System.out.println("Before method: " + joinPoint.getSignature().getName());
          }
      }
      ```

2. **Безопасность**:
    - **Aspect**:
      ```java
      @Aspect
      public class SecurityAspect {
          @Before("execution(* com.example.service.*.*(..))")
          public void checkAuthentication() {
              // проверка аутентификации пользователя
          }
      }
      ```

3. **Транзакционность**:
    - **Aspect**:
      ```java
      @Aspect
      public class TransactionAspect {
          @Around("execution(* com.example.service.*.*(..))")
          public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
              try {
                  // начало транзакции
                  Object result = joinPoint.proceed();
                  // завершение транзакции
                  return result;
              } catch (Exception e) {
                  // откат транзакции
                  throw e;
              }
          }
      }
      ```

В этих примерах аспекты используют аннотации Spring AOP для определения advices и pointcuts. AOP позволяет разработчикам более чётко разделять основную логику приложения от перекрестных проблем (cross-cutting concerns), таких как логирование или безопасность, что упрощает поддержку и развитие программного обеспечения.





 




