package me.splitque.trolled.config;

public class MessagesConfig extends ConfigHandler {
    public MessagesConfig() {
        super("messages.yml");
    }

    @Override
    public void setOptions() {
        addString("return_back", "Return back");
        addString("unspecified_player", "You §edon't specify §fa player!");
        addString("player_offline", "This player §eis offline!");
        addString("no_permission", "You §4don't have permission §fto do this!");
        addString("command_executor_dont_player", "§eOnly players §fcan execute this command");
        addString("reload", "Plugin §ereloading...");
        addString("reload_complete", "Plugin §2reloaded!");
    }
}
