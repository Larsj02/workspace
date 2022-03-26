package me.challenges.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.challenges.main.main;

public class GMCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length ==1) {
				switch (Integer.valueOf(args[0])) {
				case 0:
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(main.Prefix+"Dein §eSpielmodus §7wurde zu §eSurvival §7geändert");
					break;
				case 1:
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(main.Prefix+"Dein §eSpielmodus §7wurde zu §eCreative §7geändert");
					break;
				case 2:
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(main.Prefix+"Dein §eSpielmodus §7wurde zu §eAdventure §7geändert");
					break;
				case 3:
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage(main.Prefix+"Dein §eSpielmodus §7wurde zu §eSpectator §7geändert");
					break;
				}
			}else {
				p.sendMessage(main.Fehler+"Verusche /gm <0 | 1 | 2 | 3>");
			}
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

}