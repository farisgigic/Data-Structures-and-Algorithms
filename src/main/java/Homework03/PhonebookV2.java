package Homework03;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args ) throws FileNotFoundException {
        System.out.println("Loading the entries");

        RedBlackTree<Entry1> tree = FileUtils.readFile("C:\\Users\\pc\\Desktop\\DataStructures\\raw_phonebook_data.csv");
        System.out.println("System is ready.");

        int[] numberOfEdges = tree.countRedAndBlackEdges();
        System.out.println("Total "  + "red edges " +"in the tree: " + numberOfEdges[1]);
        System.out.println("Total black edges in the tree: " + numberOfEdges[0] + "\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a name that you wish to search for, or -1 to exit:");
            String inputField = scanner.nextLine();
            if (inputField.equals("-1")) {
                System.out.println("Thank you for using the phonebook.");
                break;
            }

            ArrayList<Entry1> entries = tree.get(inputField);

            if (entries == null) {
                System.out.println("No entries with the given name exist in the phonebook.\n");
            } else {
                System.out.println("Entries found: " + entries.size() + "\n");
                for (Entry1 entry : entries) {
                    System.out.println(entry);
                }
            }
        }
        scanner.close();
    }
}
