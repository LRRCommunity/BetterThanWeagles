package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
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

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("speed"))
		{
			return stack.getTagCompound().getByte("speed");
		}
		else
		{
			return super.getMaxItemUseDuration(stack);
		}
	}

	@Override
	public int getHealAmount(ItemStack stack)
	{
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("hunger"))
		{
			return stack.getTagCompound().getByte("hunger");
		}
		else
		{
			return super.getHealAmount(stack);
		}
	}

	@Override
	public float getSaturationModifier(ItemStack stack)
	{
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("saturation"))
		{
			return stack.getTagCompound().getFloat("saturation");
		}
		else
		{
			return super.getSaturationModifier(stack);
		}
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
