package Labs.Week6.labTask;

import java.util.Random;

public class DualPivotQuickSort {

    /* Quick sort algorithm (public invocation) */
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        // your code
        shuffle(elements); // Shuffle the array to ensure average-case performance
        sort(elements, 0, elements.length - 1);
    }

    /* Knuth shuffle (performance guarantee) */
    private static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        // your code here
        Random rand = new Random();
        for (int i = elements.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(elements, i, j);
        }
    }

    /* Recursive quick sort logic */
    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        // your code here
        if (low < high) {
            int[] pivots = partition(elements, low, high);
            sort(elements, low, pivots[0] - 1);
            sort(elements, pivots[0] + 1, pivots[1] - 1);
            sort(elements, pivots[1] + 1, high);
        }
    }

    /* Partition an array using the dual-pivot approach and return the pivot indices */
    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        // your code here (next line is a placeholder)
        if (elements[low].compareTo(elements[high]) > 0) {
            swap(elements, low, high);
        }

        Data leftPivot = elements[low];
        Data rightPivot = elements[high];

        int i = low + 1;
        int j = high - 1;
        int k = i;

        while (k <= j) {
            if (elements[k].compareTo(leftPivot) < 0) {
                swap(elements, k, i);
                i++;
            } else if (elements[k].compareTo(rightPivot) > 0) {
                while (elements[j].compareTo(rightPivot) > 0 && k < j) {
                    j--;
                }
                swap(elements, k, j);
                j--;
                if (elements[k].compareTo(leftPivot) < 0) {
                    swap(elements, k, i);
                    i++;
                }
            }
            k++;
        }

        swap(elements, low, i - 1);
        swap(elements, high, j + 1);

        return new int[]{i - 1, j + 1};
        //return null;
    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}