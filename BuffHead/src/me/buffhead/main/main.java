package me.buffhead.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.buffhead.commands.BuffheadCommand;
import me.buffhead.listener.PlayerInteractListener;

public class main extends JavaPlugin{
	
	public void onEnable() {
		System.out.println("[Buffhead] was successfully enabled");
		
		getCommand("buffhead").setExecutor(new BuffheadCommand());	
		
		PluginManager pluginmanager = Bukkit.getPluginManager();	
		pluginmanager.registerEvents(new PlayerInteractListener(), this);
	}
	
	public void onDisable() {
		System.out.println("[Buffhead] was Disabled");
	}

}
