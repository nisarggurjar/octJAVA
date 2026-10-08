class MathOperations {
    // 1. Base method: two ints
    public int multiply(int a, int b) {
        return a * b;
    }

    // 2. Overloaded by parameter count: three ints
    public int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // 3. Overloaded by parameter data type: two doubles
    public double multiply(double a, double b) {
        return a * b;
    }
}

public class CompileTimePolymorphismDemo {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        // Compiler selects the exact method at compilation time via arguments passed
        System.out.println("2 ints    : " + math.multiply(4, 5));
        System.out.println("3 ints    : " + math.multiply(2, 3, 4));
        System.out.println("2 doubles : " + math.multiply(2.5, 4.0));
    }
}