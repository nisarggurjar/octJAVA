import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. BASIC MAP OPERATIONS (HashMap)
        // Backed by hash buckets. Keys must implement hashCode() and equals().
        // =====================================================================
        System.out.println("=== 1. BASIC HASHMAP OPERATIONS ===");

        Map<String, Integer> stockMap = new HashMap<>();

        // .put(key, value) -> Inserts entry; overwrites and returns previous value if key exists
        stockMap.put("Apple", 120);
        stockMap.put("Banana", 40);
        stockMap.put("Orange", 75);
        stockMap.put("Mango", 90);

        // Overwriting an existing key:
        Integer previousPrice = stockMap.put("Apple", 135);
        System.out.println("Previous price of Apple: " + previousPrice); // 120
        System.out.println("Updated Map: " + stockMap);

        // .putIfAbsent(key, value) -> Only inserts if key does not exist or maps to null
        stockMap.putIfAbsent("Banana", 50); // Will NOT change 40 to 50
        stockMap.putIfAbsent("Grapes", 110); // Inserts Grapes
        System.out.println("After putIfAbsent: " + stockMap);


        // =====================================================================
        // 2. RETRIEVAL & INSPECTION METHODS
        // =====================================================================
        System.out.println("\n=== 2. RETRIEVAL & INSPECTION ===");

        // .get(key) -> Returns value or null if key absent
        System.out.println("Price of Orange: " + stockMap.get("Orange")); // 75
        System.out.println("Price of Kiwi:   " + stockMap.get("Kiwi"));   // null

        // .getOrDefault(key, defaultValue) -> Prevents NullPointerException by falling back
        int kiwiPrice = stockMap.getOrDefault("Kiwi", 0);
        System.out.println("Price of Kiwi (safe): " + kiwiPrice); // 0

        // .containsKey(key) & .containsValue(value)
        System.out.println("Has 'Mango' key?:    " + stockMap.containsKey("Mango")); // true (O(1))
        System.out.println("Has value 110?:       " + stockMap.containsValue(110));  // true (O(n))

        // .size() & .isEmpty()
        System.out.println("Map size: " + stockMap.size());


        // =====================================================================
        // 3. REMOVAL & REPLACEMENT
        // =====================================================================
        System.out.println("\n=== 3. REMOVAL & REPLACEMENT ===");

        // .remove(key) -> Removes key and returns removed value
        stockMap.remove("Banana");

        // .remove(key, value) -> Conditional removal (only removes if both key and value match)
        boolean removed = stockMap.remove("Orange", 100); // Fails because value is 75
        System.out.println("Removed Orange with price 100?: " + removed); // false

        // .replace(key, newValue) vs .replace(key, oldValue, newValue)
        stockMap.replace("Orange", 80);
        System.out.println("Map after removal and replace: " + stockMap);


        // =====================================================================
        // 4. ITERATING OVER A MAP (3 Collection Views)
        // =====================================================================
        System.out.println("\n=== 4. ITERATING A MAP ===");

        // View 1: Entry Set (.entrySet()) - Recommended for reading key AND value
        System.out.println("-- Iterating via entrySet() --");
        for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
            System.out.printf("Product: %-7s | Price: %d%n", entry.getKey(), entry.getValue());
        }

        // View 2: Key Set (.keySet())
        System.out.print("-- Keys: ");
        for (String key : stockMap.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();

        // View 3: Values Collection (.values())
        System.out.println("-- Values: " + stockMap.values());

        // View 4: Lambda .forEach() (Java 8+)
        System.out.println("-- Lambda forEach --");
        stockMap.forEach((k, v) -> System.out.println(k + " costs " + v));


        // =====================================================================
        // 5. MODERN JAVA 8+ COMPUTATION METHODS
        // =====================================================================
        System.out.println("\n=== 5. COMPUTE METHODS ===");

        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};

        // computeIfAbsent: Useful for grouping or initializing
        // merge: The cleanest way to tally frequencies
        for (String word : words) {
            wordFrequency.merge(word, 1, Integer::sum);
        }
        System.out.println("Frequencies via merge(): " + wordFrequency); // {banana=2, apple=3, cherry=1}


        // =====================================================================
        // 6. ORDERING COMPARISON: HashMap vs LinkedHashMap vs TreeMap
        // =====================================================================
        System.out.println("\n=== 6. ORDERING COMPARISONS ===");

        // 1. HashMap: Unpredictable hash-bucket order
        Map<String, Integer> unsorted = new HashMap<>();
        unsorted.put("Zebra", 1);
        unsorted.put("Monkey", 2);
        unsorted.put("Ant", 3);
        System.out.println("HashMap (no order guarantee): " + unsorted);

        // 2. LinkedHashMap: Retains order of insertion
        Map<String, Integer> insertionOrder = new LinkedHashMap<>();
        insertionOrder.put("Zebra", 1);
        insertionOrder.put("Monkey", 2);
        insertionOrder.put("Ant", 3);
        System.out.println("LinkedHashMap (insertion order): " + insertionOrder);

        // 3. TreeMap: Sorted alphabetically by keys
        Map<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Zebra", 1);
        sortedMap.put("Monkey", 2);
        sortedMap.put("Ant", 3);
        System.out.println("TreeMap (natural key sorting):  " + sortedMap);


        // =====================================================================
        // 7. NAVIGABLEMAP METHODS (TreeMap specific)
        // =====================================================================
        System.out.println("\n=== 7. TREEMAP NAVIGATION METHODS ===");

        NavigableMap<Integer, String> rankMap = new TreeMap<>();
        rankMap.put(10, "Bronze");
        rankMap.put(20, "Silver");
        rankMap.put(30, "Gold");
        rankMap.put(40, "Platinum");

        System.out.println("First Key:       " + rankMap.firstKey());        // 10
        System.out.println("Last Key:        " + rankMap.lastKey());         // 40
        System.out.println("Floor entry(25): " + rankMap.floorEntry(25));    // 20=Silver (<= 25)
        System.out.println("Ceiling entry(25): " + rankMap.ceilingEntry(25)); // 30=Gold (>= 25)
        System.out.println("Descending view: " + rankMap.descendingMap());
    }
}