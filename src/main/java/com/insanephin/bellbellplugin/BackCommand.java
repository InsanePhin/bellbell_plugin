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
                player.sendMessage(ChatColor.GREEN+"죽기전 위치로 이동하였습니다.");
            }
            else {
                player.sendMessage(ChatColor.RED+"죽은 뒤 명령어를 사용하실 수 있습니다.");
                try {
                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.GOLD +"3");

                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.YELLOW +"2");

                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.DARK_GREEN +"1");
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
