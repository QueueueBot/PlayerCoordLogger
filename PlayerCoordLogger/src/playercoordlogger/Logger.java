package playercoordlogger;

import java.util.ArrayList;

import org.bukkit.entity.Player;

class Logger {
	
	
	private static boolean isOpened = false;
	
	public static boolean getStatus() {
		return false;
	}
	
	public static boolean Init() {
		return false;
	}
	
	public static int writeLog(OBJ_Record r) {
		return -1;
	}
	
	public static int writeAll(Player[] plist) {
		return -1;
	}
	
	public static int writeLog(ArrayList<OBJ_Record> list) {
		return -1;
	}
	
	public static int getLog(String s) {
		return -1;
	}

}
