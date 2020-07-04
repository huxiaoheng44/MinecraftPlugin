package com.huxiaoheng;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {
    public static JavaPlugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new addEvent(),this);
        this.getCommand("show").setExecutor(new ShowCommandExecutor(this));
        this.getCommand("Cheat").setExecutor(new CheatCommandExecutor(this));
        getLogger().info("----------第一个plugin启动------------");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("----------第一个plugin关闭------------");
        super.onDisable();
    }
}
