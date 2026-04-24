# Quantum Car Factory System – Technical Documentation
---

## 1. Summary
The **Quantum Car Factory** is a Java-based Object-Oriented application designed to simulate the lifecycle of vehicle manufacturing and operation within a controlled environment. The system facilitates the creation of vehicles with interchangeable powertrain configurations (Gasoline, Electronic, Hybrid) and manages their operational states through a centralized factory manager.

This documentation outlines the architectural structure, component responsibilities, operational logic, and usage protocols for the software suite.

---

## 2. System Architecture
The application follows a modular architecture based on **Composition over Inheritance** principles. The core relationship exists between the `Car` class (the aggregate) and the `Engine` interface (the dependency).

### 2.1 High-Level Structure
*   **Interface Layer:** Defines the contract for engine behavior (`Engine`).
*   **Concrete Implementation Layer:** Specific powertrain implementations (`GasolineEngine`, `ElectronicEngine`, `HybridEngine`).
*   **Domain Layer:** The vehicle entity (`Car`) which encapsulates state and behavior.
*   **Manager Layer:** The factory mechanism (`CarFactory`) responsible for persistence and lifecycle management.
*   **Presentation Layer:** The command-line interface entry point (`Main`).

---

## 3. Component Specification

### 3.1 `Engine` Interface
**Purpose:** Defines the standard contract for all powertrain units to ensure polymorphic behavior within the `Car` class.  
**Key Methods:**
*   `increase()`: Increments internal engine speed by 1 unit.
*   `decrease()`: Decrements internal engine speed by 1 unit (min 0).
*   `setSpeed(int)`: Synchronizes internal state with external velocity commands.
*   `getActiveEngineName()`: Returns the specific active sub-engine in composite types.

### 3.2 Concrete Engine Implementations
| Class | Description | Logic Constraints |
| :--- | :--- | :--- |
| **`GasolineEngine`** | Standard internal combustion unit. | Direct speed mapping; no conditional logic. |
| **`ElectronicEngine`** | Pure electric motor unit. | Direct speed mapping; instant response. |
| **`HybridEngine`** | Composite unit containing both Gas and Electric engines. | **Switch Logic:** Operates on Electric mode below 50 km/h. Switches to Gas mode at or above 50 km/h. Optimizes cost by avoiding simultaneous operation. |

### 3.3 `Car` Class
**Purpose:** Represents the vehicle entity, managing velocity limits and engine synchronization.  
**Key Attributes:**
*   `carName`: Unique identifier for the vehicle instance.
*   `engine`: Reference to an `Engine` interface implementation.
*   `carSpeed`: Current velocity (0–200 km/h).

**Key Methods:**
*   `start()`: Initializes speed at 0 and activates engine state.
*   `stop()`: Deactivates engine and resets speed to 0.
*   `accelerate()`: Increases speed by **20 km/h** increments (Max: 200).
*   `brake()`: Decreases speed by **20 km/h** decrements (Min: 0).
*   `setEngine(Engine)`: Allows runtime engine replacement.

### 3.4 `CarFactory` Class
**Purpose:** Static manager for the vehicle garage. Handles creation, storage, and modification of car instances.  
**Key Features:**
*   **Static Storage:** Maintains a static `List<Car>` (`allCars`) to persist state across method calls within the session.
*   **Creation:** Instantiates cars based on string identifiers ("gasoline", "electronic", "hybrid").
*   **Replacement:** Allows swapping the engine of an existing car without recreating the vehicle object.

### 3.5 `Main` Class
**Purpose:** Application entry point providing a CLI menu system for user interaction.  
**Workflow:**
1.  Displays menu options (Create, View, Replace, Test, Exit).
2.  Parses user input via `Scanner`.
3.  Invokes corresponding factory or car methods based on selection.

---

## 4. Operational Logic & State Synchronization

### 4.1 Speed Synchronization Protocol
The system maintains two distinct speed metrics that must remain synchronized:
1.  **Car Velocity:** Controlled by the `Car` class (Steps of 20 km/h).
2.  **Engine Internal RPM/Load:** Controlled by the `Engine` interface methods (Steps of 1 km/h).

**Synchronization Flow:**
When a speed change occurs in the `Car`:
1.  The `Car` calculates new velocity.
2.  The `Car` calls `engine.setSpeed(carSpeed)`.
3.  The specific engine implementation updates its internal state to match the car's velocity.

### 4.2 Hybrid Engine Optimization Logic
The `HybridEngine` implements a conditional strategy based on vehicle velocity:
*   **Condition A (Velocity < 50 km/h):**
    *   Active Component: `ElectronicEngine`.
    *   Action: Calls `electric.increase()` or `decrease()`. Gas engine is reset to 0.
*   **Condition B (Velocity ≥ 50 km/h):**
    *   Active Component: `GasolineEngine`.
    *   Action: Calls `gas.increase()` or `decrease()`. Electric engine is reset to 0.

This ensures cost optimization by preventing simultaneous fuel and battery consumption during operation.

---

## 5. Usage Guide

### 5.1 Compilation & Execution
Ensure all `.java` files are in the same directory structure. Compile using:
```bash
javac *.java
```
Run the application using:
```bash
java Main
```

### 5.2 Workflow Example
1.  **Initialization:** Select Option `1` (Make a new car). Enter name and engine type (e.g., "Hybrid").
2.  **Verification:** Select Option `2` (View cars) to confirm the vehicle is in the garage list.
3.  **Operation:** Select Option `4` (Test a car).
    *   Choose Index `0`.
    *   Execute `Start engine`.
    *   Execute `Accelerate` until speed exceeds 50 km/h.
    *   Observe console output for "Active Engine" status change in the Hybrid test view.
4.  **Modification:** Select Option `3` (Replace engine). Change a car's engine from Gasoline to Electronic.

---

## 6. Design Patterns & Principles

| Pattern | Implementation Detail | Benefit |
| :--- | :--- | :--- |
| **Interface Segregation** | `Engine` interface defines only necessary methods (`increase`, `decrease`). | Decouples Car logic from specific engine implementations. |
| **Factory Method** | `CarFactory.createCar()` encapsulates instantiation logic. | Centralizes object creation and reduces coupling in `Main`. |
| **Polymorphism** | `Car` holds an `Engine` reference but interacts with concrete subclasses. | Allows runtime flexibility (swapping engines without Car code changes). |
| **Encapsulation** | Private fields (`carSpeed`, `engine`) accessed via public getters/setters. | Protects internal state integrity. |

---

## 7. Constraints & Assumptions
1.  **Memory Management:** The system uses a static list for cars; memory is not cleared between sessions unless the JVM restarts.
2.  **Input Validation:** Basic validation exists (e.g., speed limits), but robust exception handling relies on `try-catch` blocks in the `Main` class.
3.  **Engine Logic:** Internal engine mechanics are abstracted; only speed synchronization is tracked, not fuel consumption or battery levels explicitly.

---
