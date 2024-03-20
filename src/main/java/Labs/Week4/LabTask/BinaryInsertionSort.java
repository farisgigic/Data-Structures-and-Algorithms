package Labs.Week4.LabTask;

//import Labs.Week1.Task1.LinkedList;
import Labs.Week4.LabTask.LinkedList;

public class BinaryInsertionSort {
    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        for(int i = 0; i < ll.count();i++){
            Data key = ll.get(i);
            int insertionPoint = findInsertionPoint(ll,i-1,key);
            ll.add(insertionPoint,key);
            }

    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        // your code here (next line is a placeholder)
        int low = 0;
        while(low <= high) {
            int mid = low +( high - low ) / 2;
            int cmp = key.compareTo(ll.get(mid));
            if(cmp == 0){
                return mid;
            }else if(cmp < 0 ) {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return low;
    }
}
