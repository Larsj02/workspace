package me.systemlars.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("system.team")) {
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					p.openInventory(target.getInventory());
					
				}else {
					p.sendMessage("§7[§4ERROR§7] §c/invsee <spieler>");
				}
			}else {
				p.sendMessage("§7[§4ERROR§7] §cDu hast keine Berechtigung für diesen Befehl!");
			}
		}else {
			sender.sendMessage("[System]Der Befehl kann nur Ingame ausgeführt werden!");
		}
		return true;
	}

}
