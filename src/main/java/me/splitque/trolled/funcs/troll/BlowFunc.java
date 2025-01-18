package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.AbstractFunc;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BlowFunc extends AbstractFunc {
    public BlowFunc() {
        super(Material.TNT, Trolled.funcConfig.getString("troll.blow.title"), Trolled.funcConfig.getString("troll.blow.description"), 1, 1);
    }

    @Override
    public void func(Player admin, Player trolled) {
        Trolled.log.info("Getted func from " + getTitle());
        trolled.getLocation().createExplosion(Trolled.funcConfig.getInteger("troll.blow.power"), Trolled.funcConfig.getBoolean("troll.blow.setfire"), Trolled.funcConfig.getBoolean("troll.blow.breakblocks"));
    }
}
