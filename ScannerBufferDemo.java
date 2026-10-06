import java.util.Scanner;

public class ScannerBufferDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // =====================================================================
        // PART 1: THE PROBLEM (Skipping Input)
        // =====================================================================
        System.out.println("=== 1. Demonstrating The Problem ===");
        System.out.print("Enter your age: ");

        // User types: 25 and presses [ENTER]
        // Buffer now contains: ['2', '5', '\n']
        int problemAge = scanner.nextInt(); 

        // nextInt() only reads the digits "25".
        // It stops before '\n'.
        // Remaining in buffer: ['\n']

        System.out.print("Enter your full name: ");
        // nextLine() searches for the next newline character.
        // It instantly finds the leftover '\n' sitting in the buffer!
        // It consumes that '\n' and returns an empty string (""), 
        // appearing to "skip" asking the user for their name.
        String problemName = scanner.nextLine(); 

        System.out.printf("Results -> Age: %d, Name: \"%s\" (Notice: Name is empty!)%n%n", 
                          problemAge, problemName);


        // =====================================================================
        // PART 2: SOLUTION A (The Throwaway nextLine() Flush)
        // =====================================================================
        System.out.println("=== 2. Solution A: Clearing the Buffer with scanner.nextLine() ===");
        System.out.print("Enter your age again: ");

        // User types: 30 and presses [ENTER]
        // Buffer: ['3', '0', '\n']
        int solvedAge = scanner.nextInt(); 
        // Buffer remaining: ['\n']

        // THE FIX: Consume the orphaned newline character
        scanner.nextLine(); 
        // Buffer is now clean: []

        System.out.print("Enter your full name: ");
        // Now nextLine() actually waits for fresh user input
        String solvedName = scanner.nextLine(); 

        System.out.printf("Results -> Age: %d, Name: \"%s\"%n%n", solvedAge, solvedName);


        // =====================================================================
        // PART 3: SOLUTION B (The Robust Industry Pattern: Integer.parseInt)
        // =====================================================================
        System.out.println("=== 3. Solution B: Read everything as lines, then parse ===");
        System.out.print("Enter your age once more: ");

        // Read the entire line (digits + newline) so nothing is ever left behind,
        // then convert the String to an int.
        int parsedAge = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter your full name: ");
        String parsedName = scanner.nextLine();

        System.out.printf("Results -> Age: %d, Name: \"%s\"%n", parsedAge, parsedName);

        scanner.close();
    }
}