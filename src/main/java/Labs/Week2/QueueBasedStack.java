package Labs.Week2;

import java.util.NoSuchElementException;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;
    private int size = 0;
    public QueueBasedStack() {
        this.q1 = new Queue<>();
        this.q2 = new Queue<>();
    }

    public void push(Data data) {
        //int size = 0;
        q2.enqueue(data); // adding new "data" item to the q2
        size++;
    }

    public Data pop() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }  // we want to check if queue is empty and if it is we have to throw exception

        size--; // because the operation is about to remove an element from the queue.
        return q1.dequeue(); // we remove and return an element from the front of q1
                             // maintaining the FIFO principle

    }

    public Data peek() {
        return q1.peek(); // we can do the same as in previous method, check if queue is empty and if
                          // it is not we can then return q1.peek();
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
        // or second way we can do this is
        // return q1.isEmpty() && q2.isEmpty();
    }

}
