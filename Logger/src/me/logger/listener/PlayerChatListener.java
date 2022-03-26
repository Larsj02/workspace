package me.logger.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerChatListener implements Listener{
	
	String msg = "";
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		UUID uuid = p.getUniqueId();
		File file = new File("plugins/Logger/"+uuid, "messages.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		SimpleDateFormat date = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
		String original = date.format(new Date());		
		String last = cfg.getString("Message.last");		
		String second = cfg.getString("Message.second");		
		String third = cfg.getString("Message.third");		
		String fourth = cfg.getString("Message.fourth");		
		String fifth = cfg.getString("Message.fifth");		
		String sixth = cfg.getString("Message.sixth");		
		String seventh = cfg.getString("Message.seventh");		
		String eighth = cfg.getString("Message.eighth");		
		String ninth = cfg.getString("Message.ninth");		
		String tenth = cfg.getString("Message.tenth");		
		String eleventh = cfg.getString("Messagen.eleventh");		
		String twelfth = cfg.getString("Message.twelfth");	
		String thirteenth = cfg.getString("Message.thirteenth");	
		String fourteenth = cfg.getString("Message.fourteenth");
		
		cfg.set("Message.last", original+": "+msg);
		cfg.set("Message.second", last);
		cfg.set("Message.third", second);
		cfg.set("Message.fourth", third);
		cfg.set("Message.fifth", fourth);
		cfg.set("Message.sixth", fifth);
		cfg.set("Message.seventh", sixth);
		cfg.set("Message.eighth", seventh);
		cfg.set("Message.ninth", eighth);
		cfg.set("Message.tenth", ninth);
		cfg.set("Message.eleventh", tenth);
		cfg.set("Message.twelfth", eleventh);
		cfg.set("Message.thirteenth", twelfth);
		cfg.set("Message.fourteenth", thirteenth);
		cfg.set("Message.fifteenth", fourteenth);
		
		 try { 
			 cfg.save(file);
		 } catch (IOException ex) {	
		 }	
	}
	
	@EventHandler
	public void onCmd(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		UUID uuid = p.getUniqueId();
		File file = new File("plugins/Logger/"+uuid, "messages.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		SimpleDateFormat date = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
		String original = date.format(new Date());		
		String last = cfg.getString("Command.last");		
		String second = cfg.getString("Command.second");		
		String third = cfg.getString("Command.third");		
		String fourth = cfg.getString("Command.fourth");		
		String fifth = cfg.getString("Command.fifth");		
		String sixth = cfg.getString("Command.sixth");		
		String seventh = cfg.getString("Command.seventh");		
		String eighth = cfg.getString("Command.eighth");		
		String ninth = cfg.getString("Command.ninth");		
		String tenth = cfg.getString("Command.tenth");		
		String eleventh = cfg.getString("Command.eleventh");		
		String twelfth = cfg.getString("Command.twelfth");	
		String thirteenth = cfg.getString("Command.thirteenth");	
		String fourteenth = cfg.getString("Command.fourteenth");
		
		cfg.set("Command.last", original+": "+msg);
		cfg.set("Command.second", last);
		cfg.set("Command.third", second);
		cfg.set("Command.fourth", third);
		cfg.set("Command.fifth", fourth);
		cfg.set("Command.sixth", fifth);
		cfg.set("Command.seventh", sixth);
		cfg.set("Command.eighth", seventh);
		cfg.set("Command.ninth", eighth);
		cfg.set("Command.tenth", ninth);
		cfg.set("Command.eleventh", tenth);
		cfg.set("Command.twelfth", eleventh);
		cfg.set("Command.thirteenth", twelfth);
		cfg.set("Command.fourteenth", thirteenth);
		cfg.set("Command.fifteenth", fourteenth);
		
		 try { 
			 cfg.save(file);
		 } catch (IOException ex) {	
		 }	
	}

}
