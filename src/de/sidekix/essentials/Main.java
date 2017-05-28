package de.sidekix.essentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	
  public static String Prefix = "§a[sidekixEssentials] ";
  public static String wuerfel = "[Würfel] ";
  public static String wuerfelbr = "[Würfel-Broadcast] ";
  public static String wuerfeldb = "[Würfel-Debug] ";
  
  public void onEnable()
  
  {
	  // bStats vorbereitung 
      // Metrics metrics = new Metrics(this);
      
      // Konsolenausgabe wenn das Plugin geloaden wird
	  Bukkit.getConsoleSender().sendMessage(Prefix + " Plugin wird geladen ...");
	  
	  try
    {
	  // Befehle registrieren ...
      register();
    }
    catch (Exception e1)
    {
      // Ausgabe bei einem Fehler ...
      Bukkit.getConsoleSender().sendMessage(Prefix + " Das Plugin konnte nicht geladen werden!");
      
      return;
    }
    Bukkit.getConsoleSender().sendMessage(Prefix + " Das Plugin wurde geladen!");
    Bukkit.getConsoleSender().sendMessage(Prefix + " Module: Wuerfeln, bStats");
  }
  
  public void register()
  {
    getCommand("wuerfel").setExecutor(new CommandWuerfel());
    getCommand("wp").setExecutor(new CommandWuerfel());
  }
}