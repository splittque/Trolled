package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.AbstractFunc;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class KickFunc extends AbstractFunc {
    public KickFunc() {
        super(Material.BARRIER, Trolled.funcConfig.getString("troll.kick.title"), Trolled.funcConfig.getString("troll.kick.description"), 1, 3);
    }

    @Override
    public void func(Player admin, Player trolled) {
        trolled.kick(Component.text(Trolled.funcConfig.getString("troll.kick.reason")));
    }
}
