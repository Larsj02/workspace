package me.logger.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.logger.commands.LoggerCommand;
import me.logger.commands.PlaytimeCommand;
import me.logger.listener.PlayerChatListener;
import me.logger.listener.PlayerJoinListener;
import me.logger.listener.PlayerQuitListener;


public class main extends JavaPlugin{
	
	private static main plugin;
	
	public void onEnable() {
		plugin = this;
		
		loadConfig();
		
		startTimer();
		
		getCommand("logger").setExecutor(new LoggerCommand());	
		getCommand("playtime").setExecutor(new PlaytimeCommand());	
		
		PluginManager pluginmanager = Bukkit.getPluginManager();	
		pluginmanager.registerEvents(new PlayerJoinListener(), this);
		pluginmanager.registerEvents(new PlayerQuitListener(), this);
		pluginmanager.registerEvents(new PlayerChatListener(), this);
		
		System.out.println("[Logger] Plugin by Lars https://www.fiverr.com/users/onlylars/");
		System.out.println("[Logger] Logger was Sucsessfully enabled!");
	}
	public void onDisable() {
		System.out.println("[Logger] Logger was Disabled!");
	}	
	
	public void loadConfig() {
		reloadConfig();
		
		getConfig().options().header("be Carfully! HOW TO EDIT: 1.Edit 2.Reload or Restart the Server  (ColorCodes: §+ 1 2 3 4 5 6 7 8 9 a b c d e f) (Formatting codes: §+ k l m n o r) Playername: PLAYER ");
		
		getConfig().addDefault("Logger.error", "§8[§bLogger§8] §f/logger <messages/onlinetime/locations> <name>");
		getConfig().addDefault("Logger.nopermission", "§8[§bLogger§8] §cYou don't have enough permission to do that!");
		
		getConfig().addDefault("Logger.messages.topborder", "§l§m====================");
		getConfig().addDefault("Logger.messages.playername", "§lPLAYER");
		getConfig().addDefault("Logger.messages.space1", "");
		getConfig().addDefault("Logger.messages.Lastmessages", "Last Messages");
		getConfig().addDefault("Logger.messages.space2", "");
		getConfig().addDefault("Logger.messages.lastcommands", "Last Commands");
		getConfig().addDefault("Logger.messages.bottomborder", "§l§m====================");
		
		getConfig().addDefault("Logger.onlinetime.topborder", "§l§m====================");
		getConfig().addDefault("Logger.onlinetime.playername", "§lPLAYER");
		getConfig().addDefault("Logger.onlinetime.space1", "");
		getConfig().addDefault("Logger.onlinetime.playtime", "Playtime:");
		getConfig().addDefault("Logger.onlinetime.space2", "");
		getConfig().addDefault("Logger.onlinetime.firstjoin", "First time Joined:");
		getConfig().addDefault("Logger.onlinetime.space3", "");
		getConfig().addDefault("Logger.onlinetime.lastjoins", "Last onlinetime Joined:");
		getConfig().addDefault("Logger.onlinetime.bottomborder", "§l§m====================");
		
		getConfig().addDefault("Logger.locations.topborder", "§l§m====================");
		getConfig().addDefault("Logger.locations.playername", "§lPLAYER");
		getConfig().addDefault("Logger.locations.space1", "");
		getConfig().addDefault("Logger.locations.lastlocs", "Last Locations:");
		getConfig().addDefault("Logger.locations.bottomborder", "§l§m====================");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		System.out.println("[Logger] Successfully (re)loaded config.yml");
	}
	
	public static main getPlugin() {
		return plugin;
	}
	
	public void startTimer() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for(Player players : Bukkit.getOnlinePlayers()) {
					UUID uuid = players.getUniqueId();
					File file = new File("plugins/Logger/"+uuid, "time.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					int hours = cfg.getInt("Time.hours");
					int minutes = cfg.getInt("Time.minutes");
					
					minutes ++;
					
					cfg.set("Time.minutes", minutes);
					try {
						cfg.save(file);
					} catch (IOException e) {
					}
					if(minutes == 60) {
						cfg.set("Time.minutes", 0);
						hours ++;
						cfg.set("Time.hours", hours);
						try {
							cfg.save(file);
						} catch (IOException e) {
						}
					}
				}
			}
		}, 20*60, 20*60);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for(Player players : Bukkit.getOnlinePlayers()) {
					UUID uuid = players.getUniqueId();
					
					File file2 = new File("plugins/Logger/"+uuid, "locations.yml");
					FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
					
					SimpleDateFormat date = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
					String original = date.format(new Date());		
					
					String world = players.getWorld().getName();
					double X = players.getLocation().getX();
					double Y = players.getLocation().getY();
					double Z = players.getLocation().getZ();
					
					String lastT = cfg2.getString("Last.loc.Time");	
					String lastX = cfg2.getString("Last.loc.X");		
					String lastY = cfg2.getString("Last.loc.Y");	
					String lastZ = cfg2.getString("Last.loc.Z");	
					String lastW = cfg2.getString("Last.loc.World");
					
					String secondT = cfg2.getString("secondlast.loc.Time");
					String secondX = cfg2.getString("secondlast.loc.X");	
					String secondY = cfg2.getString("secondlast.loc.Y");	
					String secondZ = cfg2.getString("secondlast.loc.Z");
					String secondW = cfg2.getString("secondlast.loc.World");	
					
					String thirdT = cfg2.getString("third.loc.Time");
					String thirdX = cfg2.getString("third.loc.X");		
					String thirdY = cfg2.getString("third.loc.Y");		
					String thirdZ = cfg2.getString("third.loc.Z");	
					String thirdW = cfg2.getString("third.loc.World");	
					
					String fourthT = cfg2.getString("fourth.loc.Time");	
					String fourthX = cfg2.getString("fourth.loc.X");	
					String fourthY = cfg2.getString("fourth.loc.Y");	
					String fourthZ = cfg2.getString("fourth.loc.Z");
					String fourthW = cfg2.getString("fourth.loc.World");
					
					String fifthT = cfg2.getString("fifth.loc.Time");	
					String fifthX = cfg2.getString("fifth.loc.X");	
					String fifthY = cfg2.getString("fifth.loc.Y");	
					String fifthZ = cfg2.getString("fifth.loc.Z");	
					String fifthW = cfg2.getString("fifth.loc.World");	
					
					String sixthT = cfg2.getString("sixth.loc.Time");
					String sixthX = cfg2.getString("sixth.loc.X");		
					String sixthY = cfg2.getString("sixth.loc.Y");		
					String sixthZ = cfg2.getString("sixth.loc.Z");	
					String sixthW = cfg2.getString("sixth.loc.World");		
					
					String seventhT = cfg2.getString("seventh.loc.Time");
					String seventhX = cfg2.getString("seventh.loc.X");	
					String seventhY = cfg2.getString("seventh.loc.Y");	
					String seventhZ = cfg2.getString("seventh.loc.Z");	
					String seventhW = cfg2.getString("seventh.loc.World");	
					
					String eighthT = cfg2.getString("eighth.loc.Time");	
					String eighthX = cfg2.getString("eighth.loc.X");	
					String eighthY = cfg2.getString("eighth.loc.Y");	
					String eighthZ = cfg2.getString("eighth.loc.Z");
					String eighthW = cfg2.getString("eighth.loc.World");
					
					String ninthT = cfg2.getString("ninth.loc.Time");
					String ninthX = cfg2.getString("ninth.loc.X");		
					String ninthY = cfg2.getString("ninth.loc.Y");		
					String ninthZ = cfg2.getString("ninth.loc.Z");	
					String ninthW = cfg2.getString("ninth.loc.World");
					
					String tenthT = cfg2.getString("tenth.loc.Time");
					String tenthX = cfg2.getString("tenth.loc.X");		
					String tenthY = cfg2.getString("tenth.loc.Y");		
					String tenthZ = cfg2.getString("tenth.loc.Z");	
					String tenthW = cfg2.getString("tenth.loc.World");
					
					String eleventhT = cfg2.getString("eleventh.loc.Time");
					String eleventhX = cfg2.getString("eleventh.loc.X");	
					String eleventhY = cfg2.getString("eleventh.loc.Y");	
					String eleventhZ = cfg2.getString("eleventh.loc.Z");
					String eleventhW = cfg2.getString("eleventh.loc.World");
					
					String twelfthT = cfg2.getString("twelfth.loc.Time");
					String twelfthX = cfg2.getString("twelfth.loc.X");	
					String twelfthY = cfg2.getString("twelfth.loc.Y");
					String twelfthZ = cfg2.getString("twelfth.loc.Z");
					String twelfthW = cfg2.getString("twelfth.loc.World");
					
					String thirteenthT = cfg2.getString("thirteenth.loc.Time");
					String thirteenthX = cfg2.getString("thirteenth.loc.X");	
					String thirteenthY = cfg2.getString("thirteenth.loc.Y");	
					String thirteenthZ = cfg2.getString("thirteenth.loc.Z");
					String thirteenthW = cfg2.getString("thirteenth.loc.World");
					
					String fourteenthT = cfg2.getString("fourteenth.loc.Time");
					String fourteenthX = cfg2.getString("fourteenth.loc.X");
					String fourteenthY = cfg2.getString("fourteenth.loc.Y");
					String fourteenthZ = cfg2.getString("fourteenth.loc.Z");
					String fourteenthW = cfg2.getString("fourteenth.loc.World");
					
					cfg2.set("Last.loc.Time", original);
					cfg2.set("Last.loc.X", " (X)= "+X);
					cfg2.set("Last.loc.Y", " (Y)= "+Y);
					cfg2.set("Last.loc.Z", " (Z)= "+Z);
					cfg2.set("Last.loc.World", " (World)= "+world);
					
					cfg2.set("secondlast.loc.Time", lastT);
					cfg2.set("secondlast.loc.X", lastX);
					cfg2.set("secondlast.loc.Y", lastY);
					cfg2.set("secondlast.loc.Z", lastZ);
					cfg2.set("secondlast.loc.World", lastW);
					
					cfg2.set("third.loc.Time", secondT);
					cfg2.set("third.loc.X", secondX);
					cfg2.set("third.loc.Y", secondY);
					cfg2.set("third.loc.Z", secondZ);
					cfg2.set("third.loc.World", secondW);
					
					cfg2.set("fourth.loc.Time", thirdT);
					cfg2.set("fourth.loc.X", thirdX);
					cfg2.set("fourth.loc.Y", thirdY);
					cfg2.set("fourth.loc.Z", thirdZ);
					cfg2.set("fourth.loc.World", thirdW);
					
					cfg2.set("fifth.loc.Time", fourthT);
					cfg2.set("fifth.loc.X", fourthX);
					cfg2.set("fifth.loc.Y", fourthY);
					cfg2.set("fifth.loc.Z", fourthZ);
					cfg2.set("fifth.loc.World", fourthW);
					
					cfg2.set("sixth.loc.Time", fifthT);
					cfg2.set("sixth.loc.X", fifthX);
					cfg2.set("sixth.loc.Y", fifthY);
					cfg2.set("sixth.loc.Z", fifthZ);
					cfg2.set("sixth.loc.World", fifthW);
					
					cfg2.set("seventh.loc.Time", sixthT);
					cfg2.set("seventh.loc.X", sixthX);
					cfg2.set("seventh.loc.Y", sixthY);
					cfg2.set("seventh.loc.Z", sixthZ);
					cfg2.set("seventh.loc.World", sixthW);
					
					cfg2.set("eighth.loc.Time", seventhT);
					cfg2.set("eighth.loc.X", seventhX);
					cfg2.set("eighth.loc.Y", seventhY);
					cfg2.set("eighth.loc.Z", seventhZ);
					cfg2.set("eighth.loc.World", seventhW);
					
					cfg2.set("ninth.loc.Time", eighthT);
					cfg2.set("ninth.loc.X", eighthX);
					cfg2.set("ninth.loc.Y", eighthY);
					cfg2.set("ninth.loc.Z", eighthZ);
					cfg2.set("ninth.loc.World", eighthW);
					
					cfg2.set("tenth.loc.Time", ninthT);
					cfg2.set("tenth.loc.X", ninthX);
					cfg2.set("tenth.loc.Y", ninthY);
					cfg2.set("tenth.loc.Z", ninthZ);
					cfg2.set("tenth.loc.World", ninthW);
					
					cfg2.set("eleventh.loc.Time", tenthT);
					cfg2.set("eleventh.loc.X", tenthX);
					cfg2.set("eleventh.loc.Y", tenthY);
					cfg2.set("eleventh.loc.Z", tenthZ);
					cfg2.set("eleventh.loc.World", tenthW);
					
					cfg2.set("twelfth.loc.Time", eleventhT);
					cfg2.set("twelfth.loc.X", eleventhX);
					cfg2.set("twelfth.loc.Y", eleventhY);
					cfg2.set("twelfth.loc.Z", eleventhZ);
					cfg2.set("twelfth.loc.World", eleventhW);
					
					cfg2.set("thirteenth.loc.Time", twelfthT);
					cfg2.set("thirteenth.loc.X", twelfthX);
					cfg2.set("thirteenth.loc.Y", twelfthY);
					cfg2.set("thirteenth.loc.Z", twelfthZ);
					cfg2.set("thirteenth.loc.World", twelfthW);
					
					cfg2.set("fourteenth.loc.Time", thirteenthT);
					cfg2.set("fourteenth.loc.X", thirteenthX);
					cfg2.set("fourteenth.loc.Y", thirteenthY);
					cfg2.set("fourteenth.loc.Z", thirteenthZ);
					cfg2.set("fourteenth.loc.World", thirteenthW);
					
					cfg2.set("fifteenth.loc.Time", fourteenthT);
					cfg2.set("fifteenth.loc.X", fourteenthX);
					cfg2.set("fifteenth.loc.Y", fourteenthY);
					cfg2.set("fifteenth.loc.Z", fourteenthZ);
					cfg2.set("fifteenth.loc.World", fourteenthW);
					
					 try { 
						 cfg2.save(file2);
					 } catch (IOException ex) {	
					 }	
				}
			}
		}, 20*30, 20*30);
	}
}
