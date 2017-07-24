package net.darkmorford.btweagles;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BetterThanWeagles.MODID, version = BetterThanWeagles.VERSION)
public class BetterThanWeagles
{
	public static final String MODID = "btweagles";
	public static final String VERSION = "1.12-0.0.1.0";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// some example code
		System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
	}
}
