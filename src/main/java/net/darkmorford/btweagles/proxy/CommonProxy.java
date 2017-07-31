package net.darkmorford.btweagles.proxy;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.block.BlockButter;
import net.darkmorford.btweagles.block.BlockMemeOre;
import net.darkmorford.btweagles.block.ModBlocks;
import net.darkmorford.btweagles.item.ItemMusicDisc;
import net.darkmorford.btweagles.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
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

		// Records
		event.getRegistry().register(new ItemMusicDisc("rap_music", ModSounds.rap_music));

		// Food
		event.getRegistry().register(new ItemFood(20, 5.0F, false)
				.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 100, 0), 0.5F)
				.setAlwaysEdible()
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName(BetterThanWeagles.MODID, "dilly_bar")
				.setUnlocalizedName("dilly_bar"));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		event.getRegistry().register(ModSounds.rap_music);
	}
}
