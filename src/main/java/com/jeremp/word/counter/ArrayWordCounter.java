
package com.jeremp.word.counter;

import java.util.Arrays;

/**
 * An implementation not relying on java Collections
 * @author jpasseron
 */
public class ArrayWordCounter implements WordCounter {
	
	public ArrayWordCounter() {
	}

	@Override
	public String produceReport(String inputText) {		
		String[] splited = splitWords(inputText);
		String[] distinctWords = retrieveDistinctWords( splited );
		Arrays.sort(distinctWords, WORD_LENGTH_COMPARATOR);
		
		int[] wordCounter = countWords(distinctWords, splited);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<distinctWords.length ; i++){
			sb.append(wordCounter[i]);
			sb.append(" ");
			sb.append(distinctWords[i]);
			sb.append("\n");
		}
		return sb.toString();		
	}


	
	/**
	 * Build an array containing all distinct words of a phrase
	 * @param inputText the given phrase
	 * @return 
	 */
	private String[] retrieveDistinctWords(String[] words) {		
		String[] result = new String[words.length];
		int firstFreeIndex = 0;
		for (String word : words) {
			int indexOfWord = findIndexOf(result, word);
			if (indexOfWord == -1) {
				result[firstFreeIndex] = word;
				firstFreeIndex++;
			}
		}
		// remove empty cells
		result = Arrays.copyOf(result, firstFreeIndex, String[].class);
		return result;
	}
	
	/**
	 * Find a word in a string array
	 * @param container the string array
	 * @param value the word to find
	 * @return the index where the word has been found, -1 otherwise
	 */
	private int findIndexOf(String[] container, String value){
		for(int i=0 ; i<container.length ; i++){
			String containedValue = container[i];
			if(containedValue!=null && containedValue.equals(value)){
				return i ;
			}
		}
		return -1; 
	}
	
	private int[] countWords(String[] words, String[] phrase){
		int[] result = new int[words.length];
		for (int indexWord = 0; indexWord < words.length; indexWord++) {
			result[indexWord] = countWord(words[indexWord], phrase);
		}
		return result;
	}
	
	private int countWord(String word, String[] phrase){
		int counter = 0 ;
		for(String s : phrase){
			if(s.equals(word)){
				counter++ ;
			}
		}
		return counter ;
	}
	
	private String[] splitWords(String phrase){
		if(phrase!=null && phrase.trim().length()>0){
			return phrase.split(" ");
		}else{
			return new String[0];
		}
	}
	
}
