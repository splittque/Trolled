package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.Func;
import me.splitque.trolled.funcs.Manager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TeleportFunc extends Func {
    public TeleportFunc(Manager manager) {
        super(manager, Material.ELYTRA, Trolled.funcConfig.getString("troll.teleport.title"), Trolled.funcConfig.getString("troll.teleport.description"), 1, 6);
    }

    @Override
    public void func(Player admin, Player trolled) {
        double x = trolled.getLocation().getX() + Trolled.funcConfig.getDouble("troll.teleport.x");
        double y = trolled.getLocation().getY() + Trolled.funcConfig.getDouble("troll.teleport.y");
        double z = trolled.getLocation().getZ() + Trolled.funcConfig.getDouble("troll.teleport.z");

        trolled.teleport(new Location(trolled.getWorld(), x, y, z));
    }
}
