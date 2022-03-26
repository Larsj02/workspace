package me.bansystem.command;

import java.util.UUID;
import me.bansystem.main.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;




public class UnBanCommand
  implements CommandExecutor
{
  String error = main.getPlugin().getConfig().getString("errorunban");
  String noperm = main.getPlugin().getConfig().getString("nopermission");

  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender.hasPermission("bansystem.ban")) {
      if (args.length == 1) {
        UUID targetuuid = UUID.fromString(args[0]);
        main.getPlugin().getConfig().set("Player." + targetuuid + ".ban", Boolean.valueOf(false));
        String playername = main.getPlugin().getConfig().getString("BanList." + targetuuid);
        sender.sendMessage(String.valueOf(playername) + " is now unbanned!");
      } else {
        sender.sendMessage(this.error);
      } 
    } else {
      sender.sendMessage(this.noperm);
    } 
    return true;
  }
}
