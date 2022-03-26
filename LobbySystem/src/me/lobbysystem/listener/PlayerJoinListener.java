package me.lobbysystem.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;

import me.lobbysystem.main.main;

public class PlayerJoinListener implements Listener{
	
	Scoreboard sb;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		p.teleport(new Location(p.getWorld(), 113, 70, -143.5));
		
		for(Player players :Bukkit.getOnlinePlayers()) {
			if(PlayerInteractListener.HideShow.contains(players.getName())) {
				players.hidePlayer(p);
			}
		}
		
		ItemStack Teleporter = new ItemStack(Material.NETHER_STAR);
		ItemMeta TPmeta = Teleporter.getItemMeta();
		ArrayList<String> TPLore = new ArrayList<>();
		TPLore.add("§7§oTeleportiert dich zu Allen Spielmodi");
		TPLore.add("§7§ound zurück zum Spawn.");
		TPmeta.setLore(TPLore);
		TPmeta.setDisplayName("§cNavigator §7(Rechtsklick)");
		Teleporter.setItemMeta(TPmeta);
		
		ItemStack HidePlayers = new ItemStack(Material.BLAZE_ROD);
		ItemMeta HPMeta = HidePlayers.getItemMeta();
		ArrayList<String> HPLore = new ArrayList<>();
		HPLore.add("§7§oVersteckt Spieler");
		HPLore.add("§7§ound lässt sie wieder erscheinen.");
		HPMeta.setLore(HPLore);
		HPMeta.setDisplayName("§2Spieler Verstecken/Sichtbar machen §7(Rechtsklick)");
		HidePlayers.setItemMeta(HPMeta);
		
		ItemStack ItemInventar = new ItemStack(Material.CHEST);
		ItemMeta IVmeta = ItemInventar.getItemMeta();
		ArrayList<String> IVLore = new ArrayList<>();
		IVLore.add("§7§oÖffnet dein ItemInventar");
		IVLore.add("§7§ound lässt dich Items Kaufen.");
		IVmeta.setLore(IVLore);
		IVmeta.setDisplayName("§6Iteminventar §7(Rechtsklick)");
		ItemInventar.setItemMeta(IVmeta);
		
		p.getInventory().setItem(1, Teleporter);
		p.getInventory().setItem(4, HidePlayers);
		p.getInventory().setItem(7, ItemInventar);
		
		if(p.hasPermission("LobbySystem.Chat.Owner")) {
			e.setJoinMessage(main.OwnerPrefix+"§4"+p.getName()+" hat den Server betreten!");
		}else if(p.hasPermission("LobbySystem.Chat.Admin")) {
			e.setJoinMessage(main.AdminPrefix+"§c"+p.getName()+" hat den Server betreten!");
		}else if(p.hasPermission("LobbySystem.Chat.Developer")) {
			e.setJoinMessage(main.DeveloperPrefix+"§e"+p.getName()+" hat den Server betreten!");
		}else if(p.hasPermission("LobbySystem.Chat.Moderator")) {
			e.setJoinMessage(main.ModeratorPrefix+"§9"+p.getName()+" hat den Server betreten!");
		}else if(p.hasPermission("LobbySystem.Chat.Builder")) {
			e.setJoinMessage(main.BuilderPrefix+"§3"+p.getName()+" hat den Server betreten!");
		}else if(p.hasPermission("LobbySystem.Chat.Premium")) {
			e.setJoinMessage(main.PremiumPrefix+"§9"+p.getName()+" hat den Server betreten!");
		}else {
			e.setJoinMessage(null);
		}
		
	}

}
