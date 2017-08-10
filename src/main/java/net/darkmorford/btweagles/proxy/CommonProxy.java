package net.darkmorford.btweagles.proxy;

import cofh.thermalexpansion.util.managers.machine.CrucibleManager;
import com.pam.harvestcraft.item.ItemRegistry;
import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.Config;
import net.darkmorford.btweagles.block.BlockButter;
import net.darkmorford.btweagles.block.BlockMemeOre;
import net.darkmorford.btweagles.block.ModBlocks;
import net.darkmorford.btweagles.fluid.ModFluids;
import net.darkmorford.btweagles.item.ItemJellyBean;
import net.darkmorford.btweagles.item.ItemMusicDisc;
import net.darkmorford.btweagles.item.ModItems;
import net.darkmorford.btweagles.sound.ModSounds;
import net.darkmorford.btweagles.villager.ModVillagers;
import net.minecraft.block.Block;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy
{
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event)
	{
		// Load configuration from file
		File configDir = event.getModConfigurationDirectory();
		config = new Configuration(new File(configDir.getPath(), "btweagles.cfg"));
		Config.readConfig();

		registerFluids();

		ModVillagers.registerVillagerTrades();
	}

	public void init(FMLInitializationEvent event)
	{
		// Register custom loot tables
		LootTableList.register(new ResourceLocation(BetterThanWeagles.MODID, "custom/simple_dungeon_chest"));

		// Set up integration with other mods
		if (Loader.isModLoaded("actuallyadditions"))
		{
			ActuallyAdditionsAPI.addOilGenRecipe("liquid_butter", 40, 80);
		}

		if (Loader.isModLoaded("tconstruct"))
		{
			TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModBlocks.butter, 1000), ModFluids.liquid_butter, 300));
			TinkerRegistry.registerBasinCasting(new CastingRecipe(new ItemStack(ModBlocks.butter), ModFluids.liquid_butter, 1000, 60));

			if (Loader.isModLoaded("harvestcraft"))
			{
				TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ItemRegistry.butterItem, 250), ModFluids.liquid_butter, 200));
				TinkerRegistry.registerTableCasting(new CastingRecipe(new ItemStack(ItemRegistry.butterItem), RecipeMatch.of(TinkerSmeltery.castIngot), ModFluids.liquid_butter, 250, 15));
			}
		}

		if (Loader.isModLoaded("thermalexpansion"))
		{
			CrucibleManager.addRecipe(10000, new ItemStack(ModItems.butter), new FluidStack(ModFluids.liquid_butter, 1000));

			if (Loader.isModLoaded("harvestcraft"))
			{
				CrucibleManager.addRecipe(2500, new ItemStack(ItemRegistry.butterItem), new FluidStack(ModFluids.liquid_butter, 250));
			}
		}
	}

	public void postInit(FMLPostInitializationEvent event)
	{
		// Save configuration file
		if (config.hasChanged())
		{
			config.save();
		}
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new BlockButter());
		event.getRegistry().register(new BlockMemeOre());

		event.getRegistry().register(new BlockFluidClassic(ModFluids.liquid_butter, MaterialLiquid.WATER).setRegistryName("liquid_butter").setUnlocalizedName("liquid_butter").setCreativeTab(BetterThanWeagles.tabBTWeagles));
	}

	public static void registerFluids()
	{
		FluidRegistry.addBucketForFluid(ModFluids.liquid_butter);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		// ItemBlocks
		event.getRegistry().register(new ItemBlock(ModBlocks.butter)
				.setRegistryName(ModBlocks.butter.getRegistryName()));
		event.getRegistry().register(new ItemBlock(ModBlocks.meme_ore)
				.setRegistryName(ModBlocks.meme_ore.getRegistryName()));
		event.getRegistry().register(new ItemBlock(ModBlocks.liquid_butter)
				.setRegistryName(ModBlocks.liquid_butter.getRegistryName()));

		// Miscellaneous
		event.getRegistry().register(new Item().setUnlocalizedName("shiny_stone").setRegistryName("shiny_stone").setCreativeTab(BetterThanWeagles.tabBTWeagles));

		// Records
		event.getRegistry().register(new ItemMusicDisc("rap_music", ModSounds.rap_music));

		// Food
		event.getRegistry().register(new ItemFood(20, 5.0F, false)
				.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 100, 0), 0.5F)
				.setAlwaysEdible()
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName(BetterThanWeagles.MODID, "dilly_bar")
				.setUnlocalizedName("dilly_bar"));

		event.getRegistry().register(new ItemJellyBean(2, 0.1F));

		event.getRegistry().register(new ItemFood(Config.chickendinner_hunger, 2.0F, false)
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName("chicken_dinner")
				.setUnlocalizedName("chicken_dinner"));

		event.getRegistry().register(new ItemFood(Config.meatshroom_hunger, 2.0F, false)
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName("meatshroom")
				.setUnlocalizedName("meatshroom"));

		// Armor
		event.getRegistry().register(new ItemArmor(BetterThanWeagles.wool_armor, 1, EntityEquipmentSlot.HEAD)
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName("wool_helmet")
				.setUnlocalizedName("wool_helmet"));

		event.getRegistry().register(new ItemArmor(BetterThanWeagles.wool_armor, 1, EntityEquipmentSlot.CHEST)
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName("wool_chestplate")
				.setUnlocalizedName("wool_chestplate"));

		event.getRegistry().register(new ItemArmor(BetterThanWeagles.wool_armor, 2, EntityEquipmentSlot.LEGS)
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName("wool_leggings")
				.setUnlocalizedName("wool_leggings"));

		event.getRegistry().register(new ItemArmor(BetterThanWeagles.wool_armor, 1, EntityEquipmentSlot.FEET)
				.setCreativeTab(BetterThanWeagles.tabBTWeagles)
				.setRegistryName("wool_boots")
				.setUnlocalizedName("wool_boots"));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		// Music
		event.getRegistry().register(ModSounds.rap_music);

		// SFX
		event.getRegistry().register(ModSounds.airhorn);
		event.getRegistry().register(ModSounds.beejdrop);
	}

	@SubscribeEvent
	public static void registerVillagers(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event)
	{
		event.getRegistry().register(ModVillagers.professionKrog);
		event.getRegistry().register(ModVillagers.professionTorg);
	}
}
