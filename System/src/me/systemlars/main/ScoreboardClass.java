package me.systemlars.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardClass implements Listener{
	
	
	public Integer getMoney(String name) {
		File file = new File("plugins/System", "money.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int money = cfg.getInt(name+".money");
		return money;
	}
	
	private main plugin;
	int sched;
	
	public ScoreboardClass(main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		this.updateScoreboard(p);
		
		if(!Bukkit.getScheduler().isCurrentlyRunning(sched)) {
			sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

				@Override
				public void run() {
					updateScoreboard(p);
				}
				
			}, 20*60, 20*60);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void updateScoreboard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "bbb");
		
		obj.setDisplayName(p.getName());
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		int hours = plugin.getConfig().getInt(p.getName()+".hours");
		int minutes = plugin.getConfig().getInt(p.getName()+".minutes");
		
		
		
		Score five = obj.getScore(Bukkit.getOfflinePlayer("§6Geld:"));
		Score four = obj.getScore(Bukkit.getOfflinePlayer("§6"+getMoney(p.getName())));
		Score three = obj.getScore(Bukkit.getOfflinePlayer("§aSpielzeit:"));
		Score two = obj.getScore(Bukkit.getOfflinePlayer("§a"+hours+"h "+minutes+"m"));
		Score one = obj.getScore(Bukkit.getOfflinePlayer("§3Rang:"));
		if(p.hasPermission("system.team")) {
			Score zero = obj.getScore(Bukkit.getOfflinePlayer("§cTeam-Mitglied"));
			zero.setScore(0);
		}else if(p.hasPermission("system.premium")) {
			Score zero = obj.getScore(Bukkit.getOfflinePlayer("§6Premium"));
			zero.setScore(0);
		}else {
			Score zero = obj.getScore(Bukkit.getOfflinePlayer("§7Spieler"));
			zero.setScore(0);
		}
		
		five.setScore(5);
		four.setScore(4);
		three.setScore(3);
		two.setScore(2);
		one.setScore(1);
		
		p.setScoreboard(board);
		
	}

}
