package me.splitque.trolled.config;

import me.splitque.trolled.Trolled;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class ConfigHandler {
    public FileConfiguration config;
    public FileConfiguration fileConfig;
    public StringBuilder path = new StringBuilder("plugins/Trolled/");

    public ConfigHandler(String file) {
        config = new YamlConfiguration();
        path.append(file);
        Trolled.log.info("Config " + path.toString() + " created!");
    }

    public void load() {
        if (Files.exists(Path.of(path.toString()))) {
            try {
                fileConfig = new YamlConfiguration();
                fileConfig.load(path.toString());
                Trolled.log.info("Config " + path.toString() + " loaded!");
            } catch (IOException | InvalidConfigurationException e) {
                fileConfig = null;
                throw new RuntimeException(e);
            }
        }
    }
    public void save() {
        try {
            config.save(path.toString());
            Trolled.log.info("Config " + path.toString() + " saved!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void set();

    public void addString(String key, String value) {
        if (fileConfig != null) {
            if (fileConfig.getString(key) != value && fileConfig.get(key) != null) config.set(key, fileConfig.getString(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
        Trolled.log.info("Added option " + key + ":" + getString(key) + " to " + path.toString() + " config!");
    }
    public void addBoolean(String key, Boolean value) {
        if (fileConfig != null) {
            if (fileConfig.getBoolean(key) != value && fileConfig.get(key) != null) config.set(key, fileConfig.getBoolean(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
        Trolled.log.info("Added option " + key + ":" + getBoolean(key) + " to " + path.toString() + " config!");
    }
    public void addInteger(String key, Integer value) {
        if (fileConfig != null) {
            if (fileConfig.getInt(key) != value && fileConfig.get(key) != null) config.set(key, fileConfig.getInt(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
        Trolled.log.info("Added option " + key + ":" + getInteger(key) + " to " + path.toString() + " config!");
    }
    public void addDouble(String key, Double value) {
        if (fileConfig != null) {
            if (fileConfig.getDouble(key) != value && fileConfig.get(key) != null) config.set(key, fileConfig.getDouble(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
        Trolled.log.info("Added option " + key + ":" + getDouble(key) + " to " + path.toString() + " config!");
    }
    public String getString(String key) {
        Trolled.log.info("Getted option from " + path.toString() + " config!");
        return (String) config.get(key);
    }
    public String getString(String key, Player player) {
        Trolled.log.info("Getted option from " + path.toString() + " config!");
        String s = (String) config.get(key);
        return s.replace("{player}", player.getName());
    }
    public Boolean getBoolean(String key) {
        Trolled.log.info("Getted option from " + path.toString() + " config!");
        return (Boolean) config.get(key);
    }
    public Integer getInteger(String key) {
        Trolled.log.info("Getted option from " + path.toString() + " config!");
        return (Integer) config.get(key);
    }
    public Double getDouble(String key) {
        Trolled.log.info("Getted option from " + path.toString() + " config!");
        return (Double) config.get(key);
    }
}
