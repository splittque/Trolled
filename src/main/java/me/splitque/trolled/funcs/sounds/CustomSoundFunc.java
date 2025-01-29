package me.splitque.trolled.funcs.sounds;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.Func;
import me.splitque.trolled.funcs.Manager;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CustomSoundFunc extends Func {

    public CustomSoundFunc(Manager manager) {
        super(manager, Material.PLAYER_HEAD, Trolled.funcConfig.getString("sounds.custom.title"), Trolled.funcConfig.getString("sounds.custom.description"), 1, 2);
    }

    @Override
    public void func(Player admin, Player trolled) {
        trolled.playSound(trolled.getLocation(), "custom", 500.0F, 50.0F);
    }
}
