package me.challenges.listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.challenges.main.main;

public class PlayerDieListener implements Listener{
	File file = new File("plugins/Challenges", "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onDead(PlayerDeathEvent e) {
		Player p = (Player)e.getEntity().getPlayer();
		e.setDeathMessage(null);
		Bukkit.broadcastMessage("§c✞§6 "+p.getName()+" §7ist §6gestorben. §cFeelsBadMan §7in Chat! §c✞");
		if (cfg.getBoolean("TodChallenge") == true) {
			Bukkit.broadcastMessage(main.Prefix+"§eMit §6/reset §ekann die Karte zurückgesetzt werden");
			Bukkit.broadcastMessage(main.Prefix+"§6Für alle Zuschauer: Der Seed war");
			long Seed = p.getPlayer().getWorld().getSeed();
			Bukkit.broadcastMessage("§e"+Seed);
			for(Player players : Bukkit.getOnlinePlayers()){
				players.setGameMode(GameMode.SPECTATOR);
            }
			Bukkit.broadcastMessage(main.Prefix+"Bei §6"/*TODO ZEIT*/+" §7wurde die Challenge abgebrochen!");
		}

	}

}

