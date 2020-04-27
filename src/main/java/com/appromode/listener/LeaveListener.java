package com.appromode.listener;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.appromode.ci.Initialise;
import com.google.inject.Inject;

public class LeaveListener implements Listener {

	@Inject
	private Initialise plugin;

	@EventHandler
	public void foLeave(PlayerQuitEvent event) {
		String sPlayer = event.getPlayer().getName();
		Player player = Bukkit.getPlayer(sPlayer);
		final UUID uuid = player.getUniqueId();

		if (plugin.foCooldownTime.containsKey(uuid)) {
			int fotime = plugin.foCooldownTime.get(uuid);
			plugin.foTimes.put(uuid, fotime);
			plugin.foCooldownTime.remove(uuid);
			plugin.foCooldownTask.remove(uuid);
			return;
		} else {
			return;
		}
	}
}
