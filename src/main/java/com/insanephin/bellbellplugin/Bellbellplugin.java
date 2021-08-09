package com.insanephin.bellbellplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public class Bellbellplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("tools").setExecutor(new ToolsCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("b").setExecutor(new BackCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("tpaccept").setExecutor(new TpacceptCommand());
        getCommand("tpadeny").setExecutor(new TpadenyCommand());

        getServer().getPluginManager().registerEvents(new BackCommand(), this);

        getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule showDeathMessages false");

        getLogger().info(Color.GREEN+"벨벨플러그인 [활성화]");
    }

    @Override
    public void onDisable() {
        getLogger().info(Color.RED+"벨벨플러그인 [비활성화]");
    }

}
