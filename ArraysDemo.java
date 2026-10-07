import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {

        // =====================================================================
        // 1. ARRAY DECLARATION & INITIALIZATION
        // =====================================================================
        System.out.println("=== 1. DECLARATION & INITIALIZATION ===");

        // Method A: Declare with fixed size (elements get default values: 0 for int)
        int[] numbers = new int[5]; 
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;

        // Method B: Array literal (instantiate and populate simultaneously)
        int[] primes = {2, 3, 5, 7, 11};

        // Accessing elements and checking length
        System.out.println("First element in primes: " + primes[0]);
        System.out.println("Length of primes array: " + primes.length); // .length is a field, not a method


        // =====================================================================
        // 2. ITERATING OVER ARRAYS
        // =====================================================================
        System.out.println("\n=== 2. ITERATING ARRAYS ===");

        // Standard index-based for loop (allows reading and modifying elements)
        System.out.print("Standard for-loop: ");
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i] + " ");
        }
        System.out.println();

        // Enhanced for-each loop (cleaner, read-only traversal)
        System.out.print("For-each loop: ");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();


        // =====================================================================
        // 3. ESSENTIAL UTILITY METHODS (java.util.Arrays)
        // =====================================================================
        System.out.println("\n=== 3. JAVA.UTIL.ARRAYS METHODS ===");

        int[] sample = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8};

        // A. Arrays.toString() -> Prints readable array contents instead of memory hash
        System.out.println("Original array: " + Arrays.toString(sample));

        // B. Arrays.sort() -> Sorts array in ascending order (Dual-Pivot Quicksort)
        Arrays.sort(sample);
        System.out.println("Sorted array  : " + Arrays.toString(sample));

        // C. Arrays.binarySearch() -> Fast search (Requires sorted array first!)
        // Returns the index of key, or a negative value if not found
        int searchIndex = Arrays.binarySearch(sample, 42);
        System.out.println("Index of 42   : " + searchIndex);

        // D. Arrays.fill() -> Assigns a specific value to every index
        int[] blankBoard = new int[5];
        Arrays.fill(blankBoard, -1);
        System.out.println("Filled array  : " + Arrays.toString(blankBoard));

        // E. Arrays.copyOf() -> Creates a new array with a new capacity
        int[] expanded = Arrays.copyOf(sample, 15); // Expands size to 15, padding with zeros
        System.out.println("Expanded copy : " + Arrays.toString(expanded));

        // F. Arrays.copyOfRange() -> Slices a sub-array [fromIndex, toIndex)
        int[] sliced = Arrays.copyOfRange(sample, 1, 5); // Indexes 1 through 4
        System.out.println("Sliced array  : " + Arrays.toString(sliced));

        // G. Arrays.equals() -> Compares element contents (== only compares memory references)
        int[] arrA = {1, 2, 3};
        int[] arrB = {1, 2, 3};
        int[] arrC = {3, 2, 1};
        System.out.println("arrA == arrB             : " + (arrA == arrB));             // false (different objects)
        System.out.println("Arrays.equals(arrA, arrB): " + Arrays.equals(arrA, arrB)); // true (same contents)
        System.out.println("Arrays.equals(arrA, arrC): " + Arrays.equals(arrA, arrC)); // false


        // =====================================================================
        // 4. MULTIDIMENSIONAL & JAGGED ARRAYS
        // =====================================================================
        System.out.println("\n=== 4. MULTIDIMENSIONAL & JAGGED ARRAYS ===");

        // 2D Matrix (2 rows x 3 columns)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Use Arrays.deepToString() for nested/multidimensional arrays
        System.out.println("Matrix: " + Arrays.deepToString(matrix));

        // Jagged Array (rows with variable column lengths)
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1};
        jagged[1] = new int[]{2, 3};
        jagged[2] = new int[]{4, 5, 6, 7};
        System.out.println("Jagged: " + Arrays.deepToString(jagged));


        // =====================================================================
        // 5. COMMON PITFALL: ArrayIndexOutOfBoundsException
        // =====================================================================
        System.out.println("\n=== 5. COMMON PITFALL ===");
        try {
            int invalid = numbers[10]; // numbers length is only 5
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: Cannot access index outside 0 to (length - 1)");
        }
    }
}