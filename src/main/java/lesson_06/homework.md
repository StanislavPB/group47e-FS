## 1. Задание: Разработка основы для рабочего приложения

- придумать задание
- создать проект в IDEA с помощью Spring Boot generator
- добавить зависимости (spring-boot-starter-web, lombok )
- создать entity, dto, repository, service, controller
- проверить работоспособность с помощью postman


#### Цель:
Разработать основу для рабочего приложения, представляющего собой мини-проект.
В ходе выполнения задания необходимо создать основные компоненты приложения: entity, repository, service и controller.

#### Описание задания:
Необходимо создать приложение, которое будет выполнять CRUD (Create, Read, Update, Delete) операции для определённой сущности с использованием коллекций для хранения данных.
Приложение должно позволять добавлять, редактировать, удалять и просматривать объекты этой сущности.

#### Требования:

1. **Entity**:
    - Создайте класс, представляющий сущность в системе (например, `Product`, `Customer`, `Order` и т.д.).
    - Пример атрибутов для класса `Product`:
        - `Long id` (уникальный идентификатор)
        - `String name` (название продукта)
        - `String description` (описание продукта)
        - `double price` (цена продукта)
        - `int quantity` (количество на складе)

2. **Repository**:
    - Создайте интерфейс `YourEntityRepository`, который будет содержать методы для работы с коллекцией объектов.
    - Методы интерфейса `YourEntityRepository`:
        - `List<YourEntity> findAll()`
        - `YourEntity findById(Long id)`
        - `YourEntity save(YourEntity entity)`
        - `void deleteById(Long id)`
        - Дополнительные методы для поиска по различным критериям (например, `List<YourEntity> findByName(String name)`).

3. **Service**:
    - Создайте интерфейс `YourEntityService` и его реализацию `YourEntityServiceImpl`, которая будет использовать коллекцию для хранения данных.
    - Методы интерфейса `YourEntityService`:
        - `List<YourEntity> findAll()`
        - `YourEntity findById(Long id)`
        - `YourEntity save(YourEntity entity)`
        - `void deleteById(Long id)`
        - Дополнительные методы для поиска по различным критериям (например, `List<YourEntity> findByName(String name)`).

4. **Controller**:
    - Создайте класс `YourEntityController`, помеченный аннотацией `@RestController`.
    - Настройте маршруты для обработки следующих HTTP-запросов:
        - `GET /entities` - получение списка всех объектов
        - `GET /entities/{id}` - получение объекта по идентификатору
        - `POST /entities` - добавление нового объекта
        - `PUT /entities/{id}` - обновление существующего объекта
        - `DELETE /entities/{id}` - удаление объекта по идентификатору
        - Дополнительные маршруты для поиска по различным критериям (например, `GET /entities/search?name={name}`).

#### Пример реализации:

1. **Entity**:
```java
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    // Геттеры и сеттеры
}
```

2. **Repository**:
```java
public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findByName(String name);
}
```

3. **Service**:
```java
public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findByName(String name);
}

public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();

    // Реализация методов
}
```

4. **Controller**:
```java
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.findByName(name);
    }
}
```

#### Критерии оценки:
1. Корректность и полнота реализации классов `YourEntity`, `YourEntityRepository`, `YourEntityService`, `YourEntityServiceImpl` и `YourEntityController`.
2. Работоспособность CRUD операций.
3. Тестирование созданного приложения (можно использовать JUnit для написания тестов).
4. Чистота и читаемость кода.

#### Рекомендации:
- Следуйте принципам SOLID.

Удачи в разработке!


