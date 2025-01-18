package me.splitque.trolled;

import me.splitque.trolled.config.FunctionConfig;
import me.splitque.trolled.config.MessagesConfig;
import me.splitque.trolled.funcs.sounds.SoundsManager;
import me.splitque.trolled.funcs.troll.TrollManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Trolled extends JavaPlugin {
    public static Logger log;
    public static FunctionConfig funcConfig;
    public static MessagesConfig msgConfig;
    public static TrollManager trollManager;
    public static SoundsManager soundsManager;

    @Override
    public void onEnable() {
        log = getSLF4JLogger();

        funcConfig = new FunctionConfig();
        msgConfig = new MessagesConfig();

        trollManager = new TrollManager(funcConfig.getString("troll.title"), this);
        soundsManager = new SoundsManager(funcConfig.getString("sounds.title"), this);

        getCommand("trolled").setExecutor(new TrollCommand());
        getCommand("trolled").setTabCompleter(new TrollCompleter());
    }

    @Override
    public void onDisable() {
        funcConfig.save();
        msgConfig.save();
    }

    class TrollCommand implements CommandExecutor {
        @Override
        public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
            if (commandSender instanceof Player) {
                if (commandSender.hasPermission("trolled.permission")) {
                    if (strings.length != 1) {
                        commandSender.sendMessage(msgConfig.getString("unspecified_player"));
                        return true;
                    }
                    String player = strings[0];
                    if (getServer().getPlayer(player) == null) {
                        commandSender.sendMessage(msgConfig.getString("player_offline"));
                        return true;
                    }
                    String argPlayerName = getServer().getPlayer(player).getName();
                    Player admin = (Player) commandSender;
                    admin.openInventory(trollManager.getMenu().getInventory(argPlayerName));
                    return true;
                }
            }
            return false;
        }
    }
    class TrollCompleter implements TabCompleter {
        @Override
        public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
            if (strings.length == 1) {
                List<String> list = new ArrayList<>();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    list.add(player.getName());
                }
                return list;
            }
            return new ArrayList<>();
        }
    }
}
