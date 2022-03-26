package me.joinit.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.joinit.main.main;

public class JoinCommand implements CommandExecutor {

	public Inventory inv = null;
	private boolean offline;
	private String motd;
	private int onlinePlayers;
	private int maxPlayers;
	private InetAddress address;
	private int port;

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String error = main.getPlugin().getConfig().getString("join.error");
		String noperm = main.getPlugin().getConfig().getString("JoinIt.nopermission");
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("Joinit.join")) {
				if (args.length == 1) {
					String gamemode = args[0];
					if (main.getPlugin().getConfig().getString("GameModes." + gamemode) != null) {
						int items = 0;
						inv = p.getServer().createInventory(null, 54, gamemode);
						for (String Server : main.getPlugin().getConfig()
								.getConfigurationSection("GameModes." + gamemode).getKeys(false)) {
							String MapName = main.getPlugin().getConfig()
									.getString("GameModes." + gamemode + "." + Server + ".MapName");
							String IP = main.getPlugin().getConfig()
									.getString("GameModes." + gamemode + "." + Server + ".IP");
							int Port = main.getPlugin().getConfig()
									.getInt("GameModes." + gamemode + "." + Server + ".Port");
							int mat = main.getPlugin().getConfig()
									.getInt("GameModes." + gamemode + "." + Server + ".ItemID");
							Material CMaterial = Material.getMaterial(mat);
							try {
								InetAddress addr = InetAddress.getByName(IP);
								int ServerPort = Port;

								Socket socket = new Socket();
								try {
									socket.setSoTimeout(3000);
									socket.setTcpNoDelay(true);
									socket.setTrafficClass(18);
									socket.connect(new InetSocketAddress(addr, ServerPort), 3000);

									DataOutputStream out = new DataOutputStream(socket.getOutputStream());
									DataInputStream in = new DataInputStream(socket.getInputStream());

									out.write(0xFE);

									StringBuilder str = new StringBuilder();

									int b;
									while ((b = in.read()) != -1) {
										if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
											str.append((char) b);
										}
									}

									String[] data = str.toString().split("�");
									String motd = data[0];
									int onlinePlayers = Integer.valueOf(data[1]);
									int maxPlayers = Integer.valueOf(data[2]);
									this.offline = false;
									this.motd = motd;
									this.onlinePlayers = onlinePlayers;
									this.maxPlayers = maxPlayers;

									socket.close();
									socket = new Socket();

									ItemStack item = new ItemStack(CMaterial);
									ItemMeta meta = item.getItemMeta();
									ArrayList<String> lore = new ArrayList<>();
									lore.add(motd);
									lore.add(onlinePlayers + " / " + maxPlayers);
									meta.setLore(lore);
									meta.setDisplayName("�eMap: " + MapName);
									item.setItemMeta(meta);

									inv.setItem(items, item);
								} catch (Exception e) {
									e.printStackTrace();
								}
							} catch (UnknownHostException e1) {
								e1.printStackTrace();
							}
							items++;
						}
						p.openInventory(inv);
					} else {
						p.sendMessage("�8[�bJoinIt�8] �cthis Game Mode doesn't exist use /gamelist for an Overview.");
					}
				} else if (args.length == 2) {
					String gamemode = args[0];
					if (main.getPlugin().getConfig().getString("GameModes." + gamemode) != null) {
						for (String Server : main.getPlugin().getConfig()
								.getConfigurationSection("GameModes." + gamemode).getKeys(false)) {
							String MapName = main.getPlugin().getConfig()
									.getString("GameModes." + gamemode + "." + Server + ".MapName");
							String IP = main.getPlugin().getConfig()
									.getString("GameModes." + gamemode + "." + Server + ".IP");
							int Port = main.getPlugin().getConfig()
									.getInt("GameModes." + gamemode + "." + Server + ".Port");
							int mat = main.getPlugin().getConfig()
									.getInt("GameModes." + gamemode + "." + Server + ".ItemID");
							Material CMaterial = Material.getMaterial(mat);
							String ServerName = main.getPlugin().getConfig()
									.getString("GameModes." + gamemode + "." + Server + ".ServerName");
							try {
								InetAddress addr = InetAddress.getByName(IP);
								int ServerPort = Port;

								Socket socket = new Socket();
								try {
									socket.setSoTimeout(3000);
									socket.setTcpNoDelay(true);
									socket.setTrafficClass(18);
									socket.connect(new InetSocketAddress(addr, ServerPort), 3000);

									DataOutputStream out = new DataOutputStream(socket.getOutputStream());
									DataInputStream in = new DataInputStream(socket.getInputStream());

									out.write(0xFE);

									StringBuilder str = new StringBuilder();

									int b;
									while ((b = in.read()) != -1) {
										if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
											str.append((char) b);
										}
									}

									String[] data = str.toString().split("�");
									String motd = data[0];
									int onlinePlayers = Integer.valueOf(data[1]);
									int maxPlayers = Integer.valueOf(data[2]);
									this.offline = false;
									this.motd = motd;
									this.onlinePlayers = onlinePlayers;
									this.maxPlayers = maxPlayers;

									socket.close();
									socket = new Socket();
									
									motd = motd.toLowerCase();
									if (motd.contains(("waiting"))) {
										String mapchosen = args[1];
										if (mapchosen.equalsIgnoreCase(MapName)) {
											if (onlinePlayers > 1) {
												ByteArrayDataOutput outmap = ByteStreams.newDataOutput();
												outmap.writeUTF(ServerName);
												outmap.writeUTF(p.getName());
												Bukkit.getPlayer(p.getName()).sendPluginMessage(main.getPlugin(),
														"joinsys", outmap.toByteArray());
											} else {
												ByteArrayDataOutput outmap = ByteStreams.newDataOutput();
												outmap.writeUTF(ServerName);
												outmap.writeUTF(p.getName());
												Bukkit.getPlayer(p.getName()).sendPluginMessage(main.getPlugin(),
														"joinsys", outmap.toByteArray());
											}
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							} catch (UnknownHostException e1) {
								e1.printStackTrace();
							}
						}
					} else {
						p.sendMessage("�8[�bJoinIt�8] �cthis Game Mode doesn't exist use /gamelist for an Overview.");
					}
				} else {
					p.sendMessage(error);
				}
			} else {
				p.sendMessage(noperm);

			}
		} else {
			sender.sendMessage("[JoinIt] This Command can only be used Ingame!");
		}
		return true;
	}
}
