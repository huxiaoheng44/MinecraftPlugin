package com.huxiaoheng.CommendExecutor;

import com.connorlinfoot.titleapi.TitleAPI;
import com.huxiaoheng.EventListener.EffectEvent;
import com.huxiaoheng.MyPlugin;
import com.huxiaoheng.EventListener.addEventListener;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitRunnable;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;
import sun.jvm.hotspot.oops.Metadata;
import sun.jvm.hotspot.opto.Block;

import java.util.ArrayList;
import java.util.List;



public class CheatCommandExecutor implements CommandExecutor {
    private final MyPlugin plugin;

    public CheatCommandExecutor(MyPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            if(command.getName().equalsIgnoreCase("cheat")){
                for(int i=0;i<strings.length;i++){
                    if(strings[i].equalsIgnoreCase("fly")){
                        plugin.getLogger().info("一个玩家会飞了");
                        commandSender.sendMessage("你现在能飞了");
                        ((Player) commandSender).setAllowFlight(true);
                        ((Player) commandSender).setFlying(true);
                    }else if(strings[i].equalsIgnoreCase("recover")){
                        if (commandSender.hasPermission("vip.v1")) {
                            commandSender.sendMessage("钻石之路启动");
                            Bukkit.getPluginManager().registerEvents(new addEventListener(), MyPlugin.plugin);
                        }
                    }else if(strings[i].equalsIgnoreCase("money")){
                        PermissionAttachment attachment = commandSender.addAttachment(MyPlugin.plugin);
                        if(!commandSender.hasPermission("vip.v1")){
                            attachment.setPermission("vip.v1",true);
                        }else if(!commandSender.hasPermission("vip.v2")){
                            attachment.setPermission("vip.v2",true);
                        }else if(!commandSender.hasPermission("vip.v3")){
                            attachment.setPermission("vip.v3",true);
                        }
                        Player player = (Player)commandSender;

                    }else if(strings[i].equalsIgnoreCase("bag")){

                        Inventory inv1 = Bukkit.createInventory(null, InventoryType.CHEST, "§2 !seesaw!");
                        ItemStack itemStack = new ItemStack(Material.APPLE,13);
                        ItemStack MineCart = new ItemStack(Material.MINECART,3);
                        ItemStack rail = new ItemStack(Material.RAILS,20);
                        String itemname = "JinPingGuo";
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName(itemname);
                        itemStack.setItemMeta(itemMeta);
                        List<String> lores = new ArrayList<String>();
                        lores.add("+5攻击力");  //第一行lore
                        lores.add("abc");  //这条lore在123之后
                        ItemStack myItem = new ItemStack(Material.DIAMOND_SWORD);  //你的物品
                        itemMeta.setLore(lores); //add the lores of course
                        itemStack.setItemMeta(itemMeta); //give the item the new itemmeta
                        inv1.addItem(itemStack);
                        inv1.addItem(MineCart);
                        inv1.addItem(rail);
                        inv1.getHolder();
                        ((Player) commandSender).closeInventory();
                        ((Player) commandSender).openInventory(inv1);

                    }else if(strings[i].equalsIgnoreCase("lao")){
                        PermissionAttachment attachment = commandSender.addAttachment(MyPlugin.plugin);
                        attachment.setPermission("lao",true);
                    }else if(strings[i].equalsIgnoreCase("effect")){
                        //注册监听
                        Bukkit.getPluginManager().registerEvents(new EffectEvent(),MyPlugin.plugin);
                    }else if(strings[i].equalsIgnoreCase("title")){
                        //title test
                        TitleAPI.sendTitle((Player)commandSender,10,40,10,"sendTitle","fi");
                    }else if(strings[i].equalsIgnoreCase("tele")){
                        Location l = ((Player) commandSender).getLocation();
                        World world = ((Player) commandSender).getWorld();
                        l = l.add(0,3,-1);
                        MaterialData materialData = new MaterialData(Material.STONE);
                        FallingBlock b = world.spawnFallingBlock(l,new MaterialData(Material.GOLD_BLOCK));
                        b.setDropItem(false);
//                        Entity entity = world.spawnEntity(l.add(1,0,1), EntityType.GHAST);
//                        entity.setCustomName("Ghasht");
//                        entity.set
                        world.spawnEntity(l.add(2,0,1), EntityType.SNOWMAN);
                        Entity pass = world.spawnEntity(l.add(1,0,1), EntityType.PIG);
                        Entity entity = (Horse) world.spawnEntity(l.add(2,0,1), EntityType.SHEEP);
                        entity.setCustomName("Horse");
                        entity.setCustomNameVisible(true);
                        entity.addPassenger(pass);

                    }

                }
                return true;
            }
        }else {
            commandSender.sendMessage("You must be a player!");
            return false;
        }
        return false;
    }
}
