package com.insanephin.bellbellplugin;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ToolsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack sword = new ItemStack(Material.STONE_SWORD);
            ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE);
            ItemStack axe = new ItemStack(Material.STONE_AXE);

            sword.addEnchantment(Enchantment.DURABILITY, 1);
            pickaxe.addEnchantment(Enchantment.DURABILITY, 1);
            axe.addEnchantment(Enchantment.DURABILITY, 1);

            player.getInventory().addItem(sword, pickaxe, axe);

            player.sendMessage(ChatColor.GREEN+"너에게 내구성1짜리 돌셋을 줄게.");
            return true;
        }
        else if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(Color.RED+"You can't use this command in console");
            return false;
        }
        return false;
    }
}
