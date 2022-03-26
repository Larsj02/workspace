package me.logger.commands;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlaytimeCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("logger.playtime")) {
			if(args.length >=1) {
				Player target = Bukkit.getPlayer(args[0]);
				UUID uuid = target.getUniqueId();
					File file = new File("plugins/Logger/"+uuid, "time.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					int hours = cfg.getInt("Time.hours");
					int minutes = cfg.getInt("Time.minutes");
					
					sender.sendMessage("§m§l========================");
					sender.sendMessage("§l"+target.getName());
					sender.sendMessage("");
					sender.sendMessage("Playtime:");
					sender.sendMessage(hours+"Hour(s) and "+minutes+"Minute(s)");
					sender.sendMessage("§m§l========================");
				}
		}else {
			
		}
		return true;
	}

}
