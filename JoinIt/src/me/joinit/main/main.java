package me.joinit.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.joinit.commands.AutoJoinCommand;
import me.joinit.commands.GamelistCommand;
import me.joinit.commands.JoinCommand;
import me.joinit.commands.JoinitCommand;
import me.joinit.listener.InventoryClickListener;

public class main extends JavaPlugin{
	
private static main plugin;
	
private static main instance;

	public void onEnable() {
		plugin = this;
		instance = this;
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(main.getInstance(), "joinsys");
		
		File configfile = new File("plugins/JoinIt/", "config.yml");
		if(!configfile.exists()) {
			loadConfig();
		}else {
			reloadConfig();
		}
		
		getCommand("autojoin").setExecutor(new AutoJoinCommand());
		getCommand("gamelist").setExecutor(new GamelistCommand());
		getCommand("join").setExecutor(new JoinCommand());
		getCommand("joinit").setExecutor(new JoinitCommand());
		
		PluginManager pluginmanager = Bukkit.getPluginManager();	
		pluginmanager.registerEvents(new InventoryClickListener(), this);
		
		System.out.println("[JoinIt] Plugin by Lars https://www.fiverr.com/users/onlylars/");
		System.out.println("[JoinIt] Joinit was Sucsessfully enabled!");
	}
	public void onDisable() {
		System.out.println("[JoinIt] Joinit was Disabled!");
	}	
	
	public static main getInstance() {
        return instance;
    }
	
	public void sendData(String message, String player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(message);
        out.writeUTF(player);
        Bukkit.getPlayer(player).sendPluginMessage(this, "joinsys", out.toByteArray());
    }
	
	public void loadConfig() {
		reloadConfig();
		
		getConfig().options().header("be Carfully! HOW TO EDIT: 1.Edit 2.Reload or Restart the Server  (ColorCodes: ?+ 1 2 3 4 5 6 7 8 9 a b c d e f) (Formatting codes: ?+ k l m n o r) Playername: PLAYER ");
		
		getConfig().addDefault("autojoin.error", "?8[?bJoinIt?8] ?f/autojoin <Gamemode>");
		getConfig().addDefault("gamelist.error", "?8[?bJoinIt?8] ?f/gamelist");
		getConfig().addDefault("join.error", "?8[?bJoinIt?8] ?f/join <Gamemode> [<Mapname>]");
		getConfig().addDefault("joinit.error", "?8[?bJoinIt?8] ?f/joinit [<reload>]");
		
		getConfig().addDefault("JoinIt.nopermission", "?8[?bJoinIt?8] ?cYou don't have enough permission to do that!");
		
		//Example1
		//Server1
		getConfig().addDefault("GameModes.Example1.Server1.IP", "localhost");
		getConfig().addDefault("GameModes.Example1.Server1.Port", 25565);
		getConfig().addDefault("GameModes.Example1.Server1.MapName", "Example");
		getConfig().addDefault("GameModes.Example1.Server1.ItemID", 1);
		getConfig().addDefault("GameModes.Example1.Server1.ServerName", "bw1");
		//Server2
		getConfig().addDefault("GameModes.Example1.Server2.IP", "localhost");
		getConfig().addDefault("GameModes.Example1.Server2.Port", 25565);
		getConfig().addDefault("GameModes.Example1.Server2.MapName", "Example");
		getConfig().addDefault("GameModes.Example1.Server2.ItemID", 2);
		getConfig().addDefault("GameModes.Example1.Server2.ServerName", "bw2");
		//Server3
		getConfig().addDefault("GameModes.Example1.Server3.IP", "localhost");
		getConfig().addDefault("GameModes.Example1.Server3.Port", 25565);
		getConfig().addDefault("GameModes.Example1.Server3.MapName", "Example");
		getConfig().addDefault("GameModes.Example1.Server3.ItemID", 3);
		getConfig().addDefault("GameModes.Example1.Server3.ServerName", "bw3");
		
		
		//Example2
		//Server1
		getConfig().addDefault("GameModes.Example2.Server1.IP", "localhost");
		getConfig().addDefault("GameModes.Example2.Server1.Port", 25565);
		getConfig().addDefault("GameModes.Example2.Server1.MapName", "Example");
		getConfig().addDefault("GameModes.Example2.Server1.ItemID", 1);
		getConfig().addDefault("GameModes.Example2.Server1.ServerName", "sg1");
		//Server2
		getConfig().addDefault("GameModes.Example2.Server2.IP", "localhost");
		getConfig().addDefault("GameModes.Example2.Server2.Port", 25565);
		getConfig().addDefault("GameModes.Example2.Server2.MapName", "Example");
		getConfig().addDefault("GameModes.Example2.Server2.ItemID", 2);
		getConfig().addDefault("GameModes.Example2.Server2.ServerName", "sg2");
		//Server3
		getConfig().addDefault("GameModes.Example2.Server3.IP", "localhost");
		getConfig().addDefault("GameModes.Example2.Server3.Port", 25565);
		getConfig().addDefault("GameModes.Example2.Server3.MapName", "Example");
		getConfig().addDefault("GameModes.Example2.Server3.ItemID", 3);
		getConfig().addDefault("GameModes.Example2.Server3.ServerName", "sg3");
		
		//Example3
		//Server1
		getConfig().addDefault("GameModes.Example3.Server1.IP", "localhost");
		getConfig().addDefault("GameModes.Example3.Server1.Port", 25565);
		getConfig().addDefault("GameModes.Example3.Server1.MapName", "Example");
		getConfig().addDefault("GameModes.Example3.Server1.ItemID", 1);
		getConfig().addDefault("GameModes.Example3.Server1.ServerName", "rl1");
		//Server2
		getConfig().addDefault("GameModes.Example3.Server2.IP", "localhost");
		getConfig().addDefault("GameModes.Example3.Server2.Port", 25565);
		getConfig().addDefault("GameModes.Example3.Server2.MapName", "Example");
		getConfig().addDefault("GameModes.Example3.Server2.ItemID", 2);
		getConfig().addDefault("GameModes.Example3.Server2.ServerName", "rl2");
		//Server3
		getConfig().addDefault("GameModes.Example3.Server3.IP", "localhost");
		getConfig().addDefault("GameModes.Example3.Server3.Port", 25565);
		getConfig().addDefault("GameModes.Example3.Server3.MapName", "Example");
		getConfig().addDefault("GameModes.Example3.Server3.ItemID", 3);
		getConfig().addDefault("GameModes.Example3.Server3.ServerName", "rl3");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		System.out.println("[JoinIt] Successfully (re)loaded config.yml");
	}
	
	public static main getPlugin() {
		return plugin;
	}

}
