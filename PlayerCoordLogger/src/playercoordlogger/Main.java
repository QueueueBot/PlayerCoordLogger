package playercoordlogger;

import java.util.Timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	// TODO [R : Reservation, C : Complete]
	// [C] Change cmd aliases "pcl" to "cl"
	// [C] Add Time Schedule to write logging
	// [R] Add shorted lookup cmd(latest 3d, around 10 blocks)
	// [R] Add detailed lookup cmd(by uuid, nickname, limit time, block range)
	
	public static final String Plugin_Name = "Player Coord Logger";
	private static String Plugin_Directory = null;
	public static final int config_version = 1;
	private FileConfiguration config = this.getConfig();
	
	private int LoggingInterval;
	private boolean isDebug;
	
	Timer timer;
	LoggingScheduler ls;
	
	@Override
	public void onEnable(){
		setConfig();

		LoggingInterval = config.getInt("Logging Interval(second)");
		isDebug = config.getBoolean("Debug mode");
		Plugin_Directory = getDataFolder().getAbsolutePath();

		getCommand("cl").setExecutor(new CommandHandler());
		if(SQLite.Init()) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Database Successfully Init.");
		}
		else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ERROR] Database Init Failed!!");
			for(String s : SQLite.getReport()) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + s);
			}
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
	
	public static String getPluginDir() {
		return Plugin_Directory;
	}

	
}
