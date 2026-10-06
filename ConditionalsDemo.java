public class ConditionalsDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. SIMPLE if STATEMENT
        // Executes the block only when the condition evaluates to true.
        // =====================================================================
        System.out.println("=== 1. SIMPLE IF ===");
        int age = 20;

        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        }


        // =====================================================================
        // 2. if-else STATEMENT
        // Executes block 1 if true; otherwise executes block 2.
        // =====================================================================
        System.out.println("\n=== 2. IF-ELSE ===");
        int number = 17;

        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }


        // =====================================================================
        // 3. if-else-if LADDER
        // Evaluates conditions sequentially from top to bottom.
        // Stops checking as soon as the first true branch executes.
        // =====================================================================
        System.out.println("\n=== 3. IF-ELSE-IF LADDER ===");
        int score = 85;

        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B"); // Matches here, executes, skips rest
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }


        // =====================================================================
        // 4. NESTED if STATEMENTS
        // An 'if' block nested inside another 'if' block.
        // Used when second check depends on the outcome of the first.
        // =====================================================================
        System.out.println("\n=== 4. NESTED IF ===");
        boolean hasPassport = true;
        boolean hasVisa = false;

        if (hasPassport) {
            System.out.println("Passport verified.");
            if (hasVisa) {
                System.out.println("Access granted: Allowed to travel.");
            } else {
                System.out.println("Access denied: Valid visa required.");
            }
        } else {
            System.out.println("Access denied: No passport found.");
        }


        // =====================================================================
        // 5. TERNARY OPERATOR (? :)
        // Shorthand for simple if-else expressions returning a value.
        // Syntax: (condition) ? value_if_true : value_if_false
        // =====================================================================
        System.out.println("\n=== 5. TERNARY OPERATOR ===");
        int accountBalance = 500;
        int withdrawalAmount = 200;

        String status = (accountBalance >= withdrawalAmount) 
                        ? "Transaction Approved" 
                        : "Insufficient Funds";
        System.out.println("Status: " + status);


        // =====================================================================
        // 6. CLASSIC switch STATEMENT
        // Matches an exact expression against discrete 'case' constants.
        // Supports: byte, short, char, int, String, and enum types.
        // 'break' is essential to prevent unintended fall-through.
        // =====================================================================
        System.out.println("\n=== 6. CLASSIC SWITCH STATEMENT ===");
        int dayOfWeek = 3;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday"); // Matches here
                break; // Exits switch block
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default: // Runs if no case matches
                System.out.println("Weekend");
                break;
        }

        // Classic switch intentional fall-through example:
        char gradeLevel = 'B';
        System.out.print("Evaluation: ");
        switch (gradeLevel) {
            case 'A':
            case 'B':
            case 'C':
                System.out.println("Passing Grade"); // Executed for A, B, or C
                break;
            case 'D':
            case 'F':
                System.out.println("Failing Grade");
                break;
            default:
                System.out.println("Invalid Grade");
        }


        // =====================================================================
        // 7. MODERN switch EXPRESSION (Java 14+)
        // Uses arrow syntax '->'.
        // Key benefits:
        // - Eliminates fall-through bugs (no 'break' needed).
        // - Can return values directly into a variable.
        // - Allows multiple labels per line (case "SAT", "SUN" -> ...).
        // =====================================================================
        System.out.println("\n=== 7. MODERN SWITCH EXPRESSION (ARROW SYNTAX) ===");
        String dayName = "WED";

        // Switch returning a value:
        String dayType = switch (dayName) {
            case "MON", "TUE", "WED", "THU", "FRI" -> "Weekday";
            case "SAT", "SUN" -> "Weekend";
            default -> "Unknown day";
        };
        System.out.println(dayName + " is a " + dayType);

        // Switch expression with a multi-line block using 'yield'
        int code = 2;
        String action = switch (code) {
            case 1 -> "Initialize";
            case 2 -> {
                System.out.println("Performing safety checks before running...");
                yield "Execute"; // 'yield' returns the value from a code block
            }
            default -> "Halt";
        };
        System.out.println("Action: " + action);
    }
}