package me.lobbysystem.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.lobbysystem.commands.BroadcastCommand;
import me.lobbysystem.commands.ChatClearCommand;
import me.lobbysystem.commands.FlyCommand;
import me.lobbysystem.commands.MsgCommand;
import me.lobbysystem.commands.SupportCommand;
import me.lobbysystem.listener.InventoryClickListener;
import me.lobbysystem.listener.PlayerChatListener;
import me.lobbysystem.listener.PlayerDamageListener;
import me.lobbysystem.listener.PlayerDropListener;
import me.lobbysystem.listener.PlayerFoodListener;
import me.lobbysystem.listener.PlayerInteractListener;
import me.lobbysystem.listener.PlayerJoinListener;
import me.lobbysystem.listener.PlayerLeaveListener;
import me.lobbysystem.listener.PlayerMoveListener;
import me.lobbysystem.listener.WeatherChangeListener;

public class main extends JavaPlugin{
	
	public static String Prefix = "§8[§bLobbySystem§8] §f";
	public static String Fehler = "§8[§4Fehler§8] §c";
	public static String Konsole = "[LobbySystem] Befehle können nur Ingame ausgeführt werden!";
	public static String NoPerm = "§8[§4Fehler§8] §cDu hast dafür keine Berechtigung!";
	
	public static String OwnerPrefix = "§8[§4Owner§8] §4";
	public static String AdminPrefix = "§8[§cAdmin§8] §c";
	public static String DeveloperPrefix = "§8[§eDeveloper§8] §e";
	public static String ModeratorPrefix = "§8[§9Moderator§8] §9";
	public static String BuilderPrefix = "§8[§3Builder§8] §3";
	public static String PremiumPrefix = "§8[§6Premium§8] §6";
	public static String SpielerPrefix = "§8[§7Spieler§8] §7";
	
	public void onEnable() {
		
		getCommand("msg").setExecutor(new MsgCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("clearchat").setExecutor(new ChatClearCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("support").setExecutor(new SupportCommand());
		
		PluginManager pluginmanager = Bukkit.getPluginManager();
		pluginmanager.registerEvents(new PlayerJoinListener(), this);
		pluginmanager.registerEvents(new PlayerLeaveListener(), this);
		pluginmanager.registerEvents(new PlayerChatListener(), this);
		pluginmanager.registerEvents(new PlayerMoveListener(), this);
		pluginmanager.registerEvents(new PlayerDamageListener(), this);
		pluginmanager.registerEvents(new WeatherChangeListener(), this);
		pluginmanager.registerEvents(new PlayerFoodListener(), this);
		pluginmanager.registerEvents(new PlayerDropListener(), this);
		pluginmanager.registerEvents(new InventoryClickListener(), this);
		pluginmanager.registerEvents(new PlayerInteractListener(), this);
		
		System.out.println("[LobbySystem]wurde Aktiviert!");
	}

	public void onDisable() {
		System.out.println("[LobbySystem]wurde Deaktiviert!");
	}
}
