# Lesson 11

### РЕГУЛЯРНЫЕ ВЫРАЖЕНИЯ

### Введение в регулярные выражения

Регулярные выражения (RegEx, RegExp) — это мощный инструмент для работы с текстом, позволяющий искать, сравнивать и заменять строки по заданным шаблонам. Они используются в различных языках программирования и текстовых редакторах. Основная идея регулярных выражений заключается в использовании специальных символов и конструкций для описания шаблонов текста.

### Принцип работы

Регулярные выражения состоят из символов и метасимволов. Символы представляют собой обычные символы текста (буквы, цифры и т.д.), а метасимволы имеют специальное значение и определяют шаблоны.

#### Основные метасимволы:

1. **Точка (.)**: обозначает любой одиночный символ, кроме символа новой строки.
    - Пример: шаблон `a.b` совпадет с "aab", "acb", "a1b", но не с "ab" или "a\nb".

2. **Квантификаторы**:
    - `*` — совпадение с предыдущим символом 0 или более раз.
        - Пример: `ab*c` совпадет с "ac", "abc", "abbc" и т.д.
    - `+` — совпадение с предыдущим символом 1 или более раз.
        - Пример: `ab+c` совпадет с "abc", "abbc", но не с "ac".
    - `?` — совпадение с предыдущим символом 0 или 1 раз.
        - Пример: `ab?c` совпадет с "ac" и "abc".
    - `{n}` — совпадение с предыдущим символом ровно n раз.
        - Пример: `a{3}` совпадет с "aaa", но не с "aa".
    - `{n,m}` — совпадение с предыдущим символом от n до m раз.
        - Пример: `a{2,4}` совпадет с "aa", "aaa" и "aaaa", но не с "a" или "aaaaa".

3. **Классы символов**:
    - `[abc]` — любой символ из множества, например, a, b или c.
        - Пример: `b[aeiou]t` совпадет с "bat", "bet", "bit", "bot", "but".
    - `[a-z]` — любой символ из диапазона, например, от a до z.
        - Пример: `[0-9]` совпадет с любой цифрой.
    - `[^abc]` — любой символ, кроме указанных.
        - Пример: `[^0-9]` совпадет с любым символом, кроме цифры.

4. **Якоря**:
    - `^` — начало строки.
        - Пример: `^Hello` совпадет с "Hello" в начале строки.
    - `$` — конец строки.
        - Пример: `world$` совпадет с "world" в конце строки.

5. **Группировка и захват**:
    - `()` — группировка символов и захват совпадения для последующего использования.
        - Пример: `(abc)+` совпадет с "abc", "abcabc" и т.д.

6. **Или (альтернация)**:
    - `|` — оператор "или".
        - Пример: `a|b` совпадет с "a" или "b".

### Примеры регулярных выражений

1. **Поиск email адресов**:
   ```regex
   [a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}
   ```
    - Объяснение: Ищет строки, соответствующие шаблону email адреса.

2. **Поиск всех слов в строке**:
   ```regex
   \b\w+\b
   ```
    - Объяснение: `\b` обозначает границу слова, `\w+` — одно или более буквенно-цифровых символов.

3. **Проверка номера телефона (формат: XXX-XXX-XXXX)**:
   ```regex
   \d{3}-\d{3}-\d{4}
   ```
    - Объяснение: `\d` обозначает цифру, `{3}` — ровно три раза, `-` — дефис.

4. **Поиск HTML тегов**:
   ```regex
   <([a-zA-Z]+)([^<]+)*(?:>(.*)<\/\1>|\s+\/>)
   ```
    - Объяснение: Ищет HTML теги с возможными атрибутами и содержимым.


### Пример на Java

Для работы с регулярными выражениями в Java используется класс `Pattern` и `Matcher` из пакета `java.util.regex`.

#### Пример 1: Поиск всех слов в строке

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String text = "This is a sample text with several words.";
        String patternString = "\\b\\w+\\b";

        // Компиляция регулярного выражения в объект Pattern
        Pattern pattern = Pattern.compile(patternString);

        // Создание объекта Matcher для поиска совпадений в тексте
        Matcher matcher = pattern.matcher(text);

        // Поиск и вывод всех совпадений
        while (matcher.find()) {
            System.out.println("Found word: " + matcher.group());
        }
    }
}
```

#### Объяснение:
- `\\b` — граница слова.
- `\\w+` — одна или более буквенно-цифровых символов.
- `\\b` — граница слова.

#### Пример 2: Проверка формата email адреса

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        String[] emails = {
            "user@example.com",
            "user.name@domain.com",
            "user.name@domain.co.in",
            "user@domaincom",
            "user@.com.my"
        };

        // Регулярное выражение для email
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Компиляция регулярного выражения
        Pattern pattern = Pattern.compile(emailPattern);

        // Проверка каждого email на соответствие
        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                System.out.println(email + " is a valid email.");
            } else {
                System.out.println(email + " is not a valid email.");
            }
        }
    }
}
```

#### Объяснение:
- `^[a-zA-Z0-9._%+-]+` — начало строки, за которым следуют один или более допустимых символов для локальной части email.
- `@[a-zA-Z0-9.-]+` — символ "@" и один или более допустимых символов для домена.
- `\\.[a-zA-Z]{2,}$` — точка и два или более буквенных символов для доменной зоны, конец строки.

#### Пример 3: Замена шаблона в строке

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog.";
        String patternString = "\\bfox\\b";
        String replacement = "cat";

        // Компиляция регулярного выражения
        Pattern pattern = Pattern.compile(patternString);

        // Создание объекта Matcher
        Matcher matcher = pattern.matcher(text);

        // Замена всех совпадений
        String newText = matcher.replaceAll(replacement);
        
        System.out.println("Original text: " + text);
        System.out.println("Modified text: " + newText);
    }
}
```

#### Объяснение:
- `\\bfox\\b` — шаблон для слова "fox", окруженного границами слова.
- `replaceAll` — метод, заменяющий все совпадения шаблона на указанную строку.

### Заключение

Регулярные выражения в Java являются мощным инструментом для обработки строк. Классы `Pattern` и `Matcher` обеспечивают функциональность для поиска, проверки и замены текста по заданным шаблонам. Эти примеры демонстрируют основные способы использования регулярных выражений в Java.



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



