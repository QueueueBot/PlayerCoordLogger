package playercoordlogger;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static final String Plugin_Name = "Player Coord Logger";
	
	
	@Override
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + Plugin_Name + " �� Ȱ��ȭ �Ǿ����ϴ�.");
	}
	
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + Plugin_Name + " �� ��Ȱ��ȭ �Ǿ����ϴ�.");
	}
	
	
	

	
	
}
