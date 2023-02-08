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
		ModSounds.registerModSounds();



		//TODO
		// Make UI to assist the user when playing

		//TODO ART:
		// Find each note a sound effect (Ask mom to record?)
		// Make an icon for the mod
	}
}