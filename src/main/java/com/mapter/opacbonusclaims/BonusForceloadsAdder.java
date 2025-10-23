package com.mapter.opacbonusclaims;

import net.minecraft.server.level.ServerPlayer;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.player.config.api.IPlayerConfigAPI;
import xaero.pac.common.server.player.config.api.PlayerConfigOptions;

public class BonusForceloadsAdder {

    public static void addOneBonusForceload(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS);

        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS, current + 1);
    }

    public static void addThreeBonusForceload(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS);

        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS, current + 3);
    }

    public static void addFiveBonusForceload(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS);

        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS, current + 5);
    }

    public static void addTenBonusForceload(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;

        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());

        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS);

        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_FORCELOADS, current + 10);
    }
}
