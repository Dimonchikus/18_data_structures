package CountingSort;

public class CountingSort {

    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // Find the maximum and minimum values
        int max = array[0], min = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int range = max - min + 1;
        int[] count = new int[range];

        // Count the occurrences
        for (int num : array) {
            count[num - min]++;
        }

        // Modify count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Sort the array
        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            output[--count[array[i] - min]] = array[i];
        }

        // Copy back to the original array
        System.arraycopy(output, 0, array, 0, array.length);
    }
}