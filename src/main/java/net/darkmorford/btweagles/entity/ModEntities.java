package net.darkmorford.btweagles.entity;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.entity.render.RenderSteveBeej;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.Set;

public class ModEntities
{
	public static void init()
	{
		// Register mod entities
		int entityId = 1;
		EntityRegistry.registerModEntity(new ResourceLocation("btweagles:stevebeej"), EntitySteveBeej.class, "SteveBeej", entityId++, BetterThanWeagles.instance, 64, 3, true, 0xD1A288, 0x00CCCC);

		// Set up spawn criteria
		Set<Biome> validBiomes = new HashSet<>();

		validBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS));
		validBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST));

		validBiomes.removeAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER));
		validBiomes.removeAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.END));

		EntityRegistry.addSpawn(EntitySteveBeej.class, 50, 1, 2, EnumCreatureType.MONSTER, validBiomes.toArray(new Biome[validBiomes.size()]));

		// Register entity loot tables
		LootTableList.register(EntitySteveBeej.LOOT_TABLE);
	}

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySteveBeej.class, RenderSteveBeej.FACTORY);
	}
}
