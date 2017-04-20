package reksilier.regexputil.service.replace;

import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Random;

public class RandomFromListReplacementResolver implements ReplacementResolver {
	
	private List<String> replacements;
	
	private Random rnd = new Random();
	
	public RandomFromListReplacementResolver(List<String> replacements) {
		Preconditions.checkArgument(replacements != null);
		this.replacements = replacements;
	}
	
	@Override
	public String nextReplacement() {
		if(replacements.isEmpty()) {
			return "";
		} else {
			return replacements.get(rnd.nextInt(replacements.size()));
		}
	}
	
	public List<String> getReplacements() {
		return replacements;
	}
	
	public void setReplacements(List<String> replacements) {
		this.replacements = replacements;
	}
}
