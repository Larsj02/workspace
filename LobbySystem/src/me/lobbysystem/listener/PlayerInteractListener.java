package me.lobbysystem.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.lobbysystem.main.main;

public class PlayerInteractListener implements Listener{
	
	public static ArrayList<String> HideShow = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("LobbySystem.Interact")) {
			e.setCancelled(false);
		}else {
			e.setCancelled(true);
		}
		
		try {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNavigator §7(Rechtsklick)")) {
					if(p.hasPermission("LobbySystem.Interact")){
						e.setCancelled(true);
					}
					Inventory inv = Bukkit.createInventory(null, 27,"§cNavigator");
					
					ItemStack Citybuild = new ItemStack(Material.DIAMOND_AXE);
					ItemMeta CMeta = Citybuild.getItemMeta();
					ArrayList<String> CLore = new ArrayList<>();
					CLore.add("§7§oBau dein Eigenes Grundstück");
					CLore.add("§7§ound handel mit anderen Spielern.");
					CMeta.setLore(CLore);
					CMeta.setDisplayName("§aCitybuild");
					Citybuild.setItemMeta(CMeta);
					
					ItemStack SurvivalGames = new ItemStack(Material.STONE_SWORD);
					ItemMeta SGMeta = SurvivalGames.getItemMeta();
					ArrayList<String> SGLore = new ArrayList<>();
					SGLore.add("§7§oStelle dich anderen Spielern in einem PVP Spiel");
					SGLore.add("§7§oDoch nur der letzte überlebende Gewinnt.");
					SGMeta.setLore(SGLore);
					SGMeta.setDisplayName("§cSurvivalGames");
					SurvivalGames.setItemMeta(SGMeta);
					
					ItemStack Spawn = new ItemStack(Material.MAGMA_CREAM);
					ItemMeta SMeta = Spawn.getItemMeta();
					ArrayList<String> SLore = new ArrayList<>();
					SLore.add("§7§oTeleportiert dich zurück");
					SLore.add("§7§ozum Spawn.");
					SMeta.setLore(SLore);
					SMeta.setDisplayName("§5Spawn");
					Spawn.setItemMeta(SMeta);
					
					ItemStack BedWars = new ItemStack(Material.RED_BED);
					ItemMeta BWMeta = BedWars.getItemMeta();
					ArrayList<String> BWLore = new ArrayList<>();
					BWLore.add("§7§oVerteidige deine Insel vor anderen Spielern");
					BWLore.add("§7§ound Greife die Gegnerischen Inseln an");
					BWLore.add("§7§onur das zuletzt überlebende Team gewinnt");
					BWMeta.setLore(BWLore);
					BWMeta.setDisplayName("§9Bedwars");
					BedWars.setItemMeta(BWMeta);
					
					ItemStack Events = new ItemStack(Material.EMERALD);
					ItemMeta EMeta = Events.getItemMeta();
					ArrayList<String> ELore = new ArrayList<>();
					ELore.add("§7§o§cZurzeit ist kein Event aktiv!");
					EMeta.setLore(ELore);
					EMeta.setDisplayName("§6Event");
					Events.setItemMeta(EMeta);
					
					ItemStack Platzhalter = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
					ItemMeta PMeta = Platzhalter.getItemMeta();
					PMeta.setDisplayName("§1");
					Platzhalter.setItemMeta(PMeta);
					
					inv.setItem(9, Citybuild);
					inv.setItem(11, SurvivalGames);
					inv.setItem(13, Spawn);
					inv.setItem(15, BedWars);
					inv.setItem(17, Events);
					
					inv.setItem(0, Platzhalter);
					inv.setItem(1, Platzhalter);
					inv.setItem(2, Platzhalter);
					inv.setItem(3, Platzhalter);
					inv.setItem(4, Platzhalter);
					inv.setItem(5, Platzhalter);
					inv.setItem(6, Platzhalter);
					inv.setItem(7, Platzhalter);
					inv.setItem(8, Platzhalter);
					inv.setItem(10, Platzhalter);
					inv.setItem(12, Platzhalter);
					inv.setItem(14, Platzhalter);
					inv.setItem(16, Platzhalter);
					inv.setItem(18, Platzhalter);
					inv.setItem(19, Platzhalter);
					inv.setItem(20, Platzhalter);
					inv.setItem(21, Platzhalter);
					inv.setItem(22, Platzhalter);
					inv.setItem(23, Platzhalter);
					inv.setItem(24, Platzhalter);
					inv.setItem(25, Platzhalter);
					inv.setItem(26, Platzhalter);
					
					p.openInventory(inv);
				}
			}
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Spieler Verstecken/Sichtbar machen §7(Rechtsklick)")) {
					if(p.hasPermission("LobbySystem.Interact")){
						e.setCancelled(true);
					}
					if(HideShow.contains(p.getName())) {
						HideShow.remove(p.getName());
						for(Player players : Bukkit.getOnlinePlayers()) {
							p.showPlayer(players);
						}
						p.sendMessage(main.Prefix+"Alle Spieler sind nun wieder Sichtbar");
					}else {
						HideShow.add(p.getName());
						for(Player players : Bukkit.getOnlinePlayers()) {
							p.hidePlayer(players);
						}
						p.sendMessage(main.Prefix+"Alle Spieler sind nun Unsichtbar");
					}
				}
			}
		}catch(Exception ex){
			
		}
	}

}
