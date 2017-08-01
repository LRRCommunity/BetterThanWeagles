package net.darkmorford.btweagles.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
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

	// Food
	public static final ItemFood dilly_bar = null;
	public static final ItemJellyBean jelly_bean = null;

	// Armor
	public static final ItemArmor wool_helmet = null;
	public static final ItemArmor wool_chestplate = null;
	public static final ItemArmor wool_leggings = null;
	public static final ItemArmor wool_boots = null;

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		rap_music.initModel();
		jelly_bean.initModel();

		ModelLoader.setCustomModelResourceLocation(dilly_bar, 0, new ModelResourceLocation(dilly_bar.getRegistryName(), "inventory"));
	}
}
