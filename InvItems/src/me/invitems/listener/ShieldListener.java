package me.invitems.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.invitems.main.main;

public class ShieldListener implements Listener{
	
	HashMap<Player, BukkitRunnable> run = new HashMap<>();
	
	@EventHandler
	public void onInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = p.getInventory();
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Schild §aAktivieren")) {
			ItemStack Schild = new ItemStack(Material.REDSTONE);
			ItemMeta SMeta = Schild.getItemMeta();
			ArrayList<String> SLore = new ArrayList<>();
			SLore.add("§7§oLässt Spieler wieder in dein nähe!");
			SLore.add("§7§oAnklicken zum Deaktivieren.");
			SMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
			SMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			SMeta.setLore(SLore);
			SMeta.setDisplayName("§7Schild §cDeaktivieren");
			Schild.setItemMeta(SMeta);
			
			inv.setItem(31, Schild);
			
			run.put(p, new BukkitRunnable() {
				@Override
				public void run() {
					p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 3);
				}
			});
			run.get(p).runTaskTimer(main.getPlugin(), 20, 20);
			p.sendMessage(main.getPlugin().getConfig().getString("shield_activate"));
		}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Schild §cDeaktivieren")) {
			ItemStack Schild = new ItemStack(Material.REDSTONE);
			ItemMeta SMeta = Schild.getItemMeta();
			ArrayList<String> SLore = new ArrayList<>();
			SLore.add("§7§oHält andere Spieler von dir fern!");
			SLore.add("§7§oAnklicken zum Aktivieren.");
			SMeta.setLore(SLore);
			SMeta.setDisplayName("§7Schild §aAktivieren");
			Schild.setItemMeta(SMeta);
			
			inv.setItem(31, Schild);
			
			run.get(p).cancel();
			run.remove(p);
			p.sendMessage(main.getPlugin().getConfig().getString("shield_deactivate"));
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(run.containsKey(e.getPlayer())){
			run.get(e.getPlayer()).cancel();
			run.remove(e.getPlayer());
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		for(Player players : run.keySet()) {
			if(p != players) {
				if(p.getLocation().distance(players.getLocation()) <= 2) {
					
					double Ax = p.getLocation().getX();
					double Ay = p.getLocation().getY();
					double Az = p.getLocation().getZ();
					
					double Bx = players.getLocation().getX();
					double By = players.getLocation().getY();
					double Bz = players.getLocation().getZ();
					
					double x = Ax - Bx;
					double y = Ay - By;
					double z = Az - Bz;
					
					Vector v = new Vector(x, y, z).normalize().multiply(2D).setY(0.3D);
					p.setVelocity(v);
					p.sendMessage(main.getPlugin().getConfig().getString("shield_knockback"));
				}
			}
		}
		
		if(run.containsKey(p)) {
			for(Entity entity : p.getNearbyEntities(2, 2, 2)) {
				if(entity instanceof Player) {
					Player target = (Player) entity;
					if(p != target) {
						double Ax = p.getLocation().getX();
						double Ay = p.getLocation().getY();
						double Az = p.getLocation().getZ();
						
						double Bx = target.getLocation().getX();
						double By = target.getLocation().getY();
						double Bz = target.getLocation().getZ();
						
						double x = Bx - Ax;
						double y = By - Ay;
						double z = Bz - Az;
						
						Vector v = new Vector(x, y, z).normalize().multiply(2D).setY(0.3D);
						target.setVelocity(v);
						target.sendMessage(main.getPlugin().getConfig().getString("shield_knockback"));
					}
				}
			}
		}
	}

}
