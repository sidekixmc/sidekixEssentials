package de.sidekix.essentials;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	String version;
	String name;

	public static String Prefix = "§a[sidekixEssentials] ";
	public static String wuerfel = "[Würfel] ";
	public static String wuerfelbr = "[Würfel-Broadcast] ";
	public static String wuerfeldb = "[Würfel-Debug] ";

	public void onEnable() {

		// Konsolenausgabe wenn das Plugin geloaden wird
		Bukkit.getConsoleSender().sendMessage(Prefix + " Plugin wird geladen ...");

		initConfig(); // config.yml anlegen oder neu einlesen

		try {
			// Befehle registrieren ...
			register();
		} catch (Exception e1) {
			// Ausgabe bei einem Fehler ...
			Bukkit.getConsoleSender().sendMessage(Prefix + " Das Plugin konnte nicht geladen werden!");

			return;
		}
		Bukkit.getConsoleSender().sendMessage(Prefix + " Das Plugin wurde geladen!");
		Bukkit.getConsoleSender().sendMessage(Prefix + " Module: Wuerfeln");
	}

	private void initConfig() {

		this.reloadConfig(); // Config Datei im Ordner Plugins neu einlesen

		this.getConfig().options().header("1. Zeile");
		this.getConfig().addDefault("sidekisEssentials.MySQL.Enable", "false");
		this.getConfig().addDefault("sidekisEssentials.MySQL.Benutzername", "Benutzername");
		this.getConfig().addDefault("sidekisEssentials.MySQL.Passwort", "Passwort");
		this.getConfig().addDefault("sidekisEssentials.MySQL.Datenbank", "Datenbank");
		this.getConfig().addDefault("sidekisEssentials.MySQL.Host", "Host");

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		System.out.println("[sidekixxx] Succefully (re)load config.yml");
	}

	public void register() {
		getCommand("wuerfel").setExecutor(new CommandWuerfel());
		getCommand("wp").setExecutor(new CommandWuerfel());
	}
}