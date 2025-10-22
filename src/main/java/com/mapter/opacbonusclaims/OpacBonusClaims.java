package com.mapter.opacbonusclaims;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OpacBonusClaims.MODID)
public class OpacBonusClaims {
    public static final String MODID = "opacbonusclaims";

    public OpacBonusClaims() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.registerItems(modBus);

    }
}
