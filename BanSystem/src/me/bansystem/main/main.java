package me.bansystem.main;

import java.io.File;
import java.util.UUID;
import me.bansystem.command.BanCommand;
import me.bansystem.command.UnBanCommand;
import me.bansystem.listener.PlayerClickEvent;
import me.bansystem.listener.PlayerLoginListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main
  extends JavaPlugin {
  private static main plugin;
  
  public void onEnable() {
    plugin = this;
    
    startTimer();
    
    File configfile = new File("plugins/Bansystem/", "config.yml");
    if (!configfile.exists()) {
      loadConfig();
    } else {
      reloadConfig();
      System.out.println("[BanSystem] Successfully reloaded config.yml");
    } 
    
    getCommand("ban").setExecutor((CommandExecutor)new BanCommand());
    getCommand("unban").setExecutor((CommandExecutor)new UnBanCommand());
    
    PluginManager pluginmanager = Bukkit.getPluginManager();
    pluginmanager.registerEvents((Listener)new PlayerClickEvent(), (Plugin)this);
    pluginmanager.registerEvents((Listener)new PlayerLoginListener(), (Plugin)this);
    
    System.out.println("[BanSystem] Plugin by Lars https://www.fiverr.com/users/onlylars/");
    System.out.println("[BanSystem] Logger was Sucsessfully enabled!");
  }
  
  public void onDisable() { System.out.println("[BanSystem] Logger was Disabled!"); }

  
  public void loadConfig() {
    reloadConfig();
    
    getConfig().options().header("be Carfully! HOW TO EDIT: 1.Edit 2.Reload or Restart the Server  (ColorCodes: 1 2 3 4 5 6 7 8 9 a b c d e f) (Formatting codes: k l m n o r) Playername: PLAYER ");
    
    getConfig().addDefault("error", "<name>");
    getConfig().addDefault("errorunban", "<name>");
    getConfig().addDefault("nopermission", "don't have enough permission to do that!");
    getConfig().addDefault("servername", "");
    
    getConfig().addDefault("bansystem.banreason1.ItemID", Integer.valueOf(276));
    getConfig().addDefault("bansystem.banreason1.BanReason", "KillAura");
    getConfig().addDefault("bansystem.banreason1.BanTimeInMin", Integer.valueOf(99999));
    
    getConfig().addDefault("bansystem.banreason2.ItemID", Integer.valueOf(264));
    getConfig().addDefault("bansystem.banreason2.BanReason", "Duplication");
    getConfig().addDefault("bansystem.banreason2.BanTimeInMin", Integer.valueOf(10));

    
    getConfig().options().copyDefaults(true);
    saveConfig();
    System.out.println("[BanSystem] Successfully loaded config.yml");
  }

  
  public static main getPlugin() { return plugin; }

  
  public void startTimer() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable()
        {
          public void run() {
            for (String BannedPlayers : main.getPlugin().getConfig().getConfigurationSection("BanList").getKeys(false)) {
              if (BannedPlayers != null)
              {
                
                UUID puuid = UUID.fromString(BannedPlayers);
                int ende = main.getPlugin().getConfig().getInt("Player." + puuid + ".minutes");
                ende--;
                if (ende == 0) {
                  main.this.getConfig().set("Player." + puuid + ".ban", Boolean.valueOf(false));
                } else {
                  main.this.getConfig().set("Player." + puuid + ".minutes", Integer.valueOf(ende));
                } 
                main.this.saveConfig();
              }
            
            } 
          }
        }, 1200L, 0);
  }
}
