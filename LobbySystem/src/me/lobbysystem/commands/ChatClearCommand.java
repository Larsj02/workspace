package me.lobbysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lobbysystem.main.main;

public class ChatClearCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!p.hasPermission("LobbySystem.Chat.Clear")) {
				p.sendMessage(main.NoPerm);
			}else {
				for(int i=0; i<100; ++i) {
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage(main.Prefix+"Der Chat wurde von "+p.getName()+" geleert!");
			}
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

}
