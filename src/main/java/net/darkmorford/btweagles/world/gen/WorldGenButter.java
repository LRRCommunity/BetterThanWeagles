package net.darkmorford.btweagles.world.gen;

import net.darkmorford.btweagles.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenButter extends WorldGenerator
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		// Find the tallest dirt/grass block at these (x, z) coordinates
		int groundLevel = findGroundLevel(worldIn, position.getX(), position.getZ());

		// Check against minimum Y-level
		if (groundLevel >= position.getY())
		{
			BlockPos location = new BlockPos(position.getX(), groundLevel + 1, position.getZ());

			// What block is currently here?
			IBlockState oldBlock = worldIn.getBlockState(location);

			// If it's air or a plant, replace it with butter
			if (oldBlock.getBlock() == Blocks.AIR || oldBlock.getMaterial() == Material.PLANTS)
			{
				worldIn.setBlockState(location, ModBlocks.butter.getDefaultState(), 0x02);
			}

			return true;
		}

		return false;
	}

	public static int findGroundLevel(World worldIn, int x, int z)
	{
		for (int y = 255; y >= 0; --y)
		{
			Block blockAtPos = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
			if (blockAtPos == Blocks.DIRT || blockAtPos == Blocks.GRASS)
			{
				return y;
			}
		}

		return 0;
	}
}
