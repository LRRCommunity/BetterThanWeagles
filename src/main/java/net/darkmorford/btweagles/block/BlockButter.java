package net.darkmorford.btweagles.block;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockButter extends Block
{
	public BlockButter()
	{
		super(Material.CLAY);

		setRegistryName(BetterThanWeagles.MODID, "butter");
		setUnlocalizedName("butter");
	}
}
