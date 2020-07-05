package com.huxiaoheng;

import Utils.BlockUtils;
import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.graalvm.compiler.phases.schedule.BlockClosure;

public class addEvent implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        //MyPlugin.plugin.getLogger().info("玩家触发了OnPlayerMove事件");
        Player player = event.getPlayer();
        // 得到玩家当前的坐标.
        if(player.hasPermission("vip.v2")) {
            Location loc = event.getPlayer().getLocation();
            // 设置目标坐标为玩家头顶 5 格处.
            loc.setY(loc.getY() - 1);
            // 得到目标坐标的方块
            Block b = loc.getBlock();
            // 将目标坐标的方块更改为石头 (stone).
            b.setType(Material.GOLD_BLOCK);

        }
        if(player.hasPermission("lao")){
            Location loc = event.getPlayer().getLocation();
            Block b1 = BlockUtils.getShiftBlock(loc,-1,0,0);
            Block b2 = BlockUtils.getShiftBlock(loc,+1,0,0);
            Block b1_xia = BlockUtils.getShiftBlock(loc,-1,-1,0);
            Block b2_xia = BlockUtils.getShiftBlock(loc,+1,-1,0);
            Block b = BlockUtils.getShiftBlock(loc,0,0,0);
            b1_xia.setType(Material.IRON_BLOCK);
            b2_xia.setType(Material.IRON_BLOCK);
            b1.setType(Material.REDSTONE_TORCH_ON);
            b2.setType(Material.REDSTONE_TORCH_ON);
            b.setType(Material.POWERED_RAIL);
            MyPlugin.plugin.getLogger().info("get face:"+b1.getFace(b1).toString());
            MyPlugin.plugin.getLogger().info("get relative:"+b1.getRelative(b1.getFace(b)).toString());

        }
    }
    @EventHandler
    public void PlayerIn(PlayerJoinEvent event){
        Player player = event.getPlayer(); // 当玩家加入游戏
        PlayerInventory inventory = player.getInventory(); // 获取玩家背包列表
        ItemStack itemstack = new ItemStack(Material.DIAMOND, 64); // 生成一组钻石

        if (!inventory.contains(itemstack)) {
            inventory.addItem(itemstack); // 将一组钻石放到玩家的背包里
            player.sendMessage("Wow！你的钻石哪来的！"); //向玩家发送消息("Wow！你看上去很土豪啊！")
        }
        MyPlugin.plugin.getLogger().info("玩家触发了加入游戏事件");
        //Player player = event.getPlayer();
        player.sendMessage("欢迎加入"+player.getName());



        if(player.isPermissionSet("vip")){
            player.sendMessage("用户设置了vip权限");
        }else{
            player.sendMessage("用户没有设置vip权限");
        }

        if(player.isPermissionSet("vip.v1")){
            player.sendMessage("用户设置了v1权限");
        }else{
            player.sendMessage("用户没有设置v1权限");
        }

        if(player.hasPermission("vip")){
            player.sendMessage("你有vip权限");
        }else{
            player.sendMessage("你没有vip权限");
        }
        if(player.hasPermission("vip.v1")){
            player.sendMessage("你有v1权限");
        }else{
            player.sendMessage("你没有v1权限");
        }
        if(player.hasPermission("vip.v2")){
            player.sendMessage("你有v2权限");
        }else{
            player.sendMessage("你没有v2权限");
        }
        if(player.hasPermission("vip.v3")){
            player.sendMessage("你有v3权限");
        }else{
            player.sendMessage("你没有v3权限");
        }

    }

    @EventHandler
    public void addMore(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        player.sendMessage("你点击了"+event.getRightClicked());
        MyPlugin.plugin.getLogger().info("玩家触发了加入游戏事件");
        Inventory inventory = player.getInventory();
        ItemStack itemStack = new ItemStack((ItemStack) event.getRightClicked());
        itemStack.setAmount(1);
        inventory.addItem(itemStack);

    }


}
