package me.splitque.trolled.config;

public class MessagesConfig extends ConfigHandler {
    public MessagesConfig() {
        super("messages.yml");
    }

    @Override
    public void setOptions() {
        addString("return_back", "Return back");
        addString("unspecified_player", "You don't specify a player!");
        addString("player_offline", "This player is is offline!");
        addString("no_permission", "You don't have permission to do this!");
        addString("command_executor_dont_player", "Only players can execute this command");
        addString("reload", "Plugin reloading...");
    }
}
