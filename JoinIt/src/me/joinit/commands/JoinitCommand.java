package me.joinit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.joinit.main.main;

public class JoinitCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String noperm = main.getPlugin().getConfig().getString("JoinIt.nopermission");
		if(args.length == 1) {
			if(sender.hasPermission("Joinit.reload")) {
				main.getPlugin().reloadConfig();
				sender.sendMessage("§8[§bJoinIt§8] §fThe Config was reloaded successfully!");
			}else {
				sender.sendMessage(noperm);
			}
		}else {
			sender.sendMessage("§b§l§m==============================");
			sender.sendMessage("§a/Autojoin <Gamemode>");
			sender.sendMessage("§2Join the Fullest Server with that Gamemode.");
			sender.sendMessage("");
			sender.sendMessage("§a/Join <Gamemode> §6[<MapName>]");
			sender.sendMessage("§2Open the Overview GUI.");
			sender.sendMessage("§6Join the Fullest Server with that MapName.");
			sender.sendMessage("");
			sender.sendMessage("§a/Gamelist");
			sender.sendMessage("§2Get a list of all existing Gamemodes.");
			sender.sendMessage("");
			sender.sendMessage("§a/Joinit §6[<reload>]");
			sender.sendMessage("§aGet a Plugin Overview.");
			sender.sendMessage("§6Reload the Plugin.");
			sender.sendMessage("§b§l§m==============================");
		}
		return true;
	}

}
