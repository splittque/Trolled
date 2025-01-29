package me.splitque.trolled.funcs.sounds;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.Func;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CreeperFunc extends Func {
    public CreeperFunc(SoundsManager manager) {
        super(manager, Material.CREEPER_HEAD, Trolled.funcConfig.getString("sounds.creeper.title"), Trolled.funcConfig.getString("sounds.creeper.description"), 1, 1);
    }

    @Override
    public void func(Player admin, Player trolled) {
        trolled.playSound(trolled.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0f, 1.0f);
    }
}
