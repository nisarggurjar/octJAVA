public class AllOperatorsDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. ARITHMETIC OPERATORS (+, -, *, /, %)
        // =====================================================================
        System.out.println("=== 1. ARITHMETIC OPERATORS ===");
        int a = 15;
        int b = 4;

        System.out.println("a + b = " + (a + b)); // Addition: 19
        System.out.println("a - b = " + (a - b)); // Subtraction: 11
        System.out.println("a * b = " + (a * b)); // Multiplication: 60
        
        // Integer division truncates the decimal portion (15 / 4 = 3)
        System.out.println("a / b = " + (a / b)); // Division: 3
        System.out.println("a / b = " + ((double )a / b)); // Division: 3
        
        // Modulo yields the remainder after integer division (15 % 4 = 3)
        System.out.println("a % b = " + (a % b)); // Modulo: 3

        // String concatenation with '+'
        System.out.println("Hello " + "World!"); // "Hello World!"


        // =====================================================================
        // 2. UNARY OPERATORS (+, -, ++, --, !)
        // =====================================================================
        System.out.println("\n=== 2. UNARY OPERATORS ===");
        int count = 10;
        boolean flag = false;

        System.out.println("+count  : " + (+count)); // Unary plus: 10
        System.out.println("-count  : " + (-count)); // Unary minus (negation): -10
        System.out.println("!flag   : " + (!flag));   // Logical NOT: inverts false to true

        // Prefix vs Postfix Increment/Decrement:
        int x = 5;
        // Postfix (++ after variable): Uses current value first, then increments
        System.out.println("x++     : " + (x++)); // Prints 5, then x becomes 6
        System.out.println("After x++: " + x);    // Prints 6

        // Prefix (++ before variable): Increments first, then returns new value
        System.out.println("++x     : " + (++x)); // Increments to 7, prints 7

        // Decrement works identically
        System.out.println("x--     : " + (x--)); // Prints 7, then x becomes 6
        System.out.println("--x     : " + (--x)); // Decrements to 5, prints 5


        // =====================================================================
        // 3. RELATIONAL / COMPARISON OPERATORS (==, !=, >, <, >=, <=)
        // Evaluates to a boolean (true / false)
        // =====================================================================
        System.out.println("\n=== 3. RELATIONAL OPERATORS ===");
        int num1 = 20;
        int num2 = 30;

        System.out.println("num1 == num2 : " + (num1 == num2)); // Equal to: false
        System.out.println("num1 != num2 : " + (num1 != num2)); // Not equal to: true
        System.out.println("num1 > num2  : " + (num1 > num2));  // Greater than: false
        System.out.println("num1 < num2  : " + (num1 < num2));  // Less than: true
        System.out.println("num1 >= num2 : " + (num1 >= num2)); // Greater than or equal to: false
        System.out.println("num1 <= num2 : " + (num1 <= num2)); // Less than or equal to: true


        // =====================================================================
        // 4. LOGICAL OPERATORS (&&, ||, !) vs BITWISE LOGICAL (&, |)
        // Short-circuiting behavior
        // =====================================================================
        System.out.println("\n=== 4. LOGICAL OPERATORS ===");
        boolean p = true;
        boolean q = false;

        // Logical AND (&&): Short-circuits. If left is false, right is never evaluated.
        System.out.println("p && q : " + (p && q)); // false

        // Logical OR (||): Short-circuits. If left is true, right is never evaluated.
        System.out.println("p || q : " + (p || q)); // true

        // Non-short-circuit bitwise boolean operators evaluate both sides unconditionally:
        int check = 0;
        boolean testShortCircuit = (false && (++check > 0)); 
        System.out.println("Short-circuit check: " + check); // check is still 0

        boolean testComplete = (false & (++check > 0)); 
        System.out.println("Non-short-circuit check: " + check); // check is incremented to 1


        // =====================================================================
        // 5. BITWISE & BIT-SHIFT OPERATORS (&, |, ^, ~, <<, >>, >>>)
        // Operates on individual binary bits of integer primitives
        // =====================================================================
        System.out.println("\n=== 5. BITWISE & BIT-SHIFT OPERATORS ===");
        int bitA = 6;  // In binary: 0000 0110
        int bitB = 3;  // In binary: 0000 0011

        System.out.println("bitA & bitB   : " + (bitA & bitB)); // Bitwise AND: 0010 (2)
        System.out.println("bitA | bitB   : " + (bitA | bitB)); // Bitwise OR:  0111 (7)
        System.out.println("bitA ^ bitB   : " + (bitA ^ bitB)); // Bitwise XOR: 0101 (5)
        System.out.println("~bitA         : " + (~bitA));       // Bitwise Complement: inverts bits (-7 in 2's comp)

        // Left Shift (<<): Shifts bits left, fills right with 0 (multiplies by 2^n)
        // 6 << 2 = 6 * (2^2) = 24
        System.out.println("6 << 2        : " + (6 << 2)); // 24

        // Signed Right Shift (>>): Shifts right, preserves the sign bit (divides by 2^n)
        // -16 >> 2 = -4
        System.out.println("-16 >> 2      : " + (-16 >> 2)); // -4

        // Unsigned Right Shift (>>>): Shifts right and fills leftmost bits with 0 regardless of sign
        System.out.println("-16 >>> 2     : " + (-16 >>> 2)); // 1073741820


        // =====================================================================
        // 6. ASSIGNMENT OPERATORS (=, +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, >>>=)
        // Compound assignments include an implicit type-cast
        // =====================================================================
        System.out.println("\n=== 6. ASSIGNMENT OPERATORS ===");
        int val = 10;

        val += 5;  // Equivalent to: val = val + 5 -> 15
        System.out.println("val += 5  : " + val);

        val -= 3;  // Equivalent to: val = val - 3 -> 12
        System.out.println("val -= 3  : " + val);

        val *= 2;  // Equivalent to: val = val * 2 -> 24
        System.out.println("val *= 2  : " + val);

        val /= 4;  // Equivalent to: val = val / 4 -> 6
        System.out.println("val /= 4  : " + val);

        val %= 4;  // Equivalent to: val = val % 4 -> 2
        System.out.println("val %= 4  : " + val);

        val <<= 2; // Equivalent to: val = val << 2 -> 8
        System.out.println("val <<= 2 : " + val);

        // Implicit casting feature:
        byte byteNum = 10;
        // byteNum = byteNum + 5; // Compilation error: (byte + int) produces an int
        byteNum += 5;             // Legal: automatically cast back to (byte)
        System.out.println("byteNum += 5: " + byteNum);


        // =====================================================================
        // 7. TERNARY OPERATOR ( condition ? expression1 : expression2 )
        // Inline shorthand for if-else
        // =====================================================================
        System.out.println("\n=== 7. TERNARY OPERATOR ===");
        int score = 78;
        String result = (score >= 50) ? "Passed" : "Failed";
        System.out.println("Result: " + result); // "Passed"


        // =====================================================================
        // 8. TYPE COMPARISON OPERATOR (instanceof)
        // Checks if an object is an instance of a specific class or interface
        // =====================================================================
        System.out.println("\n=== 8. INSTANCEOF OPERATOR ===");
        String str = "Hello Java";
        Object obj = str;

        boolean isString = obj instanceof String;
        System.out.println("obj instanceof String : " + isString); // true

        // Pattern Matching for instanceof (Java 16+)
        if (obj instanceof String s) {
            // 's' is automatically cast to String within this scope
            System.out.println("Pattern match length  : " + s.length());
        }
    }
}