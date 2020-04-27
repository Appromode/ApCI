package com.appromode.utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.ci.Initialise;
import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class FoRunnable extends BukkitRunnable {

	@Inject
	private Initialise plugin;

	int secToMin(int seconds) {
		return (seconds / 60) + 1;
	}

	int secToHour(int seconds) {
		return ((seconds / 60) / 60) + 1;
	}

	@Override
	public void run() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			UUID uuid = player.getUniqueId();
			if (plugin.foCooldownTime.containsKey(uuid)) {
				if (player.getWorld().getName().equals("ASkyBlock")) {
					player.setAllowFlight(true);
					if (plugin.foCooldownTime.get(uuid) <= 59 && plugin.foCooldownTime.get(uuid) > 1) {
						ActionBarAPI.sendActionBar(player, ChatColor.DARK_PURPLE + " Your flight orb has "
								+ plugin.foCooldownTime.get(uuid) + " second(s) left!");
					} else if (plugin.foCooldownTime.get(uuid) == 0) {
						player.setAllowFlight(false);
						player.setFlying(false);
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Your flight orb's effects have worn off!");
						ActionBarAPI.sendActionBar(player,
								ChatColor.DARK_PURPLE + " Your flight orb's effects have worn off!", 100);
					}
				} else {
					player.setAllowFlight(false);
					player.setFlying(false);
					ActionBarAPI.sendActionBar(player,
							ChatColor.DARK_PURPLE + " Your flight orb's effects have stopped due to switching worlds!");
				}
			}
		}
	}
}
