package playercoordlogger;

import java.util.ArrayList;

interface Logger {
	
	
	static boolean isOpened = false;
	
	public boolean getStatus();
	
	public static boolean Init() {
		return false;
	}
	
	public static int writeLog(OBJ_Record r) {
		return 0;
	}
	
	public static int writeLog(ArrayList<OBJ_Record> list) {
		return 0;
	}
	
	public static int getLog(String s) {
		return 0;
	}

}
