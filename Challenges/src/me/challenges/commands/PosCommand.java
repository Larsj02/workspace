package me.challenges.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.challenges.main.main;

public class PosCommand implements CommandExecutor {
	File file = new File("plugins/Challenges", "positions.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length ==1) {
				String posname = args[0];
				int x = (int) p.getLocation().getX();
				int y = (int) p.getLocation().getY();
				int z = (int) p.getLocation().getZ();
				p.sendMessage(main.Prefix+"Die §aPosition §7wurde §2erstellt");
				Bukkit.broadcastMessage(main.Prefix+"§2"+posname+" §7bei §aX="+x+" Y="+y+" Z="+z);
				
				cfg.set("Positionen."+posname+".x", x);
				cfg.set("Positionen."+posname+".y", y);
				cfg.set("Positionen."+posname+".z", z);
				
				try {
					cfg.save(file);
				} catch (IOException e) {
					p.sendMessage(main.Fehler+"Es ist ein Fehler beim Speichern aufgetreten! Probier es erneut.");
				}
			}else {
				try {
					int size = cfg.getConfigurationSection("Positionen").getKeys(false).size();
					sender.sendMessage(main.Prefix+"§7Es gibt §2"+size+" §7gespeicherte §aPositonen:");
					for(String posnames : cfg.getConfigurationSection("Positionen").getKeys(false)) {
						int cfgx = cfg.getInt("Positionen."+posnames+".x");
						int cfgy = cfg.getInt("Positionen."+posnames+".y");
						int cfgz = cfg.getInt("Positionen."+posnames+".z");
						sender.sendMessage(main.Prefix+"§a"+posnames+"§7 ( X=§2"+cfgx+"§7, Y=§2"+cfgy+"§7, Z=§2"+cfgz);
					}
				} catch (Exception e) {
					p.sendMessage(main.Fehler+" Es wurde noch keine Position hinzugefügt! Probier es mit /pos <Name>");
				}
			}
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

}