package net.darkmorford.btweagles.block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder("btweagles")
public class ModBlocks
{
	public static final BlockButter butter = null;

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		butter.initModel();
	}
}
