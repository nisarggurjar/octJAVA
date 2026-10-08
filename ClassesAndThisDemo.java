// Blueprint (Class)
class Car {
    // Instance variables / Fields (Unique to each object in the heap)
    private String model;
    private int speed;
    private String color;

    // =========================================================================
    // 1. DEFAULT / NO-ARG CONSTRUCTOR (Demonstrating this(...) chaining)
    // =========================================================================
    public Car() {
        // Calls the 3-argument constructor below with default fallback values.
        // Rule: this(...) MUST be the first statement in the constructor.
        this("Base Model", 0, "White");
        System.out.println("Default constructor executed via chaining.");
    }

    // =========================================================================
    // 2. PARAMETERIZED CONSTRUCTOR (Resolving variable shadowing)
    // =========================================================================
    public Car(String model, int speed, String color) {
        // 'model' alone refers to the local argument parameter.
        // 'this.model' refers to the instance field of the current object.
        this.model = model;
        this.speed = speed;
        this.color = color;
    }

    // =========================================================================
    // 3. INSTANCE METHODS (Operating on the specific object)
    // =========================================================================
    public void accelerate(int increment) {
        // Here, 'this' refers to whichever Car called accelerate()
        this.speed += increment;
        System.out.printf("%s is now going %d km/h%n", this.model, this.speed);
    }

    // =========================================================================
    // 4. RETURNING 'this' (Enables Method Chaining / Fluent API)
    // =========================================================================
    public Car repaint(String newColor) {
        this.color = newColor;
        // Returns the current object instance back to the caller
        return this; 
    }

    public void displaySpecs() {
        System.out.printf("Specs -> Model: %-12s | Speed: %3d km/h | Color: %s%n",
                this.model, this.speed, this.color);
    }
}

public class ClassesAndThisDemo {
    public static void main(String[] args) {

        // =====================================================================
        // CREATING OBJECTS (INSTANTIATION)
        // 'car1' and 'car2' are reference variables stored on the stack.
        // 'new Car(...)' allocates memory for the actual Car object on the heap.
        // =====================================================================
        System.out.println("=== 1. Instantiating Objects ===");

        // Object 1: created using the full parameterized constructor
        Car car1 = new Car("Mustang", 60, "Red");

        // Object 2: created using the chained default constructor
        Car car2 = new Car();

        // Print initial states
        car1.displaySpecs();
        car2.displaySpecs();


        // =====================================================================
        // 2. INDEPENDENT OBJECT STATES
        // Modifying car1 does NOT affect car2 because they reside at different
        // heap memory addresses.
        // =====================================================================
        System.out.println("\n=== 2. State Isolation ===");
        
        car1.accelerate(40); // Inside accelerate(), 'this' points to car1
        car2.accelerate(15); // Inside accelerate(), 'this' points to car2

        System.out.println("\nState after acceleration:");
        car1.displaySpecs();
        car2.displaySpecs();


        // =====================================================================
        // 3. METHOD CHAINING VIA RETURNING 'this'
        // =====================================================================
        System.out.println("\n=== 3. Method Chaining with 'this' ===");

        // repaint() returns the 'car2' reference, allowing immediate chaining
        car2.repaint("Matte Black").accelerate(30);
        car2.displaySpecs();


        // =====================================================================
        // 4. REFERENCE COMPARISON VS OBJECTS
        // =====================================================================
        System.out.println("\n=== 4. Reference Semantics ===");

        Car car3 = car1; // car3 copies the reference address of car1
        
        System.out.println("car1 == car2 (different objects): " + (car1 == car2)); // false
        System.out.println("car1 == car3 (same heap address) : " + (car1 == car3)); // true

        // Mutating car3 alters car1 because both references point to the exact same object
        car3.repaint("Neon Blue");
        System.out.print("car1 specs after modifying car3: ");
        car1.displaySpecs();
    }
}