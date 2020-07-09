package com.huxiaoheng.VexView;

import lk.vexview.VexView;
import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.VexComponents;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vex;

import java.util.ArrayList;
import java.util.List;

public class MyGUI {
    public static VexGui fisstGui(Player player){
        List<VexComponents> vexComponentsList = new ArrayList<>();

        return new VexGui("[local]gui.png",-1,-1,400,200);
    }
}
