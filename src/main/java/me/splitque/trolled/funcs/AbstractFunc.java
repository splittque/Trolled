package me.splitque.trolled.funcs;

import me.splitque.trolled.Trolled;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public abstract class AbstractFunc {
    private Material item;
    private String title;
    private String description;
    private int row;
    private int column;

    public AbstractFunc(Material item, String title, String description, int row, int column) {
        this.item = item;
        this.title = title;
        this.description = description;
        this.row = row;
        this.column = column;
        Trolled.log.info("Created func");
    }

    public void register(AbstractManager manager) {
        manager.getMenu().registerToMenu(item, title, description, row, column);
        manager.addToList(this);
        Trolled.log.info("func registered");
    }

    public String getTitle() {
        return title;
    }
    public Material getItem() {
        return item;
    }

    public abstract void func(Player admin, Player trolled);
}
