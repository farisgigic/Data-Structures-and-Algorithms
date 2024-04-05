package Labs.Week6;




import Labs.Week3.Lecture.BubbleSort;
import Labs.Week4.Lecture.InsertionSort;
import Labs.Week4.Lecture.SelectionSort;
import Labs.Week4.Lecture.ShellSort;
import Labs.Week5.BottomUpMergeSort;
import Labs.Week5.MergeSort;

import java.util.Random;

public class EmpiricalAnalysis {
    public static void main(String[] args) {
        int arraySize = 10000000;
        // Change the algorithm ("bubble", "selection", "insertion", "shell", "merge-rec", "merge-iter", "quick") and the number of elements
        runAndMeasureSortAlgorithm("quick", arraySize);
    }

    public static void runAndMeasureSortAlgorithm(String algorithm, int arraySize) {
        int[] elements = generateArray(arraySize);

        long start = System.currentTimeMillis(); // start measuring time
        int index;
        switch (algorithm) {
            case "bubble":
                BubbleSort.sort(elements);
                //BubbleSort.sort(elements);
                break;
            case "selection":
                SelectionSort.sort(elements);
                //SelectionSort.sort(elements);
                break;
            case "insertion":
                InsertionSort.sort(elements);
                //InsertionSort.sort(elements);
                break;
            case "shell":
                ShellSort.sort(elements);
                //ShellSort.sort(elements);
                break;
            case "merge-rec":
                MergeSort.sort(elements);
                MergeSort.sort(elements);
                break;
            case "merge-iter":
                BottomUpMergeSort.sort(elements);
                //BottomUpMergeSort.sort(elements);
                break;
            case "quick":
                QuickSort.sort(elements);
                //QuickSort.sort(elements);
                break;
            default:
                System.out.println("Invalid algorithm selected. Use 'bubble', 'selection', 'insertion', 'shell', 'merge-rec', 'merge-iter' or 'quick'.");
                return;
        }

        long timeElapsed = System.currentTimeMillis() - start;
        System.out.println("Elapsed time for " + algorithm + " sort on " + arraySize + " elements: " + timeElapsed + " ms");
    }

    /**
     * Generate an array of random integers with a given size.
     * @param size
     */
    public static int[] generateArray(int size) {
        int[] elements = new int[size];

        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Random().nextInt(size * 10);
        }

        return elements;
    }
}