package playercoordlogger;

import java.util.ArrayList;

abstract class ABS_Logger {
	
	
	private boolean status = false;
	
	public boolean getStatus() {
		return status;
	}
	
	public ABS_Logger() {
		status = Init();
	}
	
	abstract boolean Init();
	
	
	public abstract void writeLog(OBJ_Record r);
	
	public abstract void writeLog(ArrayList<OBJ_Record> list);
	
	public abstract void getLog(String s);
	
	
	
	
	

}
