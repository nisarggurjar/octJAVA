public class Variables {
    public static void main(String[] args) {
        /*
            Now we reach one of the most important concepts.
            A variable is a named memory location used to store data.
        */

        int age = 26;
        System.out.println("age: "+ age);
        
        /*
        This is called declaration + initialization.
        int     age     =     26;
         ↓       ↓      ↓      ↓
        type variable assignment value

        ┌──────────────┐
        │      26      │
        └──────────────┘
               age

        You can later change its value:
        */

        age = 27;

        // 
        int age1;
        age1 = 29;
    }
}

/*
Mandatory Compiler Rules

Violating any of these results in a compilation error:

1. Allowed Characters:

Letters (A-Z, a-z)
Digits (0-9)
Underscore (_)
Dollar sign ($)
(Technically, any Unicode currency symbols or connecting characters via Character.isJavaIdentifierStart() and Character.isJavaIdentifierPart()).

2. Cannot Start with a Digit:

Valid: count1, _value, $total
Invalid: 1count, 7days

3. Cannot Be a Reserved Keyword:

You cannot use Java keywords or literals such as class, int, for, static, public, null, true, or false.
Note: Identifiers are case-sensitive, so Class or Int compile, but doing so violates best practices.

4. Cannot Be a Single Underscore:

A single underscore (_) is a reserved keyword in modern Java (Java 9+) and cannot be used as an identifier name.
Multiple underscores (__) or underscores mixed with characters (_a) are allowed.

5. No Whitespace or Special Symbols:

Spaces, punctuation, and mathematical operators (@, #, %, -, +, !, etc.) are forbidden.
Valid: user_name
Invalid: user name, user-name, user@id

6. Case Sensitivity:

Identifiers are strictly case-sensitive. myVariable, myvariable, and MYVARIABLE are treated as three distinct variables.

7. No Hard Length Limit:

Variable names can technically be arbitrarily long, though practical readability dictates reasonable lengths.
*/

/*
Java Naming Conventions:

1. Classes:

Use UpperCamelCase (PascalCase).
Should be a noun or noun phrase.
Examples: CustomerAccount, ThreadRunner, StringTokenizer.

2. Interfaces:

Use UpperCamelCase (PascalCase).
Often named with an adjective ending in -able or -ible to indicate capability, or as a descriptive noun.
Examples: Runnable, Comparable, Serializable, List, UserRepository.

3. Methods:

Use lowerCamelCase.
Should be a verb or verb phrase describing the action.
Standard accessors and mutators follow JavaBeans style: getName(), setName(), isActive(), hasChildren().
Examples: calculateTax(), fetchData(), toString().

4. Variables & Fields (Instance and Local):

Use lowerCamelCase.
Should be short yet meaningful nouns indicating purpose.
Single-letter names are reserved strictly for short-lived loop counters (i, j, k) or coordinate planes (x, y).
Examples: orderCount, userEmail, firstName.

5. Constants (static final fields):

Use SCREAMING_SNAKE_CASE (all uppercase letters separated by underscores).
Should describe a fixed, immutable value.
Examples: MAX_RETRY_COUNT, DEFAULT_TIMEOUT_MS, PI.

6. Packages:

Use all lowercase letters only (no underscores, hyphens, or uppercase characters).
Prefix with a reversed Internet domain name to avoid collisions.
Examples: com.company.project.module, org.springframework.boot, java.util.concurrent.

7. Enums:

Enum types: Use UpperCamelCase, identical to standard classes (e.g., DayOfWeek, UserRole).
Enum constants: Use SCREAMING_SNAKE_CASE, identical to constants (e.g., NORTH, SOUTH, PENDING_APPROVAL).

8. Generic Type Parameters:

Use a single uppercase letter.
Common conventions:
    T: General type
    E: Element (used heavily in collections)
    K: Map key
    V: Map value
    N: Number
    S, U, V: 2nd, 3rd, and 4th types

9. Annotations:

Use UpperCamelCase (PascalCase).
Typically an adjective, noun, or verb depending on role.
Examples: @Override, @Deprecated, @FunctionalInterface, @Entity.

10. General Avoidances:

Do not use the dollar sign ($) in identifiers; it is reserved for compiler-generated code and inner classes.
Avoid Hungarian notation (e.g., strName, iCount).
Avoid abbreviations and acronyms where possible (e.g., prefer htmlParser or HtmlParser over HTMLPrsr).
*/