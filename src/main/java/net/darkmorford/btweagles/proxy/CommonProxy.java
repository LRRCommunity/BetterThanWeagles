package net.darkmorford.btweagles.proxy;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.block.BlockButter;
import net.darkmorford.btweagles.block.BlockMemeOre;
import net.darkmorford.btweagles.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
	}

	public void init(FMLInitializationEvent event)
	{
	}

	public void postInit(FMLPostInitializationEvent event)
	{
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new BlockButter());
		event.getRegistry().register(new BlockMemeOre());
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		// ItemBlocks
		event.getRegistry().register(new ItemBlock(ModBlocks.butter)
				.setRegistryName(ModBlocks.butter.getRegistryName()));
		event.getRegistry().register(new ItemBlock(ModBlocks.meme_ore)
				.setRegistryName(ModBlocks.meme_ore.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		ResourceLocation soundId = new ResourceLocation(BetterThanWeagles.MODID, "rap_music");
		event.getRegistry().register(new SoundEvent(soundId).setRegistryName(soundId));

		soundId = new ResourceLocation(BetterThanWeagles.MODID, "bus_music");
		event.getRegistry().register(new SoundEvent(soundId).setRegistryName(soundId));
	}
}
