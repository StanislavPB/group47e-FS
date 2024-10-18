# Lesson 06

Основные аннотации для работы с контроллерами в Spring Framework.

### 1. `@RestController`

Аннотация `@RestController` указывает, что класс является REST-контроллером. Это означает, что методы внутри класса будут возвращать данные (обычно в формате JSON) вместо представлений (HTML, JSP и т.д.). Эта аннотация объединяет `@Controller` и `@ResponseBody`.

```java
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // Методы обработки запросов будут добавлены здесь
}
```

### 2. `@RequestMapping`

Аннотация `@RequestMapping` используется для определения URL-шаблона, которому будет соответствовать метод или класс. Она также может указать HTTP-методы, параметры и заголовки, которым должен соответствовать запрос.

#### Пример на уровне класса:
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // Все методы внутри этого контроллера будут обрабатывать запросы по URL, начинающимся с /api/users
}
```

#### Пример на уровне метода:
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        // Логика получения всех пользователей
    }
}
```

### 3. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`

Эти аннотации являются специализированными версиями `@RequestMapping` для обработки запросов с определенными HTTP-методами (GET, POST, PUT, DELETE, PATCH). Они упрощают код и делают его более читаемым.

#### Примеры:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        // Логика получения всех пользователей
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        // Логика создания нового пользователя
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        // Логика обновления пользователя по ID
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        // Логика удаления пользователя по ID
    }
}
```

### 4. `@PathVariable`

Аннотация `@PathVariable` используется для извлечения значений из URL. Это полезно для получения параметров пути, таких как идентификаторы ресурсов.

```java
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        // Логика получения пользователя по ID
    }
}
```

### 5. `@RequestParam`

Аннотация `@RequestParam` используется для извлечения значений параметров запроса (query parameters). Это полезно для получения значений, передаваемых в строке запроса.

```java
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getUsersByPage(@RequestParam int page, @RequestParam int size) {
        // Логика получения пользователей с пагинацией
    }
}
```

### 6. `@RequestBody`

Аннотация `@RequestBody` используется для привязки тела HTTP-запроса к параметру метода. Это позволяет автоматически десериализовать JSON, XML или другие форматы данных в объект Java.

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user) {
        // Логика создания нового пользователя
    }
}
```

### 7. `@ResponseBody`

Аннотация `@ResponseBody` указывает, что возвращаемое значение метода должно быть записано непосредственно в тело HTTP-ответа.
Обычно используется в сочетании с `@Controller`. В `@RestController` эта аннотация используется неявно.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class UserController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello, World!";
    }
}
```

Эти аннотации являются основными инструментами для создания контроллеров в Spring Framework.
Они позволяют разрабатывать мощные и гибкие веб-приложения, обрабатывающие различные виды HTTP-запросов и управляющие ответами.


### URI и URL: Основные понятия

#### URI (Uniform Resource Identifier)
**URI (Uniform Resource Identifier, универсальный идентификатор ресурса)** – это строка, которая однозначно идентифицирует ресурс. URI может быть в форме URL или URN. Он используется для обозначения ресурса и может содержать схему, путь, запрос и фрагмент.

Пример URI:
```
https://www.example.com:8080/docs/resource1.html?id=123#section2
```
- **Протокол**: `https`
- **Authority**: `www.example.com:8080`
- **Путь**: `/docs/resource1.html`
- **Запрос**: `id=123`
- **Фрагмент**: `#section2`

#### URL (Uniform Resource Locator)
**URL (Uniform Resource Locator, универсальный локатор ресурса)** – это подтип URI, который используется для указания местоположения ресурса и способа его получения. URL всегда включает в себя протокол (схему), такой как HTTP, HTTPS, FTP и т.д.

Пример URL:
```
https://www.example.com:8080/docs/resource1.html?id=123
```
- **Протокол**: `https`
- **Authority**: `www.example.com:8080`
- **Путь**: `/docs/resource1.html`
- **Запрос**: `id=123`

### Различия между URI и URL
- **Все URL являются URI**, но не все URI являются URL. URL является подтипом URI, который предоставляет способ получения ресурса.
- **URI** может использоваться для идентификации ресурса без указания способа его получения (например, URN - Uniform Resource Name), тогда как **URL** всегда указывает способ получения ресурса.

### Использование в контроллерах Spring

В Spring Framework, URI и URL широко используются в аннотациях контроллеров для определения путей, параметров запроса и других элементов взаимодействия с веб-приложением.

#### Примеры использования URI и URL в контроллерах:

1. **Определение пути в контроллере с использованием URL:**
```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        // Логика получения пользователя по ID
    }
}
```
В данном примере, URL для метода `getUserById` будет иметь форму `/api/users/{id}`, где `{id}` является переменной пути.

2. **Использование параметров запроса (query parameters) в URL:**
```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getUsersByPage(@RequestParam int page, @RequestParam int size) {
        // Логика получения пользователей с пагинацией
    }
}
```
В данном примере, URL может быть таким: `/api/users?page=1&size=10`, где `page` и `size` являются параметрами запроса.

3. **Использование фрагментов URI (часто используется на стороне клиента):**
```html
<a href="https://www.example.com/docs/resource1.html#section2">Go to Section 2</a>
```
Фрагменты URI, такие как `#section2`, используются на стороне клиента для перехода к определенной части страницы.

### Заключение

**URI** и **URL** являются фундаментальными понятиями в веб-технологиях, которые используются для идентификации и доступа к ресурсам.
В Spring Framework, они играют ключевую роль в аннотациях контроллеров для определения путей и параметров, обеспечивая гибкость и мощность при создании веб-приложений.






