package hw10.ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class WordFrequencyCounter {
    public static void main(String[] args) {
        String fileName = "/Users/galyna.gaponova/IdeaProjects/Test1/src/main/java/hw10/ex3/words.txt";
        Map<String, Integer> wordFrequencyMap = countWordFrequency(fileName);
        printWordFrequency(wordFrequencyMap);
    }

    public static Map<String, Integer> countWordFrequency(String fileName) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequencyMap;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequencyMap) {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequencyMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
