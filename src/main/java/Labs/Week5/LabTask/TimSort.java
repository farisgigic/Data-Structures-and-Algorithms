package Labs.Week5.LabTask;



public class TimSort {

    public static <Data extends Comparable<Data>> void sort(Data[] elements, int threshold) {
        // HINT: It is not possible to directly create a new generic array in Java,
        // so you can use this workaround - create a Comparable array and cast it
        // Data[] aux = (Data[]) new Comparable[elements.length];

        Data[] aux = (Data[]) new Comparable[elements.length];

        int runLength = calculateRunLength(elements.length, threshold);
        // 1 4 5 3 6 2 1 2 4 3 3 2


        for (int i = 0; i < elements.length; i += runLength) {
            insertionSort(elements, i, Math.min(runLength + i - 1, elements.length - 1));
        }

        for (int size = runLength; size < elements.length; size *= 2) {

            for (int low = 0; low < elements.length - size; low += size * 2) {
                int mid = size + low - 1;
                int high = Math.min(low + 2 * size - 1, elements.length - 1);
                merge(elements, aux, low, mid, high);
            }
        }

    }

    public static <Data extends Comparable<Data>> void insertionSort(Data[] elements, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low; j--) {
                if (elements[j].compareTo(elements[j - 1]) < 0) {
                    Data temp = elements[j - 1];
                    elements[j - 1] = elements[j];
                    elements[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static <Data extends Comparable<Data>> void merge(Data[] elements, Data[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = elements[k];
        }

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > high) {
                elements[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) > 0) {
                elements[k] = aux[j++];
            } else {
                elements[k] = aux[i++];
            }
        }
    }

    public static int calculateRunLength(int initialLength, int threshold) {
        int runLength = initialLength;
        int remainder = 0;
        while (runLength > threshold) {
            if (runLength % 2 == 1) {
                remainder = 1;
            }
            runLength /= 2;
        }
        return runLength + remainder;
}
}