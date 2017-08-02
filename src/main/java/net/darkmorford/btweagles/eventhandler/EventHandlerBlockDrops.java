package net.darkmorford.btweagles.eventhandler;

import net.darkmorford.btweagles.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandlerBlockDrops
{
	@SubscribeEvent
	public static void modifyHarvestDrops(BlockEvent.HarvestDropsEvent event)
	{
		if (event.getState().getBlock() == Blocks.GRAVEL)
		{
			event.getDrops().add(new ItemStack(ModItems.shiny_stone));
		}
	}
}
