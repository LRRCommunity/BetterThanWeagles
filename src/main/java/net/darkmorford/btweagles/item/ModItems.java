package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder("btweagles")
@Mod.EventBusSubscriber
public class ModItems
{
	// ItemBlocks
	public static final Item butter = null;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		// ItemBlocks
		event.getRegistry().register(new ItemBlock(ModBlocks.butter)
			.setRegistryName(BetterThanWeagles.MODID, "butter"));
	}
}
