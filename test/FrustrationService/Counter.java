package FrustrationService;

public class Counter {
	private int counter;
	
	public Counter() {
		super();
		counter = 0;
	}
	
	public void increment() {
		counter++;
	}
	
	public Integer getCounter() {
		return counter;
	}
}
