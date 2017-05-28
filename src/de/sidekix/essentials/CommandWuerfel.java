package de.sidekix.essentials;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWuerfel
  implements CommandExecutor
{
  int gewuerfelteAugenzahl = new Random().nextInt(6) + 1;
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
  {
    Player p = (Player)sender;
    int gewuerfeltezahl = new Random().nextInt(6) + 1;
    if ((cmd.getName().equalsIgnoreCase("wuerfel")) && 
      (p.hasPermission("wuerfel.cmd")) && 
      (args.length == 0))
    {
      Bukkit.broadcastMessage(ChatColor.YELLOW + Main.wuerfelbr + ChatColor.LIGHT_PURPLE + p.getPlayer().getName() + ChatColor.GOLD + " hat die Zahl " + ChatColor.GREEN + gewuerfeltezahl + ChatColor.GOLD + " gew�rfelt!");
      p.sendMessage(ChatColor.YELLOW + Main.wuerfeldb + ChatColor.GOLD + "Du hast eine " + ChatColor.GREEN + gewuerfeltezahl + ChatColor.GOLD + " gewuerfelt!");
    }
    if ((cmd.getName().equalsIgnoreCase("wp")) && 
      (p.hasPermission("wuerfel.public.cmd")) && 
      (args.length == 0)) {
      Bukkit.broadcastMessage(ChatColor.YELLOW + Main.wuerfelbr + ChatColor.LIGHT_PURPLE + p.getPlayer().getName() + ChatColor.GOLD + " hat die Zahl " + ChatColor.GREEN + gewuerfeltezahl + ChatColor.GOLD + " gew�rfelt!");
    }
    return false;
  }
}
