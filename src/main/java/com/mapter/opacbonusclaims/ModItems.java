package com.mapter.opacbonusclaims;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OpacBonusClaims.MODID);

    public static final RegistryObject<Item> COMMON_CLAIM = ITEMS.register("common_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> UNCOMMON_CLAIM = ITEMS.register("uncommon_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> RARE_CLAIM = ITEMS.register("rare_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> EPIC_CLAIM = ITEMS.register("epic_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)));

    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

