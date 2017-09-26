package net.darkmorford.btweagles.block;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockMemeOre extends Block
{
	public BlockMemeOre()
	{
		super(Material.ROCK);

		setRegistryName(BetterThanWeagles.MODID, "meme_ore");
		setUnlocalizedName("meme_ore");
		setCreativeTab(BetterThanWeagles.tabBTWeagles);

		setHardness(1.5F);
		setResistance(1000.0F);
		setHarvestLevel("pickaxe", 2);
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
	{
		String tipString = I18n.format("tile.meme_ore.tooltip");
		tooltip.add(tipString);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		return true;
	}
}
