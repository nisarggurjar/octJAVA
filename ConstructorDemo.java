class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // 1. Fully-parameterized Master Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        System.out.println("Master constructor executed.");
    }

    // 2. Overloaded Constructor (chains to master using default salary)
    public Employee(int id, String name, String department) {
        // this(...) delegates initialization to the 4-arg constructor
        // MUST be the very first statement
        this(id, name, department, 50000.0);
    }

    // 3. Overloaded Constructor (chains using default department and salary)
    public Employee(int id, String name) {
        this(id, name, "General");
    }

    // 4. No-arg / Default Constructor
    public Employee() {
        this(0, "Unassigned", "Probation", 30000.0);
    }

    public void display() {
        System.out.printf("ID: %-3d | Name: %-12s | Dept: %-10s | Salary: $%.2f%n",
                id, name, department, salary);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        System.out.println("--- Creating e1 (No-arg) ---");
        Employee e1 = new Employee();

        System.out.println("\n--- Creating e2 (2 parameters) ---");
        Employee e2 = new Employee(101, "Aarav");

        System.out.println("\n--- Creating e3 (Full parameters) ---");
        Employee e3 = new Employee(102, "Nikita", "Engineering", 95000.0);

        System.out.println("\n--- Final Employee Records ---");
        e1.display();
        e2.display();
        e3.display();
    }
}