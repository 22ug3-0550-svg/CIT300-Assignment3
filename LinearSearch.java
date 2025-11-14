import java.util.Random;

public class LinearSearch {

    // This creates the same random array every time
    private static int[] generateArray(int size) {
        Random rand = new Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
        // Linear search: look one by one
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
        public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        for (int size : sizes) {
            int[] arr = generateArray(size);
            int target = arr[size - 1];  // Last element exists
            long start = System.nanoTime();
            linearSearch(arr, target);
            long end = System.nanoTime();
            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.2f%n", size, timeMs);
        }
    }
}