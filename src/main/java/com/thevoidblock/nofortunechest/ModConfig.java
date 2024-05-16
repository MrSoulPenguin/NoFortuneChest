package com.thevoidblock.nofortunechest;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

import static com.thevoidblock.nofortunechest.NoFortuneChest.MOD_ID;

@Config(name = MOD_ID)
public class ModConfig implements ConfigData {
    public boolean modEnabled = true;

    public boolean warningEnabled = true;
    public String warningMessage = "Warning: you are holding a non Silk Touch pickaxe";
    public int warningColor = 16711680;

    public boolean titleEnabled = true;
    public String titleMessage = "Warning: you are holding a non Silk Touch pickaxe";
    public int titleColor = 16711680;
}
