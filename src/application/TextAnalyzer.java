package application;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TextAnalyzer {
	
    public Map<String, Integer> countTopWords(HashMap<String, Integer> map, Integer numElements) {
		// Reverse sort the map by value and limit the output to the desired number of elements
		Map<String, Integer> sortedMap = map.entrySet().stream()
			    .sorted(Entry.<String, Integer>comparingByValue().reversed())
			    .limit(numElements)
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		return sortedMap;
	}
			
	public void readFile(String filename, HashMap<String, Integer> map) {
        // Open input file and process words until done
        try {
            Scanner sc = new Scanner(new File(filename));
            
            // Grab one string at a time
            while (sc.hasNext()) {
            	String word = sc.next();
            	word = word.replaceAll("\\p{P}", "");  	// Replace all punctuation characters with regex
            	word = word.toLowerCase();				// force all words to lower case

            	if (map.containsKey(word)) {
            		map.put(word, map.get(word) + 1);	// Increment word hash by one
            	} else {
            		map.put(word, 1);					// Add a newly discoverd word
            	}            	      
            }
            sc.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("ERROR: Unable to open file '" + filename + "', please try another filename");
        }
	}   
}
