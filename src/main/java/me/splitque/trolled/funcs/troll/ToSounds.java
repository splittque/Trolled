package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.Func;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ToSounds extends Func {
    public ToSounds(TrollManager manager) {
        super(manager, Material.NOTE_BLOCK, Trolled.funcConfig.getString("troll.sounds.title"), Trolled.funcConfig.getString("troll.sounds.description"), 1, 5);
    }

    @Override
    public void func(Player admin, Player trolled) {
        admin.openInventory(Trolled.soundsManager.getMenu().getInventory(trolled.getDisplayName()));
    }
}
