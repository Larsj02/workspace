package me.systemlars.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.EntityPlayer;

public class PingCommand implements CommandExecutor {
	
	public int getPing(Player p) {
		CraftPlayer pingc = (CraftPlayer) p;
		EntityPlayer pinge = pingc.getHandle();
		return pinge.ping;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			p.sendMessage("§7[§2Ping§7] §a"+getPing(p)+"ms");
		}else {
			sender.sendMessage("[System] Dieser Befehl kann nur Ingame ausgeführt werden!");
		}
		return true;
	}

}
