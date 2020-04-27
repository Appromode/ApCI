package com.appromode.item;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class KitUnlock {
	
	public void kUnlockTyche(Player player, int amount) {
		ItemStack item = new ItemStack(Material.CHEST, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Tyche" + ChatColor.WHITE + " Kit Unlock");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Tyche" + ChatColor.WHITE + " kit unlock will permanenly unlock");
		iteml.add(ChatColor.WHITE + "the Tyche kit.");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in the");
		iteml.add(ChatColor.WHITE + "skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public void kUnlockArtemis(Player player, int amount) {
		ItemStack item = new ItemStack(Material.CHEST, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Artemis" + ChatColor.WHITE + " Kit Unlock");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Artemis" + ChatColor.WHITE + " kit unlock will permanenly unlock");
		iteml.add(ChatColor.WHITE + " the Artemis kit.");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in the");
		iteml.add(ChatColor.WHITE + "skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public void kUnlockDemeter(Player player, int amount) {
		ItemStack item = new ItemStack(Material.CHEST, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Demeter" + ChatColor.WHITE + " Kit Unlock");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Demeter" + ChatColor.WHITE + " kit unlock will permanenly unlock");
		iteml.add(ChatColor.WHITE + "the Demeter kit.");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public void kUnlockHephaetus(Player player, int amount) {
		ItemStack item = new ItemStack(Material.CHEST, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hephaetus" + ChatColor.WHITE + " Kit Unlock");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Hephaetus" + ChatColor.WHITE + " kit unlock will permanenly unlock");
		iteml.add(ChatColor.WHITE + "the Hephaetus kit.");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public void kUnlockHades(Player player, int amount) {
		ItemStack item = new ItemStack(Material.CHEST, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hades" + ChatColor.WHITE + " Kit Unlock");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Hades" + ChatColor.WHITE + " kit unlock will permanenly unlock");
		iteml.add(ChatColor.WHITE + "the Hades kit.");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public void kUnlockNemesis(Player player, int amount) {
		ItemStack item = new ItemStack(Material.CHEST, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Nemesis" + ChatColor.WHITE + " Kit Unlock");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Nemesis" + ChatColor.WHITE + " kit unlock will permanenly unlock");
		iteml.add(ChatColor.WHITE + "the Nemesis kit.");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public void kUnlockRandom(Player player, int amount) {
		ItemStack item = new ItemStack(Material.CHEST, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Random" + ChatColor.WHITE + " Kit Unlock");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Random" + ChatColor.WHITE + " kit unlock will permanenly unlock any");
		iteml.add(ChatColor.WHITE + "Random kit.");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}

}
