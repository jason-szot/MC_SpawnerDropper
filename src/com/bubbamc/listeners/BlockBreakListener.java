package com.bubbamc.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.bubbamc.events.SpawnerBreakEvent;

public class BlockBreakListener implements Listener{

	public BlockBreakListener() {
		
	}
	
	@EventHandler (priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent e){
        
		
        Block broken = e.getBlock();
        
        // check if block broken is a spawner, and if the tool had Silk Touch
        
		if (broken.getType().equals(Material.SPAWNER) && e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
			Bukkit.getServer().getPluginManager().callEvent(new SpawnerBreakEvent(e.getPlayer(), broken));
		}
		
        }
	
}
