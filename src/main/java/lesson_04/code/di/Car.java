package lesson_04.code.di;

public class Car {
    private Body body;
    private EngineGeneral engine;
    private Transmission transmission;

    public Car(Body body, EngineGeneral engine, Transmission transmission) {
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    public Body getBody() {
        return body;
    }

    public EngineGeneral getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}
