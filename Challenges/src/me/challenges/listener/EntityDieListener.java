package me.challenges.listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.challenges.main.main;

public class EntityDieListener implements Listener {
	File file = new File("plugins/Challenges", "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	@EventHandler
	public void onEntityDead(EntityDeathEvent e) {
		if (e.getEntity() instanceof EnderDragon) {
			if (cfg.getBoolean("EnderDragonChallenge") == true) {
				Bukkit.broadcastMessage(main.Prefix+"§aDie Challenge wurde §2erfolgreich §aabgeschlossen.");
				Bukkit.broadcastMessage(main.Prefix+"Der §2Enderdrache §7ist gestorben.");
				Bukkit.broadcastMessage(main.Prefix+"Es wurden §2"+/*TODO Zeit*/" §7benötigt!");
				
				for(Player players : Bukkit.getOnlinePlayers()){
					players.setGameMode(GameMode.SPECTATOR);
	            }
			}
		} else if (e.getEntity() instanceof Wither) {
			if (cfg.getBoolean("WitherChallenge") == true) {
				Bukkit.broadcastMessage(main.Prefix+"§aDie Challenge wurde §2erfolgreich §aabgeschlossen.");
				Bukkit.broadcastMessage(main.Prefix+"Der §2Wither §7ist gestorben.");
				Bukkit.broadcastMessage(main.Prefix+"Es wurden §2"+/*TODO Zeit*/" §7benötigt!");
				
				for(Player players : Bukkit.getOnlinePlayers()){
					players.setGameMode(GameMode.SPECTATOR);
	            }
			}
		}
	}

}
