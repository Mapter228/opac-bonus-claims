package com.mapter.opacbonusclaims.item;

import com.mapter.opacbonusclaims.OpacBonusClaims;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OpacBonusClaims.MODID);

    public static final RegistryObject<CreativeModeTab> OPAC_BONUS_CLAIMS_TAB =
            CREATIVE_MODE_TABS.register("opac_bonus_claims_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("item_group.opacbonusclaims.main"))
                            .icon(() -> new ItemStack(ModItems.COMMON_CLAIM.get()))
                            .displayItems((params, output) -> {
                                //CLAIMS
                                output.accept(ModItems.COMMON_CLAIM.get().getDefaultInstance());
                                output.accept(ModItems.UNCOMMON_CLAIM.get().getDefaultInstance());
                                output.accept(ModItems.RARE_CLAIM.get().getDefaultInstance());
                                output.accept(ModItems.EPIC_CLAIM.get().getDefaultInstance());

                                //FORCELOADS
                                output.accept(ModItems.COMMON_FORCELOAD.get().getDefaultInstance());
                                output.accept(ModItems.UNCOMMON_FORCELOAD.get().getDefaultInstance());
                                output.accept(ModItems.RARE_FORCELOAD.get().getDefaultInstance());
                                output.accept(ModItems.EPIC_FORCELOAD.get().getDefaultInstance());
                            })
                            .build());

    public static void registerTabs(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
