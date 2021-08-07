package com.insanephin.bellbellplugin;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

public class BackCommand implements CommandExecutor, Listener {

    static HashMap<Player, Location> back = new HashMap<Player, Location>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        back.put(player, player.getLocation());

        event.setDeathMessage(ChatColor.RED+"누가 죽었다.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (back.containsKey(player)) {
                player.teleport(back.get(player));
                back.remove(player);
                player.sendMessage(ChatColor.GREEN+"죽었던 곳으로 보내줄게.");
            }
            else {
                player.sendMessage(ChatColor.RED+"죽고나면 명령어를 사용할 수 있을거야. 3초뒤에 죽여줄게.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.setHealth(0);
            }

            return true;
        }
        else if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(Color.RED+"You can't use this command in console");
            return false;
        }
        return false;
    }
}
