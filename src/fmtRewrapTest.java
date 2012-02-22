//fmtRewrapTest.java
//James Dressel
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)//Best practices would break this file into
		//multiple files, but I figured ease of grading trumps performance
public class fmtRewrapTest {
	
	String inputString;
	int width;
	String expected;

	
	public fmtRewrapTest(String inputString, int width, String expected){
		this.inputString = inputString;
		this.width = width;
		this.expected = expected;
	}
	
	@Parameterized.Parameters 
	public static Collection primeNumbers(){
		return Arrays.asList(new Object[][]{
				{"fox", 30, "fox\n"},
				{"box", 30, "box\n"}	
		});
	}
	
	@Test
	public void testSingleWord() {
		assertEquals(expected, fmtRewrap.fmtRewrap(inputString, width));
	}
		
	@Test
	public void testFmtRewrapLongSentence(){
		inputString = "This sentence is longer than the width so it should take multiple lines";
		width = 30;
		expected = "This sentence is longer than\nthe width so it should take\nmultiple lines\n";
		assertEquals(expected, fmtRewrap.fmtRewrap(inputString, width));
	}
	
	
	@Test
	public void testFmtRewrapWordLongerThanWidth(){
		inputString = "This sentence is longer than the width so it should take multiple lines";
		width = 5;
		expected = "This\nsentence\nis\nlonger\nthan\nthe\nwidth\nso\nit\nshould\ntake\nmultiple\nlines\n";
		assertEquals(expected, fmtRewrap.fmtRewrap(inputString, width));
	}
	
	@Test
	public void testFmtRewrapRedone(){
		inputString = "This sentence is longer than the width so it should take multiple lines";
		width = 5;
		expected = "This\nsentence\nis\nlonger\nthan\nthe\nwidth\nso\nit\nshould\ntake\nmultiple\nlines\n";
		String repeat = fmtRewrap.fmtRewrap(inputString, width);
		//Have only one newline at the end
		assertEquals(expected, fmtRewrap.fmtRewrap(repeat, width));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFmtRewrapZeroWidth(){
		inputString = "Fox";
		width = 0;
		fmtRewrap.fmtRewrap(inputString, width);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFmtRewrapNegativeWidth(){
		inputString = "Fox";
		width = -5;
		fmtRewrap.fmtRewrap(inputString, width);
	}
	
	@Test(expected=NullPointerException.class)
	public void testFmtRewrapNullInput(){
		width = 5;
		fmtRewrap.fmtRewrap(null, width);
	}
	
	@Test
	public void testFmtRewrapEmptyString(){
		inputString = "";
		width = 10;
		expected = "\n";
		assertEquals(expected, fmtRewrap.fmtRewrap(inputString, width));
	}

	@Test
	public void testNewlineInput(){
		inputString = "This\nline\nhas\nsome line breaks of its own. Does this break things?";
		width = 30;
		expected = "This\nline\nhas\nsome line\nbreaks of its own. Does this\nbreak things?\n";
		assertEquals(expected, fmtRewrap.fmtRewrap(inputString, width));
	}
	@Test
	public void testFmtRewrapSingleSpaceString(){
		inputString = " ";
		width = 10;
		expected = " \n";
		assertEquals(expected, fmtRewrap.fmtRewrap(inputString, width));
	}

	

}