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
	private boolean isDebug;
	
	
	@Override
	public void onEnable(){
		setConfig();

		LoggingInterval = config.getInt("Logging Interval(second)");
		isDebug = config.getBoolean("Debug mode");
		
		
		getCommand("pcl").setExecutor(new CommandHandler());
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + Plugin_Name + " �� Ȱ��ȭ �Ǿ����ϴ�.");
	}
	
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + Plugin_Name + " �� ��Ȱ��ȭ �Ǿ����ϴ�.");
	}
	
	
	private void setConfig() {
		config.addDefault("Config Version", config_version);
		config.addDefault("Logging Interval(second)", 30);
		config.addDefault("Debug mode", false);
		config.options().copyDefaults(true);
		this.saveConfig();
	}
	

	
}
