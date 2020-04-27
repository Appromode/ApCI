package com.appromode.item;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class RankOrb {
	
	public void roHermes(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hermes");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will give access to the" + ChatColor.DARK_PURPLE + " Hermes " + ChatColor.WHITE
				+ "rank. Use");
		iteml.add(ChatColor.WHITE + "this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void roApollo(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Apollo");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will upgrade or give access to the" + ChatColor.DARK_PURPLE + " Apollo ");
		iteml.add(ChatColor.WHITE + "rank. Usethis orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void roAres(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Ares");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will upgrade or give access to the" + ChatColor.DARK_PURPLE + " Ares ");
		iteml.add(ChatColor.WHITE + "rank. Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void roHera(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Hera");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will upgrade or give access to the" + ChatColor.DARK_PURPLE + " Hera ");
		iteml.add(ChatColor.WHITE + "rank. Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void roPoseidon(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Poseidon");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will upgrade or give access to the" + ChatColor.DARK_PURPLE + " Poseidon ");
		iteml.add(ChatColor.WHITE + "rank. Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void roZeus(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Zeus");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will upgrade or give access to the" + ChatColor.DARK_PURPLE + " Zeus ");
		iteml.add(ChatColor.WHITE + "rank. Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void roAtlas(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb" + ChatColor.WHITE + " Atlas");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will upgrade or give access to the" + ChatColor.DARK_PURPLE + " Atlas ");
		iteml.add(ChatColor.WHITE + "rank. Use this orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}
	
	public void roUpgrade(Player player, int amount) {
		ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Rank Upgrade Orb");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "Will upgrade your rank to the next one up apart");
		iteml.add(ChatColor.WHITE + "from if you have the top rank already. Use this");
		iteml.add(ChatColor.WHITE + "orb wisely!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "You will not be able to use this");
	    iteml.add(ChatColor.WHITE + "if you have the top rank already or in any other");
	    iteml.add(ChatColor.WHITE + "world apart from the skyblock world");
	    iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    itemm.setLore(iteml);
	    itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(itemm);
	    item.addUnsafeEnchantment(Enchantment.LUCK, 1);
	    
	    player.getInventory().addItem(item);
	}

}
