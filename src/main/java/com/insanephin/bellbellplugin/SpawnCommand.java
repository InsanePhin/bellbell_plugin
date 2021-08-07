package com.insanephin.bellbellplugin;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            player.teleport(player.getBedSpawnLocation());

            player.sendMessage(ChatColor.GREEN+"여기가 너의 스폰지역이야.");
            return true;
        }
        else if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(Color.RED+"You can't use this command in console");
            return false;
        }
        return false;
    }
}
