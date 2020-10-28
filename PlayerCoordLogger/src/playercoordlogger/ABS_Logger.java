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
	
	public abstract int writeLog(OBJ_Record r);
	
	public abstract int writeLog(ArrayList<OBJ_Record> list);
	
	public abstract int getLog(String s);
	
	
	
	
	

}
