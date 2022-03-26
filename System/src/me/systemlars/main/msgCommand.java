package me.systemlars.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class msgCommand implements CommandExecutor{
	
	String message = "";
	
	public msgCommand() {
		
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length >=2) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						for(int i = 1; i < args.length; i++) {
							message = message + args[i] + " ";
						}
						
						p.sendMessage("§7[§bMsg§7]§7 Du -> §a"+target.getName()+" §c>>§7 "+message);
						target.sendMessage("§7[§bMsg§7]§a "+p.getName()+" -> §7Du §c>>§7 "+message);
						
						for(Player players : Bukkit.getOnlinePlayers()) {
							if(players.hasPermission("system.team")) {
								players.sendMessage("§7[§bMsgSpy§7]§a"+p.getName()+ " -> §a"+target.getName()+" §c>>§7 "+message);
							}
						}
						
					}else {
						p.sendMessage("§7[§4ERROR§7] §cDieser Spieler ist nicht Online!");
					}
				}else {
					p.sendMessage("§7[§4ERROR§7] §c/msg <spieler> <nachricht>");
				}
				return true;
			}else {
				sender.sendMessage("[System] Du kannst diesen Befehl nur Ingame asführen!");
			    return true;
			}
	}
	

}
