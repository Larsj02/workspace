package me.logger.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener{
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		UUID uuid = e.getPlayer().getUniqueId();
		File file = new File("plugins/Logger/"+uuid, "time.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		

		SimpleDateFormat date = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
		String original = date.format(new Date());		
		String last = cfg.getString("Last.Join");		
		String second = cfg.getString("secondlast.Join");		
		String third = cfg.getString("third.Join");		
		String fourth = cfg.getString("fourth.Join");		
		String fifth = cfg.getString("fifth.Join");		
		String sixth = cfg.getString("sixth.Join");		
		String seventh = cfg.getString("seventh.Join");		
		String eighth = cfg.getString("eighth.Join");		
		String ninth = cfg.getString("ninth.Join");		
		String tenth = cfg.getString("tenth.Join");		
		String eleventh = cfg.getString("eleventh.Join");		
		String twelfth = cfg.getString("twelfth.Join");	
		String thirteenth = cfg.getString("thirteenth.Join");	
		String fourteenth = cfg.getString("fourteenth.Join");
		
		cfg.set("Last.Join", original);
		cfg.set("secondlast.Join", last);
		cfg.set("third.Join", second);
		cfg.set("fourth.Join", third);
		cfg.set("fifth.Join", fourth);
		cfg.set("sixth.Join", fifth);
		cfg.set("seventh.Join", sixth);
		cfg.set("eighth.Join", seventh);
		cfg.set("ninth.Join", eighth);
		cfg.set("tenth.Join", ninth);
		cfg.set("eleventh.Join", tenth);
		cfg.set("twelfth.Join", eleventh);
		cfg.set("thirteenth.Join", twelfth);
		cfg.set("fourteenth.Join", thirteenth);
		cfg.set("fifteenth.Join", fourteenth);
		
		 try { 
			 cfg.save(file);
		 } catch (IOException ex) {	
		 }	
		
		 if(!e.getPlayer().hasPlayedBefore()) {
			 cfg.set("First.Join", original);
			 try { 
				 cfg.save(file);
			 } catch (IOException ex) {	
			 }	
		 }
	}

}
