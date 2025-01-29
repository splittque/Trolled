package me.splitque.trolled.funcs.sounds;

import me.splitque.trolled.funcs.Manager;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundsManager extends Manager {
    public SoundsManager(String title, JavaPlugin plugin) {
        super(title, 4, plugin);
    }

    @Override
    public void setFuncs() {
        registerFunc(new CreeperFunc(this));
        registerFunc(new CustomSoundFunc(this));
        registerFunc(new ToTroll(this));
    }
}
