package Labs.Week3.Lecture;

public class LinearSearch {
    public static int search (int[] elements, int key) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
