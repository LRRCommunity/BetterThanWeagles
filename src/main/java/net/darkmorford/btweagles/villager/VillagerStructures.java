package net.darkmorford.btweagles.villager;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.List;
import java.util.Random;

public class VillagerStructures
{
	public static class Cave extends StructureVillagePieces.Village
	{
		public Cave()
		{
		}

		public Cave(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox box, EnumFacing facing)
		{
			super(start, type);
			this.setCoordBaseMode(facing);
			this.boundingBox = box;
		}

		public static Cave createPiece(StructureVillagePieces.Start start, List<StructureComponent> components, Random rand, int x, int y, int z, EnumFacing facing, int type)
		{
			StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 6, 10, facing);
			return canVillageGoDeeper(box) && StructureComponent.findIntersecting(components, box) == null ? new Cave(start, type, rand, box, facing) : null;
		}

		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
		{
			if (this.averageGroundLvl < 0)
			{
				this.averageGroundLvl = this.getAverageGroundLevel(worldIn, structureBoundingBoxIn);

				if (this.averageGroundLvl < 0)
				{
					return true;
				}

				this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 5, 0);
			}

			IBlockState cobble = Blocks.COBBLESTONE.getDefaultState();

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 9, 6, 10, cobble, Blocks.AIR.getDefaultState(), false);

			for (int x = 0; x < 9; ++x)
			{
				for (int z = 0; z < 10; ++z)
				{
					this.clearCurrentPositionBlocksUpwards(worldIn, x, 6, z, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, cobble, x, -1, z, structureBoundingBoxIn);
				}
			}

			return true;
		}

		@Override
		protected VillagerRegistry.VillagerProfession chooseForgeProfession(int count, VillagerRegistry.VillagerProfession prof)
		{
			return ModVillagers.professionKrog;
		}
	}
}
