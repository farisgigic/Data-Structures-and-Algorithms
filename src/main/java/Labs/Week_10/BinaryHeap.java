package Labs.Week_10;

import javax.xml.crypto.Data;

public class BinaryHeap<Data extends Comparable<Data>>{
    @SuppressWarnings({ "unchecked" })
    public Data[] pq = (Data[]) new Comparable[2];
    public int length = 0;

    /* Insert a new element into the priority queue */
    public void insert(Data data) {
        if (pq.length == length + 1) {          // 1
            resize(2 * pq.length);              // 1
        }
        pq[++length] = data;                    // 2
        swim(length);                           // 3
    }

    /* Node promotion:
     * swim up a node to its correct position */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {     // 1
            swap(k, k/2);                   // 2
            k = k/2;                        // 3
        }
    }

    /* Remove the maximum (max. priority) item  */
    public Data delMax() {
        Data max = pq[1];                               // 1
        swap(1, length--);                              // 2
        pq[length + 1] = null;                          // 3

        if (length > 0 && length == pq.length / 4) {    // 4
            resize(pq.length / 2);                      // 4
        }

        sink(1);                                        // 5
        return max;                                     // 6
    }

    /* Node demotion:
     * sink down a node to its correct position */
    private void sink(int k) {
        while (2*k <= length) {                     // 1
            int j = 2 * k;                          // 2
            if (j < length && less(j, j + 1)) {     // 2
                j++;                                // 2
            }

            if (!less(k, j)) {                      // 3
                break;                              // 3
            }

            swap(k, j);                             // 4
            k = j;                                  // 5
        }
    }

    /* Check if the priority queue is empty */
    public boolean isEmpty() {
        return length == 0;
    }

    /* Return the current size of the priority queue */
    public int size() {
        return length;
    }

    /* Create a new internal array with a given capacity */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Data[] copy = (Data[]) new Comparable[capacity];        // 1
        for (int i = 1; i <= length; i++) {                     // 2
            copy[i] = pq[i];                                    // 2
        }
        pq = copy;                                              // 3
    }

    /* Check which of the two elements is smaller */
    private boolean less(int a, int b) {

        return pq[a].compareTo(pq[b]) < 0;
    }

    /* Swap the array elements at provided indexes */
    private void swap(int a, int b) {
        Data temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }
}
