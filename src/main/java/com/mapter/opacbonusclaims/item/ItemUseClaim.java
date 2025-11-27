package com.mapter.opacbonusclaims.item;

import com.mapter.opacbonusclaims.common.BonusChecker;
import com.mapter.opacbonusclaims.common.BonusClaimsAdder;
import com.mapter.opacbonusclaims.common.BonusForceloadsAdder;
import net.minecraft.ChatFormatting;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(modid = "opacbonusclaims")
public class ItemUseClaim {

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {

        if (event.getLevel().isClientSide()) return;

        var player = event.getEntity();
        ItemStack item = event.getItemStack();


        if (item.getItem() == ModItems.COMMON_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addBonusClaims(serverPlayer, 1);

                int bonusUpdated = BonusChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.claims.added",
                                serverPlayer.getName(), 1, bonusUpdated).withStyle(ChatFormatting.GREEN)
                );


                item.shrink(1);
            }
        }


        else if (item.getItem() == ModItems.UNCOMMON_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addBonusClaims(serverPlayer, 3);


                int bonusUpdated = BonusChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.claims.added",
                                serverPlayer.getName(), 3, bonusUpdated).withStyle(ChatFormatting.GREEN)
                );


                item.shrink(1);
            }
        }


        else if (item.getItem() == ModItems.RARE_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addBonusClaims(serverPlayer, 5);


                int bonusUpdated = BonusChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.claims.added",
                                serverPlayer.getName(), 5, bonusUpdated).withStyle(ChatFormatting.GREEN)
                );


                item.shrink(1);
            }
        }

        else if (item.getItem() == ModItems.EPIC_CLAIM.get()) {
            if (player instanceof ServerPlayer serverPlayer) {

                BonusClaimsAdder.addBonusClaims(serverPlayer, 10);



                int bonusUpdated = BonusChecker.getBonusClaims(serverPlayer);


                serverPlayer.sendSystemMessage(
                        Component.translatable("message.opacbonusclaims.claims.added",
                                serverPlayer.getName(), 10, bonusUpdated).withStyle(ChatFormatting.GREEN)
                );


                item.shrink(1);
            }
        }
    }
}