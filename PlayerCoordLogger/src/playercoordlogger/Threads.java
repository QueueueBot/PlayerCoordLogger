package playercoordlogger;

public class Threads extends Thread {
	// Time Scheduling, Generate Logging Events
	
	private static boolean Switch = false;
	private int interval;
	
	
	public Threads(int interval) {
		// Constructor
		this.interval = interval;
		
		Switch = true;
	}
	
	
	
	public void run() {
		// Just do return if instance is not init successfully
		if(!Switch) return;
		
		
		
		
		
		
		
		
	}
	

}
