package Homework03;

import Homework01.Entry;

import java.io.*;
import java.util.Scanner;

public class FileUtils {
    public static RedBlackTree<Entry1> readFile(String filePath) throws FileNotFoundException {
        RedBlackTree<Entry1> tree = new RedBlackTree<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(";");

            String name = fields[0];
            String streetAddress = fields[1];
            String city = fields[2];
            String postcode = fields[3];
            String country = fields[4];
            String phoneNumber = fields[5];

            Entry1 entry = new Entry1(name, streetAddress, city, postcode, country, phoneNumber);
            tree.put(name, entry);
        }

        scanner.close();
        return tree;
    }
}