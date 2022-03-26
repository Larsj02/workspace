package me.systemlars.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!p.hasPermission("system.team")) {
				p.sendMessage("§7[§4ERROR§7] §cDu hast keine Berechtigung für diesen Befehl!");
			}else {
				for(int i=0; i<100; ++i) {
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage("§7[§dClearChat§7] §eDer Chat wurde von "+p.getName()+" geleert!");
				return true;
			}
		}else {
			for(int i=0; i<100; ++i) {
				Bukkit.broadcastMessage("");
			}
			Bukkit.broadcastMessage("§7[§dClearChat§7] §eDer Chat wurde durch die Konsole geleert!");
			return true;
		}
		return true;
	}

}
