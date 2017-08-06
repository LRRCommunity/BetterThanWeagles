package net.darkmorford.btweagles.block;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockButter extends Block
{
	public BlockButter()
	{
		super(Material.ROCK);

		setSoundType(SoundType.SLIME);
		setDefaultSlipperiness(0.98F);

		setRegistryName(BetterThanWeagles.MODID, "butter");
		setUnlocalizedName("butter");
		setCreativeTab(BetterThanWeagles.tabBTWeagles);

		setHarvestLevel("shovel", 2);
		setHardness(2.0F);
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
