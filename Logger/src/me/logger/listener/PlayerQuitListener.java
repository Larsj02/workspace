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
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		UUID uuid = e.getPlayer().getUniqueId();
		File file = new File("plugins/Logger/"+uuid, "time.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		

		SimpleDateFormat date = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
		String original = date.format(new Date());		
		String lastl = cfg.getString("Last.Leave");		
		String secondl = cfg.getString("secondlast.Leave");		
		String thirdl = cfg.getString("third.Leave");		
		String fourthl = cfg.getString("fourth.Leave");		
		String fifthl = cfg.getString("fifth.Leave");		
		String sixthl = cfg.getString("sixth.Leave");		
		String seventhl = cfg.getString("seventh.Leave");		
		String eighthl = cfg.getString("eighth.Leave");		
		String ninthl = cfg.getString("ninth.Leave");		
		String tenthl = cfg.getString("tenth.Leave");		
		String eleventhl = cfg.getString("eleventh.Leave");		
		String twelfthl = cfg.getString("twelfth.Leave");	
		String thirteenthl = cfg.getString("thirteenth.Leave");	
		String fourteenthl = cfg.getString("fourteenth.Leave");
		
		cfg.set("Last.Leave", original);
		cfg.set("secondlast.Leave", lastl);
		cfg.set("third.Leave", secondl);
		cfg.set("fourth.Leave", thirdl);
		cfg.set("fifth.Leave", fourthl);
		cfg.set("sixth.Leave", fifthl);
		cfg.set("seventh.Leave", sixthl);
		cfg.set("eighth.Leave", seventhl);
		cfg.set("ninth.Leave", eighthl);
		cfg.set("tenth.Leave", ninthl);
		cfg.set("eleventh.Leave", tenthl);
		cfg.set("twelfth.Leave", eleventhl);
		cfg.set("thirteenth.Leave", twelfthl);
		cfg.set("fourteenth.Leave", thirteenthl);
		cfg.set("fifteenth.Leave", fourteenthl);
		
		 try { 
			 cfg.save(file);
		 } catch (IOException ex) {	
		 }	
	}

}
