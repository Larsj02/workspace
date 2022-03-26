package me.challenges.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.challenges.commands.BPCommand;
import me.challenges.commands.GMCommand;
import me.challenges.commands.PingCommand;
import me.challenges.commands.PosCommand;
import me.challenges.commands.SettingsCommand;
import me.challenges.commands.TimerCommand;
import me.challenges.listener.EntityDieListener;
import me.challenges.listener.MenuClickListener;
import me.challenges.listener.PlayerDamageListener;
import me.challenges.listener.PlayerDieListener;
import me.challenges.listener.PlayerJoinListener;
import me.challenges.listener.PlayerLeaveListener;

public class main extends JavaPlugin {
	private static main plugin;

	public static String Prefix = "§8» §7";
	public static String Fehler = "§8[§4Fehler§8] §c";
	public static String Konsole = "[Challenges] Befehle können nur Ingame ausgeführt werden!";

	public void onEnable() {

		getCommand("ping").setExecutor(new PingCommand());
		getCommand("pos").setExecutor(new PosCommand());
		getCommand("timer").setExecutor(new TimerCommand());
		getCommand("gm").setExecutor(new GMCommand());
		getCommand("settings").setExecutor(new SettingsCommand());
		getCommand("bp").setExecutor(new BPCommand());

		PluginManager pluginmanager = Bukkit.getPluginManager();
		pluginmanager.registerEvents(new PlayerJoinListener(), this);
		pluginmanager.registerEvents(new PlayerLeaveListener(), this);
		pluginmanager.registerEvents(new PlayerDamageListener(), this);
		pluginmanager.registerEvents(new PlayerDieListener(), this);
		pluginmanager.registerEvents(new EntityDieListener(), this);
		pluginmanager.registerEvents(new MenuClickListener(), this);

		System.out.println("[Challenge Plugin]wurde Aktiviert!");
	}

	public void onDisable() {
		System.out.println("[Challenge Plugin]wurde Deaktiviert!");
	}
	
	public static main getPlugin() {
		return plugin;
	}
}
