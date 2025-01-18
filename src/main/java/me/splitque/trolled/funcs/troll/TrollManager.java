package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.funcs.AbstractManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TrollManager extends AbstractManager {
    public TrollManager(String title, JavaPlugin plugin) {
        super(title, plugin);
        register();
    }

    @Override
    public void register() {
        BlowFunc blowFunc = new BlowFunc();
        blowFunc.register(this);
        InventoryFunc inventoryFunc = new InventoryFunc();
        inventoryFunc.register(this);
        KickFunc kickFunc = new KickFunc();
        kickFunc.register(this);
        MessageFunc messageFunc = new MessageFunc();
        messageFunc.register(this);
        ToSounds toSounds = new ToSounds();
        toSounds.register(this);
    }
}
