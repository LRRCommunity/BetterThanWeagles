package net.darkmorford.btweagles;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
		modid = BetterThanWeagles.MODID,
		name = BetterThanWeagles.MODNAME,
		version = BetterThanWeagles.VERSION
)
public class BetterThanWeagles
{
	public static final String MODID = "btweagles";
	public static final String MODNAME = "BetterThanWeagles";
	public static final String VERSION = "1.12-0.0.1.0";

	@Mod.Instance
	public static BetterThanWeagles instance;

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
