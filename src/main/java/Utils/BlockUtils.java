package Utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockUtils {
    public static Block getShiftBlock(Location location,double shiftx,double shifty,double shitfz) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        x += shiftx;
        y += shifty;
        z += shitfz;
        Location shLocation = new Location(location.getWorld(),x,y,z);
        return shLocation.getBlock();
    }

//    public static Block getFrontBlock(Player player){
//        Location location = player.getLocation();
//
//    }
}
