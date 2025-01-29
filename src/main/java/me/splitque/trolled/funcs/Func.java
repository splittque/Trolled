package me.splitque.trolled.funcs;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.menu.MenuHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Func {
    private ItemStack itemStack;
    private String title;

    public Func(Manager manager, Material item, String title, String description, int row, int column) {
        this.title = title;
        this.itemStack = MenuHandler.getItemStack(item, title, description);
        manager.getMenu().registerToMenu(itemStack, row, column);
    }

    public String getTitle() {
        return title;
    }
    public ItemStack getItem() {
        return itemStack;
    }

    public abstract void func(Player admin, Player trolled);
}
