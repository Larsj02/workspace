package me.lobbysystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.lobbysystem.main.main;

public class PlayerChatListener implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String message = e.getMessage().replace("%", "Prozent");
		String newmessage = message.replace("&", "§");
		
		if(p.hasPermission("LobbySystem.Chat.Owner")) {
			e.setFormat(main.OwnerPrefix+p.getName()+"§8 >> §f"+newmessage);
		}else if(p.hasPermission("LobbySystem.Chat.Admin")) {
			e.setFormat(main.AdminPrefix+p.getName()+"§8 >> §f"+newmessage);
		}else if(p.hasPermission("LobbySystem.Chat.Developer")) {
			e.setFormat(main.DeveloperPrefix+p.getName()+"§8 >> §f"+newmessage);
		}else if(p.hasPermission("LobbySystem.Chat.Moderator")) {
			e.setFormat(main.ModeratorPrefix+p.getName()+"§8 >> §f"+newmessage);
		}else if(p.hasPermission("LobbySystem.Chat.Builder")) {
			e.setFormat(main.BuilderPrefix+p.getName()+"§8 >> §f"+newmessage);
		}else if(p.hasPermission("LobbySystem.Chat.Premium")) {
			e.setFormat(main.PremiumPrefix+p.getName()+"§8 >> §f"+newmessage);
		}else {
			e.setFormat(main.SpielerPrefix+p.getName()+"§8 >> §f"+message);
		}
	}

}
