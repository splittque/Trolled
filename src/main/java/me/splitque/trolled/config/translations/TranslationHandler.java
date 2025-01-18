package me.splitque.trolled.config.translations;

import me.splitque.trolled.Trolled;
import me.splitque.trolled.config.ConfigHandler;

@Deprecated
public abstract class TranslationHandler extends ConfigHandler {
    private Language language;

    public static TranslationHandler getTranslation() {
        TranslationHandler handler = new EnglishTranslation();
        switch (handler.getLanguage()) {
            case RUSSIAN -> handler = new RussianTranslation();
        }
        Trolled.log.info("Getted language " + handler.getLanguage());
        return handler;
    }

    public TranslationHandler(String file, Language language) {
        super(file);
        this.language = language;
        load();
        addString("language", language.toString());
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public void load() {
        super.load();
        if (fileConfig != null) {
            if (fileConfig.getString("language") != language.toString()) {
                language = Language.valueOf(fileConfig.getString("language"));
                fileConfig = null;
            }
        }
    }
}

