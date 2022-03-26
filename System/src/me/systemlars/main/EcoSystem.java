package me.systemlars.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class EcoSystem implements CommandExecutor {
	
private main plugin;
	
	public EcoSystem(main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage("§7[§aMoney§7] §e Du besitzt momentan §6"+getMoney(p.getName())+"$");
			}else if(args.length == 3) {
				if(args[0].equalsIgnoreCase("add")) {
                    if(p.hasPermission("system.team")) {
						String target = args[1];
						Integer amount = Integer.valueOf(args[2]);
						addMoney(target, amount);
						p.sendMessage("§7[§aMoney§7] §e Dem Spieler "+target+" wurden §6"+amount+"$ §e hinzugefügt!");
					}else{
						p.sendMessage("§7[§4ERROR§7] §cDu hast keine Berechtigung für diesen Befehl!");
					}
				}else if(args[0].equalsIgnoreCase("remove")) {
					if(p.hasPermission("system.team")) {
						String target = args[1];
						Integer amount = Integer.valueOf(args[2]);
						removeMoney(target, amount);
						p.sendMessage("§7[§aMoney§7] §e Dem Spieler "+target+" wurden §6"+amount+"$ §e entfernt!");
					}else {
						p.sendMessage("§7[§4ERROR§7] §cDu hast keine Berechtigung für diesen Befehl!");
					}
				}else if(args[0].equalsIgnoreCase("set")) {
                    if(p.hasPermission("system.team")) {
                    	String target = args[1];
						Integer amount = Integer.valueOf(args[2]);
						setMoney(target, amount);
						p.sendMessage("§7[§aMoney§7] §e Das Geld von "+target+" wurde auf §6"+amount+"$ §e gesetzt!");
					}else {
						p.sendMessage("§7[§4ERROR§7] §cDu hast keine Berechtigung für diesen Befehl!");
					}
				}else {
						p.sendMessage("§7[§4ERROR§7] §c/money (<add|remove|set>) (<name>) (<menge>)");
						return true;
				}
			}else {
				if(p.hasPermission("system.team")) {
					String target = args[0];
					Player target1 = plugin.getServer().getPlayer(target);
					p.sendMessage("§7[§aMoney§7] §e"+target+" hat §6"+getMoney(target1.getName())+"$");
					return true;
				}else {
					p.sendMessage("§7[§4ERROR§7] §c/money (<add|remove|set>) (<name>) (<menge>)");
					return true;
				}
			}
			
		}else {
			sender.sendMessage("[System] Du kannst Diesen Befehl nur Ingame ausführen!");
			return true;
		}
		
		return true;
	}

	public Integer getMoney(String name) {
		File file = new File("plugins/System", "money.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int money = cfg.getInt(name+".money");
		return money;
	}
	
	public void addMoney(String name, int amount) {
		File file = new File("plugins/System", "money.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int money = cfg.getInt(name+".money");
		money=money+amount;
		cfg.set(name+".money", money);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeMoney(String name, int amount) {
		File file = new File("plugins/System", "money.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int money = cfg.getInt(name+".money");
		money=money-amount;
		cfg.set(name+".money", money);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setMoney(String name, int amount) {
		File file = new File("plugins/System", "money.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set(name+".money", amount);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasEnoughMoney(String name, int amount) {
		File file = new File("plugins/System", "money.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int money = cfg.getInt(name+".money");
		if(money >= amount) {
			return true;
		}else {
			return false;
		}
	}
	
}
