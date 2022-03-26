package me.systemlars.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;


public class InventoryListener implements Listener{
	
	private main plugin;
	
	public InventoryListener(main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("§6Übersicht")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.ENDER_CHEST) {
				Inventory echest = p.getEnderChest();
				p.openInventory(echest);
			}
			if(e.getCurrentItem().getType() == Material.EMERALD) {
				plugin.inv = p.getServer().createInventory(null, 27, "§aBank-Übersicht");
				
				p.openInventory(plugin.inv);
			}
			if(e.getCurrentItem().getType() == Material.ENDER_PEARL) {
				plugin.inv = p.getServer().createInventory(null, 27, "§5Warps");
				
				p.openInventory(plugin.inv);
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND) {
				plugin.inv = p.getServer().createInventory(null, 54, "§bShop");
				
				p.openInventory(plugin.inv);
			}
		}
	}
}
