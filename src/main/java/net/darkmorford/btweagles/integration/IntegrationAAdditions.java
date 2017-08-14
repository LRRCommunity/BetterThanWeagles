package net.darkmorford.btweagles.integration;

import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import net.minecraftforge.fml.common.Optional;

public class IntegrationAAdditions
{
	@Optional.Method(modid = "actuallyadditions")
	public static void init()
	{
		ActuallyAdditionsAPI.addOilGenRecipe("liquid_butter", 40, 80);
	}
}
