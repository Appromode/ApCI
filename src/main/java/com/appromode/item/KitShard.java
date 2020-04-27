package com.appromode.item;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class KitShard {
	
	public void kShardTyche(Player player, int amount) {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Tyche" + ChatColor.WHITE + " Kit Shard");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Tyche" + ChatColor.WHITE + " kit shard rewards include - " + ChatColor.DARK_PURPLE + "1x, 2x,");
		iteml.add(ChatColor.DARK_PURPLE + "3x " + ChatColor.WHITE + "and" + ChatColor.DARK_PURPLE + " permanent unlock");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public ItemStack oneTimesTyche() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Tyche " + ChatColor.WHITE + " 1x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack twoTimesTyche() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Tyche " + ChatColor.WHITE + " 2x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack threeTimesTyche() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Tyche " + ChatColor.WHITE + " 3x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack permTyche() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Tyche " + ChatColor.WHITE + " Permanent Kit Unlock");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public void kShardArtemis(Player player, int amount) {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Artemis" + ChatColor.WHITE + " Kit Shard");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Artemis" + ChatColor.WHITE + " kit shard rewards include - " + ChatColor.DARK_PURPLE + "1x, 2x,");
		iteml.add(ChatColor.DARK_PURPLE + "3x " + ChatColor.WHITE + "and" + ChatColor.DARK_PURPLE + " permanent unlock");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public ItemStack oneTimesArtemis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Artemis " + ChatColor.WHITE + " 1x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack twoTimesArtemis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Artemis " + ChatColor.WHITE + " 2x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack threeTimesArtemis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Artemis " + ChatColor.WHITE + " 3x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack permArtemis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Artemis " + ChatColor.WHITE + " Permanent Kit Unlock");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public void kShardDemeter(Player player, int amount) {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Demeter" + ChatColor.WHITE + " Kit Shard");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Demeter" + ChatColor.WHITE + " kit shard rewards include - " + ChatColor.DARK_PURPLE + "1x, 2x,");
		iteml.add(ChatColor.DARK_PURPLE + "3x " + ChatColor.WHITE + "and" + ChatColor.DARK_PURPLE + " permanent unlock");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public ItemStack oneTimesDemeter() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Demeter " + ChatColor.WHITE + " 1x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack twoTimesDemeter() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Demeter " + ChatColor.WHITE + " 2x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack threeTimesDemeter() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Demeter " + ChatColor.WHITE + " 3x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack permDemeter() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Demeter " + ChatColor.WHITE + " Permanent Kit Unlock");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public void kShardHephaetus(Player player, int amount) {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hephaetus" + ChatColor.WHITE + " Kit Shard");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Hephaetus" + ChatColor.WHITE + " kit shard rewards include - " + ChatColor.DARK_PURPLE + "1x, 2x,");
		iteml.add(ChatColor.DARK_PURPLE + "3x " + ChatColor.WHITE + "and" + ChatColor.DARK_PURPLE + " permanent unlock");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public ItemStack oneTimesHephaetus() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hephaetus " + ChatColor.WHITE + " 1x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack twoTimesHephaetus() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hephaetus " + ChatColor.WHITE + " 2x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack threeTimesHephaetus() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hephaetus " + ChatColor.WHITE + " 3x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack permHephaetus() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hephaetus " + ChatColor.WHITE + " Permanent Kit Unlock");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public void kShardHades(Player player, int amount) {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hades" + ChatColor.WHITE + " Kit Shard");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Hades" + ChatColor.WHITE + " kit shard rewards include - " + ChatColor.DARK_PURPLE + "1x, 2x,");
		iteml.add(ChatColor.DARK_PURPLE + "3x " + ChatColor.WHITE + "and" + ChatColor.DARK_PURPLE + " permanent unlock");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public ItemStack oneTimesHades() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hades " + ChatColor.WHITE + " 1x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack twoTimesHades() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hades " + ChatColor.WHITE + " 2x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack threeTimesHades() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hades " + ChatColor.WHITE + " 3x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack permHades() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Hades " + ChatColor.WHITE + " Permanent Kit Unlock");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public void kShardNemesis(Player player, int amount) {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Nemesis" + ChatColor.WHITE + " Kit Shard");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Nemesis" + ChatColor.WHITE + " kit shard rewards include - " + ChatColor.DARK_PURPLE + "1x, 2x,");
		iteml.add(ChatColor.DARK_PURPLE + "3x " + ChatColor.WHITE + "and" + ChatColor.DARK_PURPLE + " permanent unlock");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + " This item can only be used in");
		iteml.add(ChatColor.WHITE + "the skyblock world");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}
	
	public ItemStack oneTimesNemesis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Nemesis " + ChatColor.WHITE + " 1x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack twoTimesNemesis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Nemesis " + ChatColor.WHITE + " 2x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack threeTimesNemesis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Nemesis " + ChatColor.WHITE + " 3x Kit");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public ItemStack permNemesis() {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Nemesis " + ChatColor.WHITE + " Permanent Kit Unlock");
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		return item;
	}
	
	public void kShardRandom(Player player, int amount) {
		ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Random" + ChatColor.WHITE + " Kit Shard");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.DARK_PURPLE + "Random" + ChatColor.WHITE + " kit shard rewards include - " + ChatColor.DARK_PURPLE + "1x, 2x,");
		iteml.add(ChatColor.DARK_PURPLE + "3x " + ChatColor.WHITE + "and" + ChatColor.DARK_PURPLE + " permanent unlock of any kit");
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
