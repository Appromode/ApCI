package com.appromode.utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.ci.Initialise;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class RankOrbConfirm extends BukkitRunnable {

	@Inject
	private Initialise plugin;

	@Override
	public void run() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			UUID uuid = player.getUniqueId();
			if (!plugin.confirmTime.containsKey(uuid)) {
				if (plugin.ciConfirmed.containsKey(uuid)) {
					if (plugin.ciConfirmed.get(uuid).equals(1)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Hermes" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set hermes");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(2)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Apollo" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set apollo");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(3)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Ares" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set ares");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(4)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Hera" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set hera");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(5)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Poseidon" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set poseidon");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(6)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Zeus" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set zeus");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(7)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Atlas" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set atlas");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(8)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Hermes" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set hermes");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(9)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Apollo" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set apollo");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(10)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Ares" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set ares");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(11)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Hera" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set hera");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(12)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Poseidon" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set poseidon");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(13)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Zeus" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set zeus");
						plugin.ciConfirmed.remove(uuid);
					} else if (plugin.ciConfirmed.get(uuid).equals(14)) {
						player.sendMessage(
								plugin.servern + ChatColor.DARK_PURPLE + " Enjoy your new " + ChatColor.LIGHT_PURPLE + "Atlas" + " rank and perks!");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + player.getName() + " parent set atlas");
						plugin.ciConfirmed.remove(uuid);
					} else {
						plugin.ciConfirmed.remove(uuid);
					}
				}
			}
		}		
	}
}
