package me.bansystem.command;

import java.util.ArrayList;
import java.util.Iterator;
import me.bansystem.main.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class BanCommand
  implements CommandExecutor
{
  public Inventory inv = null;



  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    String error = main.getPlugin().getConfig().getString("error");
    String noperm = main.getPlugin().getConfig().getString("nopermission");
    
    if (sender instanceof Player) {
      Player p = (Player)sender;
      if (p.hasPermission("bansystem.ban")) {
        if (args.length == 1) {
          Player target = Bukkit.getPlayer(args[0]);
          if (target != null) {
            int size = main.getPlugin().getConfig().getConfigurationSection("bansystem").getKeys(false)
              .size();
            int items = 9;
            if (size > 9) {
              this.inv = p.getServer().createInventory(null, 27, "");
              if (size > 18) {
                this.inv = p.getServer().createInventory(null, 36, "");
                if (size > 27) {
                  this.inv = p.getServer().createInventory(null, 45, "");
                  if (size > 36) {
                    this.inv = p.getServer().createInventory(null, 54, "");
                  }
                } 
              } 
            } else {
              this.inv = p.getServer().createInventory(null, 18, "");
            } 
            
            Iterator<String> iterator = main.getPlugin().getConfig().getConfigurationSection("bansystem").getKeys(false).iterator(); while (iterator.hasNext()) { String BanReasons = iterator.next();
              String BanReason = main.getPlugin().getConfig()
                .getString("bansystem." + BanReasons + ".BanReason");
              int ItemID = main.getPlugin().getConfig().getInt("bansystem." + BanReasons + ".ItemID");
              Material CMaterial = Material.getMaterial(ItemID);
              
              ItemStack item = new ItemStack(CMaterial);
              ItemMeta meta = item.getItemMeta();
              ArrayList<String> lore = new ArrayList<>();
              lore.add("30Days");
              meta.setLore(lore);
              meta.setDisplayName(BanReason);
              item.setItemMeta(meta);
              
              ItemStack item1 = new ItemStack(Material.STAINED_GLASS_PANE);
              ItemMeta meta1 = item1.getItemMeta();
              meta1.setDisplayName("");
              item1.setItemMeta(meta1);
              
              ItemStack item2 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
              SkullMeta meta2 = (SkullMeta)item2.getItemMeta();
              meta2.setOwner(args[0]);
              meta2.setDisplayName(target.getName());
              item2.setItemMeta((ItemMeta)meta2);
              
              this.inv.setItem(0, item1);
              this.inv.setItem(1, item1);
              this.inv.setItem(2, item1);
              this.inv.setItem(3, item1);
              this.inv.setItem(4, item2);
              this.inv.setItem(5, item1);
              this.inv.setItem(6, item1);
              this.inv.setItem(7, item1);
              this.inv.setItem(8, item1);
              this.inv.setItem(items, item);
              items++;
              p.openInventory(this.inv); }
          
          } else {
            p.sendMessage("This Player isn't online");
          } 
        } else {
          p.sendMessage(error);
        } 
      } else {
        p.sendMessage(noperm);
      } 
    } else {
      sender.sendMessage("[BanSystem] This Command can't be used in the console!");
    } 
    return true;
  }
}
