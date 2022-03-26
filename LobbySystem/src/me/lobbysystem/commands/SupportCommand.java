package me.lobbysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lobbysystem.main.main;

public class SupportCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			for(Player players : Bukkit.getOnlinePlayers()) {
				if(players.hasPermission("LobbySystem.Supporter")) {
					players.sendMessage(main.Prefix+p.getName()+" braucht Hilfe!");
				}
			}
			p.sendMessage(main.Prefix+"Ein Supporter wird sich in kürze bei dir Melden!");
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

}
