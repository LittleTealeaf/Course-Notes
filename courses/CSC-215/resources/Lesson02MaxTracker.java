/************
 * Christian Duncan
 * 
 * MaxTracker: Designed for CSC215: Algorithms Design and Analysis
 *
 * This program runs a very rudimentary experiment to determine how often the maximum value changes 
 * in a straight-forward scan to find the largest element in an (unsorted) array.
 * For each array size, it reports both the average number of changes, the
 * best-case number of changes, and the worst-case number of changes.
 *   Printing them out in a CSV format (for analysis on a spreadsheet program).
 ************/
import java.util.Random;

public class Lesson02MaxTracker {
    static Random ran;
    public static final int MIN_SIZE = 10;
    public static final int MAX_SIZE = 2000000;
    public static final int NUM_CASES = 1000;

    /****
     * trackMax:
     *   array: The input array to search
     *   return: The NUMBER of times the max changed.
     *   Given an array of values, computes the maximum value in that array.
     *   But returns the number of times the maximum changes (not the max). - For experimental reasons
     ****/
    public static int trackMax(double[] array) {
	if (array.length < 1)
            return 0;  // Nothing to do

        int count = 1;  // Count that first assignment as one change.
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];  // New maximum value
                count++;         // Increase the count
            }
        }
        return count;   // Note: Doesn't return MAX value, just number of changes
    }

    /****
     * testTracker:
     *   size: Size of array to be testing
     *   testCases: Number of test cases to perform
     *   Prints out best case, worst case, average case for given array size
     *     (Generating a different array for each case of course)
     ****/
    public static void testTracker(int size, int testCases) {
        long totalChanges = 0;
        long minChange = size+1;  // Just more than the maximum every possible
        long maxChange = -1;     //  Less than minimum possible
        double[] array = new double[size];

        for (int i = 0; i < testCases; i++) {
            for (int j = 0; j < size; j++) array[j] = ran.nextDouble();   // Generate a new test case
            int changes = trackMax(array);   // Compute the number of changes for this array

            // Determine if it is a best-case or worst-case situation and tally it
            totalChanges += changes;
            if (changes < minChange) {
                minChange = changes;
            }
            if (changes > maxChange) {
                maxChange = changes;
            }
        }
        System.out.println(size + ", " + minChange + ", " + maxChange + ", " + 
                           ((double) totalChanges / (double) testCases));
    }

    public static void main(String[] args) {
        ran = new Random(); // Create random number generator
        for (int size = MIN_SIZE; size <= MAX_SIZE; size *= 2)
            testTracker(size, NUM_CASES);
    }
}