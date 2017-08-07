package com.jeremp.word.counter;

import java.util.Comparator;

/**
 *
 * @author jpasseron
 */
public interface WordCounter {
	
	/**
	 * A Comparator to sort string by length (first) an alphabeticaly 
	 */
	public static final Comparator<String> WORD_LENGTH_COMPARATOR = (String a, String b) -> {
		if(a.length()!=b.length()){
			return a.length() - b.length() ;
		}else{
			return a.compareTo(b);
		}
	};
	
	/**
	 * Produce a word count report (sorted by word length then Ascii)
	 * @param inputText
	 * @return 
	 */
	public String produceReport(String inputText);

}
