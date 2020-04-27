package com.appromode.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.appromode.ci.Initialise;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class Admin {
	
	@Inject
	private Initialise plugin;
	
	public ItemStack blackPane() {
		ItemStack blackpane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
		ItemMeta blackpanem = blackpane.getItemMeta();
		blackpanem.setDisplayName(" ");
		blackpanem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		blackpane.setItemMeta(blackpanem);
		
		return blackpane;		
	}
	
	public ItemStack goBack() {
		ItemStack goback = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta gobackm = goback.getItemMeta();
		gobackm.setDisplayName(ChatColor.WHITE + "Go Back");
		gobackm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		goback.setItemMeta(gobackm);

		return goback;
	}
	
	public ItemStack goNext() {
		ItemStack goback = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta gobackm = goback.getItemMeta();
		gobackm.setDisplayName(ChatColor.WHITE + "Next Page");
		gobackm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		goback.setItemMeta(gobackm);

		return goback;
	}
	
	public ItemStack goPrevious() {
		ItemStack goback = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta gobackm = goback.getItemMeta();
		gobackm.setDisplayName(ChatColor.WHITE + "Previous Page");
		gobackm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		goback.setItemMeta(gobackm);

		return goback;
	}
	
	public void adminHomeInv(Player player) {
		Inventory inv = plugin.getServer().createInventory(null, 27, plugin.prefix + ChatColor.WHITE + " CI Admin Menu");
		
		ItemStack adminm1p1 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm1p1m = adminm1p1.getItemMeta();
		adminm1p1m.setDisplayName(ChatColor.WHITE + "Custom Items");
		adminm1p1m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm1p1.setItemMeta(adminm1p1m);
		
		ItemStack adminm1p2 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm1p2m = adminm1p1.getItemMeta();
		adminm1p2m.setDisplayName(ChatColor.WHITE + "Schematics");
		adminm1p2m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm1p2.setItemMeta(adminm1p2m);
		
		inv.setItem(12, adminm1p1);
		inv.setItem(14, adminm1p2);
		
        player.openInventory(inv);
		
		for (int i = 0; i <inv.getSize(); i++) {
			if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
				inv.setItem(i, blackPane());
			}
		}
	}
	
	public void adminCIInv(Player player) {
		Inventory inv = plugin.getServer().createInventory(null, 54, plugin.prefix + ChatColor.WHITE + " Custom Items");
		
		ItemStack adminm2p1 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p1m = adminm2p1.getItemMeta();
		adminm2p1m.setDisplayName(ChatColor.WHITE + "Flight Orb 1m");
		adminm2p1m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p1.setItemMeta(adminm2p1m);
		
		ItemStack adminm2p2 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p2m = adminm2p2.getItemMeta();
		adminm2p2m.setDisplayName(ChatColor.WHITE + "Flight Orb 2m");
		adminm2p2m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p2.setItemMeta(adminm2p2m);
		
		ItemStack adminm2p3 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p3m = adminm2p3.getItemMeta();
		adminm2p3m.setDisplayName(ChatColor.WHITE + "Flight Orb 3m");
		adminm2p3m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p3.setItemMeta(adminm2p3m);
		
		ItemStack adminm2p4 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p4m = adminm2p4.getItemMeta();
		adminm2p4m.setDisplayName(ChatColor.WHITE + "Flight Orb 4m");
		adminm2p4m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p4.setItemMeta(adminm2p4m);
		
		ItemStack adminm2p5 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p5m = adminm2p5.getItemMeta();
		adminm2p5m.setDisplayName(ChatColor.WHITE + "Flight Orb 5m");
		adminm2p5m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p5.setItemMeta(adminm2p5m);
		
		ItemStack adminm2p6 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p6m = adminm2p6.getItemMeta();
		adminm2p6m.setDisplayName(ChatColor.WHITE + "Flight Orb 10m");
		adminm2p6m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p6.setItemMeta(adminm2p6m);
		
		ItemStack adminm2p7 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p7m = adminm2p7.getItemMeta();
		adminm2p7m.setDisplayName(ChatColor.WHITE + "Flight Orb 15m");
		adminm2p7m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p7.setItemMeta(adminm2p7m);
		
		ItemStack adminm2p8 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p8m = adminm2p8.getItemMeta();
		adminm2p8m.setDisplayName(ChatColor.WHITE + "Flight Orb 30m");
		adminm2p8m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p8.setItemMeta(adminm2p8m);
		
		ItemStack adminm2p9 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p9m = adminm2p9.getItemMeta();
		adminm2p9m.setDisplayName(ChatColor.WHITE + "Flight Orb 1h");
		adminm2p9m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p9.setItemMeta(adminm2p9m);
		
		ItemStack adminm2p10 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p10m = adminm2p10.getItemMeta();
		adminm2p10m.setDisplayName(ChatColor.WHITE + "Flight Orb 2h");
		adminm2p10m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p10.setItemMeta(adminm2p10m);
		
		ItemStack adminm2p11 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p11m = adminm2p11.getItemMeta();
		adminm2p11m.setDisplayName(ChatColor.WHITE + "Flight Orb 4h");
		adminm2p11m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p11.setItemMeta(adminm2p11m);
		
		ItemStack adminm2p12 = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta adminm2p12m = adminm2p12.getItemMeta();
		adminm2p12m.setDisplayName(ChatColor.WHITE + "Flight Orb 8h");
		adminm2p12m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p12.setItemMeta(adminm2p12m);
		
		ItemStack adminm2p13 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p13m = adminm2p13.getItemMeta();
		adminm2p13m.setDisplayName(ChatColor.WHITE + "Rank Orb Hermes");
		adminm2p13m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p13.setItemMeta(adminm2p13m);
		
		ItemStack adminm2p14 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p14m = adminm2p14.getItemMeta();
		adminm2p14m.setDisplayName(ChatColor.WHITE + "Rank Orb Apollo");
		adminm2p14m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p14.setItemMeta(adminm2p14m);
		
		ItemStack adminm2p15 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p15m = adminm2p15.getItemMeta();
		adminm2p15m.setDisplayName(ChatColor.WHITE + "Rank Orb Ares");
		adminm2p15m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p15.setItemMeta(adminm2p15m);
		
		ItemStack adminm2p16 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p16m = adminm2p16.getItemMeta();
		adminm2p16m.setDisplayName(ChatColor.WHITE + "Rank Orb Hera");
		adminm2p16m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p16.setItemMeta(adminm2p16m);
		
		ItemStack adminm2p17 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p17m = adminm2p17.getItemMeta();
		adminm2p17m.setDisplayName(ChatColor.WHITE + "Rank Orb Poseidon");
		adminm2p17m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p17.setItemMeta(adminm2p17m);
		
		ItemStack adminm2p18 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p18m = adminm2p18.getItemMeta();
		adminm2p18m.setDisplayName(ChatColor.WHITE + "Rank Orb Zeus");
		adminm2p18m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p18.setItemMeta(adminm2p18m);
		
		ItemStack adminm2p19 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p19m = adminm2p19.getItemMeta();
		adminm2p19m.setDisplayName(ChatColor.WHITE + "Rank Orb Atlas");
		adminm2p19m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p19.setItemMeta(adminm2p19m);
		
		ItemStack adminm2p20 = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta adminm2p20m = adminm2p20.getItemMeta();
		adminm2p20m.setDisplayName(ChatColor.WHITE + "Rank Orb Upgrade");
		adminm2p20m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p20.setItemMeta(adminm2p20m);
		
		ItemStack adminm2p21 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta adminm2p21m = adminm2p21.getItemMeta();
		adminm2p21m.setDisplayName(ChatColor.WHITE + "Kit Shard Tyche");
		adminm2p21m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p21.setItemMeta(adminm2p21m);
		
		ItemStack adminm2p22 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta adminm2p22m = adminm2p22.getItemMeta();
		adminm2p22m.setDisplayName(ChatColor.WHITE + "Kit Shard Artemis");
		adminm2p22m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p22.setItemMeta(adminm2p22m);
		
		ItemStack adminm2p23 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta adminm2p23m = adminm2p23.getItemMeta();
		adminm2p23m.setDisplayName(ChatColor.WHITE + "Kit Shard Demeter");
		adminm2p23m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p23.setItemMeta(adminm2p23m);
		
		ItemStack adminm2p24 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta adminm2p24m = adminm2p24.getItemMeta();
		adminm2p24m.setDisplayName(ChatColor.WHITE + "Kit Shard Hephaetus");
		adminm2p24m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p24.setItemMeta(adminm2p24m);
		
		ItemStack adminm2p25 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta adminm2p25m = adminm2p25.getItemMeta();
		adminm2p25m.setDisplayName(ChatColor.WHITE + "Kit Shard Hades");
		adminm2p25m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p25.setItemMeta(adminm2p25m);
		
		ItemStack adminm2p26 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta adminm2p26m = adminm2p26.getItemMeta();
		adminm2p26m.setDisplayName(ChatColor.WHITE + "Kit Shard Nemesis");
		adminm2p26m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p26.setItemMeta(adminm2p26m);
		
		ItemStack adminm2p27 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta adminm2p27m = adminm2p27.getItemMeta();
		adminm2p27m.setDisplayName(ChatColor.WHITE + "Kit Shard Random");
		adminm2p27m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p27.setItemMeta(adminm2p27m);
		
		ItemStack adminm2p28 = new ItemStack(Material.CHEST, 1);
		ItemMeta adminm2p28m = adminm2p28.getItemMeta();
		adminm2p28m.setDisplayName(ChatColor.WHITE + "Kit Unlock Tyche");
		adminm2p28m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm2p28.setItemMeta(adminm2p28m);
		
		inv.setItem(10, adminm2p1);
		inv.setItem(11, adminm2p2);
		inv.setItem(12, adminm2p3);
		inv.setItem(13, adminm2p4);
		inv.setItem(14, adminm2p5);
		inv.setItem(15, adminm2p6);
		inv.setItem(16, adminm2p7);
		inv.setItem(19, adminm2p8);
		inv.setItem(20, adminm2p9);
		inv.setItem(21, adminm2p10);
		inv.setItem(22, adminm2p11);
		inv.setItem(23, adminm2p12);
		inv.setItem(24, adminm2p13);
		inv.setItem(25, adminm2p14);
		inv.setItem(28, adminm2p15);
		inv.setItem(29, adminm2p16);
		inv.setItem(30, adminm2p17);
		inv.setItem(31, adminm2p18);
		inv.setItem(32, adminm2p19);
		inv.setItem(33, adminm2p20);
		inv.setItem(34, adminm2p21);
		inv.setItem(37, adminm2p22);
		inv.setItem(38, adminm2p23);
		inv.setItem(39, adminm2p24);
		inv.setItem(40, adminm2p25);
		inv.setItem(41, adminm2p26);
		inv.setItem(42, adminm2p27);
		inv.setItem(43, adminm2p28);
		inv.setItem(45, goBack());
		inv.setItem(53, goNext());
		
        player.openInventory(inv);
		
		for (int i = 0; i <inv.getSize(); i++) {
			if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
				inv.setItem(i, blackPane());
			}
		}

	}
	
	public void adminCITwoInv(Player player) {
		Inventory inv = plugin.getServer().createInventory(null, 54, plugin.prefix + " Custom Items 2");
		
		
		ItemStack adminm3p1 = new ItemStack(Material.CHEST, 1);
		ItemMeta adminm3p1m = adminm3p1.getItemMeta();
		adminm3p1m.setDisplayName(ChatColor.WHITE + "Kit Unlock Artemis");
		adminm3p1m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm3p1.setItemMeta(adminm3p1m);
		
		ItemStack adminm3p2 = new ItemStack(Material.CHEST, 1);
		ItemMeta adminm3p2m = adminm3p2.getItemMeta();
		adminm3p2m.setDisplayName(ChatColor.WHITE + "Kit Unlock Demeter");
		adminm3p2m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm3p2.setItemMeta(adminm3p2m);
		
		ItemStack adminm3p3 = new ItemStack(Material.CHEST, 1);
		ItemMeta adminm3p3m = adminm3p3.getItemMeta();
		adminm3p3m.setDisplayName(ChatColor.WHITE + "Kit Unlock Hephaetus");
		adminm3p3m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm3p3.setItemMeta(adminm3p3m);
		
		ItemStack adminm3p4 = new ItemStack(Material.CHEST, 1);
		ItemMeta adminm3p4m = adminm3p4.getItemMeta();
		adminm3p4m.setDisplayName(ChatColor.WHITE + "Kit Unlock Hades");
		adminm3p4m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm3p4.setItemMeta(adminm3p4m);
		
		ItemStack adminm3p5 = new ItemStack(Material.CHEST, 1);
		ItemMeta adminm3p5m = adminm3p5.getItemMeta();
		adminm3p5m.setDisplayName(ChatColor.WHITE + "Kit Unlock Nemesis");
		adminm3p5m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm3p5.setItemMeta(adminm3p5m);		
		
		ItemStack adminm3p6 = new ItemStack(Material.CHEST, 1);
		ItemMeta adminm3p6m = adminm3p6.getItemMeta();
		adminm3p6m.setDisplayName(ChatColor.WHITE + "Kit Unlock Random");
		adminm3p6m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm3p6.setItemMeta(adminm3p6m);
		
		ItemStack adminm3p7 = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta adminm3p7m = adminm3p7.getItemMeta();
		adminm3p7m.setDisplayName(ChatColor.WHITE + "Insta-Kill Sword");
		adminm3p7m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm3p7.setItemMeta(adminm3p7m);
		
		inv.setItem(10, adminm3p1);
		inv.setItem(11, adminm3p2);
		inv.setItem(12, adminm3p3);
		inv.setItem(13, adminm3p4);
		inv.setItem(14, adminm3p5);
		inv.setItem(15, adminm3p6);
		inv.setItem(16, adminm3p7);
		inv.setItem(45, goPrevious());
		inv.setItem(49, goBack());
		
		player.openInventory(inv);
		
		for (int i = 0; i <inv.getSize(); i++) {
			if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
				inv.setItem(i, blackPane());
			}
		}
	}
	
	public void adminSchematicInv(Player player) {
		Inventory inv = plugin.getServer().createInventory(null, 54, plugin.prefix + "Schematics");
		
		ItemStack adminm4p1 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p1m = adminm4p1.getItemMeta();
		adminm4p1m.setDisplayName(ChatColor.WHITE + "Schematic 1");
		adminm4p1m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p1.setItemMeta(adminm4p1m);
		
		ItemStack adminm4p2 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p2m = adminm4p2.getItemMeta();
		adminm4p2m.setDisplayName(ChatColor.WHITE + "Schematic 2");
		adminm4p2m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p2.setItemMeta(adminm4p2m);
		
		ItemStack adminm4p3 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p3m = adminm4p3.getItemMeta();
		adminm4p3m.setDisplayName(ChatColor.WHITE + "Schematic 3");
		adminm4p3m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p3.setItemMeta(adminm4p3m);
		
		ItemStack adminm4p4 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p4m = adminm4p4.getItemMeta();
		adminm4p4m.setDisplayName(ChatColor.WHITE + "Schematic 4");
		adminm4p4m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p4.setItemMeta(adminm4p4m);
		
		ItemStack adminm4p5 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p5m = adminm4p5.getItemMeta();
		adminm4p5m.setDisplayName(ChatColor.WHITE + "Schematic 5");
		adminm4p5m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p5.setItemMeta(adminm4p5m);
		
		ItemStack adminm4p6 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p6m = adminm4p6.getItemMeta();
		adminm4p6m.setDisplayName(ChatColor.WHITE + "Schematic 6");
		adminm4p6m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p6.setItemMeta(adminm4p6m);
		
		ItemStack adminm4p7 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p7m = adminm4p7.getItemMeta();
		adminm4p7m.setDisplayName(ChatColor.WHITE + "Schematic 7");
		adminm4p7m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p7.setItemMeta(adminm4p7m);
		
		ItemStack adminm4p8 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p8m = adminm4p8.getItemMeta();
		adminm4p8m.setDisplayName(ChatColor.WHITE + "Schematic 8");
		adminm4p8m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p8.setItemMeta(adminm4p8m);
		
		ItemStack adminm4p9 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p9m = adminm4p9.getItemMeta();
		adminm4p9m.setDisplayName(ChatColor.WHITE + "Schematic 9");
		adminm4p9m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p9.setItemMeta(adminm4p9m);
		
		ItemStack adminm4p10 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p10m = adminm4p10.getItemMeta();
		adminm4p10m.setDisplayName(ChatColor.WHITE + "Schematic 10");
		adminm4p10m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p10.setItemMeta(adminm4p10m);
		
		ItemStack adminm4p11 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p11m = adminm4p11.getItemMeta();
		adminm4p11m.setDisplayName(ChatColor.WHITE + "Premium Schematic 1");
		adminm4p11m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p11.setItemMeta(adminm4p11m);
		
		ItemStack adminm4p12 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p12m = adminm4p12.getItemMeta();
		adminm4p12m.setDisplayName(ChatColor.WHITE + "Premium Schematic 2");
		adminm4p12m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p12.setItemMeta(adminm4p12m);
		
		ItemStack adminm4p13 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p13m = adminm4p13.getItemMeta();
		adminm4p13m.setDisplayName(ChatColor.WHITE + "Premium Schematic 3");
		adminm4p13m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p13.setItemMeta(adminm4p13m);
		
		ItemStack adminm4p14 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p14m = adminm4p14.getItemMeta();
		adminm4p14m.setDisplayName(ChatColor.WHITE + "Premium Schematic 4");
		adminm4p14m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p14.setItemMeta(adminm4p14m);
		
		ItemStack adminm4p15 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p15m = adminm4p15.getItemMeta();
		adminm4p15m.setDisplayName(ChatColor.WHITE + "Premium Schematic 5");
		adminm4p15m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p15.setItemMeta(adminm4p15m);
		
		ItemStack adminm4p16 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p16m = adminm4p16.getItemMeta();
		adminm4p16m.setDisplayName(ChatColor.WHITE + "Premium Schematic 6");
		adminm4p16m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p16.setItemMeta(adminm4p16m);
		
		ItemStack adminm4p17 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p17m = adminm4p17.getItemMeta();
		adminm4p17m.setDisplayName(ChatColor.WHITE + "Premium Schematic 7");
		adminm4p17m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p17.setItemMeta(adminm4p17m);
		
		ItemStack adminm4p18 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p18m = adminm4p18.getItemMeta();
		adminm4p18m.setDisplayName(ChatColor.WHITE + "Premium Schematic 8");
		adminm4p18m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p18.setItemMeta(adminm4p18m);
		
		ItemStack adminm4p19 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p19m = adminm4p19.getItemMeta();
		adminm4p19m.setDisplayName(ChatColor.WHITE + "Premium Schematic 9");
		adminm4p19m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p19.setItemMeta(adminm4p19m);
		
		ItemStack adminm4p20 = new ItemStack(Material.PAPER, 1);
		ItemMeta adminm4p20m = adminm4p20.getItemMeta();
		adminm4p20m.setDisplayName(ChatColor.WHITE + "Premium Schematic 10");
		adminm4p20m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		adminm4p20.setItemMeta(adminm4p20m);
		
		inv.setItem(10, adminm4p1);
		inv.setItem(11, adminm4p2);
		inv.setItem(12, adminm4p3);
		inv.setItem(13, adminm4p4);
		inv.setItem(14, adminm4p5);
		inv.setItem(15, adminm4p6);
		inv.setItem(16, adminm4p7);
		inv.setItem(19, adminm4p8);
		inv.setItem(20, adminm4p9);
		inv.setItem(21, adminm4p10);
		inv.setItem(22, adminm4p11);
		inv.setItem(23, adminm4p12);
		inv.setItem(24, adminm4p13);
		inv.setItem(25, adminm4p14);
		inv.setItem(28, adminm4p15);
		inv.setItem(29, adminm4p16);
		inv.setItem(30, adminm4p17);
		inv.setItem(31, adminm4p18);
		inv.setItem(32, adminm4p19);
		inv.setItem(33, adminm4p20);
		inv.setItem(45, goBack());
		
		player.openInventory(inv);
		
		for (int i = 0; i <inv.getSize(); i++) {
			if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
				inv.setItem(i, blackPane());
			}
		}
	}

}
