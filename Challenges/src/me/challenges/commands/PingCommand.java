package me.challenges.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.challenges.main.main;
import net.minecraft.server.v1_14_R1.EntityPlayer;

public class PingCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			p.sendMessage(main.Prefix+ "Du hast einen §6Ping §7von §6"+getPing(p)+"ms");
		}else {
			sender.sendMessage(main.Konsole);
		}
		return true;
	}

	public int getPing(Player p) {
		CraftPlayer pingc = (CraftPlayer)p;
		EntityPlayer pinge = pingc.getHandle();
		return pinge.ping;
	}

}
