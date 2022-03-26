package me.challenges.listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.challenges.commands.SettingsCommand;

public class MenuClickListener implements Listener{
	
	File file = new File("plugins/Challenges", "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		if(e.getView().getTitle() == "§8» §e§lMenu") {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchadensanzeige §8[§aAktiv§8]")) {
				if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {	
					try {
						cfg.set("Schadensanzeige", false);
						cfg.save(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					ItemStack dmganzeige = new ItemStack(Material.RED_DYE);
					ItemMeta dmganzeigem = dmganzeige.getItemMeta();
					dmganzeigem.setDisplayName("§cSchadensanzeige §8[§4Inaktiv§8]");
					List<String> dmganzeigel = new ArrayList<String>();
					dmganzeigel.add("§1");
					dmganzeigel.add("§7Zeigt den §eSchaden §7und den §eScahdenstyp §7im Chat an");
					dmganzeigel.add("§1");
					dmganzeigel.add("§7[Klick] §eMenu öffnen");
					dmganzeigel.add("§7[Shift-Klick] §aAktivieren");
					dmganzeigel.add("§1");
					dmganzeigem.setLore(dmganzeigel);
					dmganzeige.setItemMeta(dmganzeigem);
					SettingsCommand.Menu.setItem(10, dmganzeige);
				}else {
					
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchadensanzeige §8[§4Inaktiv§8]")) {
				if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
					try {
						cfg.set("Schadensanzeige", true);
						cfg.save(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					ItemStack dmganzeige = new ItemStack(Material.GREEN_DYE);
					ItemMeta dmganzeigem = dmganzeige.getItemMeta();
					dmganzeigem.setDisplayName("§cSchadensanzeige §8[§aAktiv§8]");
					List<String> dmganzeigel = new ArrayList<String>();
					dmganzeigel.add("§1");
					dmganzeigel.add("§7Zeigt den §eSchaden §7und den §eScahdenstyp §7im Chat an");
					dmganzeigel.add("§1");
					dmganzeigel.add("§7[Klick] §eMenu öffnen");
					dmganzeigel.add("§7[Shift-Klick] §4Deaktivieren");
					dmganzeigel.add("§1");
					dmganzeigem.setLore(dmganzeigel);
					dmganzeige.setItemMeta(dmganzeigem);
					SettingsCommand.Menu.setItem(10, dmganzeige);
				}else {
					
				}
			}
			e.setCancelled(true);
		}
	}

}
