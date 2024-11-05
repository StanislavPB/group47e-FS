# Lesson 17


## Spring Security

## 01. Безопасность в приложении


* `Aутентификация` - идентификация пользователя, кто ты?
* Аутентификация - процесс, при котором приложение запрашивает логин и пароль и проверяет их корректность (проверка подлинности данных пользователя)


* `Авторизация` - проверка прав пользователя, какие действия ты можешь выполнять?
* Авторизация - процесс, при котором приложение проверяет права пользователя на выполнение каких-либо операций
    * например, проверка на возможность получения пользователем всех курсов по адресу `/courses`

* HTTP-сессия - это некоторый объект, который мы храним на сервере, с которым может быть ассоциирован конкретный пользователь

## 02. Процесс аутентификации на основе сессии

* Сначала клиент отправляет POST-запрос на сервер по адресу `api/login`
* В теле запроса клиент передает данные для аутентификации (например, email и пароль)
* Сервер проверяет корректность этих данных (находит пользователя в базе, хеширует введенный пароль, сравнивает с тем, который есть в базе)
* Если данные для входа корректные, то сервер в оперативной памяти создает объект сессии
    * ассоциирует с этим объектом данные пользователя
    * назначает объекту идентификатор
    * отправляет клиенту этот идентификатор, который на клиенте сохраняется в куках

## 03. Процесс авторизации на основе сессии

* Клиент посылает свой запрос вместе с кукой, которая содержит идентификатор сессии
* Сервер по этому идентификатору находит сессию в хранилище и получает ее атрибуты (в нашем случае это пользователь)
* Получив пользователя, сервер проверяет его роль и доступ к определенному endpoint на основе правил (опишем далее)
* Клиенту возвращается либо запрошенный ресурс, либо 403-статус (Запрещено)


## 04. Настройка безопасности Spring Boot с Spring Security

* При подключении Spring Boot Starter Security у вас есть:
    * Страница входа
    * Защита всех endpoints
    * Логин `user`
    * Пароль генерируется в консоли
* Но мы хотим, чтобы люди заходили под своими логинами и паролями


* `Authentication` - объект, который хранит для каждого запроса информацию о пользователе и статусе его аутентификации.

* `SecurityContext` - информация о безопасности, которая ассоциирована с текущим потоком исполнения (Thread). Хранит объект Authentication.

* `SecurityContextHolder` - привязывает SecurityContext к текущему потоку исполнения. По умолчанию ThreadLocal - контекст безопосности доступен всем методам, исполняемым в рамках данного потока.

* Т.е. когда приходит запрос на сервер, сервер выделяет ему один поток из `Tomcat Thread Pool`
* Далее, SecurityContextHolder (на самом деле фильтры, но это не важно) смотрит текущую сессию и привязывает объект `Authentication` к текущему потоку исполнения
* Далее, когда запрос приходит в какой-либо контроллер или хендлер - он уже приходит с объектом аутентификации


### Шаги по настройке Spring Security


1. Создать класс-реализацию интерфейса `UserDetails`
* Данный класс нужен для того, чтобы адаптировать вашего пользователя под безопасность Spring Security
* По сути, это адаптер нашего класса `User` для `Spring Security`
2. Создать класс-реализацию интерфейса `UserDetailsService`
* Данный класс нужен для того, чтобы показать Spring Security откуда брать пользователя для проверки
3. Настройка конфигурации Spring Security
4. Навести порядок с ответами на запросы


1. Аутентификация (Authentication)

Аутентификация — это процесс проверки подлинности пользователя, то есть установления его личности. Spring Security поддерживает различные способы аутентификации, включая:

    Формы аутентификации (login form).
    Basic Authentication и Bearer Token Authentication (часто используются для API).
    OAuth2 и OpenID Connect (для интеграции с внешними провайдерами, такими как Google, Facebook и др.).
    LDAP и Database Authentication (для хранения учетных данных в базе данных или LDAP-сервере).
    JWT (JSON Web Tokens) — полезно для REST API.

2. Авторизация (Authorization)

Авторизация — это процесс проверки, какие ресурсы и действия доступны для аутентифицированного пользователя. Spring Security позволяет:

    Задавать роли и привилегии для пользователей.
    Использовать метод-уровневые аннотации (@PreAuthorize, @Secured) для ограничения доступа к методам.
    Настраивать доступ к ресурсам через URL-паттерны.

3. Защита от угроз

Spring Security предоставляет инструменты для защиты приложения от множества веб-угроз, таких как:

    CSRF (Cross-Site Request Forgery) — включен по умолчанию для защиты от межсайтовой подделки запросов.
    XSS (Cross-Site Scripting) — предотвращает внедрение скриптов через проверку данных.
    Session Fixation — предотвращает фиксацию сессии, когда злоумышленник пытается использовать идентификатор сессии легального пользователя.
    CORS (Cross-Origin Resource Sharing) — настройка разрешений на доступ с разных доменов.

4. Основные компоненты Spring Security

Spring Security состоит из различных компонентов:

    Security Context — содержит информацию об аутентифицированном пользователе и его полномочиях.
    Authentication Manager — управляет процессом аутентификации.
    Security Filter Chain — цепочка фильтров, которые выполняют аутентификацию и авторизацию на каждом запросе.
    Access Decision Manager — определяет, разрешить ли доступ к ресурсу на основе политики безопасности.


**Spring Security 6** — это последняя версия фреймворка для обеспечения безопасности приложений, написанных на Java. Spring Security 6 предлагает обновления и улучшения в области конфигурации безопасности, аутентификации, управления сессиями, защиты от CSRF и других аспектов безопасности. Эта версия ориентирована на упрощение настройки и повышение совместимости с новыми стандартами безопасности и версиями Java.

### Основные изменения и особенности Spring Security 6

1. **Удаление `WebSecurityConfigurerAdapter`**:
  - В Spring Security 6 удалена необходимость использовать `WebSecurityConfigurerAdapter`. Вместо этого безопасность настраивается через `SecurityFilterChain` и Java-конфигурацию с аннотацией `@Bean`.
  - Это изменение упрощает структуру кода и делает конфигурацию более модульной.

   **Пример настройки `SecurityFilterChain`**:
   ```java
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
           .authorizeHttpRequests(auth -> auth
               .requestMatchers("/public/**").permitAll()
               .anyRequest().authenticated())
           .formLogin(form -> form
               .loginPage("/login")
               .permitAll())
           .logout(logout -> logout
               .logoutUrl("/logout")
               .logoutSuccessUrl("/"));
       return http.build();
   }
   ```

2. **Изменения в настройке авторизационных запросов**:
  - Метод `authorizeRequests` заменен на `authorizeHttpRequests`, и вместо `antMatchers`, теперь используется `requestMatchers` для настройки доступов к различным URL.
  - Это улучшение сделано для унификации и упрощения конфигурации, и оно поддерживает тот же функционал, но более удобно в использовании.

3. **Полная поддержка Java 17 и Jakarta EE**:
  - Spring Security 6 разработан для полной поддержки Java 17 и новых спецификаций Jakarta EE.
  - Все зависимости Java EE заменены на Jakarta EE, например, вместо `javax.servlet` используется `jakarta.servlet`. Это изменение важно для совместимости с новыми версиями Java и Jakarta EE.

4. **OAuth2 и OpenID Connect**:
  - В Spring Security 6 добавлена поддержка новых спецификаций OAuth2 и OpenID Connect, что делает интеграцию с внешними провайдерами аутентификации (такими как Google, Facebook) еще более гибкой.
  - Поддерживаются настройки клиентских и ресурсных серверов для OAuth2, включая генерацию и валидацию токенов, настройки политики сессий и обновленные методы для защиты API с использованием токенов.

5. **Более гибкая настройка CORS и CSRF**:
  - Spring Security 6 упрощает настройку CORS (Cross-Origin Resource Sharing) и CSRF (Cross-Site Request Forgery), что особенно важно для защищенных REST API.
  - Теперь можно легко включить и настроить CSRF для определенных HTTP-методов или URL.

6. **Новый механизм PasswordEncoder**:
  - В Spring Security 6 рекомендуется использовать `PasswordEncoder` с улучшенной безопасностью, например `BCryptPasswordEncoder`, для хеширования паролей.
  - Использование `NoOpPasswordEncoder` (который не хеширует пароли) по-прежнему возможно, но не рекомендуется в продуктивной среде.

   **Пример настройки `PasswordEncoder`**:
   ```java
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
   ```

7. **Аутентификация через `UserDetailsService`**:
  - Теперь `UserDetailsService` и аутентификационные провайдеры настраиваются через `SecurityFilterChain` и внедряются как `@Bean` компоненты, что упрощает аутентификацию и облегчает тестирование.

   **Пример настройки `UserDetailsService` с пользователями в памяти**:
   ```java
   @Bean
   public UserDetailsService userDetailsService() {
       UserDetails user = User.withUsername("user")
           .password(passwordEncoder().encode("password"))
           .roles("USER")
           .build();
       return new InMemoryUserDetailsManager(user);
   }
   ```

8. **Изменения в работе с сессиями**:
  - Spring Security 6 поддерживает более гибкое управление сессиями и предоставляет улучшенные механизмы защиты от атак, таких как фиксация сессий и перехват сессий.
  - Это включает настройку тайм-аутов сессий, ограничение количества одновременных сессий для пользователей и управление политикой принудительного завершения сессий.

9. **Поддержка OpenID Connect 1.0**:
  - Встроенная поддержка OpenID Connect 1.0 позволяет использовать Spring Security для единого входа (SSO) с помощью популярных провайдеров, таких как Google и другие.
  - Настройка OpenID Connect теперь проще и удобнее, и поддерживает обновленные спецификации, такие как PKCE (Proof Key for Code Exchange).

### Примеры использования Spring Security 6

#### Пример настройки аутентификации с формой входа и ролями
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll())
            .formLogin(withDefaults())
            .logout(logout -> logout
                .logoutSuccessUrl("/home"));
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

#### Пример настройки CORS для REST API
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors
            .configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(List.of("http://localhost:3000"));
                config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                config.setAllowCredentials(true);
                return config;
            })
        )
        .csrf().disable()
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/**").authenticated())
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    return http.build();
}
```

### Вывод
Spring Security 6 — это мощное обновление, которое упрощает настройку безопасности и улучшает совместимость с новыми стандартами Java и Jakarta EE. Обновленные методы конфигурации, улучшенная поддержка OAuth2/OpenID Connect, и усовершенствованная работа с сессиями делают Spring Security 6 отличным выбором для современных Java-приложений.







