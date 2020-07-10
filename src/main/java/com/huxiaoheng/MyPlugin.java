package com.huxiaoheng;


import com.huxiaoheng.CommendExecutor.CheatCommandExecutor;
import com.huxiaoheng.CommendExecutor.EconomyCommandExecutor;
import com.huxiaoheng.CommendExecutor.ShowCommandExecutor;
import com.huxiaoheng.EventListener.*;
import com.huxiaoheng.Utils.BlockUtils;
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
        //玩家加入监听器
        Bukkit.getPluginManager().registerEvents(new addEventListener(),this);
        //粒子特效监听器
        Bukkit.getPluginManager().registerEvents(new EffectEvent(),this);
        //坐骑监听器
        Bukkit.getPluginManager().registerEvents(new TeleHorseListener(),this);
        //GUI监听器
        Bukkit.getPluginManager().registerEvents(new VexViewListener(),this);
        //安全区域监听器
        Bukkit.getPluginManager().registerEvents(new SaveAreaEvent(),this);

        this.getCommand("money").setExecutor(new EconomyCommandExecutor(this));
        this.getCommand("show").setExecutor(new ShowCommandExecutor(this));
        this.getCommand("Cheat").setExecutor(new CheatCommandExecutor(this));
        getLogger().info("----------第一个plugin启动------------");
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().info("----------没有发现Vault，插件无法继续使用！------------");
            //禁用插件
            getServer().getPluginManager().disablePlugin(this);
        }
        //vaultUtil used for economy
        if(VaultUtil.setupEconomy()){
            plugin.getLogger().info("--------------vaultutil启动成功------------------");
        }else{
            plugin.getLogger().info("----------------vaultutil启动失败--------------");
        }
        //vexGUI
        if(Bukkit.getPluginManager().isPluginEnabled("VexView")){
            plugin.getLogger().info("----------成功启动VexView---------");
        }else{
            plugin.getLogger().info("----------VexView启动失败----------");
        }

        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("----------第一个plugin关闭------------");
        super.onDisable();
    }

}
