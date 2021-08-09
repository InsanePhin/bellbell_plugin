package com.insanephin.bellbellplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TpacceptCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target = (Player) sender;

        if (TpaCommand.tpa.containsKey(target)) {
            target.sendMessage(ChatColor.AQUA + target.getName() + ChatColor.GREEN + "님이 당신의 요청을 수락했어요. TP해드릴게요.");

            Player requester = (Player) TpaCommand.tpa.get(target);

            requester.teleport(target.getLocation());

            TpaCommand.tpa.remove(target);

            target.sendMessage(ChatColor.AQUA + target.getName() + ChatColor.GREEN + "님을 당신에게 TP했어요.");

            return true;
        }
        else {
            target.sendMessage(ChatColor.RED+"아쉽게도 TP요청을 받은적이 없어요.");

            return true;
        }
    }
}