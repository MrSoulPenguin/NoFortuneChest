package com.thevoidblock.nofortunechest;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;

public class NonSilkWarning {

    public static void initializeDetection() {
        var hasAttacked = new Object(){boolean value = false;};

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

            if(
                    config.modEnabled &&
                    client.player != null
            ) {

                var isSuitable = new Object(){
                    boolean silk = false;
                    boolean pickaxe = false;
                };

                client.player.getHandItems().forEach(itemStack -> {
                    itemStack.getEnchantments().forEach(nbtElement -> {
                        if(
                                ((NbtCompound)nbtElement).get("id").asString().equals("minecraft:silk_touch")
                        ) isSuitable.silk = true;
                    });

                    if(
                            itemStack.getItem().equals(Items.NETHERITE_PICKAXE) ||
                                    itemStack.getItem().equals(Items.DIAMOND_PICKAXE)
                    ) {
                        isSuitable.pickaxe = true;
                    }
                });

                BlockHitResult result = null;

                if(
                        client.crosshairTarget != null &&
                        client.crosshairTarget.getType() == HitResult.Type.BLOCK
                ) result = (BlockHitResult) client.crosshairTarget;

                if (
                        !isSuitable.silk && isSuitable.pickaxe &&
                        result != null && result.getType() == BlockHitResult.Type.BLOCK &&
                        client.world.getBlockState(result.getBlockPos()).getBlock() == Blocks.ENDER_CHEST
                ) {
                    if(config.warningEnabled) client.player.sendMessage(Text.literal(config.warningMessage).withColor(config.warningColor), true);

                    if(
                            config.titleEnabled &&
                            client.options.attackKey.isPressed() &&
                            !hasAttacked.value
                    ) {
                        client.inGameHud.setTitle(Text.literal(config.titleMessage).withColor(config.titleColor));
                        hasAttacked.value = true;
                    }

                } else if(hasAttacked.value) {
                    client.inGameHud.clearTitle();
                    hasAttacked.value = false;
                }
            }
        });
    }
}
