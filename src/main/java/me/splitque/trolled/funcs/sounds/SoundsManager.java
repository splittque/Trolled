package me.splitque.trolled.funcs.sounds;

import me.splitque.trolled.funcs.AbstractManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundsManager extends AbstractManager {
    public SoundsManager(String title, JavaPlugin plugin) {
        super(title, plugin);
        register();
    }

    @Override
    public void register() {
        ToTroll toTroll = new ToTroll();
        toTroll.register(this);
        CreeperFunc creeperFunc = new CreeperFunc();
        creeperFunc.register(this);
    }
}
