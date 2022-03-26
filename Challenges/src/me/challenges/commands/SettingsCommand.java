package me.challenges.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.challenges.main.main;

public class SettingsCommand implements CommandExecutor {
	File file = new File("plugins/Challenges", "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static Inventory Menu;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p =(Player)sender;
			Menu = p.getServer().createInventory(null, 36,"§8» §e§lMenu");
			
			
			ItemStack phalter = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
			ItemMeta phmeta = phalter.getItemMeta();
			phmeta.setDisplayName("§1");
			phalter.setItemMeta(phmeta);
			Menu.setItem(0, phalter);
			Menu.setItem(1, phalter);
			Menu.setItem(2, phalter);
			Menu.setItem(3, phalter);
			Menu.setItem(4, phalter);
			Menu.setItem(5, phalter);
			Menu.setItem(6, phalter);
			Menu.setItem(7, phalter);
			Menu.setItem(8, phalter);
			Menu.setItem(9, phalter);
			Menu.setItem(13, phalter);
			Menu.setItem(14, phalter);
			Menu.setItem(15, phalter);
			Menu.setItem(17, phalter);
			Menu.setItem(18, phalter);
			Menu.setItem(19, phalter);
			Menu.setItem(20, phalter);
			Menu.setItem(21, phalter);
			Menu.setItem(22, phalter);
			Menu.setItem(23, phalter);
			Menu.setItem(24, phalter);
			Menu.setItem(25, phalter);
			Menu.setItem(26, phalter);
			Menu.setItem(27, phalter);
			Menu.setItem(28, phalter);
			Menu.setItem(29, phalter);
			Menu.setItem(30, phalter);
			Menu.setItem(31, phalter);
			Menu.setItem(32, phalter);
			Menu.setItem(33, phalter);
			Menu.setItem(34, phalter);
			Menu.setItem(35, phalter);
			
			
			//Schadensanzeige Item
			if(cfg.getBoolean("Schadensanzeige")==true) {
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
				Menu.setItem(10, dmganzeige);
			}else {
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
				Menu.setItem(10, dmganzeige);
			}
			
			//Das Schadenslöscher Item
			if(cfg.getBoolean("Schadenslöscher")==true) {
				ItemStack dmglöscher = new ItemStack(Material.LAVA_BUCKET);
				ItemMeta dmglöscherm = dmglöscher.getItemMeta();
				dmglöscherm.setDisplayName("§cSchadenslöscher §8[§aAktiv§8]");
				List<String> dmglöscherl = new ArrayList<String>();
				dmglöscherl.add("§1");
				dmglöscherl.add("§7Leert bei §eSchaden §7einen §eSlot");
				dmglöscherl.add("§1");
				dmglöscherl.add("§7[Klick] §eMenu öffnen");
				dmglöscherl.add("§7[Shift-Klick] §4Deaktivieren");
				dmglöscherm.setLore(dmglöscherl);
				dmglöscher.setItemMeta(dmglöscherm);
				Menu.setItem(11, dmglöscher);
			}else {
				ItemStack dmglöscher = new ItemStack(Material.BUCKET);
				ItemMeta dmglöscherm = dmglöscher.getItemMeta();
				dmglöscherm.setDisplayName("§cSchadenslöscher §8[§4Inktiv§8]");
				List<String> dmglöscherl = new ArrayList<String>();
				dmglöscherl.add("§1");
				dmglöscherl.add("§7Leert bei §eSchaden §7einen §eSlot");
				dmglöscherl.add("§1");
				dmglöscherl.add("§7[Klick] §eMenu öffnen");
				dmglöscherl.add("§7[Shift-Klick] §aAktivieren");
				dmglöscherl.add("§1");
				dmglöscherm.setLore(dmglöscherl);
				dmglöscher.setItemMeta(dmglöscherm);
				Menu.setItem(11, dmglöscher);
			}
			
			ItemStack undefined = new ItemStack(Material.BARRIER);
			ItemMeta undefinedm = undefined.getItemMeta();
			undefinedm.setDisplayName("§cUndefiniert");
			List<String> undefinedl = new ArrayList<String>();
			undefinedl.add("§1");
			undefinedl.add("§cDies ist zur Zeit deaktiviert");
			undefinedl.add("§1");
			undefinedm.setLore(undefinedl);
			undefined.setItemMeta(undefinedm);
			Menu.setItem(12, undefined);
			
			ItemStack einstellungen = new ItemStack(Material.REDSTONE_TORCH);
			ItemMeta einstellungenm = einstellungen.getItemMeta();
			einstellungenm.setDisplayName("§e§lEinstellungen");
			List<String> einstellungenl = new ArrayList<String>();
			einstellungenl.add("§1");
			einstellungenl.add("§7Stelle verschiedene §eMöglichkeiten §7ein");
			einstellungenl.add("§1");
			einstellungenm.setLore(einstellungenl);
			einstellungen.setItemMeta(einstellungenm);
			Menu.setItem(16, einstellungen);
			
			p.openInventory(Menu);
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

}