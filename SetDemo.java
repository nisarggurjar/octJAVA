import java.util.*;

public class SetDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. BASIC SET BEHAVIOR & DUPLICATE PREVENTION (HashSet)
        // Backed by HashMap. Elements must implement hashCode() and equals().
        // =====================================================================
        System.out.println("=== 1. BASIC HASHSET & DUPLICATE HANDLING ===");

        Set<String> frameworkSet = new HashSet<>();

        // .add(element) -> returns true if added, false if already present
        System.out.println("Add Spring:     " + frameworkSet.add("Spring"));     // true
        System.out.println("Add Quarkus:    " + frameworkSet.add("Quarkus"));    // true
        System.out.println("Add Micronaut:  " + frameworkSet.add("Micronaut"));  // true
        
        // Attempting to insert a duplicate:
        boolean addedDuplicate = frameworkSet.add("Spring");
        System.out.println("Add Spring again?: " + addedDuplicate);              // false

        // HashSet allows exactly one null element
        frameworkSet.add(null);

        // Printing shows arbitrary, non-guaranteed ordering
        System.out.println("HashSet contents: " + frameworkSet);


        // =====================================================================
        // 2. ESSENTIAL INSPECTION & REMOVAL METHODS
        // =====================================================================
        System.out.println("\n=== 2. INSPECTION & REMOVAL ===");

        // .contains(element) -> O(1) membership lookup
        System.out.println("Contains 'Quarkus'?: " + frameworkSet.contains("Quarkus")); // true
        System.out.println("Contains 'Django'?:  " + frameworkSet.contains("Django"));  // false

        // .size() & .isEmpty()
        System.out.println("Set size:    " + frameworkSet.size());
        System.out.println("Is empty?:   " + frameworkSet.isEmpty());

        // .remove(element) -> Removes the object if present
        frameworkSet.remove(null);
        frameworkSet.remove("Micronaut");
        System.out.println("After removals: " + frameworkSet);


        // =====================================================================
        // 3. MATHEMATICAL SET OPERATIONS (Union, Intersection, Difference)
        // =====================================================================
        System.out.println("\n=== 3. MATHEMATICAL OPERATIONS ===");

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // A. Union: .addAll() -> Combines both sets without duplicates
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Union (A ∪ B):        " + union); // [1, 2, 3, 4, 5, 6, 7, 8]

        // B. Intersection: .retainAll() -> Keeps only common elements
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection); // [4, 5]

        // C. Difference: .removeAll() -> Removes all elements present in setB from setA
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B):   " + difference); // [1, 2, 3]


        // =====================================================================
        // 4. ORDERING COMPARISON: HashSet vs LinkedHashSet vs TreeSet
        // =====================================================================
        System.out.println("\n=== 4. ORDERING DIFFERENCES ===");

        List<String> rawData = List.of("Banana", "Apple", "Mango", "Cherry", "Apple");

        // 1. HashSet: No guaranteed order
        Set<String> hashSet = new HashSet<>(rawData);
        System.out.println("HashSet (unpredictable order):    " + hashSet);

        // 2. LinkedHashSet: Preserves exact insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>(rawData);
        System.out.println("LinkedHashSet (insertion order):  " + linkedHashSet);

        // 3. TreeSet: Automatically sorted in natural alphabetical order
        // Note: TreeSet rejects 'null' elements (throws NullPointerException)
        Set<String> treeSet = new TreeSet<>(rawData);
        System.out.println("TreeSet (sorted order):           " + treeSet);


        // =====================================================================
        // 5. NAVIGABLE / SORTED SET METHODS (TreeSet specific)
        // =====================================================================
        System.out.println("\n=== 5. TREESET NAVIGATION METHODS ===");

        NavigableSet<Integer> scores = new TreeSet<>(List.of(10, 25, 50, 75, 90));
        System.out.println("Scores TreeSet: " + scores);

        System.out.println("First (lowest):   " + scores.first());          // 10
        System.out.println("Last (highest):   " + scores.last());           // 90
        System.out.println("Higher than 50:   " + scores.higher(50));       // 75 (> 50)
        System.out.println("Lower than 50:    " + scores.lower(50));        // 25 (< 50)
        System.out.println("Ceiling of 45:    " + scores.ceiling(45));      // 50 (>= 45)
        System.out.println("Floor of 45:      " + scores.floor(45));        // 25 (<= 45)

        // Subsets: headSet(), tailSet(), subSet()
        System.out.println("Subset [25, 75):  " + scores.subSet(25, 75));   // [25, 50]
        System.out.println("Descending view:  " + scores.descendingSet());  // [90, 75, 50, 25, 10]


        // =====================================================================
        // 6. IMMUTABLE SET FACTORIES (Java 9+)
        // =====================================================================
        System.out.println("\n=== 6. IMMUTABLE SETS (Set.of) ===");

        // Set.of() produces an unmodifiable set
        Set<String> immutableRoles = Set.of("ADMIN", "USER", "GUEST");
        System.out.println("Immutable Set: " + immutableRoles);

        try {
            immutableRoles.add("MODERATOR"); // Throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught exception: Cannot modify Set.of()");
        }
    }
}