package Homework01;

import java.io.*;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String fileName) throws FileNotFoundException {


        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = reader.lines().toList(); // storamo sve u listu koju citamo iz fajla
            Entry[] returnThisArray = new Entry[lines.size() - 1];
            for (int i = 1; i < lines.size(); i++) {
                String[] split = lines.get(i).split(";"); // posto su razdvojeni ; tako ih i razdvajamo prilikom citanja i pisanja u novi fajl
                Entry entry1 = new Entry(split[0], split[1], split[2], split[3], split[4], split[5]); // nakon razdvajanja koristenjem ; uzimamo te podatke na oznacenim regexima i storamo u entry1
                returnThisArray[i - 1] = entry1;
            }

            reader.close();
            return returnThisArray;
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        // implement the actual logic

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for(Entry entry: entries) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s\n", entry.name, entry.streetAddress, entry.city, entry.postcode, entry.country, entry.phoneNumber));
        }
        writer.close();
    }
}