package com.bubbamc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.bubbamc.listeners.BlockBreakListener;
import com.bubbamc.listeners.CustomListener;

public class SpawnerDropper extends JavaPlugin{

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		getServer().getPluginManager().registerEvents(new CustomListener(), this);
		Bukkit.getServer().getLogger().info("Spawner Dropper v" + this.getDescription().getVersion() + " enabled!");
	}
	
	public void onDisable() {
		Bukkit.getServer().getLogger().info("Spawner Dropper v" + this.getDescription().getVersion() + " disabled!");
	}
	
}
