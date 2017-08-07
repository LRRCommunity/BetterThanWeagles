package net.darkmorford.btweagles.eventhandler;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandlerLootTables
{
	@SubscribeEvent
	public static void lootLoaded(LootTableLoadEvent event)
	{
		if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON))
		{
			LootTable customTable = event.getLootTableManager().getLootTableFromLocation(new ResourceLocation(BetterThanWeagles.MODID, "custom/simple_dungeon_chest"));
			LootPool customPool = customTable.getPool("weagles");
			event.getTable().addPool(customPool);
		}
	}
}
