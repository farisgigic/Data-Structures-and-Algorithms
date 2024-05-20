package Homework01;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int left = 0; // current search range
        int right = entries.length - 1; // current search range
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // binary search main formula for getting midd element

            if (entries[mid].name.compareTo(searchableName) == 0) {

                firstOccurrence = mid;
                lastOccurrence = mid; // If the middle element's name matches the searchableName, both firstOccurrence and lastOccurrence are initially set to the midd index.


                int tempLeft = mid;
                while (tempLeft > left && entries[tempLeft - 1].name.compareTo(searchableName) == 0) {
                    firstOccurrence = --tempLeft; // The loop continues moving tempLeft left until it either reaches the start of the array (left) or finds an element that does not match searchableName.
                }


                int tempRight = mid;
                while (tempRight < right && entries[tempRight + 1].name.compareTo(searchableName) == 0) { // tempRight starts at mid and moves rightward to find the last occurrence of searchableName.
                    lastOccurrence = ++tempRight;
                }

                break;
            } else if (entries[mid].name.compareTo(searchableName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (firstOccurrence == -1) {
            return new int[]{}; // If no occurrence was found (firstOccurrence remains -1), an empty array is returned.
        }

        return new int[]{firstOccurrence, lastOccurrence}; // If occurrences were found, an array containing the indices of the first and last occurrences is returned.
    }
}