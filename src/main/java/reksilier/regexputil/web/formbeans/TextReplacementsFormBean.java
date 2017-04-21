package reksilier.regexputil.web.formbeans;

import java.util.ArrayList;
import java.util.List;

public class TextReplacementsFormBean {
	
	private String text = "";
	
	private String replacement = "";
	
	private List<String> replacings = new ArrayList<>();
	
	private boolean descendingOrder;
	
	public TextReplacementsFormBean() {
		replacings.add("");
	}
	
	public TextReplacementsFormBean(String text, String replacement, List<String> replacings, boolean descendingOrder) {
		this.text = text;
		this.replacement = replacement;
		this.replacings = replacings;
		this.descendingOrder = descendingOrder;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("TextFormBean{");
		sb.append("descendingOrder=").append(descendingOrder);
		sb.append(", text='").append(text).append('\'');
		sb.append(", replacement='").append(replacement).append('\'');
		sb.append(", replacings=").append(replacings);
		sb.append('}');
		return sb.toString();
	}
	
	public boolean isDescendingOrder() {
		return descendingOrder;
	}
	
	public void setDescendingOrder(boolean descendingOrder) {
		this.descendingOrder = descendingOrder;
	}
	
	public String getReplacement() {
		return replacement;
	}
	
	public void setReplacement(String replacements) {
		this.replacement = replacements;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public List<String> getReplacings() {
		return replacings;
	}
	
	public void setReplacings(List<String> replacings) {
		this.replacings = replacings;
	}
}
