public class Car {
    private String carName;
    private Engine engine;
    private int carSpeed = 0;
    private final int speedLimit = 200;

    public Car(String name, Engine engine) {
        this.carName = name;
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
        engine.setSpeed(carSpeed);
    }

    public void start() {
        carSpeed = 0;
        engine.setSpeed(0);
        System.out.println(carName + " started. Speed: " + carSpeed);
    }

    public void stop() {
        carSpeed = 0;
        engine.setSpeed(0);
        System.out.println(carName + " stopped. Speed: " + carSpeed);
    }

    public void accelerate() {
        if (carSpeed + 20 <= speedLimit) {
            carSpeed += 20;
            engine.setSpeed(carSpeed);
            System.out.println(carName + " accelerated to " + carSpeed + " km/h");
        } else {
            System.out.println("Cannot exceed speed limit!");
        }
    }

    public void brake() {
        if (carSpeed - 20 >= 0) {
            carSpeed -= 20;
            engine.setSpeed(carSpeed);
            System.out.println(carName + " slowed to " + carSpeed + " km/h");
        } else {
            System.out.println("Car is already stopped.");
        }
    }

    public int getSpeed() {
        return carSpeed;
    }

    public String getCarName() {
        return carName;
    }

    public String getEngineType() {
        return engine.getClass().getSimpleName();
    }

    public String getActiveEngineName() {
        String name = engine.getActiveEngineName();
        return name != null ? name : getEngineType();
    }
}
