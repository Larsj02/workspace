package me.systemlars.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

private main plugin;
	
	public ChatListener(main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = (Player)e.getPlayer();
		String msg = e.getMessage();
		
		if(p.hasPermission("system.team")) {
			e.setFormat("§7[§cTeam-Mitglied§7] §c"+p.getName()+"§8 >> §b"+msg);
		}else if(p.hasPermission("system.premium")) {
			e.setFormat("§7[§6Spieler§7] "+p.getName()+"§8 >> §b"+msg);
		}else {
			e.setFormat("§7[Spieler] "+p.getName()+"§8 >> §7"+msg);
		}
	}
	
}
