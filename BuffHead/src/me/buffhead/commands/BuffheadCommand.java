package me.buffhead.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class BuffheadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("§cBuffhead")) {
			if (args.length == 2) {
				Player target = Bukkit.getPlayer(args[0]);
				if (target.isOnline()) {
					ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta meta = (SkullMeta) item.getItemMeta();
					meta.setOwner(args[1]);
					meta.setDisplayName(args[1]);
					item.setItemMeta(meta);

					target.getInventory().addItem(item);
				} else {
					sender.sendMessage("§8[§cBuffHead§8] §f" + target.getName() + " is currently offline!");
				}
			} else {
				sender.sendMessage("§8[§cBuffHead§8] §f/Buffhead <Player> <HeadOwner>");
			}
		}else {
			sender.sendMessage("§8[§cBuffHead§8] §fYou don't have enough permission!");
		}
		return true;
	}

}
