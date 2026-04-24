import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Hello and welcome to our car factory!!");
        System.out.println("where you can make any car with any engine!!");

        while (!exit) {
            System.out.println("\nWhat are you here for?");
            System.out.println("1. Make a new car");
            System.out.println("2. View cars in the garage");
            System.out.println("3. Replace engine for a car");
            System.out.println("4. Test a car");
            System.out.println("5. Leave the factory");

            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    System.out.print("Enter car name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter engine type:");
                    System.out.println("1. Gasoline");
                    System.out.println("2. Electronic");
                    System.out.println("3. Hybrid");
                    System.out.print("Enter choice (1-3): ");
                    String engineChoice = scanner.nextLine();
                    String engineType = getEngineType(engineChoice);
                    if (engineType != null) {
                        try {
                            CarFactory.createCar(name, engineType);
                            System.out.println("Car created!");
                        } catch (Exception e) {
                            System.out.println("Failed to create car: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid engine type.");
                    }
                    break;
                case "2":
                    if (CarFactory.hasCars()) {
                        CarFactory.viewCars();
                    } else {
                        System.out.println("There are no cars to view. How about making one!");
                    }
                    break;
                case "3":
                    if (CarFactory.hasCars()) {
                        CarFactory.viewCars();
                        System.out.print("Enter car index to replace engine: ");
                        int idx = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter new engine type:");
                        System.out.println("1. Gasoline");
                        System.out.println("2. Electronic");
                        System.out.println("3. Hybrid");
                        System.out.print("Enter choice (1-3): ");
                        String newEngineChoice = scanner.nextLine();
                        String newEngine = getEngineType(newEngineChoice);
                        if (newEngine != null) {
                            try {
                                CarFactory.replaceEngine(idx, newEngine);
                            } catch (Exception e) {
                                System.out.println("Failed to replace engine: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Invalid engine type.");
                        }
                    } else {
                        System.out.println("There are no cars to modify. How about making one!");
                    }
                    break;
                case "4":
                    if (CarFactory.hasCars()) {
                        CarFactory.viewCars();
                        System.out.print("Enter car index to test: ");
                        int testIdx = Integer.parseInt(scanner.nextLine());
                        if (testIdx >= 0 && testIdx < CarFactory.getAllCars().size()) {
                            runCarTest(CarFactory.getAllCars().get(testIdx), scanner);
                        } else {
                            System.out.println("Invalid car index.");
                        }
                    } else {
                        System.out.println("There are no cars to test. How about making one!");
                    }
                    break;
                case "5":
                    System.out.println("Let us see you again");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static String getEngineType(String choice) {
        switch (choice) {
            case "1":
                return "gasoline";
            case "2":
                return "electronic";
            case "3":
                return "hybrid";
            default:
                return null;
        }
    }

    private static void runCarTest(Car car, Scanner scanner) {
        boolean testRunning = true;
        boolean engineStarted = false;

        System.out.println("\n=== Testing Car: " + car.getCarName() + " ===");
        System.out.println("Engine Type: " + car.getEngineType());
        printTestStatus(car, engineStarted);

        while (testRunning) {
            System.out.println("\nTest Menu:");
            System.out.println("1. Start engine");
            System.out.println("2. Accelerate (+20 km/h)");
            System.out.println("3. Brake (-20 km/h)");
            System.out.println("4. Stop engine");
            System.out.println("5. Restart engine");
            System.out.println("6. Close test");
            System.out.print("Enter choice: ");

            String testChoice = scanner.nextLine();

            switch (testChoice) {
                case "1":
                    if (!engineStarted) {
                        car.start();
                        engineStarted = true;
                        printTestStatus(car, engineStarted);
                    } else {
                        System.out.println("Engine is already started");
                    }
                    break;
                case "2":
                    if (engineStarted) {
                        car.accelerate();
                        printTestStatus(car, engineStarted);
                    } else {
                        System.out.println("Start the engine first!");
                    }
                    break;
                case "3":
                    if (engineStarted) {
                        car.brake();
                        printTestStatus(car, engineStarted);
                    } else {
                        System.out.println("Start the engine first!");
                    }
                    break;
                case "4":
                    if (engineStarted) {
                        if (car.getSpeed() == 0) {
                            car.stop();
                            engineStarted = false;
                            printTestStatus(car, engineStarted);
                        } else {
                            System.out.println("Cannot stop engine! Speed must be 0 first. Brake to stop.");
                        }
                    } else {
                        System.out.println("Engine is already stopped.");
                    }
                    break;
                case "5":
                    if (!engineStarted) {
                        car.start();
                        engineStarted = true;
                        printTestStatus(car, engineStarted);
                    } else {
                        System.out.println("Engine is already running.");
                    }
                    break;
                case "6":
                    System.out.println("Test closed.");
                    testRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void printTestStatus(Car car, boolean engineStarted) {
        System.out.println("\n--- Current Status ---");
        System.out.println("Engine Status: " + (engineStarted ? "ON" : "OFF"));
        System.out.println("Current Speed: " + car.getSpeed() + " km/h");
        if (car.getEngineType().equals("HybridEngine")) {
            System.out.println("Active Engine: " + car.getActiveEngineName());
        }
        System.out.println("---");
    }
}
