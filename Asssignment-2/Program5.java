import java.io.*;
import java.util.*;

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        HashMap<String, Integer> wordCount = new HashMap<>();

        try {
          
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            br.close();

            
            System.out.println("\nWord Occurrences:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found!");
        } catch (IOException e) {
            System.out.println("❌ Error reading file!");
        }

        sc.close();
    }
}
