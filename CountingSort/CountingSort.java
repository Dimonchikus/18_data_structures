package CountingSort;

public class CountingSort {

    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return;
        }

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

        for (int num : array) {
            count[num - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            output[--count[array[i] - min]] = array[i];
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }
}