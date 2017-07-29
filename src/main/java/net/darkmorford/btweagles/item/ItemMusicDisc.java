package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class ItemMusicDisc extends ItemRecord
{
	public ItemMusicDisc(String p_i46742_1_, SoundEvent soundIn)
	{
		super(p_i46742_1_, soundIn);

		this.setRegistryName(BetterThanWeagles.MODID, p_i46742_1_);
		this.setUnlocalizedName("record." + p_i46742_1_);
		this.setCreativeTab(BetterThanWeagles.tabBTWeagles);
	}
}
