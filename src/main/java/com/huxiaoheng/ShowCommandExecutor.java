package com.huxiaoheng;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowCommandExecutor implements CommandExecutor {
    private final MyPlugin plugin;

    public ShowCommandExecutor(MyPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            if(command.getName().equalsIgnoreCase("show")){
                plugin.getLogger().info("show命令已被检测到");
                plugin.getLogger().info("Player name:"+commandSender.getName());
                commandSender.sendMessage("Your name:"+commandSender.getName());
                Location l = ((Player) commandSender).getLocation();
                plugin.getLogger().info("Player location:\n"+"x:"+l.getBlockX()+"\ny:"+l.getBlockY()+"\nz:"+l.getBlockZ());
                commandSender.sendMessage("Your location:\n"+"x:"+l.getBlockX()+"\ny:"+l.getBlockY()+"\nz:"+l.getBlockZ());
                Player player = (Player)commandSender;
                //权限
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
                return true;
            }
        }else {
            commandSender.sendMessage("You must be a player!");
            return false;
        }
        return false;
    }
}
