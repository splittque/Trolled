package me.splitque.trolled.config;

public class FunctionConfig extends ConfigHandler {
    public FunctionConfig() {
        super("function_config.yml");
    }

    @Override
    public void setOptions() {
        addString("troll.title", "Troll Menu");
        addString("troll.blow.title", "§cBlow up §fthe player!");
        addString("troll.blow.description", "§7Create explosion around the player");
        addInteger("troll.blow.power", 10);
        addBoolean("troll.blow.setfire", true);
        addBoolean("troll.blow.breakblocks", true);
        addString("troll.inventory.title", "§fCheck player inventory");
        addString("troll.inventory.description", "§7Make what you want with player inventory!");
        addString("troll.kick.title", "§fFake §c/ban");
        addString("troll.kick.description", "§7Kick player and say him about his banning");
        addString("troll.kick.reason", "You are banned from this server");
        addString("troll.message.title", "§fFake §a/op");
        addString("troll.message.description", "§7Say player now his operator");
        addString("troll.message.message", "§7§o[Server: Made {player} a server operator]");
        addString("troll.sounds.title", "§fPlay §esounds!");
        addString("troll.sounds.description", "§7Play any sounds to the player!");
        addString("troll.teleport.title", "§fTeleport §eto moon");
        addString("troll.teleport.description", "§7Teleport player to 100.000 Y");
        addDouble("troll.teleport.x", 0.0);
        addDouble("troll.teleport.y", 100000.0);
        addDouble("troll.teleport.z", 0.0);
        addString("sounds.title", "Sounds Menu");
        addString("sounds.custom.title", "§fCustom sound");
        addString("sounds.custom.description", "§7Play custom sound");
        addString("sounds.creeper.title", "§fCreeper §cAww");
        addString("sounds.creeper.description", "§7Play creeper aww!");
    }
}
