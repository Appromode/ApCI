package com.appromode.item;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class InstaSword {
	
	public void instaSword(Player player, int amount) {
		ItemStack item = new ItemStack(Material.WOOD_SWORD, amount);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(ChatColor.DARK_PURPLE + "Insta-Kill Sword");
		ArrayList<String> iteml = new ArrayList<String>();
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		iteml.add(ChatColor.WHITE + "This will destroy anything in it's path!");
		iteml.add(ChatColor.DARK_PURPLE + "Warning: " + ChatColor.WHITE + "This item will break on use and can");
		iteml.add(ChatColor.WHITE + "only be used in the warzone.");
		iteml.add(ChatColor.LIGHT_PURPLE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		itemm.setLore(iteml);		
		itemm.addItemFlags(ItemFlag.HIDE_ENCHANTS);		
		item.setItemMeta(itemm);
		item.addUnsafeEnchantment(Enchantment.LUCK, 1);
		
		player.getInventory().addItem(item);
	}

}
