package net.darkmorford.btweagles.item;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder("btweagles")
public class ModItems
{
	// ItemBlocks
	public static final ItemBlock butter = null;
	public static final ItemBlock meme_ore = null;

	// Records
	public static final ItemMusicDisc rap_music = null;

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		rap_music.initModel();
	}
}
