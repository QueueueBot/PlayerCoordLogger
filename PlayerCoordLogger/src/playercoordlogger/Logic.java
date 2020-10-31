package playercoordlogger;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


class LoggingScheduler extends TimerTask{
	

	private static boolean loggingEnabled = true;
	private static boolean isDebug = false;
	
	public LoggingScheduler(boolean iD) {
		isDebug = iD;
	}

	@Override
	public void run() {
		if(this.loggingEnabled) {
			
			if(isDebug) {
				Bukkit.getConsoleSender().sendMessage("[Debug] Start logging");
			}
			int res = doLogging();
			if(isDebug) {
				Bukkit.getConsoleSender().sendMessage("[Debug] Logging res : " + res);
			}
			else if(res != 0) {
				Bukkit.getConsoleSender().sendMessage("Logging res : " + res);
			}
		}
	}
	
	public static void toEnable() {
		loggingEnabled = true;
	}
	
	public static void toDisable() {
		loggingEnabled = false;
	}
	
	public static int doLogging() {
		@SuppressWarnings("deprecation")
		Player[] plist = Bukkit.getOnlinePlayers();
		return SQLite.writeAll(plist);
	}
	
	
}
