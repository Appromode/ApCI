package com.appromode.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.appromode.ci.Initialise;
import com.appromode.item.DSchematic;
import com.appromode.item.FlightOrb;
import com.appromode.item.InstaSword;
import com.appromode.item.KitShard;
import com.appromode.item.KitUnlock;
import com.appromode.item.RankOrb;
import com.appromode.item.Schematic;
import com.appromode.menu.Admin;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class AdminMenuListener implements Listener {

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

	@EventHandler
	public void amMenuClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		

		if (open == null) {
			return;
		} else {
			if (open.getName().equals(plugin.prefix + ChatColor.WHITE + " CI Admin Menu")) {
				event.setCancelled(true);

				if (item == null || !item.hasItemMeta()) {
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Custom Items")) {
					player.closeInventory();
					am.adminCIInv(player);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematics")) {
					player.closeInventory();
					am.adminSchematicInv(player);
					return;
				} else {
					return;
				}
			} else if (open.getName().equals(plugin.prefix + ChatColor.WHITE + " Custom Items")) {
				event.setCancelled(true);

				if (item.equals(null) || !item.hasItemMeta()) {
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Go Back")) {
					player.closeInventory();
					am.adminHomeInv(player);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Next Page")) {
					player.closeInventory();
					am.adminCITwoInv(player);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 1m")) {
					fo.fo1m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 2m")) {
					fo.fo2m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 3m")) {
					fo.fo3m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 4m")) {
					fo.fo4m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 5m")) {
					fo.fo5m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 10m")) {
					fo.fo10m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 15m")) {
					fo.fo15m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 30m")) {
					fo.fo30m(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 1h")) {
					fo.fo1h(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 2h")) {
					fo.fo2h(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 4h")) {
					fo.fo4h(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Flight Orb 8h")) {
					fo.fo8h(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Hermes")) {
					ro.roHermes(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Apollo")) {
					ro.roApollo(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Ares")) {
					ro.roAres(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Hera")) {
					ro.roHera(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Poseidon")) {
					ro.roPoseidon(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Zeus")) {
					ro.roZeus(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Atlas")) {
					ro.roAtlas(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Rank Orb Upgrade")) {
					ro.roUpgrade(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Shard Tyche")) {
					ks.kShardTyche(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Shard Artemis")) {
					ks.kShardArtemis(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Shard Demeter")) {
					ks.kShardDemeter(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Shard Hephaetus")) {
					ks.kShardHephaetus(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Shard Hades")) {
					ks.kShardHades(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Shard Nemesis")) {
					ks.kShardNemesis(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Shard Random")) {
					ks.kShardRandom(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Unlock Tyche")) {
					ku.kUnlockTyche(player, 1);
					return;
				} else {
					return;
				}
			} else if (open.getName().equals(plugin.prefix + " Custom Items 2")) {
				event.setCancelled(true);

				if (item.equals(null) || !item.hasItemMeta()) {
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Go Back")) {
					player.closeInventory();
					am.adminHomeInv(player);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Previous Page")) {
					player.closeInventory();
					am.adminCIInv(player);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Unlock Artemis")) {
					ku.kUnlockArtemis(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Unlock Demeter")) {
					ku.kUnlockDemeter(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Unlock Hephaetus")) {
					ku.kUnlockHephaetus(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Unlock Hades")) {
					ku.kUnlockHades(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Unlock Nemesis")) {
					ku.kUnlockNemesis(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Kit Unlock Random")) {
					ku.kUnlockRandom(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Insta-Kill Sword")) {
					is.instaSword(player, 1);
					return;
				} else {
					return;
				}
			} else if (open.getName().equals(plugin.prefix + "Schematics")) {
				event.setCancelled(true);

				if (item.equals(null) || !item.hasItemMeta()) {
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Go Back")) {
					player.closeInventory();
					am.adminHomeInv(player);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 1")) {
					s.schematicOne(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 2")) {
					s.schematicTwo(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 3")) {
					s.schematicThree(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 4")) {
					s.schematicFour(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 5")) {
					s.schematicFive(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 6")) {
					s.schematicSix(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 7")) {
					s.schematicSeven(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 8")) {
					s.schematicEight(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 9")) {
					s.schematicNine(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Schematic 10")) {
					s.schematicTen(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 1")) {
					ds.dSchematicOne(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 2")) {
					ds.dSchematicTwo(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 3")) {
					ds.dSchematicThree(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 4")) {
					ds.dSchematicFour(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 5")) {
					ds.dSchematicFive(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 6")) {
					ds.dSchematicSix(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 7")) {
					ds.dSchematicSeven(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 8")) {
					ds.dSchematicEight(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 9")) {
					ds.dSchematicNine(player, 1);
					return;
				} else if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Premium Schematic 10")) {
					ds.dSchematicTen(player, 1);
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
