package com.mapter.opacbonusclaims.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mapter.opacbonusclaims.OpacBonusClaims;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.player.config.api.IPlayerConfigAPI;
import xaero.pac.common.server.player.config.api.PlayerConfigOptions;

@Mod.EventBusSubscriber(modid = OpacBonusClaims.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BonusForceloadsCommand {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        register(event.getDispatcher());
    }

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("opacbonusclaims")
            .requires(source -> source.hasPermission(2))
            .then(Commands.literal("forceloads")
                .then(Commands.argument("target", EntityArgument.player())
                    .then(Commands.literal("plus")
                        .then(Commands.argument("amount", IntegerArgumentType.integer(1))
                            .executes(ctx -> modifyForceloads(ctx, IntegerArgumentType.getInteger(ctx, "amount"))))
                    )
                    .then(Commands.literal("minus")
                        .then(Commands.argument("amount", IntegerArgumentType.integer(1))
                            .executes(ctx -> modifyForceloads(ctx, -IntegerArgumentType.getInteger(ctx, "amount"))))
                    )
                )
            )
        );
    }

    private static int modifyForceloads(CommandContext<CommandSourceStack> context, int amount) throws CommandSyntaxException {
        ServerPlayer target = EntityArgument.getPlayer(context, "target");
        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(context.getSource().getServer())
            .getPlayerConfigs().getLoadedConfig(target.getUUID());
        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS);
        int newAmount = Math.max(0, current + amount);
        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS, newAmount);

        String key = amount > 0 ? "message.opacbonusclaims.forceloads.added" : "message.opacbonusclaims.forceloads.removed";
        ChatFormatting color = amount > 0 ? ChatFormatting.GREEN : ChatFormatting.GOLD;
        Component message = Component.translatable(key, target.getName(), Math.abs(amount), newAmount)
            .withStyle(color);
        boolean samePlayer = context.getSource().getEntity() instanceof ServerPlayer
            && ((ServerPlayer) context.getSource().getEntity()).getUUID().equals(target.getUUID());

        if (samePlayer) {
            context.getSource().sendSuccess(message, false);
        } else {
            context.getSource().sendSuccess(message, false);
            target.sendSystemMessage(message);
        }
        return 1;
    }
}
