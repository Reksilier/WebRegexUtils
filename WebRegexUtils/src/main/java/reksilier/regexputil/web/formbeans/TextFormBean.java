package reksilier.regexputil.web.formbeans;

public class TextFormBean {
	
	private String text = "";
	
	private String replacement = "";
	
	private int startingNumber = 1;
	
	private boolean descendingOrder;
	
	public TextFormBean() {
		// NOP
	}
	
	public TextFormBean(String text, String replacement, int startingNumber, boolean descendingOrder) {
		this.text = text;
		this.replacement = replacement;
		this.startingNumber = startingNumber;
		this.descendingOrder = descendingOrder;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("TextFormBean{");
		sb.append("descendingOrder=").append(descendingOrder);
		sb.append(", text='").append(text).append('\'');
		sb.append(", replacement='").append(replacement).append('\'');
		sb.append(", startingNumber=").append(startingNumber);
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
	
	public int getStartingNumber() {
		return startingNumber;
	}
	
	public void setStartingNumber(int startingNumber) {
		this.startingNumber = startingNumber;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
