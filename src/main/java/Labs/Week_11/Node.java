package Labs.Week_11;

import com.sun.jdi.Value;


public class Node<Key extends Comparable<Key>, Value> {

    public Key key;							// the node's key
    public Value value;						// the value associated with the key
    public Node<Key, Value> left, right;	// references to the left and right child
    public int size = 1;					// size of the node

    /* Node constructor */
    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}