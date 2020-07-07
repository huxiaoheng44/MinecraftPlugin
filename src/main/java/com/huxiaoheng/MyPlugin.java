package com.huxiaoheng;


import com.huxiaoheng.CommendExecutor.CheatCommandExecutor;
import com.huxiaoheng.CommendExecutor.EconomyCommandExecutor;
import com.huxiaoheng.CommendExecutor.ShowCommandExecutor;
import com.huxiaoheng.EventListener.EffectEvent;
import com.huxiaoheng.EventListener.addEventListener;
import com.huxiaoheng.Utils.VaultUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MyPlugin extends JavaPlugin {
    public static JavaPlugin plugin;
    //vault plugin
    private static final Logger log = Logger.getLogger("Minecraft");
    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new addEventListener(),this);
        Bukkit.getPluginManager().registerEvents(new EffectEvent(),this);
        this.getCommand("money").setExecutor(new EconomyCommandExecutor(this));
        this.getCommand("show").setExecutor(new ShowCommandExecutor(this));
        this.getCommand("Cheat").setExecutor(new CheatCommandExecutor(this));
        getLogger().info("----------第一个plugin启动------------");
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().info("没有发现Vault，插件无法继续使用！");
            //禁用插件
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if(VaultUtil.setupEconomy()){
            plugin.getLogger().info("vaultutil启动成功");
        }else{
            plugin.getLogger().info("vaultutil启动失败");
        }

        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("----------第一个plugin关闭------------");
        super.onDisable();
    }

}
