package Labs.Week_12;
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /* Retrieve a value associated with a given key */
    public Value get(Key key) {
        Node<Key, Value> x = root;              // 1

        while (x != null) {                     // 2
            int cmp = key.compareTo(x.key);     // 3
            if (cmp < 0) {                      // 4
                x = x.left;                     // 4
            } else if (cmp > 0) {               // 5
                x = x.right;                    // 5
            } else {                            // 6
                return x.value;                 // 6
            }
        }

        return null;                            // 7
    }

    /* Orient a (temporarily) right-leaning red link to lean left */
    private Node<Key, Value> rotateLeft(Node<Key, Value> h) {
        Node<Key, Value> x = h.right;               // 1
        h.right = x.left;                           // 2
        x.left = h;                                 // 3
        x.color = h.color;                          // 4
        h.color = RED;                              // 4
        h.size = 1 + size(h.left) + size(h.right);  // 5
        return x;                                   // 6
    }

    /* Orient a left-leaning red link to (temporarily) lean right */
    private Node<Key, Value> rotateRight(Node<Key, Value> h) {
        Node<Key, Value> x = h.left;                // 1
        h.left = x.right;                           // 2
        x.right = h;                                // 3
        x.color = h.color;                          // 4
        h.color = RED;                              // 4
        h.size = 1 + size(h.left) + size(h.right);  // 5
        return x;                                   // 6
    }

    /*  Split a (temporary) 4-node */
    private void flipColors(Node<Key, Value> h) {
        h.color = RED;              // 1
        h.right.color = BLACK;      // 2
        h.left.color = BLACK;       // 2
    }

    /* Return whether a given node has a red link */
    private boolean isRed(Node<Key, Value> x) {
        if (x == null) {            // 1
            return false;           // 1
        }
        return x.color == RED;      // 2
    }

    /* Add a value to the red-black tree under a given key */
    public void put(Key key, Value value) {
        root = put(root, key, value);                       // 1
        root.color = BLACK;                                 // 1
    }

    /* Private put() method */
    private Node<Key, Value> put(Node<Key, Value> h, Key key, Value value) {
        if (h == null) {                                    // 2
            return new Node<Key, Value>(key, value, RED);   // 2
        }

        int cmp = key.compareTo(h.key);                     // 3
        if (cmp < 0) {                                      // 4
            h.left = put(h.left, key, value);               // 4
        } else if (cmp > 0) {                               // 5
            h.right = put(h.right, key, value);             // 5
        } else {                                            // 6
            h.value = value;                                // 6
        }

        /* Color balancing */
        if (isRed(h.right) && !isRed(h.left)) {             // 7
            h = rotateLeft(h);                              // 7
        }
        if (isRed(h.left) && isRed(h.left.left)) {          // 8
            h = rotateRight(h);                             // 8
        }
        if (isRed(h.left) && isRed(h.right)) {              // 9
            flipColors(h);                                  // 9
        }

        h.size = 1 + size(h.left) + size(h.right);          // 10
        return h;                                           // 11
    }

    /* Return the size of the tree (total number of nodes) */
    public int size() {
        return size(root);
    }

    /* Private size() method */
    private int size(Node<Key, Value> x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }
}