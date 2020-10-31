package playercoordlogger;

import java.util.Timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	// TODO [R : Reservation, C : Complete]
	// [C] Change cmd aliases "pcl" to "cl"
	// [R] Add Time Schedule to write logging
	// [R] Add shorted lookup cmd(latest 3d, around 10 blocks)
	// [R] Add detailed lookup cmd(by uuid, nickname, limit time, block range)
	
	private static final String Plugin_Name = "Player Coord Logger";
	private static final int config_version = 1;
	private FileConfiguration config = this.getConfig();
	public static Logger l;
	
	private int LoggingInterval;
	private boolean isDebug;
	
	Timer timer;
	LoggingScheduler ls;
	
	@Override
	public void onEnable(){
		setConfig();

		LoggingInterval = config.getInt("Logging Interval(second)");
		isDebug = config.getBoolean("Debug mode");
		
		l = new SQLite();
		getCommand("cl").setExecutor(new CommandHandler());
		if(Logger.Init()) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Database Successfully Init.");
		}
		else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Database Init Failed!!");
		}
		
		timer = new Timer();
		ls = new LoggingScheduler(isDebug);
		
		timer.scheduleAtFixedRate(ls, LoggingInterval * 1000, LoggingInterval * 1000);
	}
	
	@Override
	public void onDisable(){
		timer.cancel();
	}
	
	
	private void setConfig() {
		config.addDefault("Config Version", config_version);
		config.addDefault("Logging Interval(second)", 30);
		config.addDefault("Debug mode", false);
		config.options().copyDefaults(true);
		this.saveConfig();
	}
	

	
}
