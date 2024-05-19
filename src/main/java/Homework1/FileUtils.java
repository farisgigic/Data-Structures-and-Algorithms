package Homework1;


import java.io.*;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws FileNotFoundException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));  // otvaramo reader i dajemo filePath proslijedjen metodi iz kojeg ce se citati
            List<String> lines = reader.lines().toList();
            Entry[] returnThisArray = new Entry[lines.size() - 1];
            for (int i = 1; i < lines.size(); i++) {
                String[] split = lines.get(i).split(";");
                Entry newEntry = new Entry(split[0], split[1], split[2], split[3], split[4], split[5]);
                returnThisArray[i - 1] = newEntry;
            }

            reader.close(); // obavezno zatvaranje reader-a
            return returnThisArray;
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for(Entry entry: entries) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s\n", entry.name, entry.streetAddress, entry.city, entry.postcode, entry.country, entry.phoneNumber));
        }
        writer.close();
    }
}