package net.darkmorford.btweagles.world.gen;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		// Convert chunk coords to block coords
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;

		// Only generate in the overworld
		if (world.provider.getDimension() == 0)
		{
			int seaLevel = world.getSeaLevel();
			WorldGenerator butterGen = new WorldGenButter();

			// Attempt to place up to 6 blocks per chunk
			int blockCount = random.nextInt(6);
			for (int i = 0; i < blockCount; ++i)
			{
				// Choose a random block in the chunk
				int randX = blockX + random.nextInt(16);
				int randZ = blockZ + random.nextInt(16);

				// Check the biome at this position
				Biome biome = world.getBiome(new BlockPos(randX, seaLevel, randZ));

				// Only place butter in Plains
				if (biome == Biomes.PLAINS)
				{
					// Try to put butter on the ground
					butterGen.generate(world, random, new BlockPos(randX, seaLevel, randZ));
				}
			}
		}
	}
}
