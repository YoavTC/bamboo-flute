package com.yoavtc.items;

import com.yoavtc.BambooFluteMod;
import com.yoavtc.items.custom.BambooFluteItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static void registerModItems() {}

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BambooFluteMod.MOD_ID, name), item);
    }

    public static final Item BAMBOO_FLUTE = registerItem("bamboo_flute",
            new BambooFluteItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
}
