package com.insanephin.bellbellplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class bellbellplugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("뭔가 웅장한 브금과 함께 플러그인 [활성화]");
        getCommand("tools").setExecutor(new ToolsCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("b").setExecutor(new BackCommand());
        getServer().getPluginManager().registerEvents(new BackCommand(), this);

        getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule showDeathMessages false");
    }

    @Override
    public void onDisable() {
        getLogger().info("뭔가 웅장한 브금과 함께 플러그인 [비활성화]");
    }
}
