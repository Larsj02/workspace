package me.bansystem.listener;

import java.util.Iterator;
import me.bansystem.main.main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;





public class PlayerClickEvent
  implements Listener
{
  @EventHandler
  public void onClick(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    
    if (e.getInventory().getName().equalsIgnoreCase("")) {
      e.setCancelled(true);
      
      Iterator<String> iterator = main.getPlugin().getConfig().getConfigurationSection("bansystem").getKeys(false).iterator(); while (iterator.hasNext()) { String BanReasons = iterator.next();
        String BanReason = main.getPlugin().getConfig()
          .getString("bansystem." + BanReasons + ".BanReason");
        int ItemID = main.getPlugin().getConfig().getInt("bansystem." + BanReasons + ".ItemID");
        int minutes = main.getPlugin().getConfig().getInt("bansystem." + BanReasons + ".BanTimeInMin");
        Material CMaterial = Material.getMaterial(ItemID);
        String ServerName = main.getPlugin().getConfig().getString("servername");
        if (e.getCurrentItem().getType() == CMaterial) {
          
          main.getPlugin().getConfig().set("BanList." + p.getUniqueId().toString(), p.getName());
          main.getPlugin().getConfig().set("Player." + p.getUniqueId() + ".ban", Boolean.valueOf(true));
          main.getPlugin().getConfig().set("Player." + p.getUniqueId() + ".minutes", Integer.valueOf(minutes));
          main.getPlugin().getConfig().set("Player." + p.getUniqueId() + ".Reason", BanReason);
          p.kickPlayer("have been Banned from" + ServerName + "!\n" + "\n" + BanReason);
          main.getPlugin().saveConfig();
        }  }
    
    } 
  }
}
