package com.huxiaoheng;

import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugun extends JavaPlugin {

    @Override
    public void onEnable() {
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
