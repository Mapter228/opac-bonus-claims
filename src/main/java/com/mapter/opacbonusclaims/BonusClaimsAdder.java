package com.mapter.opacbonusclaims;

import net.minecraft.server.level.ServerPlayer;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.player.config.api.IPlayerConfigAPI;
import xaero.pac.common.server.player.config.api.PlayerConfigOptions;

public class BonusClaimsAdder {

   
    public static void addOneBonusClaim(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;


        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());


        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_CLAIMS);


        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_CLAIMS, current + 1);
    }

    public static void addThreeBonusClaim(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;


        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());


        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_CLAIMS);


        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_CLAIMS, current + 3);
    }

    public static void addFiveBonusClaim(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;


        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());


        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_CLAIMS);


        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_CLAIMS, current + 5);
    }

    public static void addTenBonusClaim(ServerPlayer player) {
        var server = player.getServer();
        if (server == null) return;


        IPlayerConfigAPI playerConfigAPI = OpenPACServerAPI.get(server)
                .getPlayerConfigs().getLoadedConfig(player.getUUID());


        int current = playerConfigAPI.getEffective(PlayerConfigOptions.BONUS_CHUNK_CLAIMS);


        playerConfigAPI.tryToSet(PlayerConfigOptions.BONUS_CHUNK_CLAIMS, current + 10);
    }

}
