package lesson_04.code.di;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarDemo {
    public static void main(String[] args) {

        EngineGeneral carEngine = new EngineElectric();
        Body carBody = new Body();
        Transmission carTransmission = new Transmission();

        // ==================

        Car car = new Car(carBody,carEngine,carTransmission);

        car.getEngine().start();

        // ==================

        Map<String, Object> context = new HashMap<>();

        context.put("body", carBody);
        context.put("engine", carEngine);
        context.put("transmission", carTransmission);


        Body myBody = (Body) context.get("body");




    }
}
