package net.darkmorford.btweagles;

import com.google.common.collect.ImmutableSet;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Set;

public class LootTableInjector
{
	public final static int MAX_POOLS = 3;

	public final static Set<String> INJECTED_LOOT_TABLES = ImmutableSet.of(
		"inject/minecraft/chests/abandoned_mineshaft",
		"inject/minecraft/chests/desert_pyramid",
		"inject/minecraft/chests/end_city_treasure",
		"inject/minecraft/chests/igloo_chest",
		"inject/minecraft/chests/jungle_temple",
		"inject/minecraft/chests/nether_bridge",
		"inject/minecraft/chests/simple_dungeon",
		"inject/minecraft/chests/stronghold_corridor",
		"inject/minecraft/chests/stronghold_crossing",
		"inject/minecraft/chests/stronghold_library",
		"inject/minecraft/chests/village_blacksmith",
		"inject/minecraft/chests/woodland_mansion",
		"inject/minecraft/entities/sheep/black",
		"inject/minecraft/entities/sheep/blue",
		"inject/minecraft/entities/sheep/brown",
		"inject/minecraft/entities/sheep/cyan",
		"inject/minecraft/entities/sheep/gray",
		"inject/minecraft/entities/sheep/green",
		"inject/minecraft/entities/sheep/light_blue",
		"inject/minecraft/entities/sheep/lime",
		"inject/minecraft/entities/sheep/magenta",
		"inject/minecraft/entities/sheep/orange",
		"inject/minecraft/entities/sheep/pink",
		"inject/minecraft/entities/sheep/purple",
		"inject/minecraft/entities/sheep/red",
		"inject/minecraft/entities/sheep/silver",
		"inject/minecraft/entities/sheep/white",
		"inject/minecraft/entities/sheep/yellow",
		"inject/minecraft/entities/bat",
		"inject/minecraft/entities/ender_dragon",
		"inject/minecraft/entities/endermite",
		"inject/minecraft/entities/silverfish",
		"inject/minecraft/entities/vex",
		"inject/minecraft/entities/wolf",
		"inject/minecraft/entities/cow",
		"inject/minecraft/entities/blaze",
		"inject/minecraft/entities/cave_spider",
		"inject/minecraft/entities/chicken",
		"inject/minecraft/entities/donkey",
		"inject/minecraft/entities/elder_guardian",
		"inject/minecraft/entities/enderman",
		"inject/minecraft/entities/evocation_illager",
		"inject/minecraft/entities/ghast",
		"inject/minecraft/entities/guardian",
		"inject/minecraft/entities/husk",
		"inject/minecraft/entities/iron_golem",
		"inject/minecraft/entities/magma_cube",
		"inject/minecraft/entities/mushroom_cow",
		"inject/minecraft/entities/pig",
		"inject/minecraft/entities/polar_bear",
		"inject/minecraft/entities/shulker",
		"inject/minecraft/entities/slime",
		"inject/minecraft/entities/snowman",
		"inject/minecraft/entities/spider",
		"inject/minecraft/entities/squid",
		"inject/minecraft/entities/stray",
		"inject/minecraft/entities/villager",
		"inject/minecraft/entities/vindication_illager",
		"inject/minecraft/entities/witch",
		"inject/minecraft/entities/zombie_pigman",
		"inject/minecraft/gameplay/fishing"
	);
	public LootTableInjector()
	{
		for (String path: LootTableInjector.INJECTED_LOOT_TABLES)
		{
			LootTableList.register(new ResourceLocation(BetterThanWeagles.MODID, path));
		}

		LootTableList.register(new ResourceLocation(BetterThanWeagles.MODID, "fish_heads"));
	}

	@SubscribeEvent
	public void lootTableLoaded(LootTableLoadEvent event)
	{
		ResourceLocation poolName = event.getName();

		String injectTablePath = "inject/" + poolName.getResourceDomain() + "/" + poolName.getResourcePath();

		if (!LootTableInjector.INJECTED_LOOT_TABLES.contains(injectTablePath))
		{
			return;
		}

		LootTable injectTable = event.getLootTableManager().getLootTableFromLocation(new ResourceLocation(BetterThanWeagles.MODID, injectTablePath));
		for (int i = 0; i < LootTableInjector.MAX_POOLS; i++)
		{
			LootPool pool = injectTable.getPool(String.format("inject%d", i));
			if (pool != null)
			{
				event.getTable().addPool(pool);
			}
		}
	}
}
