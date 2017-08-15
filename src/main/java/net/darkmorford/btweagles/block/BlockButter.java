package net.darkmorford.btweagles.block;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.Config;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockButter extends Block
{
	public static final PropertyBool POWERED = PropertyBool.create("powered");

	public BlockButter()
	{
		super(Material.ROCK);

		setSoundType(SoundType.SLIME);
		setDefaultSlipperiness(0.98F);
		setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false));

		setRegistryName(BetterThanWeagles.MODID, "butter");
		setUnlocalizedName("butter");
		setCreativeTab(BetterThanWeagles.tabBTWeagles);

		setHarvestLevel("shovel", 2);
		setHardness(2.0F);
		setTickRandomly(Config.butter_emits_redstone_signal);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, POWERED);
	}

	@Override
	@Deprecated
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(POWERED, (meta & 1) != 0);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(POWERED) ? 1 : 0;
	}

	@Override
	@Deprecated
	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	@Override
	@Deprecated
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return 0;
	}

	@Override
	@Deprecated
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.getValue(POWERED) ? 15 : 0;
	}

	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			IBlockState blockState = worldIn.getBlockState(pos);
			if (!blockState.getValue(POWERED) && Config.butter_emits_redstone_signal) {
				worldIn.setBlockState(pos, blockState.withProperty(POWERED, true));
				worldIn.scheduleUpdate(pos, this, 2);
			}
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(POWERED, false));
		}
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
