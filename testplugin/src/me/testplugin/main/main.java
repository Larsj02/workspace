package me.testplugin.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	String plname = "§7[§9Test§7] §f";
	String error = "§7[§4Fehler§7] §c";
	
	@Override
	public void onEnable() {
		System.out.println("[Test] Das Plugin wurde erfolgreich geladen!");
		Bukkit.getPluginManager().registerEvents(new onhitlistener(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[Test] Das Plugin wurde erfolgreich deaktiviert!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
		
		if(label.equalsIgnoreCase("test")) {
			sender.sendMessage("§1T§2e§3s§4t §5e§6r§7f§8o§9l§0g§ar§be§ci§dc§eh§f!");
			return true;
		}
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(label.equalsIgnoreCase("teleport")) {
				if(args.length == 1) {
					String Name = args[0];
					if(Bukkit.getPlayer(Name) !=null) {
						Player target = (Player)Bukkit.getPlayer(Name);
						p.teleport(target);
						p.sendMessage(plname+"Du wurdest erfolgreich zu "+Name+" teleportiert");
						return true;
					}else {
						p.sendMessage(error+"Der Spieler '"+Name+"' ist zurzeit nicht Online.");
						return true;
					}
				}else {
					p.sendMessage(error+"Zuviele/wenige Argumente!");
				}
			}
		}else {
			sender.sendMessage(error+"Die konsole kann diesen Befehl nicht ausführen");
			return true;
		}
		
		return false;
	}

}
