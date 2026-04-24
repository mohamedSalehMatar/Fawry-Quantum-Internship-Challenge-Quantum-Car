import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    static List<Car> allCars = new ArrayList<>();

    public static boolean hasCars() {
        return !allCars.isEmpty();
    }

    public static List<Car> getAllCars() {
        return allCars;
    }

    public static Car createCar(String name, String engineType) {
        Engine engine;
        switch (engineType.toLowerCase()) {
            case "gasoline":
                engine = new GasolineEngine();
                break;
            case "electronic":
                engine = new ElectronicEngine();
                break;
            case "hybrid":
                engine = new HybridEngine();
                break;
            default:
                throw new IllegalArgumentException("Unknown engine type");
        }
        Car car = new Car(name, engine);
        allCars.add(car);
        return car;
    }

    public static void viewCars() {
        if (allCars.isEmpty()) {
            System.out.println("No cars in the garage.");
            return;
        }
        for (int i = 0; i < allCars.size(); i++) {
            Car car = allCars.get(i);
            System.out.println("Index " + i + ": " + car.getCarName() + " (" + car.getEngineType() + ") Speed: " + car.getSpeed());
        }
    }

    public static void replaceEngine(int carIndex, String engineType) {
        if (carIndex < 0 || carIndex >= allCars.size()) {
            System.out.println("Invalid car index.");
            return;
        }
        Engine engine;
        switch (engineType.toLowerCase()) {
            case "gasoline":
                engine = new GasolineEngine();
                break;
            case "electronic":
                engine = new ElectronicEngine();
                break;
            case "hybrid":
                engine = new HybridEngine();
                break;
            default:
                throw new IllegalArgumentException("Unknown engine type");
        }
        allCars.get(carIndex).setEngine(engine);
        System.out.println("Engine replaced for car " + allCars.get(carIndex).getCarName());
    }

    public static void testCar(int carIndex) {
        if (carIndex < 0 || carIndex >= allCars.size()) {
            System.out.println("Invalid car index.");
            return;
        }
        Car car = allCars.get(carIndex);
        car.start();
        car.accelerate();
        car.accelerate();
        car.brake();
        car.stop();
    }
}
