package com.mapter.opacbonusclaims.common;

import net.minecraft.server.level.ServerPlayer;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.player.config.api.IPlayerConfigAPI;
import xaero.pac.common.server.player.config.api.PlayerConfigOptions;

public class BonusClaimsAdder {

    public static void addBonusClaims(ServerPlayer player, int delta) {
        var server = player.getServer();
        if (server == null) return;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_CLAIMS);
        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_CLAIMS, current + delta);
    }

}