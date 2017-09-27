package net.darkmorford.btweagles.integration;

import blusunrize.immersiveengineering.api.tool.BelljarHandler;
import com.blakebr0.mysticalagriculture.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;

public class IntegrationIEngineering
{
	@Optional.Method(modid = "immersiveengineering")
	public static void init()
	{
		if (Loader.isModLoaded("mysticalagriculture"))
		{
			BelljarHandler.registerBasicItemFertilizer(new ItemStack(ModItems.itemMysticalFertilizer), 2.25f);
		}
	}
}
