import java.util.Random;
import java.util.Arrays;

public class BinarySearch {

    private static int[] generateArray(int size) {
        Random rand = new Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
}
private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
     public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        for (int size : sizes) {
            int[] arr = generateArray(size);
            Arrays.sort(arr);  // Required before binary search
            int target = arr[arr.length - 1];
            long start = System.nanoTime();
            binarySearch(arr, target);
            long end = System.nanoTime();
            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.2f%n", size, timeMs);
        }
    }
