package com.jeremp.word.counter;

/**
 *
 * @author jpasseron
 */
public class TextUtils {

	public static String removePointsAndCommaAndLineBreaks(String text){
		return text.replaceAll("\\.", "").replaceAll("\\,", "").replace("\n", "").replace("\r", "");
	}
	
}
