package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	private static final Integer NUMBER_OF_TOP_WORDS = 20;
	
	public static void main(String[] args) {
		TextAnalyzer analyzer = new TextAnalyzer();        
    	HashMap<String, Integer> wordMap = new HashMap<>();

    	// Get filename from user
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	String filename = "";
        while (wordMap.isEmpty()) {
            System.out.printf("Enter filename to process (blank entry to quit): ");
            try {
            	filename = input.readLine();
            	if (filename.isEmpty()) {
            		System.out.println("Exiting program");
            		System.exit(0);
            	}            	
            	analyzer.readFile(filename, wordMap);
            	
            } catch (IOException e) {
                System.out.println("ERROR: " + e);
            }
        }    	
        
		// Sort the wordMap and display the results		
		Map<String, Integer> sortedMap = analyzer.countTopWords(wordMap, NUMBER_OF_TOP_WORDS);		
		System.out.println("\nTop " + NUMBER_OF_TOP_WORDS + " Words\n------------");
		printMap(sortedMap);        
	}
	
	public static void printMap(Map<String, Integer> map) {
		for (Entry<String, Integer> word : map.entrySet()) {
			System.out.println(word.getKey() + ": " + word.getValue());
		}				
	}	
}
