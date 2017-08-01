package net.darkmorford.btweagles;

import net.darkmorford.btweagles.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config
{
	// Configuration categories
	private static final String catGeneral = "general";

	// Configuration values

	public static void readConfig()
	{
		Configuration cfg = CommonProxy.config;
		try
		{
			cfg.load();
			initGeneralConfig(cfg);
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
}
