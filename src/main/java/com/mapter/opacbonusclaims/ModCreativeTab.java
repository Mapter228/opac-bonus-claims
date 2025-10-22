package com.mapter.opacbonusclaims;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {


    public static final CreativeModeTab OPAC_BONUS_CLAIMS_TAB = new CreativeModeTab("opac_bonus_claims") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.COMMON_CLAIM.get());
        }
    };
}
