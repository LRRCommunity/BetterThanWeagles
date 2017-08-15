package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSimicSlaw extends ItemFood
{
	public ItemSimicSlaw(int amount, float saturation)
	{
		super(amount, saturation, false);

		setRegistryName("simic_slaw");
		setUnlocalizedName("simic_slaw");
		setCreativeTab(BetterThanWeagles.tabBTWeagles);
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
