package me.challenges.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage("§8| §aServer §8>> §e"+e.getPlayer().getName()+" §7hat den Server betreten.");
	}

}
