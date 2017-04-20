package reksilier.regexputil.service;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import reksilier.regexputil.service.replace.ReplacementResolver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("regexpReplacerService")
public class RegexpReplacerService implements ReplacerService {
	
	@Override
	public String replaceSubStringsInText(String text, String replacingPart, ReplacementResolver replacementResolver) {
		checkArguments(text, replacingPart);
		return modifyInputText(text, replacingPart, replacementResolver);
	}
	
	private String modifyInputText(String text, String replacingPart, ReplacementResolver replacementResolver) {
		if (notNeedModifications(text, replacingPart)) {
			return text;
		} else {
			return replaceSubStrings(text, replacingPart, replacementResolver);
		}
	}
	
	private boolean notNeedModifications(String text, String replacingPart) {
		return text.isEmpty() || replacingPart.isEmpty();
	}
	
	private String replaceSubStrings(String text, String replacingPart, ReplacementResolver replacementResolver) {
		Pattern subStringPattern = Pattern.compile(replacingPart);
		Matcher textMatcher = subStringPattern.matcher(text);
		StringBuffer result = new StringBuffer();
		while (textMatcher.find()) {
			textMatcher.appendReplacement(result, replacementResolver.nextReplacement());
		}
		textMatcher.appendTail(result);
		return result.toString();
	}
	
	private void checkArguments(String text, String replacingPart) {
		Preconditions.checkArgument(text != null);
		Preconditions.checkArgument(replacingPart != null);
	}
}
