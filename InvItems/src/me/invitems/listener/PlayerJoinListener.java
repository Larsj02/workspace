package me.invitems.listener;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Inventory inv = p.getInventory();
		p.setAllowFlight(false);
		
		ItemStack FlyFeder = new ItemStack(Material.FEATHER);
		ItemMeta FFMeta = FlyFeder.getItemMeta();
		ArrayList<String> FFLore = new ArrayList<>();
		FFLore.add("§7§oLässt dich Fliegen!");
		FFLore.add("§7§oAnklicken zum Aktivieren.");
		FFMeta.setLore(FFLore);
		FFMeta.setDisplayName("§7Fliegen §aAktivieren");
		FlyFeder.setItemMeta(FFMeta);
		
		ItemStack Schild = new ItemStack(Material.REDSTONE);
		ItemMeta SMeta = Schild.getItemMeta();
		ArrayList<String> SLore = new ArrayList<>();
		SLore.add("§7§oHält andere Spieler von dir fern!");
		SLore.add("§7§oAnklicken zum Aktivieren.");
		SMeta.setLore(SLore);
		SMeta.setDisplayName("§7Schild §aAktivieren");
		Schild.setItemMeta(SMeta);
		
		ItemStack Schalter = new ItemStack(Material.LEVER);
		ItemMeta SCMeta = Schalter.getItemMeta();
		SCMeta.setDisplayName("§7Spieler Inv Befehl");
		Schalter.setItemMeta(SCMeta);
		
		if(p.hasPermission("Lobby.YT")) {
			inv.setItem(30, FlyFeder);
			inv.setItem(31, Schild);
			inv.setItem(32, Schalter);
		}
		if(p.hasPermission("Lobby.admin")) {
			inv.setItem(32, Schalter);
		}
	}

}
