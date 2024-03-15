package Labs.Week3.Lecture;

public class MainWeek3 {
    public static void main(String[] args) {
        int[] elements = {5, -1, 7, 19, 3, 12, 4};

        BubbleSort.sort(elements);

        /* Print the elements */
        for (int i: elements) {
            System.out.println(i);
        }
    }
}

