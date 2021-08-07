package com.insanephin.bellbellplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            player.teleport(player.getBedSpawnLocation());

            player.sendMessage("Complete");
            return true;
        }
        else if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("You don't use this command in console");
            return false;
        }
        return false;
    }
}
