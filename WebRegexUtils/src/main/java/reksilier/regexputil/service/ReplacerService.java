package reksilier.regexputil.service;

import reksilier.regexputil.service.replace.ReplacementResolver;

public interface ReplacerService {
	   
	String replaceSubStringsInText(String text, String replacingPart, ReplacementResolver replacementResolver);
	
}
