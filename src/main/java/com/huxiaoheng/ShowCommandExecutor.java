package com.huxiaoheng;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowCommandExecutor implements CommandExecutor {
    private final MyPlugun plugin;

    public ShowCommandExecutor(MyPlugun plugin) {
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
                return true;
            }
        }else {
            commandSender.sendMessage("You must be a player!");
            return false;
        }
        return false;
    }
}
