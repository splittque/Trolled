package me.splitque.trolled.funcs.sounds;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.AbstractFunc;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ToTroll extends AbstractFunc {
    public ToTroll() {
        super(Material.LEVER, Trolled.msgConfig.getString("return_back"), null, 4, 1);
    }

    @Override
    public void func(Player admin, Player trolled) {
        admin.openInventory(Trolled.trollManager.getMenu().getInventory(trolled.getName()));
    }
}
