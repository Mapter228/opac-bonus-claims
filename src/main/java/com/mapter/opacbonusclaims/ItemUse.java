package com.mapter.opacbonusclaims;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(modid = "opacbonusclaims")
public class ItemUse {

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {

        if (event.getLevel().isClientSide()) return;

        var player = event.getEntity();
        ItemStack item = event.getItemStack();


        if (item.getItem() == ModItems.COMMON_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addOneBonusClaim(serverPlayer);

                int bonusClaimsUpdated = BonusClaimsChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_updated", bonusClaimsUpdated)
                );


                item.shrink(1);
            }
        }


        else if (item.getItem() == ModItems.UNCOMMON_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addThreeBonusClaim(serverPlayer);


                int bonusClaimsUpdated = BonusClaimsChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_updated", bonusClaimsUpdated)
                );


                item.shrink(1);
            }
        }


        else if (item.getItem() == ModItems.RARE_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addFiveBonusClaim(serverPlayer);


                int bonusClaimsUpdated = BonusClaimsChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_updated", bonusClaimsUpdated)
                );


                item.shrink(1);
            }
        }

        else if (item.getItem() == ModItems.EPIC_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addTenBonusClaim(serverPlayer);



                int bonusClaimsUpdated = BonusClaimsChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.bonus_updated", bonusClaimsUpdated)
                );


                item.shrink(1);
            }
        }
    }
}