package reksilier.regexputil.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import reksilier.regexputil.service.replace.NextNumberReplacementResolver;
import reksilier.regexputil.service.replace.ReplacementResolver;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ReplacerWithSequenceTest {
	
	private static final String DEFAULT_REPLACING_PART = "REPLACE";
	private RegexpReplacerService testSubject = new RegexpReplacerService();
	private ReplacementResolver defaultReplacementResolver = new NextNumberReplacementResolver();
	
	@Test(expected = IllegalArgumentException.class)
	public void failOnNullText() {
		testSubject.replaceSubStringsInText(null, "", defaultReplacementResolver);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void failOnNullReplacingPart() {
		testSubject.replaceSubStringsInText("", null, defaultReplacementResolver);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void failOnBothNullArguments() {
		testSubject.replaceSubStringsInText(null, null, defaultReplacementResolver);
	}
	
	@Test
	public void returnEmptyStringForEmptyText() {
		assertEquals("", testSubject.replaceSubStringsInText("", "", defaultReplacementResolver));
	}
	
	@Test
	public void returnEmptyStringForEmptyTextEvenWithReplacingPart() {
		assertEquals("", testSubject.replaceSubStringsInText("", DEFAULT_REPLACING_PART, defaultReplacementResolver));
	}
	
	@Test
	public void keepOriginalTextWhenEmptyReplacingPart() {
		assertEquals("text", testSubject.replaceSubStringsInText("text", "", defaultReplacementResolver));
	}
	
	@Test
	public void replaceSubStringWithNumber() {
		assertEquals("text1text", testSubject.replaceSubStringsInText("textREPLACEtext", DEFAULT_REPLACING_PART, defaultReplacementResolver));
	}
	
	@Test
	public void replaceTwoSubStringsWithNumbers() {
		assertEquals("text1text2", testSubject.replaceSubStringsInText("textREPLACEtextREPLACE", DEFAULT_REPLACING_PART, defaultReplacementResolver));
	}
	
	@Test
	public void replaceThreeSubStringsWithNumbers() {
		assertEquals("text1text23", testSubject.replaceSubStringsInText("textREPLACEtextREPLACEREPLACE", DEFAULT_REPLACING_PART, defaultReplacementResolver));
	}
	
	@Test
	public void replaceInTextWithLineDelimiterWithNumbers() {
		assertEquals("text1\n23", testSubject.replaceSubStringsInText("textREPLACE\n" + "REPLACEREPLACE", DEFAULT_REPLACING_PART, defaultReplacementResolver));
	}
	
	@Test
	public void replaceSubStringStartingFromGivenNumber() {
		ReplacementResolver nextNumberFrom5 = new NextNumberReplacementResolver(5);
		assertEquals("text5text", testSubject.replaceSubStringsInText("textREPLACEtext", DEFAULT_REPLACING_PART, nextNumberFrom5));
	}
	
	@Test
	public void replaceThreeSubStringsWithNumbersStartingFromGiven() {
		ReplacementResolver nextNumberFrom5 = new NextNumberReplacementResolver(5);
		assertEquals("text5text67", testSubject.replaceSubStringsInText("textREPLACEtextREPLACEREPLACE", DEFAULT_REPLACING_PART, nextNumberFrom5));
	}
}
