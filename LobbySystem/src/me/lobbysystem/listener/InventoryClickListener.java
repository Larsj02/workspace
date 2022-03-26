package me.lobbysystem.listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener{
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		if(p.hasPermission("LobbySystem.Interact")) {
			e.setCancelled(false);
		}else {
			e.setCancelled(true);
		}
		
		if(e.getInventory().getName().equalsIgnoreCase("§cNavigator")) {
			if(p.hasPermission("LobbySystem.Interact")){
				e.setCancelled(true);
			}
			try {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCitybuild")) {
					p.teleport(new Location(p.getWorld(), 114 ,71 ,-96.5));
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSurvivalGames")) {
					p.teleport(new Location(p.getWorld(), 76, 70 ,-142.5));
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Spawn")) {
					p.teleport(new Location(p.getWorld(), 113, 70, -143.5));
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Bedwars")) {
					p.teleport(new Location(p.getWorld(), 113 ,70 ,-184.5));
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Event")) {
					
				}
			}catch(Exception ex) {
				
			}
		}
	}

}
