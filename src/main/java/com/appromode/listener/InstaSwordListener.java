package com.appromode.listener;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.ci.Initialise;
import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class InstaSwordListener implements Listener {

	@Inject
	private Initialise plugin;

	int secToMin(int seconds) {
		return (seconds / 60) + 1;
	}

	int secToHour(int seconds) {
		return ((seconds / 60) / 60) + 1;
	}

	@EventHandler
	public void useInstaSword(PlayerInteractEvent event) {
		String sPlayer = event.getPlayer().getName();
		Player player = Bukkit.getPlayer(sPlayer);
		UUID uuid = player.getUniqueId();
		ItemStack item = event.getItem();

		if (player.getWorld().getName().equals(plugin.warzone)) {
			if (player.getInventory().getItemInMainHand().getType().equals(Material.WOOD_SWORD)) {
				if (item != null) {
					if (item.getItemMeta() == null) {
						return;
					} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Insta-Kill Sword")) {
						if (plugin.ikCooldownTime.containsKey(uuid)) {
							event.setCancelled(true);
							if (plugin.ikCooldownTime.get(uuid) >= 3600) {
								player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
										+ "You cannot use an insta-kill sword for "
										+ secToHour(plugin.ikCooldownTime.get(uuid)) + " hour(s)");
								return;
							} else if (plugin.ikCooldownTime.get(uuid) >= 60) {
								player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
										+ "You cannot use an insta-kill sword for "
										+ secToMin(plugin.ikCooldownTime.get(uuid)) + " minute(s)");
								return;
							} else if (plugin.ikCooldownTime.get(uuid) < 59) {
								player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
										+ "You cannot use an insta-kill sword for " + plugin.ikCooldownTime.get(uuid)
										+ " second(s)");
								return;
							}
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
				return;
			}
		} else {
			if (player.getInventory().getItemInMainHand().getType().equals(Material.WOOD_SWORD)) {
				if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Insta-Kill Sword")) {
					event.setCancelled(true);
					return;
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}

	@EventHandler
	public void killInstaSword(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			Player attacker = (Player) event.getDamager();
			ItemStack item = attacker.getInventory().getItemInMainHand();
			final UUID uuid = attacker.getUniqueId();
			if (attacker.getWorld().getName().equals(plugin.warzone)) {
				if (event.getEntity() instanceof Player) {
					Player entity = (Player) event.getEntity();
					if (item.getType().equals(Material.WOOD_SWORD)) {
						if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Insta-Kill Sword")) {
							if (!plugin.ikCooldownTask.containsKey(uuid)) {
								event.setCancelled(true);
								if (item.getAmount() == 1) {
									attacker.getInventory().remove(item);
								} else if (item.getAmount() > 1) {
									item.setAmount(item.getAmount() - 1);
								} else {
									attacker.sendMessage(plugin.servern + " " + plugin.error);
									return;
								}
								entity.setHealth(0);
								attacker.sendMessage(plugin.servern + " You have insta killed " + entity.getName());
								entity.sendMessage(
										plugin.servern + " You have been insta killed by " + attacker.getName());
								plugin.ikCooldownTime.put(uuid, 86400);
								plugin.ikCooldownTask.put(uuid, new BukkitRunnable() {
									public void run() {
										if (plugin.ikCooldownTime.containsKey(uuid)) {
											plugin.ikCooldownTime.put(uuid, plugin.ikCooldownTime.get(uuid) - 1);
											if (plugin.ikCooldownTime.get(uuid).equals(0)) {
												plugin.ikCooldownTime.remove(uuid);
												plugin.ikCooldownTask.remove(uuid);
											}
										} else {
											cancel();
										}
									}
								});
								return;
							} else {
								event.setCancelled(true);
								return;
							}
						} else {
							return;
						}
					} else {
						return;
					}
				} else {
					if (item.getType().equals(Material.WOOD_SWORD)) {
						if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Insta-Kill Sword")) {
							event.setCancelled(true);
							ActionBarAPI.sendActionBar(attacker,
									ChatColor.DARK_PURPLE + "You can only use this item on a player");
							return;
						} else {
							return;
						}
					} else {
						return;
					}
				}
			} else {
				if (item.getType().equals(Material.WOOD_SWORD)) {
					if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Insta-Kill Sword")) {
						event.setCancelled(true);
						ActionBarAPI.sendActionBar(attacker,
								ChatColor.DARK_PURPLE + "You cannot use this item in this world");
						return;
					} else {
						return;
					}
				} else {
					return;
				}
			}
		} else {
			return;
		}
	}

}
