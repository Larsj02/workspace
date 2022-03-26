package me.lobbysystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.lobbysystem.main.main;

public class PlayerLeaveListener implements Listener{
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
		
		if(p.hasPermission("LobbySystem.Chat.Owner")) {
			e.setQuitMessage(main.OwnerPrefix+p.getName()+" hat den Server verlassen!");
		}else if(p.hasPermission("LobbySystem.Chat.Admin")) {
			e.setQuitMessage(main.AdminPrefix+p.getName()+" hat den Server verlassen!");
		}else if(p.hasPermission("LobbySystem.Chat.Developer")) {
			e.setQuitMessage(main.DeveloperPrefix+p.getName()+" hat den Server verlassen!");
		}else if(p.hasPermission("LobbySystem.Chat.Moderator")) {
			e.setQuitMessage(main.ModeratorPrefix+p.getName()+" hat den Server verlassen!");
		}else if(p.hasPermission("LobbySystem.Chat.Builder")) {
			e.setQuitMessage(main.BuilderPrefix+p.getName()+" hat den Server verlassen!");
		}else if(p.hasPermission("LobbySystem.Chat.Premium")) {
			e.setQuitMessage(main.PremiumPrefix+p.getName()+" hat den Server verlassen!");
		}else {
			e.setQuitMessage(null);
		}
	}

}
