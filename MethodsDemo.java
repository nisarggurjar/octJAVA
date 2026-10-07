import java.util.Arrays;

public class MethodsDemo {

    // =========================================================================
    // 1. INSTANCE METHOD (Void & Parameterized)
    // Bound to a specific instance; can access instance fields (if any).
    // =========================================================================
    public void printWelcome(String username) {
        System.out.println("Hello, " + username + "! Welcome to Java methods.");
    }

    // =========================================================================
    // 2. STATIC METHOD (Value-Returning)
    // Belongs to the class itself. Invoked without creating an object.
    // =========================================================================
    public static int calculateSquare(int number) {
        return number * number; // 'return' passes the value back to the caller
    }

    // =========================================================================
    // 3. METHOD OVERLOADING (Compile-Time Polymorphism)
    // Same method name, different signatures (parameter type or count).
    // Return type alone cannot distinguish overloaded methods!
    // =========================================================================
    public static int add(int a, int b) {
        return a + b;
    }

    // Overloaded by type (doubles instead of ints)
    public static double add(double a, double b) {
        return a + b;
    }

    // Overloaded by parameter count (3 ints instead of 2)
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // =========================================================================
    // 4. VARIABLE ARGUMENTS (Varargs - Type... name)
    // Allows 0 or more arguments to be passed as an array.
    // Rules:
    // - Only ONE varargs parameter is permitted per method.
    // - The varargs parameter MUST be the last parameter in the argument list.
    // =========================================================================
    public static int sumAll(int... values) {
        int total = 0;
        for (int v : values) {
            total += v;
        }
        return total;
    }

    // =========================================================================
    // 5. RECURSIVE METHOD
    // A method that calls itself until reaching a base condition.
    // =========================================================================
    public static long factorial(int n) {
        // Base case: prevents infinite recursion and StackOverflowError
        if (n <= 1) {
            return 1;
        }
        // Recursive step: n * (n - 1)!
        return n * factorial(n - 1);
    }

    // =========================================================================
    // 6. PASS-BY-VALUE DEMONSTRATION
    // Java is strictly PASS-BY-VALUE:
    // - For primitives: A copy of the actual value is passed.
    // - For objects: A copy of the memory reference address is passed.
    // =========================================================================
    public static void modifyPrimitive(int val) {
        val = 999; // Changes local copy only; caller's variable remains unchanged
    }

    public static void modifyArray(int[] arr) {
        arr[0] = 999; // Mutates the underlying object data via the copied reference
    }

    public static void reassignReference(int[] arr) {
        arr = new int[]{100, 200}; // Reassigning reference does NOT affect the caller
    }


    // =========================================================================
    // MAIN METHOD: Execution entry point
    // =========================================================================
    public static void main(String[] args) {

        // --- Testing Instance Method ---
        System.out.println("=== 1. INSTANCE METHOD ===");
        // Must instantiate the class first
        MethodsDemo demo = new MethodsDemo();
        demo.printWelcome("Nisarg");

        // --- Testing Static Method ---
        System.out.println("\n=== 2. STATIC METHOD ===");
        // Called directly using the class name (or directly inside same class)
        int square = MethodsDemo.calculateSquare(7);
        System.out.println("Square of 7: " + square);

        // --- Testing Method Overloading ---
        System.out.println("\n=== 3. METHOD OVERLOADING ===");
        System.out.println("add(10, 20)        : " + add(10, 20));          // Calls int version
        System.out.println("add(4.5, 2.5)      : " + add(4.5, 2.5));        // Calls double version
        System.out.println("add(1, 2, 3)       : " + add(1, 2, 3));         // Calls 3-int version

        // --- Testing Varargs ---
        System.out.println("\n=== 4. VARARGS METHOD ===");
        System.out.println("sumAll()           : " + sumAll());             // 0 arguments -> 0
        System.out.println("sumAll(10, 20)     : " + sumAll(10, 20));       // 2 arguments -> 30
        System.out.println("sumAll(5, 5, 5, 5) : " + sumAll(5, 5, 5, 5));   // 4 arguments -> 20

        // --- Testing Recursion ---
        System.out.println("\n=== 5. RECURSION ===");
        System.out.println("Factorial of 5 (5!): " + factorial(5));         // 120

        // --- Testing Pass-By-Value Mechanics ---
        System.out.println("\n=== 6. PASS-BY-VALUE BEHAVIOR ===");

        // A. Primitive test
        int originalNumber = 50;
        modifyPrimitive(originalNumber);
        System.out.println("Original primitive after method: " + originalNumber); // Still 50

        // B. Object mutation test
        int[] scores = {10, 20, 30};
        modifyArray(scores);
        System.out.println("Array after element mutation   : " + Arrays.toString(scores)); // [999, 20, 30]

        // C. Reference reassignment test
        reassignReference(scores);
        System.out.println("Array after reference reassign : " + Arrays.toString(scores)); // Still [999, 20, 30]
    }
}