package com.yoavtc.sound;

import com.yoavtc.BambooFluteMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static void registerModSounds() {}


    public static SoundEvent BAMBOO_HDO = registerSoundEvent("bamboo_hdo");
    public static SoundEvent BAMBOO_TI = registerSoundEvent("bamboo_ti");
    public static SoundEvent BAMBOO_LA = registerSoundEvent("bamboo_la");
    public static SoundEvent BAMBOO_SO = registerSoundEvent("bamboo_so");
    public static SoundEvent BAMBOO_FA = registerSoundEvent("bamboo_fa");
    public static SoundEvent BAMBOO_MI = registerSoundEvent("bamboo_mi");
    public static SoundEvent BAMBOO_RE = registerSoundEvent("bamboo_re");
    public static SoundEvent BAMBOO_LDO = registerSoundEvent("bamboo_ldo");

    public static SoundEvent SYNTH_HDO = registerSoundEvent("synth_hdo");
    public static SoundEvent SYNTH_TI = registerSoundEvent("synth_ti");
    public static SoundEvent SYNTH_LA = registerSoundEvent("synth_la");
    public static SoundEvent SYNTH_SO = registerSoundEvent("synth_so");
    public static SoundEvent SYNTH_FA = registerSoundEvent("synth_fa");
    public static SoundEvent SYNTH_MI = registerSoundEvent("synth_mi");
    public static SoundEvent SYNTH_RE = registerSoundEvent("synth_re");
    public static SoundEvent SYNTH_LDO = registerSoundEvent("synth_ldo");



    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(BambooFluteMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
