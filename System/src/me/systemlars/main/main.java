package me.systemlars.main;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	
	public Inventory inv = null;
	
	@Override
	public void onEnable() {
		
		loadConfig();
		registerEvents();
		registerCommands();
		startTimer();
		
		this.getServer().getPluginManager().registerEvents(this, this);
		
		System.out.println("[System Lars] Dieses Plugin wurde erfolgreich geladen!");
	}
	
	@Override
	public void onDisable() {
		System.out.println("[System Lars] Dieses Plugin wurde erfolgreich Deaktiviert!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("system")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage("?7[?9System?7] ?fDieses Plugin wurde von Lars programmiert (EinYoutuber)!");
				p.sendMessage("?7[?9System?7] ?4Owner");
				p.sendMessage("?7[?9System?7] ?cAdmin");
				p.sendMessage("?7[?9System?7] ?eDeveloper");
				p.sendMessage("?7[?9System?7] ?9Moderator");
				p.sendMessage("?7[?9System?7] ?3Builder");
				p.sendMessage("?7[?9System?7] ?6Premium");
				p.sendMessage("?7[?9System?7] ?7Spieler");
				return true;
			}else {
				sender.sendMessage("[System] Dieses Plugin wurde von Lars programmiert (EinYoutuber)!");
			    return true;
			}	
		}
		
		if(cmd.getName().equalsIgnoreCase("menu")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				inv = p.getServer().createInventory(null, 27, "?6?bersicht");
				
				ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("?1");
				item.setItemMeta(meta);
				
				ItemStack item1 = new ItemStack(Material.ENDER_CHEST);
				ItemMeta meta1 = item1.getItemMeta();
				ArrayList<String> lore1 = new ArrayList<>();
				lore1.add("?e?ffnet deine Enderchest.");
				meta1.setLore(lore1);
				meta1.setDisplayName("?5Enderchest");
				item1.setItemMeta(meta1);
				
				ItemStack item2 = new ItemStack(Material.EMERALD);
				ItemMeta meta2 = item2.getItemMeta();
				ArrayList<String> lore2 = new ArrayList<>();
				lore2.add("?e?ffnet deine Geld ?bersicht.");
				lore2.add("?cComming Soon...");
				meta2.setLore(lore2);
				meta2.setDisplayName("?aBank");
				item2.setItemMeta(meta2);
				
				ItemStack item3 = new ItemStack(Material.ENDER_PEARL);
				ItemMeta meta3 = item3.getItemMeta();
				ArrayList<String> lore3 = new ArrayList<>();
				lore3.add("?e?ffnet das Warp Men?.");
				lore3.add("?cComming Soon...");
				meta3.setLore(lore3);
				meta3.setDisplayName("?1Warps");
				item3.setItemMeta(meta3);
				
				ItemStack item4 = new ItemStack(Material.DIAMOND);
				ItemMeta meta4 = item4.getItemMeta();
				ArrayList<String> lore4 = new ArrayList<>();
				lore4.add("?e?ffnet den Item-Shop.");
				lore4.add("?cComming Soon...");
				meta4.setLore(lore4);
				meta4.setDisplayName("?bShop");
				item4.setItemMeta(meta4);
				
				inv.setItem(0, item);
				inv.setItem(1, item);
				inv.setItem(2, item);
				inv.setItem(3, item);
				inv.setItem(4, item);
				inv.setItem(5, item);
				inv.setItem(6, item);
				inv.setItem(7, item);
				inv.setItem(8, item);
				inv.setItem(9, item);
				inv.setItem(10, item1);
				inv.setItem(11, item);
				inv.setItem(12, item4);
				inv.setItem(13, item);
				inv.setItem(14, item3);
				inv.setItem(15, item);
				inv.setItem(16, item2);
				inv.setItem(17, item);
				inv.setItem(18, item);
				inv.setItem(19, item);
				inv.setItem(20, item);
				inv.setItem(21, item);
				inv.setItem(22, item);
				inv.setItem(23, item);
				inv.setItem(24, item);
				inv.setItem(25, item);
				inv.setItem(26, item);
				
				p.openInventory(inv);
				return true;
			}else {
				sender.sendMessage("[System] Du kannst Diesen Befehl nur Ingame ausf?hren!");
			    return true;
			}	
		}
		
		if(cmd.getName().equalsIgnoreCase("clear")) {
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("system.clear")) {
					p.getInventory().clear();
					p.sendMessage("?7[?9System?7] ?fDein Inventar wurde erfolgreich geleert!");
					return true;
				}else {
					p.sendMessage("?7[?4ERROR?7] ?cDu hast keine Berechtigung f?r diesen Befehl!");
					return true;
				}
			}else {
				sender.sendMessage("[System] Du kannst Diesen Befehl nur Ingame ausf?hren!");
				return true;
			}
		}
						
		return true;
	}
	
	public Integer getMoney(String name) {
		File file = new File("plugins/System", "money.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int money = cfg.getInt(name+".money");
		return money;
	}
	
	@EventHandler
	public void onjoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		if(p.hasPermission("system.team")) {
			
			int hours = getConfig().getInt(p.getName()+".hours");
			int minutes = getConfig().getInt(p.getName()+".minutes");
			int seconds = getConfig().getInt(p.getName()+".seconds");
			
			e.setJoinMessage("?7[?cTeam-Mitglied?7] ?f"+p.getName()+" ist dem Server beigetreten!");
			
			e.getPlayer().sendMessage("?l?m================================");
			e.getPlayer().sendMessage("?eWillkommen auf Diesem Server");
			e.getPlayer().sendMessage("?eBenutze /help f?r eine Command ?bersicht");
			e.getPlayer().sendMessage("?eDeine Spielzeit betr?gt zurzeit:");
			e.getPlayer().sendMessage("?e"+hours+" Stunden "+minutes+" Minuten "+seconds+" Sekunden");
			e.getPlayer().sendMessage("?eUnd du Besitz:");
			e.getPlayer().sendMessage("?6"+getMoney(e.getPlayer().getName())+"$");
			e.getPlayer().sendMessage("?l?m================================");
		}else {
			int hours = getConfig().getInt(p.getName()+".hours");
			int minutes = getConfig().getInt(p.getName()+".minutes");
			int seconds = getConfig().getInt(p.getName()+".seconds");
			
			
			
			e.setJoinMessage("");
			
			e.getPlayer().sendMessage("?l?m================================");
			e.getPlayer().sendMessage("?eWillkommen auf Diesem Server");
			e.getPlayer().sendMessage("?eBenutze /help f?r eine Command ?bersicht");
			e.getPlayer().sendMessage("?eDeine Spielzeit betr?gt zurzeit:");
			e.getPlayer().sendMessage("?e"+hours+" Stunden "+minutes+" Minuten "+seconds+" Sekunden");
			e.getPlayer().sendMessage("?eUnd du Besitz:");
			e.getPlayer().sendMessage("?6"+getMoney(e.getPlayer().getName())+"$");
			e.getPlayer().sendMessage("?l?m================================");
		}
		
	}
	
	@EventHandler
	public void onleave(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		if(p.hasPermission("system.team")) {
			e.setQuitMessage("?7[?cTeam-Mitglied?7] ?f"+p.getName()+" hat den Server verlassen!");
		}else {
			e.setQuitMessage("");
		}
		
	}
	
	@EventHandler
	public void onkick(PlayerKickEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("system.team")) {
			e.setLeaveMessage("?7[?cTeam-Mitglied?7] ?f"+p.getName()+" wurde gekickt!");
		}else {
			e.setLeaveMessage("");
		}
		
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void registerEvents() {
		new InventoryListener(this);
		new ScoreboardClass(this);
		new ChatListener(this);
	}
	
	public void registerCommands() {
		StatsCommand cStatsCommand = new StatsCommand(this);
		getCommand("stats").setExecutor(cStatsCommand);
		
		getCommand("money").setExecutor(new EcoSystem(this));
		getCommand("msg").setExecutor(new msgCommand());
		getCommand("invsee").setExecutor(new InvSeeCommand());
		getCommand("clearchat").setExecutor(new ClearChatCommand());
		getCommand("ping").setExecutor(new PingCommand());

	}
	
	public void startTimer() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for(Player players : Bukkit.getOnlinePlayers()) {
					int hours = getConfig().getInt(players.getName()+".hours");
					int minutes = getConfig().getInt(players.getName()+".minutes");
					int seconds = getConfig().getInt(players.getName()+".seconds");
					
					seconds++;
					
					getConfig().set(players.getName()+".seconds", seconds);
					saveConfig();
					
					if(seconds == 60) {
						getConfig().set(players.getName()+".seconds", 0);
						minutes ++;
						getConfig().set(players.getName()+".minutes", minutes);
						saveConfig();
					}
					if(minutes == 60) {
						getConfig().set(players.getName()+".minutes", 0);
						hours ++;
						getConfig().set(players.getName()+".hours", hours);
						saveConfig();
					}
					
				}
				
			}
		}, 20*1, 20*1);
	}

}
