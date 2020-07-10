package com.huxiaoheng.EventListener;


import com.huxiaoheng.MyPlugin;
import com.huxiaoheng.Utils.PeaceAreaUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.entity.EntityType.DROPPED_ITEM;
import static org.bukkit.entity.EntityType.ITEM_FRAME;


public class SaveAreaEvent implements Listener {
    @EventHandler
    public void SaveAreaInteract(PlayerInteractEvent event) {
//        Player player = event.getPlayer();
//        // 得到玩家当前的坐标.
//        Location location =  player.getLocation();
//        Location spawnLocation = player.getWorld().getSpawnLocation();
//        Block block = event.getClickedBlock();
//        player.sendMessage("----------------PlayerInteractEvent-----------------");
//        player.sendMessage("你点击了Block"+block.getType());
//
//        if(location.getX()-spawnLocation.getX()<=30 && location.getZ()-spawnLocation.getZ()<=30 && !event.getPlayer().hasPermission("op")){
//            if(block.getType() == Material.ENDER_PORTAL_FRAME){
//                player.sendMessage("你点击了ENDER_PORTAL_FRAME");
//                Inventory inventory = player.getInventory();
//                ItemStack itemStack = new ItemStack(block.getType(),6);
//                inventory.addItem(itemStack);
//                event.setCancelled(true);
//            }else if(block.getType() == Material.ITEM_FRAME){
//                player.sendMessage("你点击了ITEM_FRAME");
//                Inventory inventory = player.getInventory();
//                ItemStack itemStack = new ItemStack(block.getType(),6);
//                inventory.addItem(itemStack);
//            }else {
//                //player.sendMessage("你不是管理员不能进行操作:"+event.getAction());
//            }
//        }

    }
    @EventHandler
    public void SaveAreaInteractEntity(PlayerInteractEntityEvent event) {
//        Player player = event.getPlayer();
//        player.sendMessage("----------------PlayerInteractEntityEvent-----------------");
//        // 得到玩家当前的坐标.
//        Location location =  player.getLocation();
//        Location spawnLocation = player.getWorld().getSpawnLocation();
//        if(location.getX()-spawnLocation.getX()<=30 && location.getZ()-spawnLocation.getZ()<=30 && !event.getPlayer().hasPermission("op")){
//            Entity block = event.getRightClicked();
//            player.sendMessage("你点击了Entity"+block.getType());
//        }

    }

    @EventHandler
    public void DamageEvent(BlockDamageEvent event){
        Player player = event.getPlayer();
        if(PeaceAreaUtil.IsPeaceArea(player.getLocation())) {
            event.getPlayer().sendMessage("你不能搞破坏"+event.getBlock().getType());
            event.setCancelled(true);
        }
        //event.setCancelled(true);
    }

    @EventHandler
    public void EntityDamage(EntityDamageByEntityEvent event){
        if(PeaceAreaUtil.IsPeaceArea(event.getDamager().getLocation())) {
            event.getDamager().sendMessage("你不能伤害其他其他人");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(PeaceAreaUtil.IsPeaceArea(player.getLocation())) {
            //player.sendMessage("-------------BlockPlaceEvent--------------");
            player.sendMessage("你不能在这里建造东西");
            event.setCancelled(true);
        }
    }
//    @EventHandler
//    public void EntityDeath(EntityDeathEvent event){
//        MyPlugin.plugin.getLogger().info("-------------BlockBreakEvent--------------"+event.getEntity());
//    }
//    @EventHandler
//    public void EntityDrop(EntityExplodeEvent event){
//        MyPlugin.plugin.getLogger().info("-------------EntityExplodeEvent--------------"+event.getEntity());
//    }
//
//    @EventHandler
//    public void PlayerItemBreakEvent(PlayerItemBreakEvent event){
//        MyPlugin.plugin.getLogger().info("-------------PlayerItemBreakEvent--------------");
//    }
//
//    @EventHandler
//    public void PlayerDropItemEvent(PlayerDropItemEvent event){
//        MyPlugin.plugin.getLogger().info("-------------PlayerDropItemEvent--------------");
//    }

//    @EventHandler
//    public void EntitySpawn(EntitySpawnEvent event){
//        //Entity entity = event.getEntity();
//        HandlerList handlerList = event.getHandlers();
//        MyPlugin.plugin.getLogger().info(handlerList.toString());
//        if(event.getEntity().getType().equals(DROPPED_ITEM)){
//            MyPlugin.plugin.getLogger().info("-------------你不能伤害它1--------------");
//            //event.setCancelled(true);
//        }
//        if(event.getEntity().getType().toString().equalsIgnoreCase(String.valueOf(Material.ITEM_FRAME))){
//            MyPlugin.plugin.getLogger().info("-------------你不能伤害它2--------------");
//        }
//        if(event.getEntity().getType().equals(ITEM_FRAME)){
//            MyPlugin.plugin.getLogger().info("-------------你不能伤害它3--------------");
//        }
//        MyPlugin.plugin.getLogger().info("-------------EntitySpawnEvent--------------"+event.getEntity().getType());
//    }
//    @EventHandler
//    public void BlockBuildEvent(BlockCanBuildEvent event) {
//        Block b  = event.getBlock();
//        // 得到玩家当前的坐标.
//        Location location =  b.getLocation();
//        Location spawnLocation = b.getWorld().getSpawnLocation();
//        if(location.getX()-spawnLocation.getX()<=20 && location.getZ()-spawnLocation.getZ()<=20){
//            event.setBuildable(false);
//        }
//
//    }

//    @EventHandler
//    public void AreaBlockBreakEvent(BlockBreakEvent event) {
//        Block b  = event.getBlock();
//        // 得到玩家当前的坐标.
//        Location location =  b.getLocation();
//
//        Location spawnLocation = b.getWorld().getSpawnLocation();
//        if(location.getX()-spawnLocation.getX()<=30 && location.getZ()-spawnLocation.getZ()<=30 && !event.getPlayer().hasPermission("op")){
//            event.getPlayer().sendMessage("在该区域不能破坏物品");
//            event.setCancelled(true);
//        }
//
//    }

}
