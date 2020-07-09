package com.huxiaoheng.EventListener;

import com.huxiaoheng.MyPlugin;
import lk.vexview.event.KeyBoardHoldEvent;
import lk.vexview.event.KeyBoardPressEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VexViewListener implements Listener {
    @EventHandler
    public void OnKey (KeyBoardPressEvent event){
        MyPlugin.plugin.getLogger().info("玩家按下了按键"+event.getKey());
    }
}
