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
        load();
        setOptions();
    }

    private void load() {
        if (Files.exists(Path.of(path.toString()))) {
            try {
                fileConfig = new YamlConfiguration();
                fileConfig.load(path.toString());
            } catch (IOException | InvalidConfigurationException e) {
                fileConfig = null;
                throw new RuntimeException(e);
            }
        }
    }
    public void save() {
        try {
            config.save(path.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void setOptions();

    public void addString(String key, String value) {
        if (fileConfig != null) {
            if (fileConfig.get(key) != null && fileConfig.getString(key) != value) config.set(key, fileConfig.getString(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
    }
    public void addBoolean(String key, Boolean value) {
        if (fileConfig != null) {
            if (fileConfig.get(key) != null && fileConfig.getBoolean(key) != value) config.set(key, fileConfig.getBoolean(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
    }
    public void addInteger(String key, Integer value) {
        if (fileConfig != null) {
            if (fileConfig.get(key) != null && fileConfig.getInt(key) != value) config.set(key, fileConfig.getInt(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
    }
    public void addDouble(String key, Double value) {
        if (fileConfig != null) {
            if (fileConfig.get(key) != null && fileConfig.getDouble(key) != value ) config.set(key, fileConfig.getDouble(key));
            else config.set(key, value);
        } else {
            config.set(key, value);
        }
    }
    public String getString(String key) {
        return (String) config.get(key);
    }
    public String getString(String key, Player player) {
        String s = (String) config.get(key);
        return s.replace("{player}", player.getName());
    }
    public Boolean getBoolean(String key) {
        return (Boolean) config.get(key);
    }
    public Integer getInteger(String key) {
        return (Integer) config.get(key);
    }
    public Double getDouble(String key) {
        return (Double) config.get(key);
    }
}
