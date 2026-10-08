// Parent Class (Superclass)
class Vehicle {
    protected String brand; // 'protected' allows access to subclasses
    protected int maxSpeed;

    public Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        System.out.println("Vehicle (Parent) constructor invoked.");
    }

    public void startEngine() {
        System.out.println(brand + ": Ignition on, system check complete.");
    }

    public void displayInfo() {
        System.out.printf("Brand: %s | Max Speed: %d km/h%n", brand, maxSpeed);
    }
}

// Child Class (Subclass) - Car IS-A Vehicle
class ElectricCar extends Vehicle {
    private int batteryCapacityKWh;

    public ElectricCar(String brand, int maxSpeed, int batteryCapacityKWh) {
        // Explicitly invokes the Vehicle(String, int) constructor
        // super(...) MUST be the first statement in the child constructor
        super(brand, maxSpeed);
        this.batteryCapacityKWh = batteryCapacityKWh;
        System.out.println("ElectricCar (Child) constructor invoked.");
    }

    // Overriding parent method to augment behavior
    @Override
    public void startEngine() {
        // super.startEngine(); // Can invoke parent logic if desired
        System.out.println(brand + ": High-voltage contactors closed silently (EV ready).");
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Reuses parent's display logic
        System.out.printf("Battery Capacity: %d kWh%n", batteryCapacityKWh);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        ElectricCar ev = new ElectricCar("Tesla", 250, 85);
        ev.startEngine();
        ev.displayInfo();
    }
}