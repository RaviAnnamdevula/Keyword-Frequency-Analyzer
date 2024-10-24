
package org.collectionsP;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // You can change the implementation by uncommenting the required analyzer
        KeyAnalyzer keyAnalyzer;

        // Use ListKeyAnalyzerImpl - Stores keywords in a List (allows duplicates)
        // keyAnalyzer = new ListKeyAnalyzerImpl();

        // Use SetKeyAnalyzerImpl - Stores keywords in a Set (no duplicates)
        // keyAnalyzer = new SetKeyAnalyzerImpl();

        // Use MapKeyAnalyzerImpl - Stores keywords in a Map with frequency count
        keyAnalyzer = new MapKeyAnalyzerImpl();

        // Reading keywords from a file
        String fileName = "keywords.txt"; // Make sure you have a file with this name in the same directory
        try {
            // Use BufferedReader to read file line by line
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String keyword;
            System.out.println("Reading keywords from the file: " + fileName);

            while ((keyword = reader.readLine()) != null) {
                keyAnalyzer.storedKeyword(keyword.trim());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Use case 1: Get all stored keywords (depending on the implementation)
        System.out.println("\nAll stored keywords:");
        List<String> allKeywords = keyAnalyzer.getAllKeyword();
        if (allKeywords != null) {
            for (String k : allKeywords) {
                System.out.println(k);
            }
        } else {
            System.out.println("This implementation does not support retrieving all keywords.");
        }

        // Use case 2: Get keyword frequencies (only works for MapKeyAnalyzerImpl)
        if (keyAnalyzer instanceof MapKeyAnalyzerImpl) {
            System.out.println("\nKeyword frequencies:");
            Map<String, Keyword> frequencies = keyAnalyzer.getKeyFrequencies();
            for (Map.Entry<String, Keyword> entry : frequencies.entrySet()) {
                System.out.println("Keyword: " + entry.getKey() + ", Count: " + entry.getValue().getCount());
            }
        }

        // Use case 3: Get top 5 most frequent keywords (only for MapKeyAnalyzerImpl)
        if (keyAnalyzer instanceof MapKeyAnalyzerImpl) {
            System.out.println("\nTop 5 most frequent keywords:");
            Map<String, Integer> top5 = keyAnalyzer.getTop5Records();
            for (Map.Entry<String, Integer> entry : top5.entrySet()) {
                System.out.println("Keyword: " + entry.getKey() + ", Frequency: " + entry.getValue());
            }
        }

        // Additional Use Cases:
        System.out.println("\nYou can also test with additional keywords by adding more entries in the file.");
    }
}

/*package org.collectionsP;

public class Client {
    public static void main(String[] args) {
        // KeyAnalyzer keyAnalyzer =  new ListKeyAnalyzerImpl();
        // KeyAnalyzer keyAnalyzer =  new SetKeyAnalyzerImpl();
        KeyAnalyzer keyAnalyzer =  new MapKeyAnalyzerImpl();
        keyAnalyzer.storedKeyword("pen");
        keyAnalyzer.storedKeyword("pencil");
        keyAnalyzer.storedKeyword("pen");
        keyAnalyzer.storedKeyword("pencil");
        keyAnalyzer.storedKeyword("laptop");
        keyAnalyzer.storedKeyword("mobile");
        keyAnalyzer.storedKeyword("hoodie");
        keyAnalyzer.storedKeyword("laptop");
        keyAnalyzer.storedKeyword("table");
//  comparator and  comparable
       // System.out.println(keyAnalyzer.getKeyFrequencies());
        System.out.println(keyAnalyzer.getTop5Records());
// Accessing data more frequently we use Arraylist
// insertion and deletion we use LinkedList frequently
    }
}*/
