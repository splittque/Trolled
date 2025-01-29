package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.funcs.Manager;
import org.bukkit.plugin.java.JavaPlugin;

public class TrollManager extends Manager {
    public TrollManager(String title, JavaPlugin plugin) {
        super(title, 4, plugin);
    }

    @Override
    public void setFuncs() {
        registerFunc(new BlowFunc(this));
        registerFunc(new InventoryFunc(this));
        registerFunc(new KickFunc(this));
        registerFunc(new MessageFunc(this));
        registerFunc(new TeleportFunc(this));
        registerFunc(new ToSounds(this));
    }
}
