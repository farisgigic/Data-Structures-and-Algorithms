package Homework03;
import java.util.ArrayList;

public class RedBlackTree<Entry1> {
    private Node<Entry1> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;



    public ArrayList<Entry1> get(String searchableName) {
        Node<Entry1> x = root;
        int redEdges = 0;
        int blackEdges = 0;

        while (x != null) {
            int cmp = searchableName.compareTo(x.key);
            if (cmp < 0) {
                if (x.color == RED) redEdges++;
                else blackEdges++;
                x = x.left;
            } else if (cmp > 0) {
                if (x.color == RED) redEdges++;
                else blackEdges++;
                x = x.right;
            } else {
                System.out.println("Red edges on the path: " + redEdges);
                System.out.println("Black edges on the path: " + blackEdges);
                return x.values;
            }
        }
        return null;
    }


    public void put(String searchableName, Entry1 entry) {
            root = put(root, searchableName, entry);
            root.color = BLACK;
    }


    private Node<Entry1> put(Node<Entry1> h, String searchableName, Entry1 entry) {
        if (h == null) return new Node<>(searchableName, entry);

        int cmp = searchableName.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, searchableName, entry);
        else if (cmp > 0) h.right = put(h.right, searchableName, entry);
        else h.values.add(entry);
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2];
        countEdges(root, counts);
        return counts;
    }
    private void countEdges(Node<Entry1> x, int[] counts) {
        if (x == null) return;
        if (x.color == RED) counts[1]++;
        else counts[0]++;
        countEdges(x.left, counts);
        countEdges(x.right, counts);
    }
    private boolean isRed(Node<Entry1> x) {
        if (x == null) return false;
        return x.color == RED;
    }
    private Node<Entry1> rotateLeft(Node<Entry1> h) {
        Node<Entry1> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private Node<Entry1> rotateRight(Node<Entry1> h) {
        Node<Entry1> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private void flipColors(Node<Entry1> h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
}