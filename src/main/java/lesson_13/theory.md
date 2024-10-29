# Lesson 13


### Шаг 1: Получение API ключа на Weatherbit.io

Для начала работы с API Weatherbit, вам необходимо зарегистрироваться на сайте и получить API ключ, который будет использоваться для аутентификации ваших запросов. Вот более подробная инструкция по получению ключа:

1. **Посещение сайта**: Перейдите на главную страницу [Weatherbit.io](https://www.weatherbit.io/).
2. **Регистрация/Вход**: На главной странице найдите кнопку для регистрации или входа. Если у вас ещё нет аккаунта, вам нужно будет зарегистрироваться, предоставив необходимые данные.
3. **Получение API ключа**: После регистрации или входа в систему перейдите в раздел управления API ключами. Здесь вы можете создать новый API ключ. Обычно, после создания, ключ становится доступен сразу, и вы можете его скопировать.

### Формат запроса

API Weatherbit поддерживает различные типы погодных данных, включая текущую погоду, прогноз на несколько дней, исторические данные и другие. Пример запроса на получение текущей погоды:

```
https://api.weatherbit.io/v2.0/current?city=Raleigh,NC&key=ВАШ_API_КЛЮЧ
```

**Параметры запроса:**
- `city`: Город и код страны, например, "Raleigh,NC".
- `key`: Ваш API ключ.

Вы также можете использовать другие параметры, такие как `lat` и `lon` для широты и долготы, `lang` для языка ответов и многие другие, в зависимости от ваших потребностей.

### Формат ответа

API возвращает данные в формате JSON. Пример ответа API на запрос текущей погоды выглядит следующим образом:

```json
{
  "data": [
    {
      "rh": 59,        // Влажность в процентах
      "pod": "n",      // Часть суток (d = день, n = ночь)
      "lon": -78.63861,
      "pres": 1013.4,  // Давление в мбар
      "timezone": "America/New_York",
      "ob_time": "2020-10-26 03:45",  // Время наблюдения
      "country_code": "US",
      "clouds": 1,     // Облачность в процентах
      "ts": 1603698350,// Временная метка
      "solar_rad": 0,
      "state_code": "NC",
      "city_name": "Raleigh",
      "wind_spd": 3.1, // Скорость ветра в м/с
      "last_ob_time": "2020-10-26T03:45:00",
      "wind_cdir_full": "северо-западный",
      "wind_cdir": "NW",
      "slp": 1026.3,   // Давление на уровне моря в мбар
      "vis": 5,        // Видимость в км
      "h_angle": -60,
      "sunset": "23:12",
      "dni": 500,
      "dewpt": 15.4,   // Температура точки росы в °C
      "snow": 0,
      "uv": 0,
      "precip": 0,     // Осадки в мм
      "wind_dir": 273,
      "sunrise": "12:08",
      "ghi": 500,
      "dhi": 500,
      "aqi": 45,       // Индекс качества воздуха
      "lat": 35.7721,
      "weather": {
        "icon": "c02n",
        "code": "802",
        "description": "Перемен

ная облачность"
      },
      "datetime": "2020-10-26:04",
      "temp": 22.4,    // Температура в °C
      "station": "E0380",
      "elev_angle": -0.78,
      "app_temp": 22.4 // Температура по ощущениям в °C
    }
  ],
  "count": 1
}
```

### Преобразование ответа в нужный вид данных

Для преобразования JSON ответа в объекты Java, можно использовать библиотеку Jackson.
Пример классов для десериализации данных:

```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    public WeatherData[] data;

    public static class WeatherData {
        public double temp; // Температура
        public double rh; // Влажность
        public String city_name; // Название города
        public double pres; // Давление
        public String timezone; // Часовой пояс
        public double wind_spd; // Скорость ветра
        public String wind_cdir_full; // Полное направление ветра
        public double vis; // Видимость
        public double uv; // УФ-индекс
        public double aqi; // Индекс качества воздуха
        public double snow; // Снег
        public double precip; // Осадки
        public Weather weather; // Погода
        public String datetime; // Дата и время

        public static class Weather {
            public String description; // Описание погоды
            public String icon; // Иконка погоды
        }
    }
}
```

### Добавление остальных данных
Если вы хотите включить ещё больше параметров, например, давление на уровне моря (`slp`), время восхода (`sunrise`) и заката (`sunset`),
температуру точки росы (`dewpt`) и другие, просто добавьте соответствующие поля в классы `WeatherData` и `Weather`.

### Полная интеграция данных
Добавление всех данных требует точного отражения структуры JSON в ваших классах Java.
Это позволяет библиотеке Jackson корректно десериализовать входящий JSON в объекты Java.
Важно убедиться, что имена переменных и их типы соответствуют тем, которые используются в
JSON (или использовать аннотацию `@JsonProperty` для указания точных имен полей JSON).

### Пример использования
После расширения классов, ваш код для обработки ответа может выглядеть так:

```java
ObjectMapper mapper = new ObjectMapper();
WeatherResponse response = mapper.readValue(jsonString, WeatherResponse.class);

for (WeatherData data : response.data) {
    System.out.println("Город: " + data.city_name);
    System.out.println("Температура: " + data.temp + "°C");
    System.out.println("Описание погоды: " + data.weather.description);
    // Вывод других данных...
}
```

Работа со сторонними серверами через отправку GET-запросов и обработку ответов является фундаментальным аспектом взаимодействия с API в современном веб-разработке. Давайте подробно рассмотрим процесс отправки GET-запроса и обработки ответа с примерами.

### 1. Что такое GET-запрос?

GET-запрос — это тип HTTP-запроса, используемый для запроса данных с сервера. Когда вы отправляете GET-запрос, вы запрашиваете сервер отправить вам конкретный ресурс, например, данные в формате JSON или HTML-страницу. GET-запросы используются, когда вы хотите получить данные, а не изменять их на сервере.

### 2. Как работает GET-запрос?

Когда клиент (например, ваше приложение или браузер) отправляет GET-запрос, сервер принимает запрос, обрабатывает его и возвращает соответствующий ответ. Ответ сервера может включать данные в различных форматах, таких как JSON, XML, HTML и другие.

#### Пример GET-запроса

Предположим, что у нас есть API, предоставляющее информацию о погоде. Чтобы получить данные о погоде для конкретного города, мы можем отправить GET-запрос к API:

```http
GET /weather?city=London HTTP/1.1
Host: api.weather.com
Accept: application/json
```

Этот запрос запрашивает ресурс `/weather` и передает параметр `city` со значением `London`. `Accept: application/json` указывает серверу, что клиент ожидает получить ответ в формате JSON.

### 3. Отправка GET-запроса в Java с использованием RestTemplate

Для отправки GET-запросов в Java можно использовать `RestTemplate`, который является частью Spring Framework. Рассмотрим, как отправить GET-запрос и обработать ответ.

#### Пример кода на Java

```java
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(String city) {
        String url = "https://api.weather.com/weather?city=" + city;

        // Отправка GET-запроса
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);

        // Обработка ответа
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            WeatherResponse weatherResponse = response.getBody();
            return new WeatherData(weatherResponse.getTemp(), weatherResponse.getHumidity());
        } else {
            throw new RuntimeException("Failed to fetch weather data");
        }
    }
}
```

В этом примере:
1. **Создание URL**: Мы создаем строку URL с использованием заданного города.
2. **Отправка GET-запроса**: Используем метод `getForEntity` класса `RestTemplate` для отправки запроса. Этот метод возвращает объект `ResponseEntity`, который содержит как статус ответа, так и тело ответа.
3. **Обработка ответа**: Мы проверяем, успешен ли статус ответа (статус 2xx) и существует ли тело ответа. Если все в порядке, мы извлекаем данные и возвращаем их. В противном случае генерируется исключение.

#### Модель ответа

Для обработки JSON-ответа от API нам нужно создать модельный класс, соответствующий структуре JSON:

```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("humidity")
    private int humidity;

    // Getters и Setters
    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
```

### 4. Обработка ошибок и исключений

При работе с внешними API важно обрабатывать возможные ошибки, такие как таймауты, неправильные параметры или неудачные ответы сервера. Это можно сделать с помощью обработки исключений.

#### Пример обработки ошибок

```java
public WeatherData getWeatherData(String city) {
    String url = "https://api.weather.com/weather?city=" + city;

    try {
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            WeatherResponse weatherResponse = response.getBody();
            return new WeatherData(weatherResponse.getTemp(), weatherResponse.getHumidity());
        } else {
            // Обработка статусов, отличных от 2xx
            throw new RuntimeException("Failed to fetch weather data: " + response.getStatusCode());
        }
    } catch (RestClientException e) {
        // Обработка сетевых ошибок или ошибок на стороне клиента
        throw new RuntimeException("An error occurred while fetching weather data", e);
    }
}
```

### 5. Пример JSON-ответа и его десериализация

Когда сервер возвращает ответ, например, в формате JSON:

```json
{
  "temp": 23.5,
  "humidity": 60
}
```

Этот ответ автоматически преобразуется в объект `WeatherResponse` благодаря библиотеке Jackson, используемой в Spring.

### 6. Дополнительные параметры запроса и заголовки

Иногда требуется отправить дополнительные параметры или заголовки с GET-запросом. Это можно сделать с помощью `HttpHeaders` и `HttpEntity` в `RestTemplate`.

#### Пример с заголовками

```java
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public WeatherData getWeatherDataWithHeaders(String city) {
    String url = "https://api.weather.com/weather?city=" + city;
    
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    headers.set("Authorization", "Bearer your_token_here");

    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<WeatherResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, WeatherResponse.class);

    if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
        WeatherResponse weatherResponse = response.getBody();
        return new WeatherData(weatherResponse.getTemp(), weatherResponse.getHumidity());
    } else {
        throw new RuntimeException("Failed to fetch weather data");
    }
}
```


POST-запросы используются для отправки данных на сервер с целью создания или обновления ресурсов. В отличие от GET-запросов, которые запрашивают данные, POST-запросы обычно отправляют данные на сервер, и эти данные могут быть включены в тело запроса в различных форматах (например, JSON, XML, form-data).

Давайте подробно рассмотрим, как отправить POST-запрос и обработать ответ, используя пример на Java с использованием `RestTemplate` из Spring Framework.

### 1. Что такое POST-запрос?

POST-запрос — это тип HTTP-запроса, который используется для отправки данных на сервер. Он обычно используется для создания новых ресурсов или обновления существующих. Данные, отправляемые с POST-запросом, включаются в тело запроса и могут передаваться в различных форматах, таких как JSON, XML, и `application/x-www-form-urlencoded`.

### 2. Как работает POST-запрос?

Когда клиент отправляет POST-запрос, сервер получает данные в теле запроса и выполняет действие, основанное на этих данных (например, создание новой записи в базе данных). Сервер затем возвращает ответ, который может включать данные о новом ресурсе или подтверждение выполнения операции.

#### Пример POST-запроса

Предположим, что у нас есть API, который позволяет добавлять новые данные о погоде в систему:

```http
POST /weather HTTP/1.1
Host: api.weather.com
Content-Type: application/json
Accept: application/json

{
  "city": "London",
  "temperature": 18.5,
  "humidity": 65
}
```

В этом примере мы отправляем POST-запрос на сервер, чтобы создать новый ресурс с информацией о погоде для города Лондон.

### 3. Отправка POST-запроса в Java с использованием RestTemplate

Для отправки POST-запросов в Java можно использовать `RestTemplate`, который является частью Spring Framework. Рассмотрим, как отправить POST-запрос с данными и обработать ответ.

#### Пример кода на Java

```java
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData addWeatherData(String city, double temperature, int humidity) {
        String url = "https://api.weather.com/weather";

        // Создание объекта, который мы хотим отправить в теле запроса
        WeatherRequest request = new WeatherRequest(city, temperature, humidity);

        // Установка заголовков
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        // Создание HttpEntity, включающего заголовки и тело запроса
        HttpEntity<WeatherRequest> entity = new HttpEntity<>(request, headers);

        // Отправка POST-запроса
        ResponseEntity<WeatherResponse> response = restTemplate.postForEntity(url, entity, WeatherResponse.class);

        // Обработка ответа
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to add weather data");
        }
    }
}
```

#### Модель данных запроса и ответа

Для отправки и получения данных мы создадим классы-модели, представляющие структуру JSON:

```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherRequest {
    private String city;
    private double temperature;
    private int humidity;

    public WeatherRequest(String city, double temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // Getters и Setters
}

public class WeatherResponse {
    @JsonProperty("city")
    private String city;

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("humidity")
    private int humidity;

    // Getters и Setters
}
```

### 4. Обработка ошибок и исключений

При работе с POST-запросами важно обрабатывать возможные ошибки, такие как неверные параметры, таймауты или неудачные ответы сервера. Это можно сделать с помощью обработки исключений.

#### Пример обработки ошибок

```java
public WeatherData addWeatherData(String city, double temperature, int humidity) {
    String url = "https://api.weather.com/weather";

    WeatherRequest request = new WeatherRequest(city, temperature, humidity);
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");
    headers.set("Accept", "application/json");
    HttpEntity<WeatherRequest> entity = new HttpEntity<>(request, headers);

    try {
        ResponseEntity<WeatherResponse> response = restTemplate.postForEntity(url, entity, WeatherResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to add weather data: " + response.getStatusCode());
        }
    } catch (RestClientException e) {
        throw new RuntimeException("An error occurred while adding weather data", e);
    }
}
```

### 5. Пример JSON-ответа и его десериализация

Предположим, что сервер возвращает JSON-ответ, подтверждающий создание нового ресурса:

```json
{
  "city": "London",
  "temperature": 18.5,
  "humidity": 65
}
```

Этот ответ автоматически преобразуется в объект `WeatherResponse` благодаря библиотеке Jackson, используемой в Spring.

### 6. Отправка POST-запроса с дополнительными параметрами и заголовками

В некоторых случаях необходимо отправить дополнительные параметры или заголовки вместе с POST-запросом. Это можно сделать с помощью `HttpHeaders` и `HttpEntity`.

#### Пример с дополнительными заголовками

```java
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData addWeatherData(String city, double temperature, int humidity) {
        String url = "https://api.weather.com/weather";

        WeatherRequest request = new WeatherRequest(city, temperature, humidity);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        headers.set("Authorization", "Bearer your_token_here");

        HttpEntity<WeatherRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<WeatherResponse> response = restTemplate.postForEntity(url, entity, WeatherResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to add weather data");
        }
    }
}
```





