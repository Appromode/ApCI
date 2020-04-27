package com.appromode.listener;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.appromode.ci.Initialise;
import com.appromode.utils.CrateAnimation;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class KitShardListener implements Listener {

	@Inject
	private Initialise plugin;
	
	@Inject
	private CrateAnimation cs;

	@EventHandler
	public void ksUse(PlayerInteractEvent event) {
		String sPlayer = event.getPlayer().getName();
		Player player = Bukkit.getPlayer(sPlayer);
		ItemStack item = event.getItem();
		

		if (player.getWorld().getName().equals("ASkyBlock")) {
			if (item == null) {
				return;
			} else if (item.getType().equals(Material.TRIPWIRE_HOOK)) {
				if (item.getItemMeta() == null) {
				    return;	
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Tyche" + ChatColor.WHITE + " Kit Shard")) {
					cs.tycheKitShardAnimation(player);
					if (item.getAmount() == 1) {
						player.getInventory().removeItem(item);
						return;
					} else if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
						return;
					}
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Artemis" + ChatColor.WHITE + " Kit Shard")) {
					
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Demeter" + ChatColor.WHITE + " Kit Shard")) {
					
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Hephaetus" + ChatColor.WHITE + " Kit Shard")) {
					
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Hades" + ChatColor.WHITE + " Kit Shard")) {
					
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Nemesis" + ChatColor.WHITE + " Kit Shard")) {
					
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Random" + ChatColor.WHITE + " Kit Shard")) {
					
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			if (item == null) {
				return;
			} else if (item.getType().equals(Material.TRIPWIRE_HOOK)) {
				if (item.getItemMeta() == null) {
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Tyche" + ChatColor.WHITE + " Kit Shard")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Artemis" + ChatColor.WHITE + " Kit Shard")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Demeter" + ChatColor.WHITE + " Kit Shard")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Hephaetus" + ChatColor.WHITE + " Kit Shard")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Hades" + ChatColor.WHITE + " Kit Shard")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Nemesis" + ChatColor.WHITE + " Kit Shard")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Random" + ChatColor.WHITE + " Kit Shard")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
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
