package com.appromode.ci;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.item.DSchematic;
import com.appromode.item.FlightOrb;
import com.appromode.item.InstaSword;
import com.appromode.item.KitShard;
import com.appromode.item.KitUnlock;
import com.appromode.item.RankOrb;
import com.appromode.item.Schematic;
import com.appromode.listener.RankOrbListener;
import com.appromode.menu.Admin;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Inject
	private Initialise plugin;

	@Inject
	private Admin am;

	@Inject
	private DSchematic ds;

	@Inject
	private FlightOrb fo;

	@Inject
	private InstaSword is;

	@Inject
	private KitShard ks;

	@Inject
	private KitUnlock ku;

	@Inject
	private RankOrb ro;

	@Inject
	private Schematic s;

	@Inject
	private RankOrbListener rol;

	boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int stringToInt(String amount) {
		try {
			int value = Integer.parseInt(amount);
			return value;
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	int secToMin(int seconds) {
		return (seconds / 60) + 1;
	}

	int secToHour(int seconds) {
		return ((seconds / 60) / 60) + 1;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			final UUID uuid = player.getUniqueId();
			if (command.getName().equalsIgnoreCase("apci")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + ChatColor.LIGHT_PURPLE
							+ " -=-=-=-=-=");
					player.sendMessage(ChatColor.WHITE + "Type /apci help for help!");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Made by: Appromode");
					player.sendMessage(
							ChatColor.WHITE + "=-=-=-=-=- " + plugin.servern + ChatColor.WHITE + " -=-=-=-=-=");
					return true;
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help")) {
						if (player.hasPermission("apci.menu.h")) {
							player.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern
									+ ChatColor.LIGHT_PURPLE + " -=-=-=-=-=");
							player.sendMessage(ChatColor.WHITE + "[1] /apci");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "Core Ap CI command");
							player.sendMessage(ChatColor.WHITE + "[2] /apci admin");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "Admin spawning menu");
							player.sendMessage(ChatColor.WHITE + "[3] /apci reload");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "Reloads the plugin config");
							player.sendMessage(ChatColor.WHITE + "[4] /apci confirm");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "Confirms an action");
							player.sendMessage(ChatColor.WHITE + "[5] /apci ci spawn [Item] (Item) (Quantity)");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "Command for spawning items");
							player.sendMessage(ChatColor.WHITE + "[6] /apci give [Username] [Item] (item) (Quantity)");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "Command for giving items to other players");
							player.sendMessage(ChatColor.WHITE + "[] = Required () = Optional");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern
									+ ChatColor.LIGHT_PURPLE + " -=-=-=-=-=");
							return true;
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("admin")) {
						if (player.hasPermission("apci.menu.am")) {
							am.adminHomeInv(player);
							return true;
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("reload")) {
						if (player.hasPermission("apci.reload")) {
							player.sendMessage(
									plugin.servern + ChatColor.WHITE + " Plugin config files have been reloaded.");
							plugin.reloadConfig();
							return true;
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("confirm")) {
						if (plugin.ciConfirmed.containsKey(uuid)) {
							if (plugin.ciConfirmed.get(uuid) > 0 && plugin.ciConfirmed.get(uuid) < 15) {
								rol.removeRankOrb(player);
								return true;
							} else {
								player.sendMessage(plugin.servern + " " + plugin.error);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have nothing to confirm");
							return true;
						}
					} else {
						player.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 2) {
					if (args[0].equalsIgnoreCase("spawn")) {
						if (player.hasPermission("apci.ci.spawn")) {
							if (args[1].equalsIgnoreCase("instasword")) {
								is.instaSword(player, 1);
								return true;
							} else {
								player.sendMessage(plugin.servern + " " + plugin.syntax);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("help")) {
						if (player.hasPermission("apci.menu.h")) {
							if (args[1].equalsIgnoreCase("1")) {
								player.sendMessage(
										ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
								player.sendMessage(ChatColor.WHITE + "[1] /apci");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Core Ap CI command");
								player.sendMessage(ChatColor.WHITE + "[2] /apci admin");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Admin spawning menu");
								player.sendMessage(ChatColor.WHITE + "[3] /apci reload");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Reloads the plugin config");
								player.sendMessage(ChatColor.WHITE + "[4] /apci confirm");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Confirms an action");
								player.sendMessage(ChatColor.WHITE + "[5] /apci ci spawn [Item] (Item) (Quantity)");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Command for spawning items");
								player.sendMessage(
										ChatColor.WHITE + "[6] /apci give [Username] [Item] (item) (Quantity)");
								player.sendMessage(
										ChatColor.LIGHT_PURPLE + "Command for giving items to other players");
								player.sendMessage(ChatColor.WHITE + "[] = Required () = Optional");
								player.sendMessage(
										ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
								return true;
							} else if (args[1].equalsIgnoreCase("one")) {
								player.sendMessage(
										ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
								player.sendMessage(ChatColor.WHITE + "[1] /apci");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Core Ap CI command");
								player.sendMessage(ChatColor.WHITE + "[2] /apci admin");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Admin spawning menu");
								player.sendMessage(ChatColor.WHITE + "[3] /apci reload");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Reloads the plugin config");
								player.sendMessage(ChatColor.WHITE + "[4] /apci confirm");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Confirms an action");
								player.sendMessage(ChatColor.WHITE + "[5] /apci ci spawn [Item] (Item) (Quantity)");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Command for spawning items");
								player.sendMessage(
										ChatColor.WHITE + "[6] /apci give [Username] [Item] (item) (Quantity)");
								player.sendMessage(
										ChatColor.LIGHT_PURPLE + "Command for giving items to other players");
								player.sendMessage(ChatColor.WHITE + "[] = Required () = Optional");
								player.sendMessage(
										ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
								return true;
							} else {
								player.sendMessage(plugin.servern + " " + plugin.syntax);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("flight")) {
						if (args[1].equalsIgnoreCase("pause")) {
							if (plugin.foCooldownTime.containsKey(uuid)) {
								int fotime = plugin.foCooldownTime.get(uuid);
								plugin.foTimes.put(uuid, fotime);
								plugin.fopause.put(uuid, true);
								plugin.foCooldownTime.remove(uuid);
								plugin.foCooldownTask.remove(uuid);
								player.setAllowFlight(false);
								player.setFlying(false);
								player.sendMessage(
										plugin.servern + ChatColor.DARK_PURPLE + " Your flight has been paused");
								return true;
							} else if (plugin.foTimes.containsKey(uuid)) {
								int fotime = plugin.foTimes.get(uuid);
								plugin.foCooldownTime.put(uuid, fotime);
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
								plugin.foTimes.remove(uuid);
								plugin.fopause.remove(uuid);
								player.setAllowFlight(true);
								player.setFlying(true);
								player.sendMessage(
										plugin.servern + ChatColor.DARK_PURPLE + " Your flight has been unpaused");
								return true;
							} else {
								player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
										+ " You do not have a flight orb activated");
								return true;
							}
						} else if (args[1].equalsIgnoreCase("time")) {
							if (plugin.foCooldownTime.containsKey(uuid)) {
								if (plugin.foCooldownTime.get(uuid) >= 3600) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + secToHour(plugin.foCooldownTime.get(uuid))
											+ ChatColor.DARK_PURPLE + " hour(s) left");
									return true;
								} else if (plugin.foCooldownTime.get(uuid) >= 60) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + secToMin(plugin.foCooldownTime.get(uuid))
											+ ChatColor.DARK_PURPLE + " minutes(s) left");
									return true;
								} else if (plugin.foCooldownTime.get(uuid) <= 59
										&& plugin.foCooldownTime.get(uuid) > 1) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + plugin.foCooldownTime.get(uuid)
											+ ChatColor.DARK_PURPLE + " second(s) left");
									return true;
								} else if (plugin.foCooldownTime.get(uuid) == 1) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + plugin.foCooldownTime.get(uuid)
											+ ChatColor.DARK_PURPLE + " second left");
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.error);
									return true;
								}
							} else if (plugin.foTimes.containsKey(uuid)) {
								if (plugin.foTimes.get(uuid) >= 3600) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + secToHour(plugin.foTimes.get(uuid))
											+ ChatColor.DARK_PURPLE + " hour(s) left");
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " Your flight orb is currently paused");
									return true;
								} else if (plugin.foTimes.get(uuid) >= 60) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + secToMin(plugin.foTimes.get(uuid))
											+ ChatColor.DARK_PURPLE + " minutes(s) left");
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " Your flight orb is currently paused");
									return true;
								} else if (plugin.foTimes.get(uuid) <= 59 && plugin.foTimes.get(uuid) > 1) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + plugin.foTimes.get(uuid) + ChatColor.DARK_PURPLE
											+ " second(s) left");
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " Your flight orb is currently paused");
									return true;
								} else if (plugin.foTimes.get(uuid) == 1) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + plugin.foTimes.get(uuid) + ChatColor.DARK_PURPLE
											+ " second left");
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " Your flight orb is currently paused");
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.error);
									return true;
								}
							} else {
								player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
										+ " You do not have a flight orb activated");
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.syntax);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("sword")) {
						if (args[1].equalsIgnoreCase("time")) {
							if (plugin.ikCooldownTime.containsKey(uuid)) {
								if (plugin.ikCooldownTime.get(uuid) >= 3600) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + secToHour(plugin.ikCooldownTime.get(uuid))
											+ ChatColor.DARK_PURPLE + " hour(s) of cooldown left");
									return true;
								} else if (plugin.ikCooldownTime.get(uuid) >= 60) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + secToMin(plugin.ikCooldownTime.get(uuid))
											+ ChatColor.DARK_PURPLE + " minutes(s) of cooldown left");
									return true;
								} else if (plugin.ikCooldownTime.get(uuid) <= 59
										&& plugin.ikCooldownTime.get(uuid) > 1) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + plugin.ikCooldownTime.get(uuid)
											+ ChatColor.DARK_PURPLE + " second(s) of cooldown left");
									return true;
								} else if (plugin.ikCooldownTime.get(uuid) == 1) {
									player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE + " You have "
											+ ChatColor.LIGHT_PURPLE + plugin.ikCooldownTime.get(uuid)
											+ ChatColor.DARK_PURPLE + " second of cooldown left");
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.error);
									return true;
								}
							} else {
								player.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
										+ " You are not on cooldown for the insta-kill sword");
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.syntax);
							return true;
						}
					} else {
						player.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 3) {
					if (args[0].equalsIgnoreCase("spawn")) {
						if (player.hasPermission("apci.ci.spawn")) {
							if (args[1].equalsIgnoreCase("fo")) {
								if (args[2].equalsIgnoreCase("1m")) {
									fo.fo1m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("2m")) {
									fo.fo2m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("3m")) {
									fo.fo3m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("4m")) {
									fo.fo4m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("5m")) {
									fo.fo5m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("10m")) {
									fo.fo10m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("15m")) {
									fo.fo15m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("30m")) {
									fo.fo30m(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("1h")) {
									fo.fo1h(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("2h")) {
									fo.fo2h(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("4h")) {
									fo.fo4h(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("8h")) {
									fo.fo8h(player, 1);
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[1].equalsIgnoreCase("ro")) {
								if (args[2].equalsIgnoreCase("hermes")) {
									ro.roHermes(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("apollo")) {
									ro.roApollo(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("ares")) {
									ro.roAres(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("hera")) {
									ro.roHera(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("poseidon")) {
									ro.roPoseidon(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("zeus")) {
									ro.roZeus(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("atlas")) {
									ro.roAtlas(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("upgrade")) {
									ro.roUpgrade(player, 1);
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[1].equalsIgnoreCase("schem")) {
								if (args[2].equalsIgnoreCase("one")) {
									s.schematicOne(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("two")) {
									s.schematicTwo(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("three")) {
									s.schematicThree(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("four")) {
									s.schematicFour(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("five")) {
									s.schematicFive(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("six")) {
									s.schematicSix(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("seven")) {
									s.schematicSeven(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("eight")) {
									s.schematicEight(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("nine")) {
									s.schematicNine(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("ten")) {
									s.schematicTen(player, 1);
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[1].equalsIgnoreCase("dschem")) {
								if (args[2].equalsIgnoreCase("one")) {
									ds.dSchematicOne(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("two")) {
									ds.dSchematicTwo(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("three")) {
									ds.dSchematicThree(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("four")) {
									ds.dSchematicFour(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("five")) {
									ds.dSchematicFive(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("six")) {
									ds.dSchematicSix(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("seven")) {
									ds.dSchematicSeven(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("eight")) {
									ds.dSchematicEight(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("nine")) {
									ds.dSchematicNine(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("ten")) {
									ds.dSchematicTen(player, 1);
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[1].equalsIgnoreCase("kitshard")) {
								if (args[2].equalsIgnoreCase("tyche")) {
									ks.kShardTyche(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("artemis")) {
									ks.kShardArtemis(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("demeter")) {
									ks.kShardDemeter(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("hephaetus")) {
									ks.kShardHephaetus(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("hades")) {
									ks.kShardHades(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("nemesis")) {
									ks.kShardNemesis(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("random")) {
									ks.kShardRandom(player, 1);
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[1].equalsIgnoreCase("kitunlock")) {
								if (args[2].equalsIgnoreCase("tyche")) {
									ku.kUnlockTyche(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("artemis")) {
									ku.kUnlockArtemis(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("demeter")) {
									ku.kUnlockDemeter(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("hephaetus")) {
									ku.kUnlockHephaetus(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("hades")) {
									ku.kUnlockHades(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("nemesis")) {
									ku.kUnlockNemesis(player, 1);
									return true;
								} else if (args[2].equalsIgnoreCase("random")) {
									ku.kUnlockRandom(player, 1);
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[1].equalsIgnoreCase("instasword")) {
								if (isInteger(args[2])) {
									is.instaSword(player, stringToInt(args[2]));
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else {
								player.sendMessage(plugin.servern + " " + plugin.syntax);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("give")) {
						if (player.hasPermission("apci.ci.give")) {
							if (!Bukkit.getPlayer(args[1]).equals(null)) {
								Player target = Bukkit.getPlayer(args[1]);
								if (args[2].equalsIgnoreCase("instasword")) {
									is.instaSword(target, 1);
									player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given an "
											+ ChatColor.LIGHT_PURPLE + "insta-kill sword" + ChatColor.DARK_PURPLE
											+ " to " + ChatColor.LIGHT_PURPLE + target.getDisplayName());
									target.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given an " + ChatColor.LIGHT_PURPLE + "insta-kill sword");
									return true;
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else {
								player.sendMessage(plugin.servern + " " + plugin.pnotfound);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else {
						player.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 4) {
					if (args[0].equalsIgnoreCase("give")) {
						if (player.hasPermission("apci.ci.give")) {
							if (!Bukkit.getPlayer(args[1]).equals(null)) {
								Player target2 = Bukkit.getPlayer(args[1]);
								if (args[2].equalsIgnoreCase("fo")) {
									if (args[3].equalsIgnoreCase("1m")) {
										fo.fo1m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 1 minute" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 1 minute");
										return true;
									} else if (args[3].equalsIgnoreCase("2m")) {
										fo.fo2m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 2 minute" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 2 minute");
										return true;
									} else if (args[3].equalsIgnoreCase("3m")) {
										fo.fo3m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 3 minute" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 3 minute");
										return true;
									} else if (args[3].equalsIgnoreCase("4m")) {
										fo.fo4m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 4 minute" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 4 minute");
										return true;
									} else if (args[3].equalsIgnoreCase("5m")) {
										fo.fo5m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 5 minute" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 5 minute");
										return true;
									} else if (args[3].equalsIgnoreCase("10m")) {
										fo.fo10m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 10 minute"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 10 minute");
										return true;
									} else if (args[3].equalsIgnoreCase("15m")) {
										fo.fo15m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 15 minute"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 15 minute");
										return true;
									} else if (args[3].equalsIgnoreCase("30m")) {
										fo.fo30m(player, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 30 minutes"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 30 minutes");
										return true;
									} else if (args[3].equalsIgnoreCase("1h")) {
										fo.fo1h(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 1 hour" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 1 hour");
										return true;
									} else if (args[3].equalsIgnoreCase("2h")) {
										fo.fo2h(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 2 hour" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 2 hour");
										return true;
									} else if (args[3].equalsIgnoreCase("4h")) {
										fo.fo4h(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 4 hour" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 4 hour");
										return true;
									} else if (args[3].equalsIgnoreCase("8h")) {
										fo.fo8h(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "flight orb 8 hour" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "flight orb 8 hour");
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("ro")) {
									if (args[3].equalsIgnoreCase("hermes")) {
										ro.roHermes(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "hermes rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "hermes rank orb");
										return true;
									} else if (args[3].equalsIgnoreCase("apollo")) {
										ro.roApollo(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "apollo rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "apollo rank orb");
										return true;
									} else if (args[3].equalsIgnoreCase("ares")) {
										ro.roAres(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "ares rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "ares rank orb");
										return true;
									} else if (args[3].equalsIgnoreCase("hera")) {
										ro.roHera(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "hera rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "hera rank orb");
										return true;
									} else if (args[3].equalsIgnoreCase("poseidon")) {
										ro.roPoseidon(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "poseidon rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "poseidon rank orb");
										return true;
									} else if (args[3].equalsIgnoreCase("zeus")) {
										ro.roZeus(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "zeus rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "zeus rank orb");
										return true;
									} else if (args[3].equalsIgnoreCase("atlas")) {
										ro.roAtlas(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given an "
												+ ChatColor.LIGHT_PURPLE + "atlas rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given an "
														+ ChatColor.LIGHT_PURPLE + "atlas rank orb");
										return true;
									} else if (args[3].equalsIgnoreCase("upgrade")) {
										ro.roUpgrade(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given an "
												+ ChatColor.LIGHT_PURPLE + "upgrade rank orb" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given an "
														+ ChatColor.LIGHT_PURPLE + "upgrade rank orb");
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("schem")) {
									if (args[3].equalsIgnoreCase("one")) {
										s.schematicOne(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "schematic one" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Schematic one");
										return true;
									} else if (args[3].equalsIgnoreCase("two")) {
										s.schematicTwo(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic two" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Schematic two");
										return true;
									} else if (args[3].equalsIgnoreCase("three")) {
										s.schematicThree(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic three" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Schematic three");
										return true;
									} else if (args[3].equalsIgnoreCase("four")) {
										s.schematicThree(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic four" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Schematic four");
										return true;
									} else if (args[3].equalsIgnoreCase("five")) {
										s.schematicFour(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic five" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Schematic five");
										return true;
									} else if (args[3].equalsIgnoreCase("six")) {
										s.schematicFive(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic six" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Schematic six");
										return true;
									} else if (args[3].equalsIgnoreCase("seven")) {
										s.schematicSix(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic seven" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Schematic seven");
										return true;
									} else if (args[3].equalsIgnoreCase("eight")) {
										s.schematicSeven(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic eight" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Schematic eight");
										return true;
									} else if (args[3].equalsIgnoreCase("nine")) {
										s.schematicNine(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic nine" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Schematic nine");
										return true;
									} else if (args[3].equalsIgnoreCase("ten")) {
										s.schematicTen(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Schematic ten" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Schematic ten");
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("dschem")) {
									if (args[3].equalsIgnoreCase("one")) {
										ds.dSchematicOne(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic one"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic one");
										return true;
									} else if (args[3].equalsIgnoreCase("two")) {
										ds.dSchematicTwo(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic two"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic two");
										return true;
									} else if (args[3].equalsIgnoreCase("three")) {
										ds.dSchematicThree(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic three"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic three");
										return true;
									} else if (args[3].equalsIgnoreCase("four")) {
										ds.dSchematicFour(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic four"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic four");
										return true;
									} else if (args[3].equalsIgnoreCase("five")) {
										ds.dSchematicFive(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic five"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic five");
										return true;
									} else if (args[3].equalsIgnoreCase("six")) {
										ds.dSchematicSix(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic six"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic six");
										return true;
									} else if (args[3].equalsIgnoreCase("seven")) {
										ds.dSchematicSeven(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic seven"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic seven");
										return true;
									} else if (args[3].equalsIgnoreCase("eight")) {
										ds.dSchematicEight(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic eight"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic eight");
										return true;
									} else if (args[3].equalsIgnoreCase("nine")) {
										ds.dSchematicNine(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic nine"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic nine");
										return true;
									} else if (args[3].equalsIgnoreCase("ten")) {
										ds.dSchematicTen(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Premium schematic ten"
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "Premium schematic ten");
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("kitshard")) {
									if (args[3].equalsIgnoreCase("tyche")) {
										ks.kShardTyche(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "KitShard Tyche" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "KitShard Tyche");
										return true;
									} else if (args[3].equalsIgnoreCase("artemis")) {
										ks.kShardArtemis(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "KitShard Artemis" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "KitShard Artemis");
										return true;
									} else if (args[3].equalsIgnoreCase("demeter")) {
										ks.kShardDemeter(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "KitShard Demeter" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "KitShard Demeter");
										return true;
									} else if (args[3].equalsIgnoreCase("hephaetus")) {
										ks.kShardHephaetus(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "KitShard Hephaetus" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "KitShard Hephaetus");
										return true;
									} else if (args[3].equalsIgnoreCase("hades")) {
										ks.kShardHades(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "KitShard Hades" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "KitShard Hades");
										return true;
									} else if (args[3].equalsIgnoreCase("nemesis")) {
										ks.kShardNemesis(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "KitShard Nemesis" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "KitShard Nemesis");
										return true;
									} else if (args[3].equalsIgnoreCase("random")) {
										ks.kShardRandom(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "KitShard Random" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(
												plugin.servern + ChatColor.DARK_PURPLE + " You have been given a "
														+ ChatColor.LIGHT_PURPLE + "KitShard Random");
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("kitunlock")) {
									if (args[3].equalsIgnoreCase("tyche")) {
										ku.kUnlockTyche(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Kit Tyche" + ChatColor.DARK_PURPLE + " to "
												+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Kit Tyche");
										return true;
									} else if (args[3].equalsIgnoreCase("artemis")) {
										ku.kUnlockArtemis(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Kit Artemis" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Kit Artemis");
										return true;
									} else if (args[3].equalsIgnoreCase("demeter")) {
										ku.kUnlockDemeter(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Kit Demeter" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Kit Demeter");
										return true;
									} else if (args[3].equalsIgnoreCase("hephaetus")) {
										ku.kUnlockHephaetus(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Kit Hephaetus" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Kit Hephaetus");
										return true;
									} else if (args[3].equalsIgnoreCase("hades")) {
										ku.kUnlockHades(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Kit Hades" + ChatColor.DARK_PURPLE + " to "
												+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Kit Hades");
										return true;
									} else if (args[3].equalsIgnoreCase("nemesis")) {
										ku.kUnlockNemesis(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Kit Nemesis" + ChatColor.DARK_PURPLE
												+ " to " + ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Kit Nemesis");
										return true;
									} else if (args[3].equalsIgnoreCase("random")) {
										ku.kUnlockRandom(target2, 1);
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "Kit Random" + ChatColor.DARK_PURPLE + " to "
												+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE + "Kit Random");
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("instasword")) {
									if (isInteger(args[3])) {
										is.instaSword(target2, stringToInt(args[3]));
										player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " You have given a "
												+ ChatColor.LIGHT_PURPLE + "InstaKill Sword x" + stringToInt(args[3])
												+ ChatColor.DARK_PURPLE + " to " + ChatColor.LIGHT_PURPLE
												+ target2.getDisplayName());
										target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE
												+ "InstaKill Sword x" + stringToInt(args[3]));
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else {
								player.sendMessage(plugin.servern + " " + plugin.pnotfound);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("spawn")) {
						if (player.hasPermission("apci.ci.spawn")) {
							if (isInteger(args[3])) {
								if (args[1].equalsIgnoreCase("fo")) {
									if (args[2].equalsIgnoreCase("1m")) {
										fo.fo1m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("2m")) {
										fo.fo2m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("3m")) {
										fo.fo3m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("4m")) {
										fo.fo4m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("5m")) {
										fo.fo5m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("10m")) {
										fo.fo10m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("15m")) {
										fo.fo15m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("30m")) {
										fo.fo30m(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("1h")) {
										fo.fo1h(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("2h")) {
										fo.fo2h(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("4h")) {
										fo.fo4h(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("8h")) {
										fo.fo8h(player, stringToInt(args[3]));
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[1].equalsIgnoreCase("ro")) {
									if (args[2].equalsIgnoreCase("hermes")) {
										ro.roHermes(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("apollo")) {
										ro.roApollo(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("ares")) {
										ro.roAres(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("hera")) {
										ro.roHera(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("poseidon")) {
										ro.roPoseidon(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("zeus")) {
										ro.roZeus(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("atlas")) {
										ro.roAtlas(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("upgrade")) {
										ro.roUpgrade(player, stringToInt(args[3]));
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[1].equalsIgnoreCase("schem")) {
									if (args[2].equalsIgnoreCase("one")) {
										s.schematicOne(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("two")) {
										s.schematicTwo(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("three")) {
										s.schematicThree(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("four")) {
										s.schematicFour(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("five")) {
										s.schematicFive(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("six")) {
										s.schematicSix(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("seven")) {
										s.schematicSeven(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("eight")) {
										s.schematicEight(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("nine")) {
										s.schematicNine(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("ten")) {
										s.schematicTen(player, stringToInt(args[3]));
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[1].equalsIgnoreCase("dschem")) {
									if (args[2].equalsIgnoreCase("one")) {
										ds.dSchematicOne(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("two")) {
										ds.dSchematicTwo(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("three")) {
										ds.dSchematicThree(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("four")) {
										ds.dSchematicFour(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("five")) {
										ds.dSchematicFive(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("six")) {
										ds.dSchematicSix(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("seven")) {
										ds.dSchematicSeven(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("eight")) {
										ds.dSchematicEight(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("nine")) {
										ds.dSchematicNine(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("ten")) {
										ds.dSchematicTen(player, stringToInt(args[3]));
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[1].equalsIgnoreCase("kitshard")) {
									if (args[2].equalsIgnoreCase("tyche")) {
										ks.kShardTyche(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("artemis")) {
										ks.kShardArtemis(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("demeter")) {
										ks.kShardDemeter(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("hephaetus")) {
										ks.kShardHephaetus(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("hades")) {
										ks.kShardHades(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("nemesis")) {
										ks.kShardNemesis(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("random")) {
										ks.kShardRandom(player, stringToInt(args[3]));
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[1].equalsIgnoreCase("kitunlock")) {
									if (args[2].equalsIgnoreCase("tyche")) {
										ku.kUnlockTyche(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("artemis")) {
										ku.kUnlockArtemis(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("demeter")) {
										ku.kUnlockDemeter(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("hephaetus")) {
										ku.kUnlockHephaetus(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("hades")) {
										ku.kUnlockHades(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("nemesis")) {
										ku.kUnlockNemesis(player, stringToInt(args[3]));
										return true;
									} else if (args[2].equalsIgnoreCase("random")) {
										ku.kUnlockRandom(player, stringToInt(args[3]));
										return true;
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else {
								player.sendMessage(plugin.servern + " " + plugin.syntax);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else {
						player.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 5) {
					if (args[0].equalsIgnoreCase("give")) {
						if (player.hasPermission("apci.ci.give")) {
							if (!Bukkit.getPlayer(args[1]).equals(null)) {
								if (isInteger(args[4])) {
									Player target3 = Bukkit.getPlayer(args[1]);
									if (args[2].equalsIgnoreCase("fo")) {
										if (args[3].equalsIgnoreCase("1m")) {
											fo.fo1m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 1m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 1m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("2m")) {
											fo.fo2m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 2m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 2m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("3m")) {
											fo.fo3m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 3m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 3m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("4m")) {
											fo.fo4m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 4m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 4m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("5m")) {
											fo.fo5m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 5m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 5m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("10m")) {
											fo.fo10m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 10m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 10m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("15m")) {
											fo.fo15m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 15m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 15m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("30m")) {
											fo.fo30m(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 30m x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 30m x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("1h")) {
											fo.fo1h(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 1h x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 1h x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("2h")) {
											fo.fo2h(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 2h x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 2h x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("4h")) {
											fo.fo4h(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 4h x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 4h x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("8h")) {
											fo.fo8h(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 8h x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Flight Orb 8h x" + stringToInt(args[3]));
											return true;
										} else {
											player.sendMessage(plugin.servern + " " + plugin.syntax);
											return true;
										}
									} else if (args[2].equalsIgnoreCase("ro")) {
										if (args[3].equalsIgnoreCase("hermes")) {
											ro.roHermes(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Hermes x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Hermes x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("apollo")) {
											ro.roApollo(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Apollo x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Apollo x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("ares")) {
											ro.roAres(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Ares x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Ares x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("hera")) {
											ro.roHera(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Hera x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Hera x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("poseidon")) {
											ro.roPoseidon(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Poseidon x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Poseidon x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("zeus")) {
											ro.roZeus(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Zeus x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Zeus x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("atlas")) {
											ro.roAtlas(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Atlas x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Atlas x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("upgrade")) {
											ro.roUpgrade(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Upgrade x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Rank Orb Upgrade x" + stringToInt(args[3]));
											return true;
										} else {
											player.sendMessage(plugin.servern + " " + plugin.syntax);
											return true;
										}
									} else if (args[2].equalsIgnoreCase("schem")) {
										if (args[3].equalsIgnoreCase("one")) {
											s.schematicOne(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 1 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 1 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("two")) {
											s.schematicTwo(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 2 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 2 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("three")) {
											s.schematicThree(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 3 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 3 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("four")) {
											s.schematicFive(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 4 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 4 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("five")) {
											s.schematicFive(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 5 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 5 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("six")) {
											s.schematicSix(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 6 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 6 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("seven")) {
											s.schematicSeven(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 7 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 7 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("eight")) {
											s.schematicEight(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 8 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 8 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("nine")) {
											s.schematicNine(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 9 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 9 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("ten")) {
											s.schematicTen(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 10 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Schematic 10 x" + stringToInt(args[3]));
											return true;
										} else {
											player.sendMessage(plugin.servern + " " + plugin.syntax);
											return true;
										}
									} else if (args[2].equalsIgnoreCase("dschem")) {
										if (args[3].equalsIgnoreCase("one")) {
											ds.dSchematicOne(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 1 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 1 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("two")) {
											ds.dSchematicTwo(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 2 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 2 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("three")) {
											ds.dSchematicThree(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 3 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 3 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("four")) {
											ds.dSchematicFour(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 4 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 4 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("five")) {
											ds.dSchematicFive(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 5 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 5 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("six")) {
											ds.dSchematicSix(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 6 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 6 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("seven")) {
											ds.dSchematicSeven(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 7 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 7 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("eight")) {
											ds.dSchematicEight(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 8 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 8 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("nine")) {
											ds.dSchematicNine(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 9 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 9 x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("ten")) {
											ds.dSchematicTen(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 10 x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "Premium Schematic 10 x" + stringToInt(args[3]));
											return true;
										} else {
											player.sendMessage(plugin.servern + " " + plugin.syntax);
											return true;
										}
									} else if (args[2].equalsIgnoreCase("kitshard")) {
										if (args[3].equalsIgnoreCase("tyche")) {
											ks.kShardTyche(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Tyche x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitShard Tyche x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("artemis")) {
											ks.kShardArtemis(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Artemis x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitShard Artemis x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("demeter")) {
											ks.kShardDemeter(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Demeter x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitShard Demeter x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("hephaetus")) {
											ks.kShardHephaetus(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Hephaetus x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitShard Hephaetus x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("hades")) {
											ks.kShardHades(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Hades x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitShard Hades x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("nemesis")) {
											ks.kShardNemesis(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Nemesis x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitShard Nemesis x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("random")) {
											ks.kShardRandom(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Random x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitShard Random x" + stringToInt(args[3]));
											return true;
										} else {
											player.sendMessage(plugin.servern + " " + plugin.syntax);
											return true;
										}
									} else if (args[2].equalsIgnoreCase("kitunlock")) {
										if (args[3].equalsIgnoreCase("tyche")) {
											ku.kUnlockTyche(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Random x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitUnlock Tyche x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("artemis")) {
											ku.kUnlockArtemis(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Artemis x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitUnlock Artemis x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("demeter")) {
											ku.kUnlockDemeter(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Demeter x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitUnlock Demeter x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("hephaetus")) {
											ku.kUnlockHephaetus(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Hephaetus x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitUnlock Hephaetus x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("hades")) {
											ku.kUnlockHades(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Hades x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitUnlock Hades x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("nemesis")) {
											ku.kUnlockNemesis(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Nemesis x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitUnlock Nemesis x" + stringToInt(args[3]));
											return true;
										} else if (args[3].equalsIgnoreCase("random")) {
											ku.kUnlockRandom(target3, stringToInt(args[4]));
											player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
													+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Random x"
													+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
													+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
											target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
													+ " You have been given a " + ChatColor.LIGHT_PURPLE
													+ "KitUnlock Random x" + stringToInt(args[3]));
											return true;
										} else {
											player.sendMessage(plugin.servern + " " + plugin.syntax);
											return true;
										}
									} else {
										player.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else {
									player.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else {
								player.sendMessage(plugin.servern + " " + plugin.pnotfound);
								return true;
							}
						} else {
							player.sendMessage(plugin.servern + " " + plugin.noperm);
							return true;
						}
					} else {
						player.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else {
					player.sendMessage(plugin.servern + " " + plugin.syntax);
					return true;
				}
			} else {
				return false;
			}
		} else {
			if (command.getName().equalsIgnoreCase("apci")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
					sender.sendMessage(ChatColor.WHITE + "Type /apci help for help!");
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Made by: Appromode");
					sender.sendMessage(ChatColor.WHITE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
					return true;
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
						sender.sendMessage(ChatColor.WHITE + "[1] /apci");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "Core Ap CI command");
						sender.sendMessage(ChatColor.WHITE + "[2] /apci admin");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "Admin spawning menu");
						sender.sendMessage(ChatColor.WHITE + "[3] /apci reload");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "Reloads the plugin config");
						sender.sendMessage(ChatColor.WHITE + "[4] /apci confirm");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "Confirms an action");
						sender.sendMessage(ChatColor.WHITE + "[5] /apci ci spawn [Item] (Item) (Quantity)");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "Command for spawning items");
						sender.sendMessage(ChatColor.WHITE + "[6] /apci give [Username] [Item] (item) (Quantity)");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "Command for giving items to other senders");
						sender.sendMessage(ChatColor.WHITE + "[] = Required () = Optional");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
						return true;
					} else if (args[0].equalsIgnoreCase("admin")) {
						sender.sendMessage(plugin.servern + ChatColor.DARK_RED
								+ " This command can only be executed by players in game!");
						return true;
					} else if (args[0].equalsIgnoreCase("reload")) {
						plugin.reloadConfig();
						return true;
					} else if (args[0].equalsIgnoreCase("confirm")) {
						sender.sendMessage(plugin.servern + ChatColor.DARK_RED
								+ " This command can only be executed by players in game!");
						return true;
					} else {
						sender.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 2) {
					if (args[0].equalsIgnoreCase("spawn")) {
						sender.sendMessage(plugin.servern + ChatColor.DARK_RED
								+ " This command can only be executed by players in game!");
						return true;
					} else if (args[0].equalsIgnoreCase("help")) {
						if (args[1].equalsIgnoreCase("1")) {
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
							sender.sendMessage(ChatColor.WHITE + "[1] /apci");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Core Ap CI command");
							sender.sendMessage(ChatColor.WHITE + "[2] /apci admin");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Admin spawning menu");
							sender.sendMessage(ChatColor.WHITE + "[3] /apci reload");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Reloads the plugin config");
							sender.sendMessage(ChatColor.WHITE + "[4] /apci confirm");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Confirms an action");
							sender.sendMessage(ChatColor.WHITE + "[5] /apci ci spawn [Item] (Item) (Quantity)");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Command for spawning items");
							sender.sendMessage(ChatColor.WHITE + "[6] /apci give [Username] [Item] (item) (Quantity)");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Command for giving items to other senders");
							sender.sendMessage(ChatColor.WHITE + "[] = Required () = Optional");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
							return true;
						} else if (args[1].equalsIgnoreCase("one")) {
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
							sender.sendMessage(ChatColor.WHITE + "[1] /apci");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Core Ap CI command");
							sender.sendMessage(ChatColor.WHITE + "[2] /apci admin");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Admin spawning menu");
							sender.sendMessage(ChatColor.WHITE + "[3] /apci reload");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Reloads the plugin config");
							sender.sendMessage(ChatColor.WHITE + "[4] /apci confirm");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Confirms an action");
							sender.sendMessage(ChatColor.WHITE + "[5] /apci ci spawn [Item] (Item) (Quantity)");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Command for spawning items");
							sender.sendMessage(ChatColor.WHITE + "[6] /apci give [Username] [Item] (item) (Quantity)");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "Command for giving items to other senders");
							sender.sendMessage(ChatColor.WHITE + "[] = Required () = Optional");
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "=-=-=-=-=- " + plugin.servern + " -=-=-=-=-=");
							return true;
						} else {
							sender.sendMessage(plugin.servern + " " + plugin.syntax);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("flight")) {
						sender.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " This command can only be executed by players in game");
						return true;
					} else if (args[0].equalsIgnoreCase("sword")) {
						sender.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " This command can only be executed by players in game");
						return true;
					} else {
						sender.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 3) {
					if (args[0].equalsIgnoreCase("spawn")) {
						sender.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " This command can only be executed by players in game!");
						return true;
					} else if (args[0].equalsIgnoreCase("give")) {
						if (!Bukkit.getPlayer(args[1]).equals(null)) {
							Player target = Bukkit.getPlayer(args[1]);
							if (args[2].equalsIgnoreCase("instasword")) {
								is.instaSword(target, 1);
								sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
										+ " You have given a " + ChatColor.LIGHT_PURPLE + "instasword"
										+ ChatColor.DARK_PURPLE + " to "
										+ ChatColor.LIGHT_PURPLE + target.getDisplayName());
								target.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
										+ " You have been given a " + ChatColor.LIGHT_PURPLE
										+ "instasword x1");
								return true;
							} else {
								sender.sendMessage(plugin.servern + " " + plugin.syntax);
								return true;
							}
						} else {
							sender.sendMessage(plugin.servern + " " + plugin.pnotfound);
							return true;
						}
					} else {
						sender.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 4) {
					if (args[0].equalsIgnoreCase("give")) {
						if (!Bukkit.getPlayer(args[1]).equals(null)) {
							Player target2 = Bukkit.getPlayer(args[1]);
							if (args[2].equalsIgnoreCase("fo")) {
								if (args[3].equalsIgnoreCase("1m")) {
									fo.fo1m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 1m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 1m");
									return true;
								} else if (args[3].equalsIgnoreCase("2m")) {
									fo.fo2m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 2m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 2m");
									return true;
								} else if (args[3].equalsIgnoreCase("3m")) {
									fo.fo3m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 3m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 3m");
									return true;
								} else if (args[3].equalsIgnoreCase("4m")) {
									fo.fo4m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 4m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 4m");
									return true;
								} else if (args[3].equalsIgnoreCase("5m")) {
									fo.fo5m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 5m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 5m");
									return true;
								} else if (args[3].equalsIgnoreCase("10m")) {
									fo.fo10m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 10m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 10m");
									return true;
								} else if (args[3].equalsIgnoreCase("15m")) {
									fo.fo15m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 15m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 15m");
									return true;
								} else if (args[3].equalsIgnoreCase("30m")) {
									fo.fo30m(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 30m"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 30m");
									return true;
								} else if (args[3].equalsIgnoreCase("1h")) {
									fo.fo1h(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 1h"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 1h");
									return true;
								} else if (args[3].equalsIgnoreCase("2h")) {
									fo.fo2h(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 2h"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 2h");
									return true;
								} else if (args[3].equalsIgnoreCase("4h")) {
									fo.fo4h(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 4h"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 4h");
									return true;
								} else if (args[3].equalsIgnoreCase("8h")) {
									fo.fo8h(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 8h"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Flight Orb 8h");
									return true;
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[2].equalsIgnoreCase("ro")) {
								if (args[3].equalsIgnoreCase("hermes")) {
									ro.roHermes(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Hermes"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Hermes");
									return true;
								} else if (args[3].equalsIgnoreCase("apollo")) {
									ro.roApollo(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Apollo"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Apollo");
									return true;
								} else if (args[3].equalsIgnoreCase("ares")) {
									ro.roAres(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Ares"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Ares");
									return true;
								} else if (args[3].equalsIgnoreCase("hera")) {
									ro.roHera(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Hera"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Hera");
									return true;
								} else if (args[3].equalsIgnoreCase("poseidon")) {
									ro.roPoseidon(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Poseidon"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Poseidon");
									return true;
								} else if (args[3].equalsIgnoreCase("zeus")) {
									ro.roZeus(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Zeus"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Zeus");
									return true;
								} else if (args[3].equalsIgnoreCase("atlas")) {
									ro.roAtlas(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Atlas"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Atlas");
									return true;
								} else if (args[3].equalsIgnoreCase("upgrade")) {
									ro.roUpgrade(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Rank Orb Upgrade"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Rank Orb Upgrade");
									return true;
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[2].equalsIgnoreCase("schem")) {
								if (args[3].equalsIgnoreCase("one")) {
									s.schematicOne(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 1");
									return true;
								} else if (args[3].equalsIgnoreCase("two")) {
									s.schematicTwo(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 2"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 2");
									return true;
								} else if (args[3].equalsIgnoreCase("three")) {
									s.schematicThree(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 3"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 3");
									return true;
								} else if (args[3].equalsIgnoreCase("four")) {
									s.schematicThree(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 4"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 4");
									return true;
								} else if (args[3].equalsIgnoreCase("five")) {
									s.schematicFour(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 5"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 5");
									return true;
								} else if (args[3].equalsIgnoreCase("six")) {
									s.schematicFive(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 6"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 6");
									return true;
								} else if (args[3].equalsIgnoreCase("seven")) {
									s.schematicSix(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 7"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 7");
									return true;
								} else if (args[3].equalsIgnoreCase("eight")) {
									s.schematicSeven(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 8"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 8");
									return true;
								} else if (args[3].equalsIgnoreCase("nine")) {
									s.schematicNine(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 9"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 9");
									return true;
								} else if (args[3].equalsIgnoreCase("ten")) {
									s.schematicTen(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Schematic 10"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Schematic 10");
									return true;
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[2].equalsIgnoreCase("dschem")) {
								if (args[3].equalsIgnoreCase("one")) {
									ds.dSchematicOne(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 1");
									return true;
								} else if (args[3].equalsIgnoreCase("two")) {
									ds.dSchematicTwo(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 2"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 2");
									return true;
								} else if (args[3].equalsIgnoreCase("three")) {
									ds.dSchematicThree(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 3"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 3");
									return true;
								} else if (args[3].equalsIgnoreCase("four")) {
									ds.dSchematicFour(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 4"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 4");
									return true;
								} else if (args[3].equalsIgnoreCase("five")) {
									ds.dSchematicFive(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 5"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 5");
									return true;
								} else if (args[3].equalsIgnoreCase("six")) {
									ds.dSchematicSix(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 6"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 6");
									return true;
								} else if (args[3].equalsIgnoreCase("seven")) {
									ds.dSchematicSeven(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 7"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 7");
									return true;
								} else if (args[3].equalsIgnoreCase("eight")) {
									ds.dSchematicEight(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 8"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 8");
									return true;
								} else if (args[3].equalsIgnoreCase("nine")) {
									ds.dSchematicNine(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 9"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 9");
									return true;
								} else if (args[3].equalsIgnoreCase("ten")) {
									ds.dSchematicTen(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Premium Schematic 10"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "Premium Schematic 10");
									return true;
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[2].equalsIgnoreCase("kitshard")) {
								if (args[3].equalsIgnoreCase("tyche")) {
									ks.kShardTyche(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Tyche 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitShard Tyche 1");
									return true;
								} else if (args[3].equalsIgnoreCase("artemis")) {
									ks.kShardArtemis(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "Artemis Tyche 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitShard Artemis 1");
									return true;
								} else if (args[3].equalsIgnoreCase("demeter")) {
									ks.kShardDemeter(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Demeter 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitShard Demeter 1");
									return true;
								} else if (args[3].equalsIgnoreCase("hephaetus")) {
									ks.kShardHephaetus(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Hephaetus 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitShard Hephaetus 1");
									return true;
								} else if (args[3].equalsIgnoreCase("hades")) {
									ks.kShardHades(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Hades 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitShard Hades 1");
									return true;
								} else if (args[3].equalsIgnoreCase("nemesis")) {
									ks.kShardNemesis(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Nemesis 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitShard Nemesis 1");
									return true;
								} else if (args[3].equalsIgnoreCase("random")) {
									ks.kShardRandom(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitShard Random 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitShard Random 1");
									return true;
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[2].equalsIgnoreCase("kitunlock")) {
								if (args[3].equalsIgnoreCase("tyche")) {
									ku.kUnlockTyche(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Tyche 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Tyche 1");
									return true;
								} else if (args[3].equalsIgnoreCase("artemis")) {
									ku.kUnlockArtemis(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Artemis 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Artemis 1");
									return true;
								} else if (args[3].equalsIgnoreCase("demeter")) {
									ku.kUnlockDemeter(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Demeter 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Demeter 1");
									return true;
								} else if (args[3].equalsIgnoreCase("hephaetus")) {
									ku.kUnlockHephaetus(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Hephaetus 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Hephaetus 1");
									return true;
								} else if (args[3].equalsIgnoreCase("hades")) {
									ku.kUnlockHades(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Hades 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Hades 1");
									return true;
								} else if (args[3].equalsIgnoreCase("nemesis")) {
									ku.kUnlockNemesis(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Nemesis 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Nemesis 1");
									return true;
								} else if (args[3].equalsIgnoreCase("random")) {
									ku.kUnlockRandom(target2, 1);
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Random 1"
											+ ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Random 1");
									return true;
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else if (args[2].equalsIgnoreCase("instasword")) {
								if (isInteger(args[3])) {
									is.instaSword(target2, stringToInt(args[3]));
									sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
											+ " You have given a " + ChatColor.LIGHT_PURPLE + "KitUnlock Tyche "
											+ stringToInt(args[3]) + ChatColor.DARK_PURPLE + " to "
											+ ChatColor.LIGHT_PURPLE + target2.getDisplayName());
									target2.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
											+ " You have been given a " + ChatColor.LIGHT_PURPLE
											+ "KitUnlock Tyche x" + stringToInt(args[3]));
									return true;
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else {
								sender.sendMessage(plugin.servern + " " + plugin.syntax);
								return true;
							}
						} else {
							sender.sendMessage(plugin.servern + " " + plugin.pnotfound);
							return true;
						}
					} else if (args[0].equalsIgnoreCase("spawn")) {
						sender.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
								+ " This command can only be executed by players in game!");
						return true;
					} else {
						sender.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else if (args.length == 5) {
					if (args[0].equalsIgnoreCase("give")) {
						if (!Bukkit.getPlayer(args[1]).equals(null)) {
							if (isInteger(args[4])) {
								Player target3 = Bukkit.getPlayer(args[1]);
								if (args[2].equalsIgnoreCase("fo")) {
									if (args[3].equalsIgnoreCase("1m")) {
										fo.fo1m(target3, stringToInt(args[4]));
										sender.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE
												+ " You have given a " + ChatColor.LIGHT_PURPLE + "Flight Orb 1m x"
												+ stringToInt(args[4]) + ChatColor.DARK_PURPLE + " to "
												+ ChatColor.LIGHT_PURPLE + target3.getDisplayName());
										target3.sendMessage(plugin.servern + ChatColor.DARK_PURPLE
												+ " You have been given a " + ChatColor.LIGHT_PURPLE
												+ "Flight Orb 1m x" + stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("2m")) {
										fo.fo2m(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("3m")) {
										fo.fo3m(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("4m")) {
										fo.fo4m(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("5m")) {
										fo.fo5m(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("10m")) {
										fo.fo10m(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("15m")) {
										fo.fo15m(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("30m")) {
										fo.fo30m(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("1h")) {
										fo.fo1h(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("2h")) {
										fo.fo2h(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("4h")) {
										fo.fo4h(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("8h")) {
										fo.fo8h(target3, stringToInt(args[4]));
										return true;
									} else {
										sender.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("ro")) {
									if (args[3].equalsIgnoreCase("hermes")) {
										ro.roHermes(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("apollo")) {
										ro.roApollo(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("ares")) {
										ro.roAres(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("hera")) {
										ro.roHera(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("poseidon")) {
										ro.roPoseidon(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("zeus")) {
										ro.roZeus(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("atlas")) {
										ro.roAtlas(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("upgrade")) {
										ro.roUpgrade(target3, stringToInt(args[4]));
										return true;
									} else {
										sender.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("schem")) {
									if (args[3].equalsIgnoreCase("one")) {
										s.schematicOne(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("two")) {
										s.schematicTwo(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("three")) {
										s.schematicThree(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("four")) {
										s.schematicFive(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("five")) {
										s.schematicFive(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("six")) {
										s.schematicSix(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("seven")) {
										s.schematicSeven(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("eight")) {
										s.schematicEight(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("nine")) {
										s.schematicNine(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("ten")) {
										s.schematicTen(target3, stringToInt(args[4]));
										return true;
									} else {
										sender.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("dschem")) {
									if (args[3].equalsIgnoreCase("one")) {
										ds.dSchematicOne(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("two")) {
										ds.dSchematicTwo(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("three")) {
										ds.dSchematicThree(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("four")) {
										ds.dSchematicFour(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("five")) {
										ds.dSchematicFive(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("six")) {
										ds.dSchematicSix(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("seven")) {
										ds.dSchematicSeven(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("eight")) {
										ds.dSchematicEight(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("nine")) {
										ds.dSchematicNine(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("ten")) {
										ds.dSchematicTen(target3, stringToInt(args[4]));
										return true;
									} else {
										sender.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("kitshard")) {
									if (args[3].equalsIgnoreCase("tyche")) {
										ks.kShardTyche(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("artemis")) {
										ks.kShardArtemis(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("demeter")) {
										ks.kShardDemeter(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("hephaetus")) {
										ks.kShardHephaetus(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("hades")) {
										ks.kShardHades(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("nemesis")) {
										ks.kShardNemesis(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("random")) {
										ks.kShardRandom(target3, stringToInt(args[4]));
										return true;
									} else {
										sender.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else if (args[2].equalsIgnoreCase("kitunlock")) {
									if (args[3].equalsIgnoreCase("tyche")) {
										ku.kUnlockTyche(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("artemis")) {
										ku.kUnlockArtemis(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("demeter")) {
										ku.kUnlockDemeter(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("hephaetus")) {
										ku.kUnlockHephaetus(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("hades")) {
										ku.kUnlockHades(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("nemesis")) {
										ku.kUnlockNemesis(target3, stringToInt(args[4]));
										return true;
									} else if (args[3].equalsIgnoreCase("random")) {
										ku.kUnlockRandom(target3, stringToInt(args[4]));
										return true;
									} else {
										sender.sendMessage(plugin.servern + " " + plugin.syntax);
										return true;
									}
								} else {
									sender.sendMessage(plugin.servern + " " + plugin.syntax);
									return true;
								}
							} else {
								sender.sendMessage(plugin.servern + " " + plugin.syntax);
								return true;
							}
						} else {
							sender.sendMessage(plugin.servern + " " + plugin.pnotfound);
							return true;
						}
					} else {
						sender.sendMessage(plugin.servern + " " + plugin.syntax);
						return true;
					}
				} else {
					sender.sendMessage(plugin.servern + " " + plugin.syntax);
					return true;
				}
			} else {
				return false;
			}
		}
	}

}
