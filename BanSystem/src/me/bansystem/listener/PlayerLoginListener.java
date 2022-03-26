package me.bansystem.listener;

import java.text.ParseException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import me.bansystem.main.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPreLoginEvent;










public class PlayerLoginListener
  implements Listener
{
  public static String millisecondToFullTime(long millisecond) { return timeUnitToFullTime(millisecond, TimeUnit.MILLISECONDS); }


  
  public static String secondToFullTime(long second) { return timeUnitToFullTime(second, TimeUnit.SECONDS); }

  
  public static String timeUnitToFullTime(long time, TimeUnit timeUnit) {
    long day = timeUnit.toDays(time);
    long hour = timeUnit.toHours(time) % 24L;
    long minute = timeUnit.toMinutes(time) % 60L;
    if (day > 0L)
      return String.format("%dd %02dh %02dm", new Object[] { Long.valueOf(day), Long.valueOf(hour), Long.valueOf(minute) }); 
    if (hour > 0L) {
      return String.format("%dh %02dm", new Object[] { Long.valueOf(hour), Long.valueOf(minute) });
    }
    return String.format("%dm", new Object[] { Long.valueOf(minute) });
  }

  
  @EventHandler
  public void onlogin(PlayerPreLoginEvent e) throws ParseException {
    UUID p = e.getUniqueId();
    Player pl = Bukkit.getPlayer(p);
    int ende = main.getPlugin().getConfig().getInt("Player." + p + ".minutes");
    boolean Bann = main.getPlugin().getConfig().getBoolean("Player." + p + ".ban");
    String Reason = main.getPlugin().getConfig().getString("Player." + p + ".Reason");
    String ServerName = main.getPlugin().getConfig().getString("servername");

    
    ende *= 60;
    String endeformat = secondToFullTime(ende);
    if (Bann)
      e.disallow(null, "have been Banned from" + ServerName + "!\n" + "\n" + Reason + "\n \ntime" + endeformat); 
  }
}
