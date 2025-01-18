package me.splitque.trolled.funcs.troll;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.funcs.AbstractFunc;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MessageFunc extends AbstractFunc {
    public MessageFunc() {
        super(Material.DIAMOND, Trolled.funcConfig.getString("troll.message.title"), Trolled.funcConfig.getString("troll.message.description"), 1, 4);
    }

    @Override
    public void func(Player admin, Player trolled) {
        trolled.sendMessage(Trolled.funcConfig.getString("troll.message.message"));
    }
}
