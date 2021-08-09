package com.insanephin.bellbellplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class TpaCommand implements CommandExecutor, Listener {

    static HashMap<Player, Player> tpa = new HashMap<Player, Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        Player tpasender = (Player) sender;

        if (args.length == 0)
        {
            tpasender.sendMessage(ChatColor.RED + "TP요청을 보낼 유저를 명령어에 같이 적어주세요. ex) /tpa InsanePhin");
            return false;
        }

        if (tpasender == Bukkit.getPlayer(args[0])) {
            tpasender.sendMessage(ChatColor.RED + "TP요청을 자기자신에게 보낼 수 없습니다.");
            return false;
        }

        if (args.length == 1)
        {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null)
            {
                tpasender.sendMessage(ChatColor.RED + "아쉽지만 해당 플레이어는 온라인이 아니네요.");
            }
            else
            {
                tpa.put(target, tpasender);
                tpasender.sendMessage(ChatColor.AQUA+target.getName()+ChatColor.GREEN+"님에게 TP요청을 보냈어요.");
                target.sendMessage(ChatColor.AQUA + tpasender.getName() + ChatColor.GREEN + "님이 당신에게 TP요청을 보냈어요.\n\n수락은 /tpaccept, 거부는 /tpadeny로 하실 수 있습니다.");
                target.sendMessage(ChatColor.YELLOW + "2분안에 결정해주세요.");

            }
        }
    return false;
    }
}
