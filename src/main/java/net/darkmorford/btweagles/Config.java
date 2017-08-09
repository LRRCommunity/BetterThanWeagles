package net.darkmorford.btweagles;

import net.darkmorford.btweagles.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config
{
	// Configuration categories
	private static final String catGeneral = "general";
	private static final String catFood = "food";
	private static final String catJellyBeans = "jellybeans";

	// Configuration values
	public static int shiny_stone_drop_rate = 2;

	public static int jellybean_duration_generic = 100;

	public static int meatshroom_hunger = 5;
	public static int chickendinner_hunger = 10;

	public static boolean butter_emits_redstone_signal = false;

	public static void readConfig()
	{
		Configuration cfg = CommonProxy.config;
		try
		{
			cfg.load();
			initGeneralConfig(cfg);
			initFoodConfig(cfg);
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

		shiny_stone_drop_rate = cfg.getInt("shiny_stone_rate", catGeneral, shiny_stone_drop_rate, 0, 100, "Drop rate of shiny stone (percentage)");
		butter_emits_redstone_signal = cfg.getBoolean("butter_emits_redstone_signal", catGeneral, butter_emits_redstone_signal, "Whether butter randomly emits a redstone signal");
	}

	private static void initFoodConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(catFood, "Food configuration");

		chickendinner_hunger = cfg.getInt("chicken_dinner_hunger", catFood, chickendinner_hunger, 0, 20, "Chicken Dinner hunger value");
		meatshroom_hunger = cfg.getInt("meatshroom_hunger", catFood, meatshroom_hunger, 0, 20, "Meatshroom hunger value");
	}

	private static void initJellyBeanConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(catJellyBeans, "Jelly bean effect duration (in ticks)");

		jellybean_duration_generic = cfg.getInt("duration_generic", catJellyBeans, jellybean_duration_generic, 0, 600, "Duration for all jelly beans");
	}
}
