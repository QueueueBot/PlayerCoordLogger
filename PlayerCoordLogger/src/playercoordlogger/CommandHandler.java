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

		if (args.length == 0) {

		}

		if (args.length == 1) {
			if (args[0].equals("now")) {
				now(sender);
			}
			if (args[0].equals("rd")) {
				random(sender);
			}
			if (args[0].equals("o")) {
				// TODO
				// Shorted look-up cmd
			}
		}

		return true;
	}

	private void now(CommandSender s) {

		if (s instanceof Player) {
			Player p = (Player) s;
			SingleObjectPrinter(p, new OBJ_Record(p));
		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Client only command");

		}
	}

	private void random(CommandSender s) {

		if (s instanceof Player) {
			SingleObjectPrinter((Player) s, new OBJ_Record());

		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Client only command");

		}
	}

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