package com.appromode.listener;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.ci.Initialise;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class PJoinListener implements Listener {
	
	@Inject
	private Initialise plugin;		
	
	@EventHandler
	public void foJoinLoadTimer(PlayerJoinEvent event) {
		String sPlayer = event.getPlayer().getName();
		Player player = Bukkit.getPlayer(sPlayer);
		final UUID uuid = player.getUniqueId();
				
		if (plugin.foTimes.containsKey(uuid)) {
			if (plugin.fopause.containsKey(uuid)) {
				player.sendMessage(plugin.prefix + ChatColor.DARK_PURPLE + " Your flight is still paused from your last logout");
				return;
			} else {
				int time = plugin.foTimes.get(uuid);
				plugin.foCooldownTime.put(uuid, time);
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
				player.setAllowFlight(true);
				player.setFlying(true);
				plugin.foTimes.remove(uuid);
			}			
		} else {
			player.setAllowFlight(false);
			player.setFlying(false);
			return;
		}
		
	}
}
