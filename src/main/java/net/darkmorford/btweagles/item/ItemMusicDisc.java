package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMusicDisc extends ItemRecord
{
	public ItemMusicDisc(String p_i46742_1_, SoundEvent soundIn)
	{
		super(p_i46742_1_, soundIn);

		this.setRegistryName(BetterThanWeagles.MODID, p_i46742_1_);
		this.setUnlocalizedName("record." + p_i46742_1_);
		this.setCreativeTab(BetterThanWeagles.tabBTWeagles);
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
