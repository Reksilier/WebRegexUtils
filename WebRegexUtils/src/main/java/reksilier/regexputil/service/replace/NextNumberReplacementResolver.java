package reksilier.regexputil.service.replace;

public class NextNumberReplacementResolver implements ReplacementResolver {
	
	private boolean descendingOrder;
	
	private int nextNumber;
	
	public NextNumberReplacementResolver() {
		nextNumber = 1;
	}
	
	public NextNumberReplacementResolver(int startingNumber) {
		this.nextNumber = startingNumber;
	}
	
	public NextNumberReplacementResolver(int startingNumber, boolean descendingOrder) {
		this.nextNumber = startingNumber;
		this.descendingOrder = descendingOrder;
	}
	
	@Override
	public String nextReplacement() {
		String replacement = String.valueOf(nextNumber);
		nextNumber = isDescendingOrder() ? nextNumber - 1 : nextNumber + 1;
		return replacement;
	}
	
	public boolean isDescendingOrder() {
		return descendingOrder;
	}
	
	public void setDescendingOrder(boolean descendingOrder) {
		this.descendingOrder = descendingOrder;
	}
	
	public int getNextNumber() {
		return nextNumber;
	}
	
	public void setNextNumber(int nextNumber) {
		this.nextNumber = nextNumber;
	}
}
