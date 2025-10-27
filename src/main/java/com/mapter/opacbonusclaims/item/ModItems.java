package com.mapter.opacbonusclaims.item;

import com.mapter.opacbonusclaims.OpacBonusClaims;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OpacBonusClaims.MODID);

    //BONUS CLAIMS

    public static final RegistryObject<Item> COMMON_CLAIM = ITEMS.register("common_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.COMMON)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    public static final RegistryObject<Item> UNCOMMON_CLAIM = ITEMS.register("uncommon_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    public static final RegistryObject<Item> RARE_CLAIM = ITEMS.register("rare_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    public static final RegistryObject<Item> EPIC_CLAIM = ITEMS.register("epic_claim",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    //BONUS FORCELOADS

    public static final RegistryObject<Item> COMMON_FORCELOAD = ITEMS.register("common_forceload",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.COMMON)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    public static final RegistryObject<Item> UNCOMMON_FORCELOAD = ITEMS.register("uncommon_forceload",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    public static final RegistryObject<Item> RARE_FORCELOAD = ITEMS.register("rare_forceload",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    public static final RegistryObject<Item> EPIC_FORCELOAD = ITEMS.register("epic_forceload",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .tab(ModCreativeTab.OPAC_BONUS_CLAIMS_TAB)));

    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
