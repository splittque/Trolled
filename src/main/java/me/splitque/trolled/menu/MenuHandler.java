package me.splitque.trolled.menu;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuHandler implements Listener {
    private String title;
    private Map<Integer, ItemStack> items;
    private int rows;

    public static ItemStack getItemStack(Material material, String name, String description) {
        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (description != null) {
            List<String> lore = new ArrayList<>();
            lore.add(description);
            itemMeta.setLore(lore);
        }

        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public MenuHandler(String title, int rows, JavaPlugin plugin) {
        items = new HashMap<>();
        this.title = title;
        this.rows = rows;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void registerToMenu(Material material, String name, String description, int row, int column) {
        ItemStack itemStack = getItemStack(material, name, description);
        items.put(Utils.getIndex(row, column), itemStack);
    }
    public void registerToMenu(ItemStack itemStack, int row, int column) {
        items.put(Utils.getIndex(row, column), itemStack);
    }

    public Inventory getInventory(String playerName) {
        Inventory inventory = Bukkit.createInventory(null, Utils.getRows(rows), title);

        for (Integer index : items.keySet()) {
            inventory.setItem(index, items.get(index));
        }

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta head_meta = (SkullMeta) head.getItemMeta();
        head_meta.setOwningPlayer(Bukkit.getPlayer(playerName));
        head_meta.setDisplayName(playerName);
        head.setItemMeta(head_meta);

        inventory.setItem(Utils.getIndex(rows, 5), head);
        return inventory;
    }
    public String getTitle() {
        return title;
    }

    @EventHandler
    public void onItemInteract(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(title)) e.setCancelled(true);
    }
}
