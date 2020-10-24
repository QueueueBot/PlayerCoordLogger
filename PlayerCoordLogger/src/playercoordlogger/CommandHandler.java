package playercoordlogger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandHandler implements CommandExecutor {
	
	// CommandSender sender - who sent the command
	// Command cmd - the command that was executed
	// String commandLabel - the command alias that was used
	// String[] args - an array of additional arguments, e.g. typing /hello abc def would put abc in args[0], and def in args[1]
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		System.out.println("asdfasdf");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "sender : " + sender.getName());
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "arg1 : " + arg1.getName());
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "arg2 : " + arg2);
		for(String s : arg3) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "s : " + s);
		}
		if (sender instanceof Player) {
            Player player = (Player) sender;
            // Create a new ItemStack (type: diamond)
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Create a new ItemStack (type: brick)
            ItemStack bricks = new ItemStack(Material.BRICK);

            // Set the amount of the ItemStack
            bricks.setAmount(20);

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(bricks, diamond);
		}
		
		return true;
	}
	
	
}