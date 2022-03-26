package me.lobbysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lobbysystem.main.main;

public class MsgCommand implements CommandExecutor{
	
	String message = "";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length >=2) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					for(int i = 1; i < args.length; i++) {
						message = message + args[i] + " ";
					}
					
					p.sendMessage("§7[§bMsg§7]§7 Du -> §a"+target.getName()+" §c>>§7 "+message);
					target.sendMessage("§7[§bMsg§7]§a "+p.getName()+" -> §7Du §c>>§7 "+message);
					
					for(Player players : Bukkit.getOnlinePlayers()) {
						if(players.hasPermission("LobbySystem.Chat.MsgSpy")) {
							players.sendMessage("§7[§bMsgSpy§7]§a"+p.getName()+ " -> §a"+target.getName()+" §c>>§7 "+message);
						}
					}
					message = "";
				}else {
					p.sendMessage(main.Fehler+"Dieser Spieler ist nicht Online!");
				}
			}else {
				p.sendMessage(main.Fehler+"/msg <Spieler> <Nachricht>");
			}
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}
	
	

}
