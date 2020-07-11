package com.huxiaoheng.EventListener;

import com.huxiaoheng.MyPlugin;
import lk.vexview.event.KeyBoardHoldEvent;
import lk.vexview.event.KeyBoardPressEvent;
import lk.vexview.event.gui.VexGuiOpenEvent;
import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.VexButton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VexViewListener implements Listener {
    @EventHandler
    public void PlayerOpneGui(VexGuiOpenEvent event){
        VexGui gui = event.getGui();
        //如果是购买保险
        if(gui.getUrl().equals("[local]insurePurchase.png")){
            //购买第一个购买按钮
            VexButton b1 = gui.getButtonByHashCode(1);
            MyPlugin.plugin.getLogger().info("点击了按钮一");
            //第二个购买按钮
            VexButton b2 = gui.getButtonByHashCode(2);
            //第三个购买按钮
            VexButton b3 = gui.getButtonByHashCode(3);
            MyPlugin.plugin.getLogger().info("点击了按钮一");
        }
    }
}
