package com.mapter.opacbonusclaims;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("opacbonusclaims")
public class OpacBonusClaims {

    public OpacBonusClaims() {

        NewItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NewItems.CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}