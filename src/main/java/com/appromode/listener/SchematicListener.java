package com.appromode.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

import net.md_5.bungee.api.ChatColor;

public class SchematicListener implements Listener {
	
	@EventHandler
	public void sUse(PlayerInteractEvent event) {
		String sPlayer = event.getPlayer().getName();
		Player player = Bukkit.getPlayer(sPlayer);
		ItemStack item = event.getItem();

		if (player.getWorld().getName().equals("ASkyBlock")) {
			if (item == null) {
				return;
			} else if (item.getType().equals(Material.PAPER)) {
				if (item.getItemMeta() == null) {
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 1")) {
					event.setCancelled(true);
					if (item.getAmount() == 1) {
						player.getInventory().remove(item);
					} else if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					} else {
						return;
					}
					
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			if (item == null) {
				return;
			} else if (item.getType().equals(Material.PAPER)) {
				if (item.getItemMeta() == null) {
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 1")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 2")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 3")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 4")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 5")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 6")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 7")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 8")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 9")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Placeable Schematic" + ChatColor.WHITE + " 10")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
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
