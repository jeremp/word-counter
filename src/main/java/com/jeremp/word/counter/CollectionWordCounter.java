package com.jeremp.word.counter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * An implementation which rely on Java Collections
 * @author jpasseron
 */
public class CollectionWordCounter implements WordCounter {
	
	public CollectionWordCounter() {
	}
	
	@Override
	public String produceReport(String inputText) {
		
		Map<String, Integer> wordCountMap = buildMap(inputText);
		
		StringBuilder sb = new StringBuilder();
		for(String key : sortWordBy(wordCountMap.keySet(), WORD_LENGTH_COMPARATOR)){
			sb.append(wordCountMap.get(key));
			sb.append(" ");
			sb.append(key);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Build a map where keys are words and values are the number of occurence of this word in inputText
	 * @param inputText the texte to analyze
	 * @return 
	 */
	private Map<String, Integer> buildMap(String inputText){
		Map<String, Integer> wordMap = new HashMap<>();
		// never trust user input
		if(inputText!=null && inputText.trim().length()>0){
			String[] splitted = inputText.split(" ");			
			for(String word : splitted){
				Integer wordCount = wordMap.get(word);
				if(wordCount!=null){
					wordMap.put(word, wordCount+1);
				}else{
					wordMap.put(word, 1);
				}
			}
		}
		return wordMap ;
	}
	
	/**
	 * Sort a set of word with a given comparator
	 * @param words the set to sort
	 * @param comparator the comparator to use
	 * @return a sorted list
	 */
	private List<String> sortWordBy(Set<String> words, Comparator<String> comparator) {
		return words.stream().sorted(WORD_LENGTH_COMPARATOR).collect(Collectors.toList());
	}
	
}
