package me.buffhead.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerInteractListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getItem().getType() == Material.SKULL_ITEM) {
				e.setCancelled(true);
				ItemStack currhelm = p.getInventory().getHelmet();
				p.getInventory().setHelmet(e.getItem());
				if(currhelm!= null) {
					p.setItemInHand(currhelm);
				}
				
			}
		}
	}

}
