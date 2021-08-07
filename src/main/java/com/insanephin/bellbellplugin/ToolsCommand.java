package com.insanephin.bellbellplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
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

            player.getInventory().addItem(sword, pickaxe, axe);

            player.sendMessage("Complete");
            return true;
        }
        else if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("You can't use this command in console");
            return false;
        }
    return false;
    }
}
