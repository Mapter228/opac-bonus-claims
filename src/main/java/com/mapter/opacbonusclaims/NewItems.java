package com.mapter.opacbonusclaims;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NewItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "opacbonusclaims");

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "opacbonusclaims");


    public static final RegistryObject<Item> COMMON_CLAIM = ITEMS.register("common_claim",
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> UNCOMMON_CLAIM = ITEMS.register("uncommon_claim",
            () -> new Item(new Item.Properties()
                    .stacksTo(8)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final RegistryObject<Item> RARE_CLAIM = ITEMS.register("rare_claim",
            () -> new Item(new Item.Properties()
                    .stacksTo(4)
                    .rarity(Rarity.RARE)
            ));

    public static final RegistryObject<Item> EPIC_CLAIM = ITEMS.register("epic_claim",
            () -> new Item(new Item.Properties()
                    .stacksTo(2)
                    .rarity(Rarity.EPIC)
            ));


    public static final RegistryObject<CreativeModeTab> OPAC_BONUS_CLAIMS_TAB = CREATIVE_MODE_TABS.register("opac_bonus_claims_tab",
            () -> CreativeModeTab.builder()

                    .title(Component.translatable("item_group.opacbonusclaims.main"))

                    .icon(() -> new ItemStack(COMMON_CLAIM.get()))

                    .displayItems((params, output) -> {
                        output.accept(COMMON_CLAIM.get());
                        output.accept(UNCOMMON_CLAIM.get());
                        output.accept(RARE_CLAIM.get());
                        output.accept(EPIC_CLAIM.get());
                    })
                    .build());
}