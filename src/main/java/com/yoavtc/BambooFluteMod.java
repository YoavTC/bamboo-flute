package com.yoavtc;

import com.yoavtc.items.ModItems;
import com.yoavtc.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BambooFluteMod implements ModInitializer {
	public static final String MOD_ID = "bamboo-flute";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + " Mod started!");

		ModItems.registerModItems();
		ModItems.registerGroupItems();
		ModSounds.registerModSounds();



		//TODO
		// Make new flutes (Pan Flute, Synth-wave Flute)

		//TODO ART:
		// Rerecord the sounds (Make them shorter)
		// Make an icon for the mod
	}
}