package net.darkmorford.btweagles.integration;

import cofh.thermalexpansion.util.managers.dynamo.CompressionManager;
import cofh.thermalexpansion.util.managers.machine.CrucibleManager;
import mariot7.xlfoodmod.init.ItemListxlfoodmod;
import net.darkmorford.btweagles.fluid.ModFluids;
import net.darkmorford.btweagles.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;

public class IntegrationThermal
{
	@Optional.Method(modid = "thermalexpansion")
	public static void preInit()
	{
//		ThermalExpansionHelper.addCompressionFuel("liquid_butter", 64000);
	}

	@Optional.Method(modid = "thermalexpansion")
	public static void init()
	{
		CompressionManager.addFuel("liquid_butter", 64000);

		CrucibleManager.addRecipe(10000, new ItemStack(ModItems.butter), new FluidStack(ModFluids.liquid_butter, 1000));

		if (Loader.isModLoaded("xlfoodmod"))
		{
			CrucibleManager.addRecipe(2500, new ItemStack(ItemListxlfoodmod.butter), new FluidStack(ModFluids.liquid_butter, 250));
		}
	}
}
