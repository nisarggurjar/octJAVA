# octJAVA

## JAVA files sequence

1.  HelloWorld.java
2.  OutPut.java
3.  Variables.java
4.  DataTypes.java
5.  AllInputsDemo.java
6.  ScannerBufferDemo.java
7.  AllOperatorsDemo.java
8.  ConditionalsDemo.java
9.  TypeCastingDemo.java
10. ConditionalsDemo.java
11. LoopsDemo.java
12. ArrayDemo.java
13. ArratListDemo.java
14. StringDemo.java
15. SetDemo.java
16. MapDemo.java
17. MethodsDemo.java
18. ClassesAndThisDemo.java
19. EncapsulationDemo.java
20. ConstructorDemo.java
21. InheritanceDemo.java
22. CompileTimePolymorphismDemo.java
23. RuntimePolymorphismDemo.java
24. AbstractClassDemo.java
25. MultipleInterfacesDemo.java
26. InterfaceModernFeaturesDemo.java


Notes:

// : For Single Comment

/*

*/: For Multiline Comment




Practise Questions : 

Here is a curated set of **35 coding and conceptual practice questions** covering foundational Java topics, ordered from core syntax to collections.

---

### Part 1: Input, Output & Operators (Questions 1–7)

1. **The Scanner Buffer Bug:** Write a program that asks for a user's roll number (`int`), then clears the newline buffer, and subsequently reads their full name (`String` with spaces).
2. **Tabular Formatting:** Read 3 student names and their percentages, then display them in a neat tabular format using `System.out.printf()` with explicit column widths and 2-decimal precision.
3. **Floating Division vs Truncation:** Given two integers $a$ and $b$ from user input, calculate their exact decimal quotient without changing the variable types of $a$ and $b$.
4. **Swap Without Temp:** Swap two integer variables using bitwise XOR (`^`) operators only.
5. **Pre vs Post Increment Trace:** Predict the output of the following expression and write a snippet to verify:
```java
int x = 5;
int y = x++ + ++x - --x + x--;

```


6. **Bitwise Parity Check:** Check whether a number entered by the user is even or odd using only the bitwise AND (`&`) operator.
7. **Compound Assignment Promotion:** Explain why `byte b = 5; b = b + 1;` throws a compilation error, while `b += 1;` compiles cleanly.

---

### Part 2: Conditional Statements (Questions 8–13)

8. **Leap Year Validator:** Prompt the user for a year and determine if it is a leap year using a single compound `if-else` condition.
9. **Tax Slab Calculator:** Calculate income tax using an `if-else-if` ladder based on progressive brackets ($0\text{--}2.5\text{L} \to 0\%$, $2.5\text{--}5\text{L} \to 5\%$, $5\text{--}10\text{L} \to 20\%$, $>10\text{L} \to 30\%$).
10. **Modern Switch Calculator:** Build a menu-driven calculator taking two numbers and an operator character (`+`, `-`, `*`, `/`) using the modern `switch` arrow syntax (`->`).
11. **Quadratic Equation Roots:** Given coefficients $a$, $b$, and $c$, determine whether the roots are real and distinct, real and equal, or imaginary using conditionals on the discriminant ($D = b^2 - 4ac$).
12. **Nested Ternary Classification:** Use a single ternary operator expression to return `"Negative"`, `"Zero"`, or `"Positive"` for an integer input.
13. **Character Type Identifier:** Take a single character input and use conditionals to determine if it is an uppercase vowel, lowercase vowel, consonant, digit, or special symbol.

---

### Part 3: Loops & Jump Statements (Questions 14–19)

14. **Digit Reversal & Palindrome Check:** Read an integer using a `while` loop, reverse its digits mathematically, and print whether the original number is a palindrome.
15. **Prime Number Generator:** Print all prime numbers between $1$ and $N$ using nested loops. Optimize the inner check to test up to $\sqrt{n}$.
16. **Fibonacci Sequence:** Generate the first $N$ terms of the Fibonacci sequence using a `for` loop without recursion.
17. **Input Validation Menu:** Implement a console menu inside a `do-while` loop that continues prompting the user until they explicitly enter the exit code (`0`).
18. **Labeled Break in Nested Grid:** Write a program that searches for a target value inside a $4 \times 4$ integer matrix and exits all nested loops immediately upon finding it using a labeled `break`.
19. **Pattern Printing:** Print the following pattern for $N = 5$ using nested loops:

```text
    *
   ***
  *****
 *******
*********

```

---

### Part 4: Strings (Questions 20–24)

20. **String vs Reference Equality:** Demonstrate through code why `s1 == s2` evaluates to `true` for literals but `false` when one is created with `new String()`, and show how `.intern()` affects this.
21. **Palindrome String:** Check if a sentence is a palindrome, ignoring casing and spaces (e.g., `"Race car"` should return `true`).
22. **Anagram Checker:** Given two strings, determine if they are anagrams of each other (e.g., `"listen"` and `"silent"`).
23. **Word Frequency & String Parsing:** Take a CSV-like line of text, split it into words using `.split()`, and print the length of each individual token.
24. **Character Frequency Counter:** Count the occurrences of each character in a given string without using third-party libraries.

---

### Part 5: Arrays & ArrayList (Questions 25–29)

25. **Second Largest Element:** Find the second largest number in an unsorted primitive array `int[]` in a single pass ($O(n)$ time complexity).
26. **Array Rotation:** Rotate an array of $N$ elements to the right by $K$ steps.
27. **Array Deduplication:** Given a sorted integer array, remove duplicates in-place such that each unique element appears only once.
28. **ArrayList Integer Removal Pitfall:** Create an `ArrayList<Integer>` with values `[10, 20, 30]`. Write code that specifically deletes the value `20`, not the item at index `20`.
29. **Dynamic Filtering:** Populate an `ArrayList<String>` and remove all elements starting with the letter `"A"` using `.removeIf()` and a lambda expression.

---

### Part 6: Set & Map Collections (Questions 30–35)

30. **Eliminate Duplicates Preserving Order:** Given a list of integers with duplicates, filter out all duplicates while preserving their original order of appearance using a `LinkedHashSet`.
31. **Set Set-Theoretic Operations:** Given two sets $A = \{1, 2, 3, 4\}$ and $B = \{3, 4, 5, 6\}$, write a snippet to compute their Union, Intersection, and Difference.
32. **Word Count with Map:** Read a sentence from the user, parse it into words, and use `Map<String, Integer>` with the `.merge()` or `.getOrDefault()` method to compute word frequencies.
33. **Two-Sum Problem:** Given an array of integers and a `target`, use a `HashMap` to find the indices of the two numbers that add up to the target in $O(n)$ time.
34. **First Non-Repeating Character:** Find the first character in a string that does not repeat anywhere else using a `LinkedHashMap`.
35. **Sorted Frequency Map:** Given an array of numbers, sort them based on their frequency using a combination of `Map` and a custom sorted collection or list comparator.