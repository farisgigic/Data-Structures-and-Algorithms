package Homework02;
// we need to implement many methods to help us

public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    public void addProcess(Process process) {

        if (pq.length == length + 1) {
            resize(2 * pq.length); // if array is full it doubles the size of the array by calling resize()
        }
        pq[++length] = process; // first we increment length and then process is inserted at the new process
        swim(length);
    }

    public Process runNextProcess() {

        Process min = pq[1]; // min process which is root of the heap at index 1
        swap(1, length--); // process at root is swapped with the last process, and after it is swapped length is decremented (length--)
        sink(1);  // this method moves the swapped process down the heap if necessary.
        pq[length + 1] = null; // last element is set to null da se ne izgubi negdje
        return min; // returns the process that was initially at the root
    }

    public Process peekNextProcess() {

        return pq[1]; // peeking first element
    }
    public boolean isEmpty() {
        //    if(length == 0 ){
        //      return true;
        //    }
        //    return false;
        return (length == 0);
    }

    public void resize(int capacity) {
        Process[] copy = new Process[capacity];
        for (int i = 1; i <= length; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    private void swim(int k) { // code from lab with small modifications, here we need bigger element not smaller, we will use bigger() instead of less() method
        while (k > 1 && bigger(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) { // code from lab
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && bigger(j, j + 1)) {
                j++;
            }
            if (!bigger(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
    private boolean less(int a, int b) { // code from lab

        return (pq[a].compareTo(pq[b]) < 0);
    }
    private boolean bigger(int a, int b) { // code from lab; modified

        return (pq[a].compareTo(pq[b]) > 0);
    }

    private void swap(int a, int b) { // method for swapping elements
        Process newOne = pq[a];
        pq[a] = pq[b];
        pq[b] = newOne;
    }
}
