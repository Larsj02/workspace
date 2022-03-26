package me.invitems.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.invitems.listener.InventoryClickListener;
import me.invitems.listener.PlayerJoinListener;
import me.invitems.listener.ShieldListener;

public class main extends JavaPlugin{
	
	private static main plugin;
	
	public void onEnable() {
		plugin = this;
		
		File configfile = new File("plugins/InvItems/", "config.yml");
		if(!configfile.exists()) {
			loadConfig();
		}else {
			reloadConfig();
		}
		System.out.println("[InvItems] Successfully (re)loaded config.yml");
		
		PluginManager pluginmanager = Bukkit.getPluginManager();	
		pluginmanager.registerEvents(new PlayerJoinListener(), this);
		pluginmanager.registerEvents(new InventoryClickListener(), this);
		pluginmanager.registerEvents(new ShieldListener(), this);
		
		System.out.println("[InvItems] Plugin by Lars https://www.fiverr.com/users/onlylars/");
		System.out.println("[InvItems] InvItems was Sucsessfully enabled!");
	}
	public void onDisable() {
		System.out.println("[InvItems] InvItems was Disabled!");
	}	
	
	public void loadConfig() {
		reloadConfig();
		
		getConfig().options().header("be Carfully! HOW TO EDIT: 1.Edit 2.Restart the Server  (ColorCodes: �+ 1 2 3 4 5 6 7 8 9 a b c d e f) (Formatting codes: �+ k l m n o r)");
		
		getConfig().addDefault("fly_activate", "�8[�bInvItems�8] �fFliegen wurde �aAktiviert!");
		getConfig().addDefault("fly_deactivate", "�8[�bInvItems�8] �fFliegen wurde �cDeaktiviert!");
		getConfig().addDefault("shield_activate", "�8[�bInvItems�8] �fDein Schild wurde �aAktiviert!");
		getConfig().addDefault("shield_deactivate", "�8[�bInvItems�8] �fDein Schild wurde �cDeaktiviert!");
		getConfig().addDefault("shield_knockback", "�8[�bInvItems�8] �cDu wurdest durch ein Schild Weg gesto�en!");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public static main getPlugin() {
		return plugin;
	}

}
