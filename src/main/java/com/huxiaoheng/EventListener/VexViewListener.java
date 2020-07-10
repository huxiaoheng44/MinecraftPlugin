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
        //如果是保险主界面
        if(gui.getUrl().equals("[local]InsureMain.png")){
            //购买保险按钮
            VexButton b1 = gui.getButtonByHashCode(1);
            //查看保险信息按钮
            VexButton b2 = gui.getButtonByHashCode(2);
        }
    }
}
