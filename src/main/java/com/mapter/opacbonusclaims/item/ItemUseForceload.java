package com.mapter.opacbonusclaims.item;

import com.mapter.opacbonusclaims.common.BonusChecker;
import com.mapter.opacbonusclaims.common.BonusForceloadsAdder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "opacbonusclaims")
public class ItemUseForceload {

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {

        if (event.getLevel().isClientSide()) return;

        var player = event.getEntity();
        ItemStack item = event.getItemStack();


        if (item.getItem() == ModItems.COMMON_FORCELOAD.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusForceloadsAdder.addOneBonusForceload(serverPlayer);

                int bonusUpdated = BonusChecker.getBonusForceloads(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_forceload_updated", bonusUpdated)
                );


                item.shrink(1);
            }
        }


        else if (item.getItem() == ModItems.UNCOMMON_FORCELOAD.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusForceloadsAdder.addThreeBonusForceload(serverPlayer);


                int bonusUpdated = BonusChecker.getBonusForceloads(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_forceload_updated", bonusUpdated)
                );


                item.shrink(1);
            }
        }


        else if (item.getItem() == ModItems.RARE_FORCELOAD.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusForceloadsAdder.addFiveBonusForceload(serverPlayer);


                int bonusUpdated = BonusChecker.getBonusForceloads(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_forceload_updated", bonusUpdated)
                );


                item.shrink(1);
            }
        }

        else if (item.getItem() == ModItems.EPIC_FORCELOAD.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusForceloadsAdder.addTenBonusForceload(serverPlayer);



                int bonusUpdated = BonusChecker.getBonusForceloads(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_forceload_updated", bonusUpdated)
                );


                item.shrink(1);
            }
        }
    }
}