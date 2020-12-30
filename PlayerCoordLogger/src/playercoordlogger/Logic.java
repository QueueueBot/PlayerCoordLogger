package playercoordlogger;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


class LoggingScheduler extends TimerTask{
	

	private static boolean loggingEnabled = true;
	private static boolean isDebug = false;
	
	public LoggingScheduler(boolean isDebug) {
		this.isDebug = isDebug;
	}

	@Override
	public void run() {
		// If loggingEnabled is true, Try to write Log 
		if(loggingEnabled) {
			doLogging();
		}
	}
	
	public static void setEnable() {
		loggingEnabled = true;
	}
	
	public static void setDisable() {
		loggingEnabled = false;
	}
	
	
	public static void doLogging() {
		// Print Log if Debug mode
		if(isDebug) {
			Bukkit.getConsoleSender().sendMessage("[Debug] Start logging");
		}
		@SuppressWarnings("deprecation")
		Player[] plist = Bukkit.getOnlinePlayers();
		int res = SQLite.writeAll(plist);
		
		if(isDebug) {
			Bukkit.getConsoleSender().sendMessage("[Debug] Logging res : " + res);
		}
		else if(res != 0) {
			Bukkit.getConsoleSender().sendMessage("Logging res : " + res);
		}
		
	}
	
}
