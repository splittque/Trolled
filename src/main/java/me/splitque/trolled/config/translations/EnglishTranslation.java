package me.splitque.trolled.config.translations;

@Deprecated
public class EnglishTranslation extends TranslationHandler {
    public EnglishTranslation() {
        super("messages.yml", Language.ENGLISH);
    }

    @Override
    public void set() {
        addString("unspecified_player", "You don't specify a player!");
        addString("player_offline", "This player is is offline!");
    }
}
