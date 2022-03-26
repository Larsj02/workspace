package me.lobbysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lobbysystem.main.main;

public class BroadcastCommand implements CommandExecutor{
	
	String message = "";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("LobbySystem.Chat.Broadcast")) {
				if(args.length >=1) {
					for(int i = 0; i < args.length; i++) {
						message = message + args[i] + " ";
					}
					String newmessage = message.replace("~", "\n");
					String newnewmessage = newmessage.replace("&", "§");
					Bukkit.broadcastMessage("§m§l====================");
					Bukkit.broadcastMessage(newnewmessage);
					Bukkit.broadcastMessage("§m§l====================");
					Bukkit.broadcastMessage("Gesendet von "+p.getName());
					Bukkit.broadcastMessage("§m§l====================");
					message = "";
				}else {
					p.sendMessage(main.Fehler+"/broadcast <Nachricht>");
				}
			}else {
				p.sendMessage(main.NoPerm);
			}
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

}
