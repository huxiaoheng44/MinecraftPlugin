package com.huxiaoheng;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

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
                            Bukkit.getPluginManager().registerEvents(new addEvent(), MyPlugin.plugin);
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
