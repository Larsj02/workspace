package me.testplugin.main;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class onhitlistener implements Listener{
	
	public int percent(int currentValue, int percentadd){
        percentadd = percentadd + 100;		
		float percent = (currentValue) *percentadd/100;        
        return (int)percent;
        }
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		System.out.println("oof");
		if(e.getDamager() instanceof Player){
			System.out.println("sheesh");
			Player p = (Player)e.getDamager();
			ItemStack item = p.getInventory().getItemInHand();
			
			if(item.containsEnchantment(Enchantment.FIRE_ASPECT)) {
				int firstdamage = (int) e.getDamage();
				System.out.println("dame");
				System.out.println(firstdamage);
				int bonusdamage = percent(firstdamage, 25);
				int lifesteal = bonusdamage/2;
				int phealth = (int) p.getHealth();
				int phandlifesteal = phealth+lifesteal;
				System.out.println(phandlifesteal);
				if(phandlifesteal > 20) {
					p.setHealth(20);
				}else {
					p.setHealth(phandlifesteal);
				}
				System.out.println(bonusdamage);
				e.setDamage(bonusdamage);
			}
		}
	}
}
