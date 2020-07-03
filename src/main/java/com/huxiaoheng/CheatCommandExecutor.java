package com.huxiaoheng;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheatCommandExecutor implements CommandExecutor {
    private final MyPlugun plugin;

    public CheatCommandExecutor(MyPlugun plugin) {
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
                        //((Player) commandSender).setHealth();
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
