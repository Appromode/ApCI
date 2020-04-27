package com.appromode.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.appromode.ci.Initialise;
import com.appromode.item.KitShard;
import com.google.inject.Inject;

import net.md_5.bungee.api.ChatColor;

public class CrateAnimation {
	
	private HashMap<ItemStack, Integer> tycheItems = new HashMap<ItemStack, Integer>();
	private HashMap<Integer, ItemStack> tycheItemsList = new HashMap<Integer, ItemStack>();
	
	boolean tycheLoad = false;
	
	@Inject
	private Initialise plugin;
	
	@Inject
	private KitShard ks;
	
	public void tycheLoads() {
		tycheLoad = true;
		tycheItems.put(ks.oneTimesTyche(), 6);
		tycheItems.put(ks.twoTimesTyche(), 5);
		tycheItems.put(ks.threeTimesTyche(), 4);
		tycheItems.put(ks.permTyche(), 2);
		tycheItemsList.put(1, ks.oneTimesTyche());
		tycheItemsList.put(2, ks.twoTimesTyche());
		tycheItemsList.put(3, ks.threeTimesTyche());
		tycheItemsList.put(4, ks.permTyche());
	}
	
	public ItemStack purplePane() {
		ItemStack purplepane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10);
		ItemMeta purplepanem = purplepane.getItemMeta();
		purplepanem.setDisplayName(" ");
		purplepanem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		purplepane.setItemMeta(purplepanem);
		
		return purplepane;		
	}
	
	public ItemStack pinkPane() {
		ItemStack pinkpane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 6);
		ItemMeta pinkpanem = pinkpane.getItemMeta();
		pinkpanem.setDisplayName(" ");
		pinkpanem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		pinkpane.setItemMeta(pinkpanem);
		
		return pinkpane;
	}
	
	public void tycheKitShardAnimation(Player player) {
		if (tycheLoad = false) {
			tycheLoads();
		}
		
		ItemStack win = null;
		int totalWeight = 0;
		for (ItemStack item : tycheItems.keySet()) {
			totalWeight += tycheItems.get(item);
		}
		
		double rand = Math.random() * totalWeight;
		
		for (ItemStack items : tycheItems.keySet()) {
			rand -= tycheItems.get(items);
			if (rand <= tycheItems.get(items)) {
				win = items;
				break;
			}
		}
		
		Inventory Inv = plugin.getServer().createInventory(null, 27, plugin.servern + ChatColor.WHITE + " Tyche Kit Shard");
		Inv.setItem(0, pinkPane());
		Inv.setItem(1, pinkPane());
		Inv.setItem(2, pinkPane());
		Inv.setItem(3, pinkPane());
		Inv.setItem(4, purplePane());
		Inv.setItem(5, pinkPane());
		Inv.setItem(6, pinkPane());
		Inv.setItem(7, pinkPane());
		Inv.setItem(8, pinkPane());
		Inv.setItem(18, pinkPane());
		Inv.setItem(19, pinkPane());
		Inv.setItem(20, pinkPane());
		Inv.setItem(21, pinkPane());
		Inv.setItem(22, purplePane());
		Inv.setItem(23, pinkPane());
		Inv.setItem(24, pinkPane());
		Inv.setItem(25, pinkPane());
		Inv.setItem(26, pinkPane());
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int item1 = 8;
			int item2 = 9;
			int item3 = 10;
			int item4 = 11;
			int item5 = 12;
			int item6 = 13;
			int item7 = 14;
			int item8 = 15;
			int item9 = 16;
            public void run() {
                item1++;
                item2++;
                item3++;
                item4++;
                item5++;
                item6++;
                item7++;
                item8++;
                item9++;
                if (item1 >= 18) {
                	item1 = 9;
                } else if (item2 >= 18) {
                	item2 = 9;
                } else if (item3 >= 18) {
                	item3 = 9;
                } else if (item4 >= 18) {
                	item4 = 9;
                } else if (item5 >= 18) {
                	item5 = 9;
                } else if (item6 >= 18) {
                	item6 = 9;
                } else if (item7 >= 18) {
                	item7 = 9;
                } else if (item8 >= 18) {
                	item8 = 9;
                } else if (item9 >= 18) {
                	item9 = 9;
                }
                Inv.setItem(item1, tycheItemsList.get(1));
                Inv.setItem(item2, tycheItemsList.get(2));
                Inv.setItem(item3, tycheItemsList.get(3));
                Inv.setItem(item4, tycheItemsList.get(4));
                Inv.setItem(item5, tycheItemsList.get(1));
                Inv.setItem(item6, tycheItemsList.get(2));
                Inv.setItem(item7, tycheItemsList.get(3));
                Inv.setItem(item8, tycheItemsList.get(4));
                Inv.setItem(item9, tycheItemsList.get(1));
 
            }
        }, 20, 10);
		player.openInventory(Inv);
	}
	
	public void artemisKitShardAnimation(Player player) {
		
	}
	
	public void demeterKitShardAnimation(Player player) {
		
	}
	
	public void hephaetusKitShardAnimation(Player player) {
		
	}
	
	public void hadesKitShardAnimation(Player player) {
		
	}
	
	public void nemesisKitShardAnimation(Player player) {
		
	}
	
	public void randomKitShardAnimation(Player player) {
		
	}

}
