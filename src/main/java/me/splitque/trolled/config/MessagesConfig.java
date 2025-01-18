package me.splitque.trolled.config;

public class MessagesConfig extends ConfigHandler {
    public MessagesConfig() {
        super("messages.yml");
        load();
        set();
    }

    @Override
    public void set() {
        addString("return_back", "Return back");
        addString("unspecified_player", "You don't specify a player!");
        addString("player_offline", "This player is is offline!");
    }
}
