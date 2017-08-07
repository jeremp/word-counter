package com.jeremp.word.counter;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author jpasseron
 */
public class WordCounterTest {

	private static final String INPUT = "The quick brown fox jumped over the lazy brown dog’s back" ;	
	private static final String EXPECTED_OUTPUT = "1 The\n"
				+ "1 fox\n"
				+ "1 the\n"
				+ "1 back\n"
				+ "1 lazy\n"
				+ "1 over\n"
				+ "2 brown\n"
				+ "1 dog’s\n"
				+ "1 quick\n"
				+ "1 jumped\n";
	
	private final WordCounter collectionWordCounter = new CollectionWordCounter();
	
	private final WordCounter arrayWordCounter = new ArrayWordCounter();
	
	private static String LONG_TEXT ;

	public WordCounterTest() throws IOException {
		LONG_TEXT = loadLongText();
	}
	
	
	
	@Test
	public void collectionWordCounterTest(){		
		Assert.assertEquals("", collectionWordCounter.produceReport(""));
		String report = collectionWordCounter.produceReport(INPUT) ;
		System.out.println("report with collection = \n"+report);
		Assert.assertEquals(EXPECTED_OUTPUT, report);
	}
	
	@Test
	public void withoutCollectionsTest(){
        Assert.assertEquals("", arrayWordCounter.produceReport(""));	
		String report = arrayWordCounter.produceReport(INPUT) ;
		System.out.println("report without collection = \n"+report);
		Assert.assertEquals(EXPECTED_OUTPUT, report);
	}
	
	@Test
	public void performancesTest(){
		long a = System.currentTimeMillis();
		System.out.println("long textReport with collection\n"+collectionWordCounter.produceReport(LONG_TEXT));
		long b = System.currentTimeMillis();
		System.out.println("collectionWordCounter processed long text in "+(b-a)+"ms");
		long c = System.currentTimeMillis();
		System.out.println(arrayWordCounter.produceReport(LONG_TEXT));
		long d = System.currentTimeMillis();
		System.out.println("arrayWordCounter processed long text in "+(d-c)+"ms");
				
	}
	
	private String loadLongText() throws IOException{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("longText.txt");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		IOUtils.copy(in, bos);
		String longText = bos.toString("UTF-8");
		return TextUtils.removePointsAndCommaAndLineBreaks(longText);
	}
	
}
