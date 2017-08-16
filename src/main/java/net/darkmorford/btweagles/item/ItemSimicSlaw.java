package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

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
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		if (!worldIn.isRemote && worldIn.rand.nextFloat() < 0.75F)
		{
			int foodAdditions = getFoodAdditions(stack);
			int durationTicks = (10 + foodAdditions) * 20;

			playerIn.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, durationTicks));

			if (foodAdditions >= 2)
			{
				playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, durationTicks));
			}

			if (foodAdditions >= 4)
			{
				playerIn.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, durationTicks));
			}

			if (foodAdditions >= 6)
			{
				playerIn.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, durationTicks));
			}
		}
	}

	@Override
	public int getHealAmount(ItemStack stack)
	{
		return super.getHealAmount(stack) + getFoodAdditions(stack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		String translationKey = getUnlocalizedName() + ".desc";
		String translatedTip = I18n.format(translationKey);
		tooltip.add(translatedTip);
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	private int getFoodAdditions(ItemStack stack)
	{
		int food = 0;

		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("additions"))
		{
			food = stack.getTagCompound().getInteger("additions");
		}

		return food;
	}
}
