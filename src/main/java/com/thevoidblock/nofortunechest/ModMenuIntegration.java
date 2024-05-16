package com.thevoidblock.nofortunechest;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.thevoidblock.nofortunechest.gui.ConfigMenu;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ConfigMenu::getScreen;
    }
}
