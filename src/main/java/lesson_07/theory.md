# Lesson 07


###  JDBC

**Java JDBC API: работа с базами данных**

---

#### 1. Введение в JDBC

JDBC (Java Database Connectivity) является стандартным Java API для взаимодействия с базами данных. JDBC играет критически важную роль в Java-приложениях, позволяя им выполнять запросы и обновления в базах данных, а также получать результаты этих запросов.

**Пример кода:**
```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");
while (rs.next()) {
    System.out.println(rs.getString("columnname"));
}
```

---

#### 2. История появления баз данных: БД и СУБД

Базы данных были разработаны для удобного хранения и доступа к большим объемам данных. СУБД (система управления базами данных) предоставляет интерфейс для взаимодействия с базами данных, обеспечивая операции создания, чтения, обновления и удаления данных.

---

#### 3. Популярные СУБД и MySQL

Различные СУБД, такие как Oracle, MySQL, PostgreSQL, обладают своими уникальными особенностями, но все они предоставляют механизмы для управления данными.

**Примеры кода:**

**Oracle:**
```java
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:mydb", "user", "password");
```

**MySQL:**
```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
```

**PostgreSQL:**
```java
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "user", "password");
```

---

#### 4. NoSQL базы данных

NoSQL базы данных, такие как MongoDB или Cassandra, предлагают альтернативные модели хранения данных, которые могут быть более подходящими для определенных типов приложений, например, требующих горизонтального масштабирования или хранения неструктурированных данных.

---

#### 5. Сервер баз данных и СУБД

Сервер баз данных обеспечивает централизованное хранилище данных и предоставляет механизмы для управления доступом к этим данным. СУБД управляет взаимодействием между клиентом и сервером баз данных, обеспечивая выполнение запросов и возвращение результатов.

---

#### 6. SQL базы данных

SQL (Structured Query Language) - это язык, используемый для управления и манипулирования реляционными базами данных. Он позволяет создавать, изменять, запрашивать и управлять данными.

**Пример запроса SQL:**
```sql
SELECT * FROM users WHERE age > 18;
```

---

#### 7. Таблицы в базе данных: колонки и столбцы

В реляционных базах данных данные хранятся в таблицах, состоящих из строк и столбцов. Столбцы представляют собой атрибуты данных, а строки - конкретные записи.

**Пример кода:**
```java
ResultSet rs = stmt.executeQuery("SELECT name, age FROM users");
while (rs.next()) {
    String name = rs.getString("name");
    int age = rs.getInt("age");
    System.out.println("Name: " + name + ", Age: " + age);
}
```

---

#### 8. JDBC — Java Database Connectivity — архитектура

JDBC предоставляет унифицированный интерфейс для взаимодействия с различными СУБД, позволяя Java-приложениям общаться с базой данных независимо от конкретной СУБД.

**Пример использования PreparedStatement:**
```java
String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "John Doe");
pstmt.setInt(2, 30);
pstmt.executeUpdate();
```

---

#### 9. Data Access Object (DAO)

DAO — это шаблон проектирования, который предоставляет абстрактный интерфейс к типу базы данных, позволяя отделять логику доступа к данным от бизнес-логики.

**Пример реализации DAO:**
```java
public class UserDAO {
    public User getUser(int id) {
        Connection conn = DriverManager.getConnection(/* connection details */);
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
        }
        return null;
    }
}
```


### Детальная информация о драйверах JDBC и основных методах JDBC


### 1. Типы драйверов JDBC

В JDBC существует четыре типа драйверов, каждый из которых имеет разные характеристики и предназначен для различных сценариев использования:

1. **JDBC-ODBC мост (Тип 1)**: Этот драйвер использует ODBC драйвер для подключения к базе данных. Он преобразует вызовы JDBC в вызовы ODBC. Такой подход не рекомендуется, так как он вносит дополнительный уровень накладных расходов и требует наличия ODBC драйвера.

2. **Нативный API частично в Java (Тип 2)**: Тип 2 использует клиентский API для взаимодействия с базой данных, и требует наличия нативных библиотек на стороне клиента. Это обеспечивает лучшую производительность по сравнению с типом 1, но ограничивает переносимость.

3. **Сетевой протокол чисто в Java (Тип 3)**: Этот драйвер преобразует JDBC вызовы в специфические для сервера баз данных сетевые вызовы. Это позволяет клиентам использовать различные базы данных через один и тот же интерфейс.

4. **Тонкий драйвер чисто в Java (Тип 4)**: Этот драйвер преобразует вызовы JDBC непосредственно в сетевые вызовы для конкретной базы данных, минуя клиентскую библиотеку БД. Это самый популярный тип драйвера, так как он не требует дополнительных нативных библиотек и обеспечивает хорошую производительность.

---

### 2. Основные методы JDBC

#### DriverManager

`DriverManager` — это фабрика для создания объектов `Connection`. Он выбирает подходящий драйвер из загруженных в систему для установления соединения с базой данных.

**Пример кода:**
```java
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
```

#### Регистрация JDBC драйвера

До JDBC 4.0 драйверы необходимо было регистрировать в системе, используя `Class.forName()`. С JDBC 4.0 драйверы загружаются автоматически.

**Пример кода:**
```java
Class.forName("com.mysql.jdbc.Driver");
```

#### Statement

`Statement` используется для выполнения SQL-запросов без параметров.

**Пример кода:**
```java
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
```

#### ResultSet

`ResultSet` представляет собой результат выполнения SQL-запроса, предоставляя доступ к данным, полученным из базы данных.

**Пример кода:**
```java
while (resultSet.next()) {
    System.out.println(resultSet.getString("column_name"));
}
```

#### PreparedStatement

`PreparedStatement` представляет собой предварительно скомпилированный SQL-запрос, который может содержать один или несколько входных параметров.

**Пример кода:**
```java
PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mytable (column1, column2) VALUES (?, ?)");
preparedStatement.setString(1, "value1");
preparedStatement.setInt(2, 123);
preparedStatement.executeUpdate();
```

`PreparedStatement` улучшает производительность и предотвращает SQL-инъекции благодаря предварительной компиляции и использованию плейсхолдеров для параметров.

--


