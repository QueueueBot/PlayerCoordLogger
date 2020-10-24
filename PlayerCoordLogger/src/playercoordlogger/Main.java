package playercoordlogger;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static final String Plugin_Name = "Player Coord Logger";
	private static final int config_version = 1;
	private FileConfiguration config = this.getConfig();
	
	private int LoggingInterval;
	
	private Threads t;
	
	
	@Override
	public void onEnable(){
		setConfig();

		LoggingInterval = config.getInt("Logging Interval(second)");
		t = new Threads(LoggingInterval);
		
		getCommand("pcl").setExecutor(new CommandHandler());
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + Plugin_Name + " 가 활성화 되었습니다.");
	}
	
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + Plugin_Name + " 가 비활성화 되었습니다.");
	}
	
	
	private void setConfig() {
		config.addDefault("Config Version", config_version);
		config.addDefault("Logging Interval(second)", 30);
		config.addDefault("Log when Dead", true);
		
		config.addDefault("Log when Join", true);
		config.addDefault("Log when Quit", true);
		config.options().copyDefaults(true);
		this.saveConfig();
	}
	
}
