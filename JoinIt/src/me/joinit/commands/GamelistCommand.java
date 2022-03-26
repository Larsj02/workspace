package me.joinit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.joinit.main.main;

public class GamelistCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int size = main.getPlugin().getConfig().getConfigurationSection("GameModes").getKeys(false).size();
		int gmodessize = 0;
		sender.sendMessage("");
		sender.sendMessage("§b§l§m===============");
		sender.sendMessage("There are "+size+" different");
		sender.sendMessage("Gamemodes at the moment.");
		for(String gamemodes : main.getPlugin().getConfig().getConfigurationSection("GameModes").getKeys(false)) {
			gmodessize ++;
			sender.sendMessage(gmodessize+") "+gamemodes);
		}
		sender.sendMessage("§b§l§m===============");
		gmodessize = 0;
		return true;
	}

}
