import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. CREATION & STRING CONSTANT POOL (SCP)
        // =====================================================================
        System.out.println("=== 1. CREATION & MEMORY BEHAVIOR ===");

        // String Literal -> Stored in String Constant Pool
        String s1 = "Hello";
        String s2 = "Hello";

        // 'new' keyword -> Forces a new object in normal heap memory
        String s3 = new String("Hello");

        // Reference equality (==) vs Content equality (.equals())
        System.out.println("s1 == s2      : " + (s1 == s2));      // true: point to same pool literal
        System.out.println("s1 == s3      : " + (s1 == s3));      // false: different heap addresses
        System.out.println("s1.equals(s3) : " + s1.equals(s3));  // true: compares character contents

        // .intern() -> Fetches the reference from the pool
        String s4 = s3.intern();
        System.out.println("s1 == s4      : " + (s1 == s4));      // true


        // =====================================================================
        // 2. IMMUTABILITY IN ACTION
        // =====================================================================
        System.out.println("\n=== 2. IMMUTABILITY ===");

        String greeting = "Java";
        greeting.concat(" Programming"); // Return value is ignored!
        System.out.println("Original greeting: " + greeting); // Still "Java"

        // To keep changes, reassign the reference:
        greeting = greeting.concat(" Programming");
        System.out.println("Reassigned greeting: " + greeting); // "Java Programming"


        // =====================================================================
        // 3. ESSENTIAL INSPECTION METHODS
        // =====================================================================
        System.out.println("\n=== 3. INSPECTION METHODS ===");

        String text = "Software Engineer";

        // .length() -> Returns total character count (method, unlike array.length)
        System.out.println("Length: " + text.length()); // 17

        // .charAt(index) -> Zero-indexed character retrieval
        System.out.println("Char at index 3: " + text.charAt(3)); // 't'

        // .isEmpty() vs .isBlank() (isBlank was added in Java 11)
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("emptyStr.isEmpty(): " + emptyStr.isEmpty()); // true (length == 0)
        System.out.println("blankStr.isEmpty(): " + blankStr.isEmpty()); // false (length == 3)
        System.out.println("blankStr.isBlank(): " + blankStr.isBlank()); // true (only whitespace)


        // =====================================================================
        // 4. SEARCHING & SUBSTRINGS
        // =====================================================================
        System.out.println("\n=== 4. SEARCHING & SUBSTRINGS ===");

        String path = "src/main/java/Demo.java";

        // .contains(CharSequence)
        System.out.println("Contains 'java'?: " + path.contains("java")); // true

        // .startsWith() & .endsWith()
        System.out.println("Starts with 'src'?: " + path.startsWith("src")); // true
        System.out.println("Ends with '.java'?: " + path.endsWith(".java")); // true

        // .indexOf() & .lastIndexOf()
        System.out.println("First index of '/': " + path.indexOf('/'));     // 3
        System.out.println("Last index of '/':  " + path.lastIndexOf('/')); // 12
        System.out.println("Index of 'missing': " + path.indexOf("xyz"));   // -1 (not found)

        // .substring(beginIndex) & .substring(beginIndex, endIndex)
        // Note: endIndex is EXCLUSIVE [begin, end)
        String extension = path.substring(path.lastIndexOf('.') + 1); // "java"
        String segment   = path.substring(4, 8);                      // "main"
        System.out.println("File extension: " + extension);
        System.out.println("Path segment:   " + segment);


        // =====================================================================
        // 5. MODIFICATION & TRANSFORMATION METHODS
        // (Remember: All return a brand new String)
        // =====================================================================
        System.out.println("\n=== 5. TRANSFORMATIONS ===");

        String message = "   Java Core Basics   ";

        // .trim() & .strip() (.strip() is Unicode-aware, added in Java 11)
        System.out.println("Trimmed: '" + message.trim() + "'");

        // Case conversions
        System.out.println("Upper: " + message.trim().toUpperCase());
        System.out.println("Lower: " + message.trim().toLowerCase());

        // .replace() & .replaceAll()
        String replaced = message.trim().replace("Core", "Advanced");
        System.out.println("Replaced: " + replaced); // "Java Advanced Basics"

        // .repeat(n) (Java 11+)
        System.out.println("Repeated: " + "Na ".repeat(3)); // "Na Na Na "


        // =====================================================================
        // 6. SPLITTING & JOINING
        // =====================================================================
        System.out.println("\n=== 6. SPLITTING & JOINING ===");

        String csvData = "Nisarg,25,Engineer,India";

        // .split(regex) -> breaks string into array by delimiter
        String[] tokens = csvData.split(",");
        System.out.println("Parsed tokens: " + Arrays.toString(tokens));

        // String.join(delimiter, elements...) -> stitches items back together
        String joined = String.join(" | ", tokens);
        System.out.println("Joined back: " + joined);

        // .toCharArray()
        char[] charArray = "Java".toCharArray();
        System.out.println("First char from array: " + charArray[0]);


        // =====================================================================
        // 7. COMPARISONS (ALPHABETICAL ORDER)
        // =====================================================================
        System.out.println("\n=== 7. COMPARISONS ===");

        String word1 = "apple";
        String word2 = "banana";

        // .compareTo() -> returns negative if word1 comes first, 0 if equal, positive if second
        System.out.println("apple vs banana : " + word1.compareTo(word2)); // negative
        System.out.println("Case-insensitive: " + "APPLE".equalsIgnoreCase("apple")); // true
    }
}