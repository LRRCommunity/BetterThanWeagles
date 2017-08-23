package net.darkmorford.btweagles.entity;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.entity.render.RenderSteveBeej;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities
{
	public static void init()
	{
		int entityId = 1;
		EntityRegistry.registerModEntity(new ResourceLocation("btweagles:stevebeej"), EntitySteveBeej.class, "SteveBeej", entityId++, BetterThanWeagles.instance, 64, 3, true, 0xD1A288, 0x00CCCC);

		EntityRegistry.addSpawn(EntitySteveBeej.class, 100, 1, 1, EnumCreatureType.MONSTER, Biomes.PLAINS);

		LootTableList.register(EntitySteveBeej.LOOT_TABLE);
	}

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySteveBeej.class, RenderSteveBeej.FACTORY);
	}
}
