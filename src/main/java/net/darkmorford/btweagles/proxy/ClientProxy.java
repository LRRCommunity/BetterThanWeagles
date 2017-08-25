package net.darkmorford.btweagles.proxy;

import net.darkmorford.btweagles.block.ModBlocks;
import net.darkmorford.btweagles.entity.ModEntities;
import net.darkmorford.btweagles.fluid.ModFluids;
import net.darkmorford.btweagles.item.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		ModBlocks.initModels();
		ModEntities.initModels();
		ModFluids.initModels();
		ModItems.initModels();
	}
}
