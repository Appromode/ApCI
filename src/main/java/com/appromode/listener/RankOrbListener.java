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
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class RankOrbListener implements Listener {

	@Inject
	private Initialise plugin;

	int secToMin(int seconds) {
		return (seconds / 60) + 1;
	}

	int secToHour(int seconds) {
		return ((seconds / 60) / 60) + 1;
	}

	@EventHandler
	public void roUse(PlayerInteractEvent event) {
		String sPlayer = event.getPlayer().getName();
		Player player = Bukkit.getPlayer(sPlayer);
		final UUID uuid = player.getUniqueId();
		ItemStack item = event.getItem();
		if (player.getWorld().getName().equals("ASkyBlock")) {
			if (item == null) {
				return;
			} else if (player.getInventory().getItemInMainHand().getType().equals(Material.SLIME_BALL)) {
				if (item.getItemMeta() == null) {
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hermes")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.hermes")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 1);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the hermes rank or higher and so cannot redeem this item");
							return;
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Apollo")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.apollo")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 2);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the apollo rank or higher and so cannot redeem this item");
							return;
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Ares")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.ares")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 3);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the ares rank or higher and so cannot redeem this item");
							return;
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hera")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.hera")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 4);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the hera rank or higher and so cannot redeem this item");
							return;
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Poseidon")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.poseidon")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 5);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the poseidon rank or higher and so cannot redeem this item");
							return;
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Zeus")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.zeus")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 6);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTime.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the zeus rank or higher and so cannot redeem this item");
							return;
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Atlas")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.atlas")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 7);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the top rank and so cannot use this item");
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
					if (!plugin.confirmTime.containsKey(uuid)) {
						if (!player.hasPermission("apci.rank.hermes")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 8);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else if (!player.hasPermission("apci.rank.apollo")
								&& player.hasPermission("apci.rank.hermes")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 9);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else if (!player.hasPermission("apci.rank.ares")
								&& player.hasPermission("apci.rank.apollo")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 10);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else if (!player.hasPermission("apci.rank.hera") && player.hasPermission("apci.rank.ares")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 11);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else if (!player.hasPermission("apci.rank.poseidon")
								&& player.hasPermission("apci.rank.hera")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 12);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else if (!player.hasPermission("apci.rank.zeus")
								&& player.hasPermission("apci.rank.poseidon")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 13);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else if (!player.hasPermission("apci.rank.atlas") && player.hasPermission("apci.rank.zeus")) {
							event.setCancelled(true);
							plugin.ciConfirmed.put(uuid, 14);
							plugin.confirmTime.put(uuid, 30);
							plugin.confirmTask.put(uuid, new BukkitRunnable() {
								@Override
								public void run() {
									if (plugin.confirmTime.containsKey(uuid)) {
										plugin.confirmTime.put(uuid, plugin.confirmTime.get(uuid) - 1);
										if (plugin.confirmTime.get(uuid).equals(0)) {
											plugin.confirmTime.remove(uuid);
											plugin.ciConfirmed.remove(uuid);
											plugin.confirmTask.remove(uuid);
											cancel();
										}
									} else {
										cancel();
									}
								}
							});
							plugin.confirmTask.get(uuid).runTaskTimer(plugin, 20, 20);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " Type "
									+ ChatColor.LIGHT_PURPLE + "/acpi confirm" + ChatColor.DARK_PURPLE
									+ " within 30 seconds to confirm the rank upgrade");
							return;
						} else {
							event.setCancelled(true);
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
									+ " You already have the top rank and so cannot use this item");
							return;
						}
					} else {
						event.setCancelled(true);
						player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " You are already in the middle of confirming a rank orb");
						return;
					}
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			if (player.getInventory().getItemInMainHand().getType().equals(Material.SLIME_BALL)) {
				if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hermes")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Apollo")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Ares")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hera")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Poseidon")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Zeus")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Atlas")) {
					event.setCancelled(true);
					player.sendMessage(
							plugin.servern + ChatColor.DARK_PURPLE + " You cannot use this item in this world");
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
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

	public void removeRankOrb(Player player) {
		final UUID uuid = player.getUniqueId();
		if (plugin.confirmTime.containsKey(uuid)) {
			for (ItemStack item : player.getInventory().getContents()) {
				if (plugin.ciConfirmed.get(uuid).equals(1)) {
					if (item == null) {
						
					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hermes")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(2)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Apollo")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(3)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Ares")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(4)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hera")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(5)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Poseidon")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(6)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Zeus")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(7)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Atlas")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(8)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(9)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(10)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(11)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(12)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(13)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else if (plugin.ciConfirmed.get(uuid).equals(14)) {
					if (item == null) {

					} else if (item.getType().equals(Material.SLIME_BALL)) {
						if (item.getItemMeta() == null) {

						} else if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.DARK_PURPLE + "Rank Upgrade Orb")) {
							if (item.getAmount() == 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								player.getInventory().removeItem(item);
								break;
							} else if (item.getAmount() > 1) {
								plugin.confirmTime.remove(uuid);
								plugin.confirmTask.remove(uuid);
								item.setAmount(item.getAmount() - 1);
								break;
							}
						}
					}
				} else {
					player.sendMessage(plugin.servern + " " + plugin.error);
					break;
				}
			}
		} else {
			player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have nothing to confirm");
			return;
		}
	}
}
