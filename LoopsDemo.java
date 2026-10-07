import java.util.List;

public class LoopsDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. STANDARD for LOOP
        // Best when the number of iterations is known in advance.
        // Structure: for (initialization; condition; update)
        // =====================================================================
        System.out.println("=== 1. STANDARD FOR LOOP ===");
        
        // Count from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Multiple variables in initialization and update:
        for (int i = 0, j = 10; i < j; i++, j -= 2) {
            System.out.printf("i: %d, j: %d | ", i, j);
        }
        System.out.println();


        // =====================================================================
        // 2. ENHANCED for-each LOOP
        // Introduced in Java 5. Best for traversing arrays and Iterable collections.
        // Eliminates index off-by-one errors; read-only traversal.
        // =====================================================================
        System.out.println("\n=== 2. ENHANCED FOR-EACH LOOP ===");
        
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        List<Integer> numbers = List.of(10, 20, 30);
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }


        // =====================================================================
        // 3. while LOOP (Entry-Controlled)
        // Best when the number of iterations depends on an external condition.
        // Checks condition BEFORE executing the loop body.
        // If the initial condition is false, the body never runs.
        // =====================================================================
        System.out.println("\n=== 3. WHILE LOOP ===");
        
        int count = 1;
        while (count <= 4) {
            System.out.println("Count is: " + count);
            count++; // Without this update, this becomes an infinite loop!
        }


        // =====================================================================
        // 4. do-while LOOP (Exit-Controlled)
        // Checks condition AFTER running the loop body.
        // GUARANTEED to execute at least once, even if condition is false.
        // Common use-cases: Menu prompts, retry logic.
        // =====================================================================
        System.out.println("\n=== 4. DO-WHILE LOOP ===");
        
        int flag = 10;
        do {
            // Runs once even though (10 < 5) evaluates to false immediately
            System.out.println("Executed once despite condition being false (flag = " + flag + ")");
            flag++;
        } while (flag < 5);


        // =====================================================================
        // 5. LOOP CONTROL STATEMENTS: break AND continue
        // break    -> Terminates the nearest enclosing loop immediately.
        // continue -> Skips remaining code in current pass, jumps to next iteration.
        // =====================================================================
        System.out.println("\n=== 5. BREAK AND CONTINUE ===");
        
        for (int i = 1; i <= 6; i++) {
            if (i == 2) {
                System.out.println("Skipping 2 using continue");
                continue; // Skips printing 2, moves directly to i = 3
            }
            if (i == 5) {
                System.out.println("Stopping loop at 5 using break");
                break; // Exits the loop entirely
            }
            System.out.println("Current value: " + i);
        }


        // =====================================================================
        // 6. LABELED LOOPS (Breaking/Continuing Nested Loops)
        // In nested loops, a plain 'break' only terminates the innermost loop.
        // A labeled break exits whichever outer loop matches the label.
        // =====================================================================
        System.out.println("\n=== 6. LABELED BREAK IN NESTED LOOPS ===");
        
        outerLoop: // Label
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                if (row == 2 && col == 2) {
                    System.out.println("Target (2,2) found! Breaking entire outerLoop...");
                    break outerLoop; // Exits both loops directly
                }
                System.out.printf("Cell [%d, %d]%n", row, col);
            }
        }
    }
}