package com.bubbamc.listeners;

import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import com.bubbamc.events.SpawnerBreakEvent;

public class CustomListener implements Listener{

	public CustomListener() {
		
	}
	
	@EventHandler
	public void onSpawnerBreak(SpawnerBreakEvent e) {
		
		CreatureSpawner broken_Spawner = (CreatureSpawner) e.getSpawner().getState();
		ItemStack spawnerToGive = new ItemStack(Material.SPAWNER, 1);
		
		// get spawner meta info
		BlockStateMeta meta = (BlockStateMeta) spawnerToGive.getItemMeta();
		CreatureSpawner new_Spawner = (CreatureSpawner) meta.getBlockState();
		
		// set spawner item meta
		new_Spawner.setSpawnedType(broken_Spawner.getSpawnedType());
		meta.setBlockState(new_Spawner);
		spawnerToGive.setItemMeta(meta);
		

		e.getBreaker().getInventory().addItem(spawnerToGive);
		
	}
	
}
