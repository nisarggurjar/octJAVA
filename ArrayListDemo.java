import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. DECLARATION & INITIALIZATION
        // Best practice: Program to the interface (List<T> list = new ArrayList<>())
        // Cannot store primitives: Use Integer, Double, etc. instead of int, double.
        // =====================================================================
        System.out.println("=== 1. DECLARATION & INITIALIZATION ===");

        List<String> languages = new ArrayList<>();

        // .add(element) -> Appends element to the end of the list
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        // .add(index, element) -> Inserts element at a specific index, shifting others right
        languages.add(1, "Kotlin");

        System.out.println("Initial list: " + languages);
        System.out.println("Size (.size()): " + languages.size()); // Note: .size() method, not .length field


        // =====================================================================
        // 2. ACCESSING & MODIFYING ELEMENTS
        // =====================================================================
        System.out.println("\n=== 2. ACCESS & MODIFY ===");

        // .get(index) -> Returns element at the given index
        String first = languages.get(0);
        System.out.println("Element at index 0: " + first);

        // .set(index, element) -> Replaces/updates element at specified index
        languages.set(2, "Rust"); // Replaces "Python" with "Rust"
        System.out.println("After set(2, 'Rust'): " + languages);


        // =====================================================================
        // 3. REMOVING ELEMENTS
        // =====================================================================
        System.out.println("\n=== 3. REMOVAL ===");

        // A. Remove by index: .remove(int index) -> returns removed item
        String removedLang = languages.remove(3); // Removes "C++"
        System.out.println("Removed by index 3: " + removedLang);

        // B. Remove by object: .remove(Object o) -> returns true if found and removed
        boolean wasRemoved = languages.remove("JavaScript");
        System.out.println("Removed 'JavaScript'?: " + wasRemoved);
        System.out.println("List after removals: " + languages);

        // --- TRICKY PITFALL: Removing integers by value vs index ---
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // numbers.remove(1);          // Removes index 1 (removes 20)
        numbers.remove(Integer.valueOf(10)); // Explicitly removes the VALUE 10, not index 10
        System.out.println("Integer list after removing value 10: " + numbers);


        // =====================================================================
        // 4. SEARCHING & INSPECTION METHODS
        // =====================================================================
        System.out.println("\n=== 4. SEARCHING & INSPECTION ===");

        // .contains(element) -> Checks if an item exists (uses .equals())
        System.out.println("Contains 'Java'?: " + languages.contains("Java")); // true
        System.out.println("Contains 'Ruby'?: " + languages.contains("Ruby")); // false

        // .indexOf(element) -> Returns first index, or -1 if absent
        System.out.println("Index of 'Kotlin': " + languages.indexOf("Kotlin"));

        // .isEmpty() -> Checks if size == 0
        System.out.println("Is list empty?: " + languages.isEmpty());


        // =====================================================================
        // 5. BULK OPERATIONS
        // =====================================================================
        System.out.println("\n=== 5. BULK OPERATIONS ===");

        List<String> moreLangs = List.of("Go", "TypeScript", "Java");

        // .addAll(collection) -> Appends an entire collection
        languages.addAll(moreLangs);
        System.out.println("After addAll: " + languages);

        // .lastIndexOf(element) -> Searches from the back
        System.out.println("Last index of 'Java': " + languages.lastIndexOf("Java"));

        // .removeIf(Predicate) -> Removes items matching a condition (Java 8+)
        languages.removeIf(lang -> lang.startsWith("K")); // Removes "Kotlin"
        System.out.println("After removeIf(startsWith 'K'): " + languages);


        // =====================================================================
        // 6. SORTING & UTILITIES
        // =====================================================================
        System.out.println("\n=== 6. SORTING ===");

        // Method A: Modern .sort() method with natural order comparator (Java 8+)
        languages.sort(null); 
        System.out.println("Sorted alphabetically: " + languages);

        // Method B: Collections utility class
        Collections.reverse(languages);
        System.out.println("Reversed list: " + languages);


        // =====================================================================
        // 7. ITERATING OVER AN ARRAYLIST
        // =====================================================================
        System.out.println("\n=== 7. ITERATION TECHNIQUES ===");

        // 1. Enhanced for-each loop
        System.out.print("For-each: ");
        for (String lang : languages) {
            System.out.print(lang + " ");
        }
        System.out.println();

        // 2. Functional forEach with lambda (Java 8+)
        System.out.print("Lambda forEach: ");
        languages.forEach(lang -> System.out.print(lang + " "));
        System.out.println();


        // =====================================================================
        // 8. CONVERTING BETWEEN ARRAY AND ARRAYLIST
        // =====================================================================
        System.out.println("\n=== 8. CONVERSIONS ===");

        // ArrayList -> Array
        String[] langArray = languages.toArray(new String[0]);
        System.out.println("Converted to Array length: " + langArray.length);

        // Clear all elements
        languages.clear();
        System.out.println("After clear(), size: " + languages.size());
    }
}