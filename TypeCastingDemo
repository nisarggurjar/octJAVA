public class TypeCastingDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. WIDENING (IMPLICIT) CASTING
        // Direction: byte -> short -> int -> long -> float -> double
        // Also:      char -> int
        // No explicit syntax needed; completely safe from overflow.
        // =====================================================================
        System.out.println("=== 1. WIDENING (IMPLICIT) CASTING ===");

        byte byteVal = 42;
        
        // byte automatically widens to short
        short shortVal = byteVal; 
        
        // short automatically widens to int
        int intVal = shortVal; 
        
        // int automatically widens to long
        long longVal = intVal; 
        
        // long automatically widens to float
        float floatVal = longVal; 
        
        // float automatically widens to double
        double doubleVal = floatVal; 

        System.out.printf("byte: %d -> short: %d -> int: %d -> long: %d -> float: %.1f -> double: %.1f%n",
                byteVal, shortVal, intVal, longVal, floatVal, doubleVal);

        // Char to int widening: maps character to its ASCII/Unicode numeric code
        char letter = 'A';
        int asciiValue = letter; // 'A' has ASCII code 65
        System.out.printf("char '%c' widened to int: %d%n%n", letter, asciiValue);


        // =====================================================================
        // 2. NARROWING (EXPLICIT) CASTING
        // Direction: double -> float -> long -> int -> short -> byte
        // Also:      int -> char
        // Requires manual cast operator: (type) value
        // Can cause truncation (discarding decimals) and overflow/wrap-around.
        // =====================================================================
        System.out.println("=== 2. NARROWING (EXPLICIT) CASTING ===");

        // A. Truncation: double to int (chops off decimals, does not round)
        double pi = 3.999;
        int truncatedPi = (int) pi; 
        System.out.printf("double: %.3f explicitly cast to int: %d (decimal chopped off)%n", pi, truncatedPi);

        // B. float to long
        float balance = 1250.75f;
        long wholeBalance = (long) balance;
        System.out.printf("float: %.2f cast to long: %d%n", balance, wholeBalance);

        // C. int to char (maps numeric ASCII back to character symbol)
        int code = 66;
        char characterB = (char) code;
        System.out.printf("int: %d cast to char: '%c'%n", code, characterB);

        // D. int to short and byte (within valid range)
        int smallInt = 100;
        short smallShort = (short) smallInt;
        byte smallByte = (byte) smallShort;
        System.out.printf("int: %d cast safely to byte: %d%n%n", smallInt, smallByte);


        // =====================================================================
        // 3. OVERFLOW & UNDERFLOW DURING NARROWING (WRAP-AROUND)
        // What happens when the value exceeds the target type's capacity?
        // =====================================================================
        System.out.println("=== 3. OVERFLOW & WRAP-AROUND BEHAVIOR ===");

        // byte range is -128 to 127
        int largeNumber = 130; 
        
        // 130 does not fit into a byte.
        // In binary (32-bit int): 00000000 00000000 00000000 10000010
        // Narrowing keeps only lowest 8 bits: 10000010
        // In 2's complement signed byte, 10000010 = -126
        byte overflowedByte = (byte) largeNumber;
        System.out.printf("int 130 cast to byte: %d (wrapped around)%n", overflowedByte);

        int hugeNumber = 300;
        // 300 % 256 = 44
        byte wrappedAgain = (byte) hugeNumber;
        System.out.printf("int 300 cast to byte: %d%n%n", wrappedAgain);


        // =====================================================================
        // 4. AUTOMATIC TYPE PROMOTION IN EXPRESSIONS
        // All byte, short, and char values are automatically promoted to int
        // when evaluated in arithmetic expressions (+, -, *, /).
        // =====================================================================
        System.out.println("=== 4. TYPE PROMOTION IN EXPRESSIONS ===");

        byte b1 = 40;
        byte b2 = 50;

        // byte sum = b1 + b2; // COMPILE ERROR: (b1 + b2) automatically evaluates to 'int'
        byte sum = (byte) (b1 + b2); // Must explicitly cast the resulting int back to byte
        System.out.printf("byte arithmetic cast back to byte: %d%n", sum);

        // Mixed arithmetic promotes everything to the largest type in the expression
        int count = 10;
        double rate = 2.5;
        // count is promoted to double, yielding double
        double total = count * rate; 
        System.out.printf("int * double promotes to double: %.2f%n", total);
    }
}

/*
The automatic widening path follows this hierarchy:

byte --> short --> int --> long --> float --> double 

                    char--^

                    Moving left-to-right: Implicit / Widening (No data lost, no cast syntax needed).
Moving right-to-left: Explicit / Narrowing (Requires (type) syntax; watch out for truncation and overflow).
*/