package BBS;

import java.util.Random;

public class PerformanceTest {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        Random rand = new Random();
        int datasetSize = 10000; // Adjust as needed
        int[] dataset = new int[datasetSize];

        // Generate random dataset
        for (int i = 0; i < datasetSize; i++) {
            dataset[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        // Arrays to hold operation times
        long[] insertTimes = new long[100];
        long[] deleteTimes = new long[100];
        long[] searchTimes = new long[100];

        // Perform operations and measure time
        for (int i = 0; i < 100; i++) {
            int value = dataset[rand.nextInt(datasetSize)];

            // Measure insert time
            long startInsert = System.nanoTime();
            tree.insert(value);
            long endInsert = System.nanoTime();
            insertTimes[i] = endInsert - startInsert;

            // Measure search time
            long startSearch = System.nanoTime();
            boolean found = tree.contains(value);
            long endSearch = System.nanoTime();
            searchTimes[i] = endSearch - startSearch;

            // Measure delete time
            long startDelete = System.nanoTime();
            tree.delete(value);
            long endDelete = System.nanoTime();
            deleteTimes[i] = endDelete - startDelete;
        }

        System.out.println("Insert Times (nanoseconds):");
        for (long time : insertTimes) System.out.println(time);

        System.out.println("\nSearch Times (nanoseconds):");
        for (long time : searchTimes) System.out.println(time);

        System.out.println("\nDelete Times (nanoseconds):");
        for (long time : deleteTimes) System.out.println(time);

    }
}