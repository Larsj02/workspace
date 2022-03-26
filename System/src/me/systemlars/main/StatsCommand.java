package me.systemlars.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {

	private main plugin;
	
	public StatsCommand(main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			Player p = (Player) sender;
			
			int hours = plugin.getConfig().getInt(p.getName()+".hours");
			int minutes = plugin.getConfig().getInt(p.getName()+".minutes");
			int seconds = plugin.getConfig().getInt(p.getName()+".seconds");
			
			p.sendMessage("§7[§3Stats§7] §aDeine Spielzeit: "+hours+" Stunden, "+minutes+" Minuten und "+seconds+" Sekunden!");
		}else {
			sender.sendMessage("[System] Du kannst Diesen Befehl nur Ingame ausführen!");
			return true;
		}
		
		return true;
	}

}
