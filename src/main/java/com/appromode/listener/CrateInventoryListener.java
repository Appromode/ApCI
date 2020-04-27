package com.appromode.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.appromode.ci.Initialise;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class CrateInventoryListener implements Listener {
	
	@Inject
	private Initialise plugin;
	
	public void onCraftMenuClick(InventoryClickEvent event) {
		
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null) {
			return;
		} else {
			if (open.getName().equals(plugin.servern + ChatColor.WHITE + " Tyche Kit Shard")) {
				event.setCancelled(true);
				if (item == null || !item.hasItemMeta()) {
					return;
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}

}
