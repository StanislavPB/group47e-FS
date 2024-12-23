# Lesson 12



#### Введение в Mockito
- Mockito является популярным инструментом для создания и управления мок-объектами в Java, что позволяет имитировать сложные взаимодействия без необходимости взаимодействия с базой данных или внешними сервисами.
- Эта библиотека особенно полезна в контексте unit-тестирования, где важно изолировать тестируемый компонент от его зависимостей.
- Использование Mockito может значительно ускорить процесс разработки и тестирования, так как тесты становятся более предсказуемыми и легко воспроизводимыми.

#### Интеграция с Spring
- Добавление Mockito в проект через Maven или Gradle упрощает процесс интеграции, так как все зависимости управляются централизованно.
- `pom.xml` для Maven проектов или `build.gradle` для Gradle проектов — основные места, где настраивается подключение библиотек.
- Версия библиотеки должна быть совместима с используемой версией JUnit, чтобы избежать конфликтов зависимостей.

#### Мок-объекты
- Мок-объекты в Mockito создаются для замены реальных объектов в тестовом окружении, что позволяет тестировать код в изоляции от внешних сервисов.
- Использование моков позволяет точно контролировать возвращаемые значения и исключения, что важно для тестирования различных сценариев.
- Моки могут быть настроены на повторение определённых действий или на возвращение специфических результатов при вызове методов.

#### DynamicProxy
- DynamicProxy используется в Java для создания виртуальных объектов на лету, что лежит в основе механизма мокирования в Mockito.
- Прокси позволяет Mockito вмешиваться в процесс вызова методов, перехватывать их и изменять поведение без изменения кода самого класса.
- Это мощный механизм, который делает Mockito гибким инструментом для тестирования, позволяя имитировать сложные взаимодействия внутри тестируемого приложения.

#### Основные аннотации
- **@ExtendWith** используется для интеграции Mockito с JUnit 5, активируя мокирование в рамках тестовых классов.
- **@Mock** и **@Spy** — две ключевые аннотации, используемые для создания моков и шпионов соответственно, каждая с своими особенностями управления поведением объектов.
- Понимание разницы между моками и шпионами критично для правильного применения Mockito, где моки полностью контролируемые, а шпионы частично сохраняют поведение оригинального объекта.

#### Расширенное управление поведением
- Методы **doReturn()**, **doThrow()**, и **doAnswer()** предоставляют гибкость в определении реакции моков на вызовы, позволяя тонко настраивать тестовые сценарии.
- **doReturn()** часто используется для упрощения тестов , позволяя задавать возвращаемые значения без выполнения реального кода метода.
- **doAnswer()** предлагает максимальную гибкость, позволяя реализовать сложную логику ответа, что особенно полезно при тестировании взаимодействий с зависимостями, поведение которых может меняться в зависимости от контекста.

#### Верификация вызовов
- **verify()** позволяет убедиться, что определённые методы были вызваны с нужными параметрами, что важно для подтверждения правильности взаимодействий внутри тестируемого кода.
- Использование **InOrder** необходимо, когда порядок вызовов критичен для корректной работы приложения.
- Проверка порядка вызовов может выявить скрытые проблемы в логике приложения, которые не очевидны при стандартном тестировании.

#### Обработка исключений
- **assertThrows()** в JUnit 5 предоставляет простой способ проверки того, что метод корректно генерирует исключения при определённых условиях.
- Тестирование исключений необходимо для проверки устойчивости и надёжности приложения в условиях возникновения ошибок.
- Правильное управление исключениями гарантирует, что приложение может корректно обрабатывать нештатные ситуации, что улучшает пользовательский опыт и безопасность приложения.

#### Нет дополнительных взаимодействий
- **verifyNoMoreInteractions()** полезен для убеждения в том, что после проверенных операций с моком других вызовов не производилось.
- Этот метод помогает обеспечить, что тесты не пропускают неучтённые взаимодействия, которые могут влиять на работу приложения.


#### Основные аннотации

##### @ExtendWith

Активирует Mockito в тестах JUnit:

```java
@ExtendWith(MockitoExtension.class)
public class MockitoTests {
    // тесты здесь
}
```

##### @Mock и @Spy

- **@Mock** создаёт полностью контролируемый мок-объект.
- **@Spy** позволяет создать обёртку над реальным объектом, сохраняя его основное поведение:

```java
@Mock
List<String> mockList;

@Spy
List<String> spyList = new ArrayList<>();
```

#### Расширенное управление поведением

##### Методы doReturn(), doThrow(), и doAnswer()

- **doReturn()** предназначен для определения возвращаемого значения метода.
- **doThrow()** настраивает выброс исключения при вызове метода.
- **doAnswer()** позволяет задать сложное поведение:

```java
Mockito.doReturn(10).when(mockList).size();
Mockito.doThrow(new RuntimeException()).when(mockList).clear();
Mockito.doAnswer(invocation -> {
    int arg = invocation.getArgument(0);
    return arg * arg;
}).when(mockList).get(anyInt());
```

#### Верификация вызовов

##### verify() и InOrder

Проверяет, были ли выполнены вызовы определённых методов, и в правильном ли порядке:

```java
Mockito.verify(mockList).add("item");
InOrder inOrder = Mockito.inOrder(mockList);
inOrder.verify(mockList).add("Первый");
inOrder.verify(mockList).add("Второй");
```

#### Обработка исключений

##### assertThrows()

JUnit 5 метод для проверки выброса исключений:

```java
assertThrows(IllegalArgumentException.class, () -> mockList.get(1));
```

#### Нет дополнительных взаимодействий

##### verifyNoMoreInteractions()

Убеждаемся, что после проверенных вызовов не было других взаимодействий с моком:

```java
Mockito.verifyNoMoreInteractions(mockList);
```


## Тестирование контроллеров в Spring Boot

Тестирование контроллеров в Spring Boot обычно включает использование фреймворка `MockMvc`, который позволяет отправлять HTTP-запросы на контроллеры и проверять ответы без запуска полноценного сервера. Вот подробное объяснение основных методов и подходов:

### 1. Инициализация `MockMvc`

- **`MockMvcBuilders.standaloneSetup`**: Этот метод используется для создания конфигурации `MockMvc` для тестирования одного или нескольких контроллеров в изоляции от остальной части приложения. Это идеально подходит для модульного тестирования, так как не требуется загружать полный контекст Spring.
- **`MockMvcBuilders.webAppContextSetup`**: Этот метод требует загрузки полного веб-контекста приложения, что делает его подходящим для интеграционных тестов.

### 2. Конфигурация тестов

- **`@SpringBootTest`**: Эта аннотация используется для загрузки полноценного контекста приложения и применяется в интеграционных тестах, подходит для проверки реального поведения приложения в среде, максимально приближенной к продуктивной.
- **`@WebMvcTest`**: Специализированная аннотация для тестирования MVC контроллеров, которая загружает только необходимые для контроллера компоненты, такие как конвертеры и валидаторы, без запуска полного контекста Spring.

### 3. Настройка и использование `MockMvc`

- **`.perform(RequestBuilder requestBuilder)`**: Основной метод для отправки HTTP-запросов. `RequestBuilder` создается для имитации различных HTTP-запросов, как `get()`, `post()` и др.
- **`.andExpect(ResultMatcher matcher)`**: Метод для проверки ответов контроллера. Позволяет проверить статус ответа, содержимое ответа, заголовки и другие аспекты.

### 4. Проверка результатов

- **`status()`**: Проверка статуса HTTP-ответа, например, успешен ли он (`isOK()`) или привел ли к ошибке (`isBadRequest()`).
- **`jsonPath(String expression, Matcher<?> matcher)`**: Используется для проверки конкретных данных в JSON-ответе, например, содержит ли поле `name` в ответе ошибку валидации.

### 5. Обработка исключений и мокирование

- **`@MockBean`**: Аннотация для добавления моков в контекст Spring теста. Позволяет заменить реальные бины на подделки для контроля поведения зависимостей.
- **`when()` и `thenReturn()`**: Методы из библиотеки Mockito для настройки поведения моков. Например, можно настроить мок сервиса так, чтобы при вызове метода возвращалось исключение или специфический результат.

Эти методы и подходы позволяют гибко настраивать тестирование контроллеров в Spring Boot, обеспечивая как широкое покрытие функциональности, так и детализированную проверку каждого аспекта взаимодействия клиента с сервером.


