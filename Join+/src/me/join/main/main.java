package me.join.main;

import java.io.File;
import java.io.IOException;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class main extends Plugin implements Listener {
	public static String pluginprefix = "?8[?bJoin+?8] ?f";;

	@Override
	public void onEnable() {
		System.out.println("[Join+] Plugin by Lars https://www.fiverr.com/users/onlylars/");
		System.out.println("[Join+] Join+ was Sucsessfully enabled!");

		getProxy().registerChannel("joinsys");

		BungeeCord.getInstance().getPluginManager().registerListener(this, this);

		try {
			if (!getDataFolder().exists()) {
				getDataFolder().mkdir();
			}
			File file = new File(getDataFolder().getPath(), "config.yml");
			Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			config.set("test", true);
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
		} catch (IOException ex) {

		}
	}

	@Override
	public void onDisable() {
		System.out.println("[Join+] Join+ was Disabled! ");
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void receievePluginMessage(PluginMessageEvent event) throws IOException {
		if (!event.getTag().equalsIgnoreCase("joinsys")) {
			return;
		}

		ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
		String message = in.readUTF();
		String player = in.readUTF();

		ProxiedPlayer pp = BungeeCord.getInstance().getPlayer(player);
		ServerInfo target = ProxyServer.getInstance().getServerInfo(message);
		
		if(target.getMotd().toLowerCase().contains("waiting")) {
			pp.connect(target);
		}else {
			pp.sendMessage("?8[?bJoinIt?8] ?fThis Server is not in the waiting phase!");
		}
	}
}
