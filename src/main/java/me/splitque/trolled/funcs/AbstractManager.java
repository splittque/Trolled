package me.splitque.trolled.funcs;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.Utils;
import me.splitque.trolled.menu.MenuManager;
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

public abstract class AbstractManager implements Listener {
    private MenuManager menu;
    public List<AbstractFunc> funcs;

    public AbstractManager(String title, JavaPlugin plugin) {
        funcs = new ArrayList<>();
        menu = new MenuManager(title, 4, plugin);
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Trolled.log.info("Created func manager");
    }

    public abstract void register();

    public MenuManager getMenu() {
        return menu;
    }
    public void addToList(AbstractFunc func) {
        funcs.add(func);
    }

    @EventHandler
    public void onItemClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(menu.getTitle())) {
            e.setCancelled(true);

            ItemStack head = e.getView().getItem(Utils.getIndex(4, 5));
            SkullMeta meta = (SkullMeta) head.getItemMeta();

            if (meta.hasOwner()) {
                Player admin = (Player) e.getWhoClicked();
                Player trolled = meta.getOwningPlayer().getPlayer();

                if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;

                for (AbstractFunc func : funcs) {
                    if (e.getCurrentItem().getType() == func.getItem()) func.func(admin, trolled);
                }
            }
        }
    }
}
