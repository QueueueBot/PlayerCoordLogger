package playercoordlogger;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


class LoggingSchedule extends TimerTask{
	
	private Bukkit B;
	private int LoggingInterval;
	private boolean isDebug;
	
	public LoggingSchedule(Bukkit b, int interval, boolean isDebug) {
		this.B = b;
		this.LoggingInterval = interval;
		this.isDebug = isDebug;
	}

	@Override
	public void run() {
		@SuppressWarnings("deprecation")
		Player[] list = Bukkit.getOnlinePlayers();
		
	}
	
}
