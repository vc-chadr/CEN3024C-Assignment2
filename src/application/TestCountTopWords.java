package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

//import com.sun.javafx.collections.MappingChange.Map;

public class TestCountTopWords {

	@Test
	public void test() {
		TextAnalyzer test = new TextAnalyzer();		
		
		LinkedHashMap<String, Integer> expectedMap = new LinkedHashMap<>();				
		expectedMap.put("C", 8);
		expectedMap.put("Java", 7);
		expectedMap.put("Python", 6);
		expectedMap.put("Javascript", 5);
		expectedMap.put("C++", 4);					
		expectedMap.put("Golang", 3);
		expectedMap.put("Pascal", 2);
		expectedMap.put("Basic", 1);		

		// Take our the keys from the LinkedHashMap (which maintains order) and save it to an array that we can iterate by index
		ArrayList<String> expectedKeys = new ArrayList<>();
		for (Entry<String, Integer> word : expectedMap.entrySet()) {			
			expectedKeys.add(word.getKey());			
		}			
		
		HashMap<String, Integer> map = new HashMap<>();		
		map.put("Basic", 1);
		map.put("C", 8);
		map.put("C++", 4);
		map.put("Java", 7);
		map.put("Python", 6);		
		map.put("Golang", 3);
		map.put("Javascript", 5);
		map.put("Pascal", 2);
		
		Map<String, Integer> sortedMap = test.countTopWords(map, map.size());
		
		int i = 0;
		for (Entry<String, Integer> word : sortedMap.entrySet()) {
			assertEquals(word.getKey(), expectedKeys.get(i));
			assertEquals(word.getValue(), expectedMap.get(expectedKeys.get(i)));
			i++;
		}
	}
}
