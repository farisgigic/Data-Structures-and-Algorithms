package Labs.Week_12;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<String, Integer> rbt = new RedBlackTree<>();

        rbt.put("T", 1);
        rbt.put("E", 2);
        rbt.put("X", 3);
        rbt.put("A", 4);
        rbt.put("R", 5);
        rbt.put("C", 6);
        rbt.put("H", 7);
        rbt.put("M", 8);

        System.out.println("R: " + rbt.get("R"));           // 5
        System.out.println("M: " + rbt.get("M"));           // 8
        System.out.println("X: " + rbt.get("X"));           // 3
    }
}

