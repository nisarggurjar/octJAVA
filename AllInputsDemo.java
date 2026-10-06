import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner; // required for inputs

public class AllInputsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Integer types
        System.out.print("Enter a byte (-128 to 127): ");
        byte byteVal = scanner.nextByte();

        System.out.print("Enter a short (-32768 to 32767): ");
        short shortVal = scanner.nextShort();

        System.out.print("Enter an int: ");
        int intVal = scanner.nextInt();

        System.out.print("Enter a long: ");
        long longVal = scanner.nextLong();

        // 2. Floating-point types
        System.out.print("Enter a float: ");
        float floatVal = scanner.nextFloat();

        System.out.print("Enter a double: ");
        double doubleVal = scanner.nextDouble();

        // 3. Boolean
        System.out.print("Enter a boolean (true/false): ");
        boolean boolVal = scanner.nextBoolean();

        // 4. Single Word (token)
        System.out.print("Enter a single word: ");
        String singleWord = scanner.next();

        // 5. Character (Scanner has no nextChar(), grab first char of next token)
        System.out.print("Enter a single character: ");
        char charVal = scanner.next().charAt(0);

        // --- CRITICAL STEP ---
        // Consume the leftover newline character before reading a full sentence
        scanner.nextLine();

        // 6. Full Line of Text (including spaces)
        System.out.print("Enter a full sentence: ");
        String fullLine = scanner.nextLine();

        // 7. Arbitrary precision / Big numbers
        System.out.print("Enter a BigInteger: ");
        BigInteger bigIntVal = scanner.nextBigInteger();

        System.out.print("Enter a BigDecimal: ");
        BigDecimal bigDecVal = scanner.nextBigDecimal();

        // Display all collected inputs
        System.out.println("\n--- Summary of Inputs Received ---");
        System.out.printf("byte:        %d%n", byteVal);
        System.out.printf("short:       %d%n", shortVal);
        System.out.printf("int:         %d%n", intVal);
        System.out.printf("long:        %d%n", longVal);
        System.out.printf("float:       %f%n", floatVal);
        System.out.printf("double:      %f%n", doubleVal);
        System.out.printf("boolean:     %b%n", boolVal);
        System.out.printf("single word: %s%n", singleWord);
        System.out.printf("char:        %c%n", charVal);
        System.out.printf("full line:   %s%n", fullLine);
        System.out.printf("BigInteger:  %s%n", bigIntVal);
        System.out.printf("BigDecimal:  %s%n", bigDecVal);

        scanner.close();
    }
}