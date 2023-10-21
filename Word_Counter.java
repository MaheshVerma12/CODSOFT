import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Word_Counter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String inputText = scanner.nextLine();

        // To split the input text into an array of words using space and punctuation as delimiters
        String[] words = inputText.split("[\\s\\p{Punct}]+");

        // To initialize a counter variable for total words
        int totalWordCount = 0;

        // To initialize a map to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        // To iterate through the array of words, count total words and repeated words
        for (String word : words) {
            if (!word.isEmpty()) {
                totalWordCount++;

                // To count repeated words
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    wordCounts.put(word, 1);
                }
            }
        }

        System.out.println("Total count of words: " + totalWordCount);

        // To display number of repeated words
        System.out.println("Number of repeated words:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        scanner.close();
    }
}