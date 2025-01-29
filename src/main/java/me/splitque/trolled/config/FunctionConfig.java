package me.splitque.trolled.config;

public class FunctionConfig extends ConfigHandler {
    public FunctionConfig() {
        super("function_config.yml");
    }

    @Override
    public void setOptions() {
        addString("troll.title", "Troll Menu");
        addString("troll.blow.title", "Blow the player!");
        addString("troll.blow.description", "Create explosion around the player");
        addInteger("troll.blow.power", 10);
        addBoolean("troll.blow.setfire", true);
        addBoolean("troll.blow.breakblocks", true);
        addString("troll.inventory.title", "Check player inventory");
        addString("troll.inventory.description", "Make what you want with player inventory!");
        addString("troll.kick.title", "Fake /ban");
        addString("troll.kick.description", "Kick player and say him about his banning");
        addString("troll.kick.reason", "You are banned from this server");
        addString("troll.message.title", "Fake /op");
        addString("troll.message.description", "Say player now his operator");
        addString("troll.message.message", "§7§o[Server: Made {player} a server operator]");
        addString("troll.sounds.title", "Play sounds!");
        addString("troll.sounds.description", "Play any sounds to the player!");
        addString("troll.teleport.title", "Teleport to moon");
        addString("troll.teleport.description", "Teleport player to 100.000 Y");
        addDouble("troll.teleport.x", 0.0);
        addDouble("troll.teleport.y", 100000.0);
        addDouble("troll.teleport.z", 0.0);
        addString("sounds.title", "Sounds Menu");
        addString("sounds.custom.title", "Custom sound");
        addString("sounds.custom.description", "Play custom sound");
        addString("sounds.creeper.title", "Creeper Aww");
        addString("sounds.creeper.description", "Play creeper aww!");
    }
}
