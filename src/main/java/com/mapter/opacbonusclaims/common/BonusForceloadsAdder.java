package com.mapter.opacbonusclaims.common;

import net.minecraft.server.level.ServerPlayer;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.player.config.api.IPlayerConfigAPI;
import xaero.pac.common.server.player.config.api.PlayerConfigOptions;

public class BonusForceloadsAdder {

    public static void addBonusForceloads(ServerPlayer player, int delta) {
        var server = player.getServer();
        if (server == null) return;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS);

        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS, current + delta);
    }
}
