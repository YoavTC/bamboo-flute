package com.yoavtc.items;

import com.yoavtc.BambooFluteMod;
import com.yoavtc.items.custom.BambooFluteItem;
import com.yoavtc.items.custom.SynthFluteItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void registerModItems() {}

    //STOP LOOKING AT MY CODE!!!!!!
    // (:

    static ItemGroup FLUTES = FabricItemGroup.builder(new Identifier("flute-group", "flutes"))
            .displayName(Text.literal("Flutes"))
            .icon(() -> new ItemStack(ModItems.BAMBOO_FLUTE))
            .build();


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BambooFluteMod.MOD_ID, name), item);
    }

    public static final Item BAMBOO_FLUTE = registerItem("bamboo_flute",
            new BambooFluteItem(new FabricItemSettings().maxCount(1)));
    //public static final Item PAN_FLUTE = registerItem("pan_flute",
    //        new PanFluteItem(new FabricItemSettings().maxCount(1)));
    public static final Item SYNTH_FLUTE = registerItem("synth_flute",
            new SynthFluteItem(new FabricItemSettings().maxCount(1)));


    public static void registerGroupItems() {
        //ItemGroupEvents.modifyEntriesEvent(FLUTES).register(entries -> entries.add(ModItems.PAN_FLUTE));
        ItemGroupEvents.modifyEntriesEvent(FLUTES).register(entries -> entries.add(ModItems.BAMBOO_FLUTE));
        ItemGroupEvents.modifyEntriesEvent(FLUTES).register(entries -> entries.add(ModItems.SYNTH_FLUTE));
    }
}
