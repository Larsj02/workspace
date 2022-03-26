package me.invitems.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.invitems.main.main;

public class InventoryClickListener implements Listener{
	
	@EventHandler
	public void oninv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = p.getInventory();
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Fliegen §aAktivieren")) {
				ItemStack FlyFeder = new ItemStack(Material.FEATHER);
				ItemMeta FFMeta = FlyFeder.getItemMeta();
				ArrayList<String> FFLore = new ArrayList<>();
				FFLore.add("§7§oHör auf zu Fliegen!");
				FFLore.add("§7§oAnklicken zum Deaktivieren.");
			    FFMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
			    FFMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
				FFMeta.setLore(FFLore);
				FFMeta.setDisplayName("§7Fliegen §cDeaktivieren");
				FlyFeder.setItemMeta(FFMeta);
				
				inv.setItem(30, FlyFeder);
				p.setAllowFlight(true);
				p.sendMessage(main.getPlugin().getConfig().getString("fly_activate"));
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Fliegen §cDeaktivieren")) {
				ItemStack FlyFeder = new ItemStack(Material.FEATHER);
				ItemMeta FFMeta = FlyFeder.getItemMeta();
				ArrayList<String> FFLore = new ArrayList<>();
				FFLore.add("§7§oLässt dich Fliegen!");
				FFLore.add("§7§oAnklicken zum Aktivieren.");
				FFMeta.setLore(FFLore);
				FFMeta.setDisplayName("§7Fliegen §aAktivieren");
				FlyFeder.setItemMeta(FFMeta);
				
				inv.setItem(30, FlyFeder);
				p.setAllowFlight(false);
				p.sendMessage(main.getPlugin().getConfig().getString("fly_deactivate"));
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Spieler Inv Befehl")) {
				Bukkit.getServer().dispatchCommand(p, "s inv");
			}
	}

}
