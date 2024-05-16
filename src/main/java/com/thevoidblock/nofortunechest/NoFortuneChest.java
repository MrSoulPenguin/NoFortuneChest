package com.thevoidblock.nofortunechest;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoFortuneChest implements ModInitializer {

    public static final String MOD_ID = "nofortunechest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);

        LOGGER.info(String.format("%s initialized!", MOD_ID));
    }
}
