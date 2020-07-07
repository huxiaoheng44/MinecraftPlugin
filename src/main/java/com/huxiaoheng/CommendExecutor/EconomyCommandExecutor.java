package com.huxiaoheng.CommendExecutor;

import com.huxiaoheng.MyPlugin;
import com.huxiaoheng.Utils.VaultUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommandExecutor implements CommandExecutor {
    private final MyPlugin plugin;
    public EconomyCommandExecutor(MyPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            if(command.getName().equalsIgnoreCase("money")){
                double amount = VaultUtil.seemoney(((Player) commandSender).getUniqueId());
                commandSender.sendMessage("您现在拥有的金币为￥"+amount);
                }
                return true;
            }
        else {
            commandSender.sendMessage("You must be a player!");
            return false;
        }
    }
}
