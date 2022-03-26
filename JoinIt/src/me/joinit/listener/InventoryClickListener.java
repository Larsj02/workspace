package me.joinit.listener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.joinit.main.main;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		boolean invname = p.getOpenInventory().getTopInventory().getName() != null;

		e.setCancelled(true);
		for (String gamemodes : main.getPlugin().getConfig().getConfigurationSection("GameModes").getKeys(false)) {
			if (main.getPlugin().getConfig().getString("GameModes." + gamemodes) != null) {
				for (String Server : main.getPlugin().getConfig().getConfigurationSection("GameModes." + gamemodes)
						.getKeys(false)) {
					int mat = main.getPlugin().getConfig().getInt("GameModes." + gamemodes + "." + Server + ".ItemID");
					Material CMaterial = Material.getMaterial(mat);

					String IP = main.getPlugin().getConfig().getString("GameModes." + gamemodes + "." + Server + ".IP");
					int Port = main.getPlugin().getConfig().getInt("GameModes." + gamemodes + "." + Server + ".Port");
					String ServerName = main.getPlugin().getConfig()
							.getString("GameModes." + gamemodes + "." + Server + ".ServerName");

					if (e.getClickedInventory() != null) {
						if (e.getInventory().getName().equalsIgnoreCase(gamemodes)) {
							if (e.getCurrentItem().getType() == CMaterial) {
								ByteArrayDataOutput out = ByteStreams.newDataOutput();
								out.writeUTF(ServerName);
								out.writeUTF(p.getName());
								Bukkit.getPlayer(p.getName()).sendPluginMessage(main.getPlugin(), "crytec",
										out.toByteArray());
							}
						}
					}
				}
			}
		}

	}
}
