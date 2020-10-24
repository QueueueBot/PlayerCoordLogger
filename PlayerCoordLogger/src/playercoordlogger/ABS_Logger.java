package playercoordlogger;



abstract class ABS_Logger {
	
	
	private boolean status = false;
	
	public boolean getStatus() {
		return status;
	}
	
	public ABS_Logger() {
		status = Init();
	}
	
	abstract boolean Init();
	
	
	public abstract void doLog();
	
	public abstract void getLog(String s);
	
	
	
	

}
