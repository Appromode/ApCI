package com.appromode.listener;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.ci.Initialise;
import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class FlightOrbListener implements Listener {

	@Inject
	private Initialise plugin;

	@EventHandler
	public void foUse(PlayerInteractEvent event) {
		String sPlayer = event.getPlayer().getName();
		Player player = Bukkit.getPlayer(sPlayer);
		final UUID uuid = player.getUniqueId();
		ItemStack item = event.getItem();

		if (player.getWorld().getName().equals("ASkyBlock")) {
			if (!plugin.foCooldownTime.containsKey(uuid)) {
				if (!plugin.foTimes.containsKey(uuid)) {
					if (item == null) {
						return;
					} else if (item.getType().equals(Material.MAGMA_CREAM)) {
						if (item.getItemMeta() == null) {
							return;
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Minute]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 1 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 60);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Minutes]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 2 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 120);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [3 Minutes]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 3 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 180);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Minutes]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 4 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 240);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [5 Minutes]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 5 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 300);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [10 Minutes]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 10 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 600);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [15 Minutes]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 15 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 900);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [30 Minutes]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 30 minute flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 1800);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Hour]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 1 hour flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 3600);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Hours]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 2 hour flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 7200);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Hours]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 4 hour flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 14400);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else if (event.getItem().getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [8 Hours]")) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You have redeemed a 8 hour flight orb. If you teleport out of the skyblock world, the effects of the flight orb will be paused but the timer will not stop unless you do "
									+ ChatColor.LIGHT_PURPLE + "/apci flight pause");
							if (item.getAmount() == 1) {
								player.getInventory().remove(item);
							} else if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
							} else {
								return;
							}

							plugin.foCooldownTime.put(uuid, 28800);
							plugin.foCooldownTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.foCooldownTime.containsKey(uuid)) {
										plugin.foCooldownTime.put(uuid, plugin.foCooldownTime.get(uuid) - 1);
										if (plugin.foCooldownTime.get(uuid).equals(0)) {
											plugin.foCooldownTime.remove(uuid);
											plugin.foCooldownTask.remove(uuid);
										}
									} else {
										cancel();
									}
								}
							});
							plugin.foCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
						} else {
							return;
						}
					} else {
						return;
					}
				} else {
					if (item == null) {
						return;
					} else if (item.getType().equals(Material.MAGMA_CREAM)) {
						if (item.getItemMeta() == null) {
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Minute]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Minutes]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [3 Minutes]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Minutes]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [5 Minutes]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [10 Minutes]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [15 Minutes]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [30 Minutes]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Hour]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Hours]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Hours]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [8 Hours]")) {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have a flight orb activated");
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " Your activated flight orb is currently paused");
							return;
						}
					} else {
						return;
					}
				}
			} else {
				if (item == null) {
					return;
				} else if (item.getType().equals(Material.MAGMA_CREAM)) {
					if (item.getItemMeta() == null) {
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Minute]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Minutes]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [3 Minutes]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Minutes]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [5 Minutes]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [10 Minutes]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [15 Minutes]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [30 Minutes]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Hour]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Hours]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Hours]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [8 Hours]")) {
						event.setCancelled(true);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " You already have a flight orb activated");
						return;
					} else {
						return;
					}
				} else {
					return;
				}
			}
		} else {
			if (item == null) {
				return;
			} else if (item.getType().equals(Material.MAGMA_CREAM)) {
				if (item.getItemMeta() == null) {
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Minute]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Minutes]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [3 Minutes]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Minutes]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [5 Minutes]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [10 Minutes]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [15 Minutes]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [30 Minutes]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Hour]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Hours]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Hours]")) {
					event.setCancelled(true);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + "You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [8 Hours]")) {
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
