package net.darkmorford.btweagles.block;

import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder("btweagles")
public class ModBlocks
{
	public static final BlockButter butter = null;
	public static final BlockMemeOre meme_ore = null;

	public static final BlockFluidClassic liquid_butter = null;

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		butter.initModel();
		meme_ore.initModel();
	}
}
