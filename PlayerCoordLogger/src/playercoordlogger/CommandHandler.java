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
	// Command cmd 			- the command that was executed
	// String commandLabel 	- the command alias that was used
	// String[] args 		- an array of additional arguments
	// e.g. typing /hello abc def would put abc in args[0], and def in args[1]
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(args.length == 0) {
			sender.sendMessage("\"" + cmd + "\"");
		}
		if (args.length == 1) {
			
			// Display Player's Status
			if (args[0].equals("me")) {
				now(sender);
			}
			
			// Display Random Status
			if (args[0].equals("rd")) {
				random(sender);
			}
			
			if (args[0].equals("o")) {
				// TODO
				// Shorted look-up cmd
			}
			
			// Enable Logging
			if (args[0].equals("on")) {
				LoggingScheduler.setEnable();
				sender.sendMessage("Start Logging");
			}
			
			// Disable Logging
			if (args[0].equals("off")) {
				LoggingScheduler.setDisable();
				sender.sendMessage("Stop Logging");
			}
			
			// Write Log Immediately
			if (args[0].equals("wnow")) {
				sender.sendMessage("Write Log Immediately");
				LoggingScheduler.doLogging();
			}
			
			// Display SQLite Status
			if (args[0].equals("report")) {
				for(String s : SQLite.getReport()) {
					sender.sendMessage(s);
				}
			}
		}
		else {
			sender.sendMessage("Unknown Command, type \"/"+ cmd +"\" or \"/" + cmd + " ?\" to showing help.");
			
		}

		return true;
	}

	// Print Players corrent coord data
	private void now(CommandSender s) {

		if (s instanceof Player) {
			Player p = (Player) s;
			SingleObjectPrinter(p, new OBJ_Record(p));
		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Client only command");

		}
	}

	// Print Random coord data
	private void random(CommandSender s) {

		if (s instanceof Player) {
			SingleObjectPrinter((Player) s, new OBJ_Record());

		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Client only command");

		}
	}

	// Data Printer
	private void SingleObjectPrinter(Player p, OBJ_Record r) {
		p.sendMessage("uuid : " + r.getUUID());
		p.sendMessage("Name : " + r.getNickname());
		p.sendMessage("x : " + r.getX());
		p.sendMessage("y : " + r.getY());
		p.sendMessage("z : " + r.getZ());
		p.sendMessage("dim : " + r.getDim());
		p.sendMessage("t : " + r.getTimestamp());
		p.sendMessage("pit : " + r.getPitch());
		p.sendMessage("yaw : " + r.getYaw());
	}

}