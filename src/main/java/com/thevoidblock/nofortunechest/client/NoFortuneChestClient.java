package com.thevoidblock.nofortunechest.client;

import com.thevoidblock.nofortunechest.NoFortuneChest;
import com.thevoidblock.nofortunechest.NonSilkWarning;
import net.fabricmc.api.ClientModInitializer;

public class NoFortuneChestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        NonSilkWarning.initializeDetection();

        NoFortuneChest.LOGGER.info(String.format("%s client initialized!", NoFortuneChest.MOD_ID));
    }
}
