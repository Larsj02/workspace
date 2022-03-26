package me.challenges.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage("§8| §aServer §8>> §e"+e.getPlayer().getName()+" §7hat den Server verlassen.");
	}

}
