package me.splitque.trolled.funcs;

import me.splitque.trolled.Utils;
import me.splitque.trolled.menu.MenuHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class Manager implements Listener {
    private MenuHandler menu;
    private int rows;
    public List<Func> funcs;

    public Manager(String title, int rows, JavaPlugin plugin) {
        funcs = new ArrayList<>();
        menu = new MenuHandler(title, rows, plugin);
        this.rows = rows;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);

        setFuncs();
    }

    public MenuHandler getMenu() {
        return menu;
    }

    public abstract void setFuncs();

    public void registerFunc(Func func) {
        funcs.add(func);
    }

    @EventHandler
    public void onItemClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(menu.getTitle())) {
            e.setCancelled(true);

            ItemStack head = e.getView().getItem(Utils.getIndex(rows, 5));
            SkullMeta meta = (SkullMeta) head.getItemMeta();

            if (meta.hasOwner()) {
                Player admin = (Player) e.getWhoClicked();
                Player trolled = meta.getOwningPlayer().getPlayer();

                if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;

                for (Func func : funcs) {
                    if (e.getCurrentItem().toString().equals(func.getItem().toString())) func.func(admin, trolled);
                }
            }
        }
    }
}
