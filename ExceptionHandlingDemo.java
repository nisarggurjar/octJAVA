import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// =============================================================================
// 1. CUSTOM EXCEPTION DEFINITION
// - Unchecked Exception: extends RuntimeException (compiler doesn't force handling)
// - Checked Exception:   extends Exception (compiler enforces try-catch or throws)
// =============================================================================
class InsufficientFundsException extends Exception {
    private final double deficit;

    public InsufficientFundsException(String message, double deficit) {
        super(message); // Passes description to parent Exception class
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}

public class ExceptionHandlingDemo {

    // =========================================================================
    // 2. 'throws' VS 'throw'
    // - 'throws' (in signature): Warns callers that this method may emit checked exceptions.
    // - 'throw'  (in body):      Explicitly triggers/fires the exception object.
    // =========================================================================
    public static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double shortfall = amount - balance;
            // Throwing our custom checked exception
            throw new InsufficientFundsException("Withdrawal rejected: account short on funds", shortfall);
        }
        System.out.printf("Successfully withdrawn $%.2f%n", amount);
    }

    public static void main(String[] args) {

        // =====================================================================
        // 3. BASIC try-catch-finally FLOW
        // - try:     Encloses risky code that could throw an exception.
        // - catch:   Intercepts and handles specific exception instances.
        // - finally: Always executes (cleanups), whether an error occurred or not.
        // =====================================================================
        System.out.println("=== 1. Basic try-catch-finally ===");
        try {
            int dividend = 50;
            int divisor = 0; // Triggers ArithmeticException
            int result = dividend / divisor;
            System.out.println("Result: " + result); // Skipped
        } catch (ArithmeticException ex) {
            System.err.println("Caught ArithmeticException: " + ex.getMessage());
        } finally {
            System.out.println("Finally block: Always runs for cleanup tasks.");
        }


        // =====================================================================
        // 4. MULTIPLE CATCH BLOCKS & MULTI-CATCH SYNTAX
        // Rule: Subclasses must come BEFORE superclasses (e.g., NumberFormatException before Exception).
        // Java 7+ allows pipe '|' syntax for distinct exceptions handled identically.
        // =====================================================================
        System.out.println("\n=== 2. Multi-catch & Ordering ===");
        String rawInput = "abc";
        int[] numbers = {10, 20, 30};

        try {
            // int parsed = Integer.parseInt(rawInput); // Throws NumberFormatException
            int element = numbers[5];                 // Throws ArrayIndexOutOfBoundsException
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            // Pipes allow combining sibling exceptions cleanly
            System.err.println("Data error encountered: " + ex.getClass().getSimpleName() + " -> " + ex.getMessage());
        } catch (Exception ex) {
            // Generalized fallback catch must always be placed at the bottom
            System.err.println("Fallback generic handler: " + ex.getMessage());
        }


        // =====================================================================
        // 5. HANDLING CUSTOM CHECKED EXCEPTIONS
        // =====================================================================
        System.out.println("\n=== 3. Custom Checked Exception Handling ===");
        try {
            withdraw(100.00, 250.00);
        } catch (InsufficientFundsException ex) {
            System.err.println("Transaction Failed: " + ex.getMessage());
            System.err.printf("Shortfall amount: $%.2f%n", ex.getDeficit());
        }


        // =====================================================================
        // 6. MODERN TRY-WITH-RESOURCES (AutoCloseable)
        // Java 7+ feature: Any object implementing java.lang.AutoCloseable
        // declared inside try(...) is closed automatically at block exit.
        // Eliminates messy manual .close() calls in finally blocks.
        // =====================================================================
        System.out.println("\n=== 4. Try-With-Resources ===");
        // Even if an IOException happens or the block finishes normally,
        // reader.close() is guaranteed to execute silently.
        try (BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"))) {
            String firstLine = reader.readLine();
            System.out.println("File content: " + firstLine);
        } catch (IOException ex) {
            System.err.println("File read failed (AutoClosed cleanly): " + ex.getMessage());
        }


        // =====================================================================
        // 7. FINALLY EXECUTION EDGE CASE
        // 'finally' executes even if 'try' or 'catch' contains a 'return' statement!
        // The ONLY condition finally skips is System.exit() or JVM crash.
        // =====================================================================
        System.out.println("\n=== 5. Finally vs Return ===");
        System.out.println("Method returned: " + testFinallyReturn());
    }

    public static int testFinallyReturn() {
        try {
            return 10; // Sets up return value 10
        } finally {
            System.out.println("Finally runs BEFORE the method actually hands back control to caller!");
        }
    }
}