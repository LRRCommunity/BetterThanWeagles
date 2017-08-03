package net.darkmorford.btweagles;

import net.darkmorford.btweagles.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config
{
	// Configuration categories
	private static final String catGeneral = "general";
	private static final String catJellyBeans = "jellybeans";

	// Configuration values
	public static int jellybean_duration_generic = 100;

	public static void readConfig()
	{
		Configuration cfg = CommonProxy.config;
		try
		{
			cfg.load();
			initGeneralConfig(cfg);
			initJellyBeanConfig(cfg);
		}
		catch (Exception e)
		{
			BetterThanWeagles.logger.log(Level.ERROR, "Problem loading config file!", e);
		}
		finally
		{
			if (cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}

	private static void initGeneralConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(catGeneral, "General configuration");
	}

	private static void initJellyBeanConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(catJellyBeans, "Jelly bean effect duration (in ticks)");

		jellybean_duration_generic = cfg.getInt("duration_generic", catJellyBeans, jellybean_duration_generic, 0, 600, "Duration for all jelly beans");
	}
}
