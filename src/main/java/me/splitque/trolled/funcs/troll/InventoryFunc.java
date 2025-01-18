package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.AbstractFunc;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class InventoryFunc extends AbstractFunc {

    public InventoryFunc() {
        super(Material.CHEST, Trolled.funcConfig.getString("troll.inventory.title"), Trolled.funcConfig.getString("troll.inventory.description"), 1, 2);
    }

    @Override
    public void func(Player admin, Player trolled) {
        admin.openInventory(trolled.getInventory());
    }
}
