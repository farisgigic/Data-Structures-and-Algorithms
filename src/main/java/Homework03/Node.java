package Homework03;

import java.util.ArrayList;

public class Node<Entry1> {
    public String key;
    public ArrayList<Entry1> values;
    public Node<Entry1> left, right;
    public boolean color;

    public Node(String key, Entry1 value) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
        this.left = null;
        this.right = null;
        this.color = true;
    }
}