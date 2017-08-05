package net.darkmorford.btweagles.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
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

	// Miscellaneous
	public static final Item shiny_stone = null;

	// Records
	public static final ItemMusicDisc rap_music = null;

	// Food
	public static final ItemFood dilly_bar = null;
	public static final ItemFood chicken_dinner = null;
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

		ModelLoader.setCustomModelResourceLocation(shiny_stone, 0, new ModelResourceLocation(shiny_stone.getRegistryName(), "inventory"));

		ModelLoader.setCustomModelResourceLocation(dilly_bar, 0, new ModelResourceLocation(dilly_bar.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(chicken_dinner, 0, new ModelResourceLocation(chicken_dinner.getRegistryName(), "inventory"));

		ModelLoader.setCustomModelResourceLocation(wool_helmet, 0, new ModelResourceLocation(wool_helmet.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(wool_chestplate, 0, new ModelResourceLocation(wool_chestplate.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(wool_leggings, 0, new ModelResourceLocation(wool_leggings.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(wool_boots, 0, new ModelResourceLocation(wool_boots.getRegistryName(), "inventory"));
	}
}
