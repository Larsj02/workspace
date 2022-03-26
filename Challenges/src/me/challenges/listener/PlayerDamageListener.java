package me.challenges.listener;

import java.io.File;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerDamageListener implements Listener {

	File file = new File("plugins/Challenges", "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (cfg.getBoolean("Schadensanzeige") == true) {
				String dmgcause = e.getCause().toString();
				double dmg = e.getFinalDamage() / 2;
				Bukkit.broadcastMessage("§8| §aServer §8» §6" + p.getName() + " §7hat durch §6§l" + dmgcause + "§r §6"+ dmg + " §eHerzen §7Schaden bekommen!");
			}
			if (cfg.getBoolean("Schadenslöscher") == true) {
				Inventory PINV = p.getInventory();
				
				ItemStack phalter = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta phmeta = phalter.getItemMeta();
				phmeta.setDisplayName("§1");
				phalter.setItemMeta(phmeta);
				
				PINV.setItem(rndm_num(0, PINV.getSize()), phalter);
				PINV.remove(phalter);
			}
			//TODO DMG Multiplier
		}
	}
	private static int rndm_num(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
