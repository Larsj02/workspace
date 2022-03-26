package me.lobbysystem.listener;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerMoveListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getLocation().getBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
			if(p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.REDSTONE_BLOCK) {
				Vector v = p.getLocation().getDirection().multiply(2D).setY(1);
				p.setVelocity(v);
				p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
				p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
			}
		}
	}

}
