package net.darkmorford.btweagles.eventhandler;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.item.ModItems;
import net.darkmorford.btweagles.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandlerMappings
{
	@SubscribeEvent
	public static void missingItemMapping(RegistryEvent.MissingMappings<Item> event)
	{
		BetterThanWeagles.logger.warn("Caught missing item mappings! Attempting to repair them...");

		for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings())
		{
			switch (mapping.key.toString())
			{
				case "btweagles:os_music":
					BetterThanWeagles.logger.info("Item mapping for Every OS Sucks is missing, replacing it...");
					mapping.remap(ModItems.matt_music);
					break;
				default:
					BetterThanWeagles.logger.info("Item mapping for " + mapping.key + " is missing, taking default action.");
			}
		}
	}

	@SubscribeEvent
	public static void missingSoundMapping(RegistryEvent.MissingMappings<SoundEvent> event)
	{
		BetterThanWeagles.logger.warn("Caught missing sound mappings! Attempting to repair them...");

		for (RegistryEvent.MissingMappings.Mapping<SoundEvent> mapping : event.getMappings())
		{
			switch (mapping.key.toString())
			{
				case "btweagles:os_music":
					BetterThanWeagles.logger.info("Sound mapping for Every OS Sucks is missing, replacing it...");
					mapping.remap(ModSounds.matt_music);
					break;
				default:
					BetterThanWeagles.logger.info("Sound mapping for " + mapping.key + " is missing, taking default action.");
			}
		}
	}
}
