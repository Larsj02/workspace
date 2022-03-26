package me.lobbysystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lobbysystem.main.main;

public class FlyCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("LobbySystem.Fly")) {
				if(p.getAllowFlight()) {
					p.setAllowFlight(false);
					p.sendMessage(main.Prefix+"Du kannst jetzt nichtmehr Fliegen!");
				}else {
					p.setAllowFlight(true);
					p.sendMessage(main.Prefix+"Du kannst jetzt Fliegen!");
				}
			}else {
				p.sendMessage(main.NoPerm);
			}
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

}
