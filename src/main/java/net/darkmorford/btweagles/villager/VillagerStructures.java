package net.darkmorford.btweagles.villager;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.List;
import java.util.Random;

public class VillagerStructures
{
	public static class CaveHandler implements VillagerRegistry.IVillageCreationHandler
	{
		@Override
		public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i)
		{
			return new StructureVillagePieces.PieceWeight(Cave.class, 3, 1);
		}

		@Override
		public Class<?> getComponentClass()
		{
			return Cave.class;
		}

		@Override
		public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5)
		{
			return Cave.createPiece(startPiece, pieces, random, p1, p2, p3, facing, p5);
		}
	}

	public static class Cave extends StructureVillagePieces.Village
	{
		private int[] floorX = { 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7 };
		private int[] floorZ = { 1, 2, 0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 1, 2 };

		private int[] layer0X = { 0, 0, 1, 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 7, 7, 7, 7, 8, 8 };
		private int[] layer0Z = { 1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 8, 6, 7, 0, 3, 4, 5, 1, 2 };

		private int[] layer2X = { 0, 0, 1, 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 7, 7, 7, 7, 8, 8, 2, 6 };
		private int[] layer2Z = { 1, 2, 0, 3, 4, 5, 6, 7, 7, 8, 7, 6, 7, 0, 3, 4, 5, 1, 2, 0, 0 };

		private int[] layer3X = { 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7 };
		private int[] layer3Z = { 1, 2, 0, 1, 3, 4, 5, 0, 6, 7, 7, 0, 6, 7, 0, 1, 3, 4, 5, 1, 2 };

		private int[] layer4X = { 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6 };
		private int[] layer4Z = { 2, 1, 2, 3, 4, 5, 0, 1, 6, 1, 2, 3, 4, 5, 2 };

		private int[] layer5X = { 4, 4, 4, 4 };
		private int[] layer5Z = { 2, 3, 4, 5 };

		public Cave(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox box, EnumFacing facing)
		{
			super(start, type);
			this.setCoordBaseMode(facing);
			this.boundingBox = box;
		}

		public static Cave createPiece(StructureVillagePieces.Start start, List<StructureComponent> components, Random rand, int x, int y, int z, EnumFacing facing, int type)
		{
			StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 7, 10, facing);
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

			IBlockState stone = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
			IBlockState dirt = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);

			for (int i = 0; i < floorX.length; ++i)
			{
				this.setBlockState(worldIn, dirt, floorX[i], 0, floorZ[i], structureBoundingBoxIn);
			}

			for (int i = 0; i < layer0X.length; ++i)
			{
				this.setBlockState(worldIn, stone, layer0X[i], 1, layer0Z[i], structureBoundingBoxIn);
				this.setBlockState(worldIn, stone, layer0X[i], 2, layer0Z[i], structureBoundingBoxIn);
			}

			for (int i = 0; i < layer2X.length; ++i)
			{
				this.setBlockState(worldIn, stone, layer2X[i], 3, layer2Z[i], structureBoundingBoxIn);
			}

			for (int i = 0; i < layer3X.length; ++i)
			{
				this.setBlockState(worldIn, stone, layer3X[i], 4, layer3Z[i], structureBoundingBoxIn);
			}

			for (int i = 0; i < layer4X.length; ++i)
			{
				this.setBlockState(worldIn, stone, layer4X[i], 5, layer4Z[i], structureBoundingBoxIn);
			}

			for (int i = 0; i < layer5X.length; ++i)
			{
				this.setBlockState(worldIn, stone, layer5X[i], 6, layer5Z[i], structureBoundingBoxIn);
			}

			this.placeTorch(worldIn, EnumFacing.SOUTH, 4, 3, 7, structureBoundingBoxIn);
			this.placeTorch(worldIn, EnumFacing.EAST, 2, 4, 2, structureBoundingBoxIn);
			this.placeTorch(worldIn, EnumFacing.WEST, 6, 4, 2, structureBoundingBoxIn);

			for (int x = 0; x < 9; ++x)
			{
				for (int z = 0; z < 10; ++z)
				{
					this.clearCurrentPositionBlocksUpwards(worldIn, x, 7, z, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, stone, x, -1, z, structureBoundingBoxIn);
				}
			}

			this.spawnVillagers(worldIn, structureBoundingBoxIn, 4, 2, 3, 2);

			return true;
		}

		@Override
		protected VillagerRegistry.VillagerProfession chooseForgeProfession(int count, VillagerRegistry.VillagerProfession prof)
		{
			if (count == 0)
			{
				return ModVillagers.professionKrog;
			}
			else
			{
				return ModVillagers.professionTorg;
			}
		}
	}
}
