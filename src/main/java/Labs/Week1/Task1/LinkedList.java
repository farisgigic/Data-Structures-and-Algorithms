package Labs.Week1.Task1;

public class LinkedList<Data> {

    private Node head;
    private int size;

    // Node class
    private class Node {
        Data data;
        Node next;

        Node(Data data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to add data at a given index
    public void add(int index, Data data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    // Method to remove data at a given index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

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