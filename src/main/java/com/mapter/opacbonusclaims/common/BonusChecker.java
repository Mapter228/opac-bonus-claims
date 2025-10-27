package com.mapter.opacbonusclaims.common;

import net.minecraft.server.level.ServerPlayer;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.player.config.api.IPlayerConfigAPI;
import xaero.pac.common.server.player.config.api.PlayerConfigOptions;

public class BonusChecker {

    // CLAIM CHECK
    public static int getBonusClaims(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return 0;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        return playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_CLAIMS);
    }

    // FORCELOAD CHECK
    public static int getBonusForceloads(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return 0;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        return playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS);
    }
}
