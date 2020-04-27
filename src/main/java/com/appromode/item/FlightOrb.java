package com.appromode.item;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class FlightOrb {

	public void fo1m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Minute]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 1 " + ChatColor.WHITE
				+ "minute");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo2m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Minutes]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 2 " + ChatColor.WHITE
				+ "minutes");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo3m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [3 Minutes]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 3 " + ChatColor.WHITE
				+ "minutes");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo4m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Minutes]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 4 " + ChatColor.WHITE
				+ "minutes");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo5m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [5 Minutes]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 5 " + ChatColor.WHITE
				+ "minutes");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo10m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [10 Minutes]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 10 " + ChatColor.WHITE
				+ "minutes");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo15m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [15 Minutes]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 15 " + ChatColor.WHITE
				+ "minutes");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo30m(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [30 Minutes]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 30 " + ChatColor.WHITE
				+ "minutes");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo1h(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [1 Hour]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 1 " + ChatColor.WHITE
				+ "hour");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo2h(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [2 Hours]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 2 " + ChatColor.WHITE
				+ "hours");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo4h(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [4 Hours]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 4 " + ChatColor.WHITE
				+ "hours");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void fo8h(Player player, int amount) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Orb Of Flight" + ChatColor.WHITE + " [8 Hours]");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will grant temporary flight for" + ChatColor.DARK_PURPLE + " 8 " + ChatColor.WHITE
				+ "hours");
		iteml.add(ChatColor.WHITE + "Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item can only be used in");
	    iteml.add(ChatColor.WHITE + "the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
}
