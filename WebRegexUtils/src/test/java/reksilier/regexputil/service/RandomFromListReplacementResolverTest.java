package reksilier.regexputil.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import reksilier.regexputil.service.replace.NextNumberReplacementResolver;
import reksilier.regexputil.service.replace.RandomFromListReplacementResolver;
import reksilier.regexputil.service.replace.ReplacementResolver;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class RandomFromListReplacementResolverTest {
	
	public static final List<String> POSSIBLE_REPLACEMENTS = Arrays.asList("a", "b", "c");
	
	private ReplacementResolver testedSubject = new RandomFromListReplacementResolver(POSSIBLE_REPLACEMENTS);
	
	@Test(expected = IllegalArgumentException.class)
	public void failOnNullText() {
		new RandomFromListReplacementResolver(null);
	}
	
	@Test
	public void nextReplacementShouldBeFromListOnly() {
		for(int i = 0; i < 100; i++) {
			assertTrue(POSSIBLE_REPLACEMENTS.contains(testedSubject.nextReplacement()));
		}
	}
	
}
