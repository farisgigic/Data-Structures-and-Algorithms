package Labs.Week1.Task2;

public class DoublyLinkedList<Data> {

    private DoubleNode<Data> head;
    private DoubleNode<Data> tail;
    private int size;

    // DoubleNode class
    private static class DoubleNode<Data> {
        Data data;
        DoubleNode<Data> next;
        DoubleNode<Data> prev;

        DoubleNode(Data data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to add data at a given index
    public void add(int index, Data data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        DoubleNode<Data> newNode = new DoubleNode<>(data);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoubleNode<Data> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        size++;
    }

    // Method to remove data at a given index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            DoubleNode<Data> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    // Method to display the linked list
    public void display() {
        DoubleNode<Data> current = head;
        while (current != null) {
            System.out.print(current.data + " ↔ ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(0, 1); // Adding 1 at index 0
        list.add(1, 2); // Adding 2 at index 1
        list.add(2, 3); // Adding 3 at index 2
        list.add(3, 4); // Adding 4 at index 3

        System.out.print("Original List: ");
        list.display();

        list.add(2, 5); // Adding 5 at index 2
        System.out.print("After adding 5 at index 2: ");
        list.display();

        list.remove(2); // Removing element at index 2
        System.out.print("After removing element at index 2: ");
        list.display();
    }
}