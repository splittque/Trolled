package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.AbstractFunc;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ToSounds extends AbstractFunc {
    public ToSounds() {
        super(Material.NOTE_BLOCK, Trolled.funcConfig.getString("troll.sounds.title"), Trolled.funcConfig.getString("troll.sounds.description"), 1, 4);
    }

    @Override
    public void func(Player admin, Player trolled) {
        admin.openInventory(Trolled.soundsManager.getMenu().getInventory(trolled.getDisplayName()));
    }
}
