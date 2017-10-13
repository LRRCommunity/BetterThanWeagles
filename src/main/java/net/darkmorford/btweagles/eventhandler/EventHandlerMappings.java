package net.darkmorford.btweagles.eventhandler;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.item.Item;
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
			BetterThanWeagles.logger.info("Item mapping for " + mapping.key + " is missing, taking default action.");
		}
	}
}
