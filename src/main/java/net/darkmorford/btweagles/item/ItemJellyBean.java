package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class ItemJellyBean extends ItemFood
{
	private ArrayList<Pair<Potion, Integer>> beanEffects = new ArrayList<>();

	public ItemJellyBean(int amount, float saturation)
	{
		super(amount, saturation, false);

		setAlwaysEdible();
		setRegistryName("jelly_bean");
		setUnlocalizedName("jelly_bean");
		setCreativeTab(BetterThanWeagles.tabBTWeagles);

		beanEffects.add(Pair.of(MobEffects.SPEED, 100));
		beanEffects.add(Pair.of(MobEffects.SLOWNESS, 100));
		beanEffects.add(Pair.of(MobEffects.HASTE, 100));
		beanEffects.add(Pair.of(MobEffects.MINING_FATIGUE, 100));
		beanEffects.add(Pair.of(MobEffects.STRENGTH, 100));
		beanEffects.add(Pair.of(MobEffects.INSTANT_HEALTH, 100));
		beanEffects.add(Pair.of(MobEffects.INSTANT_DAMAGE, 100));
		beanEffects.add(Pair.of(MobEffects.JUMP_BOOST, 100));
		beanEffects.add(Pair.of(MobEffects.NAUSEA, 100));
		beanEffects.add(Pair.of(MobEffects.REGENERATION, 100));
		beanEffects.add(Pair.of(MobEffects.RESISTANCE, 100));
		beanEffects.add(Pair.of(MobEffects.FIRE_RESISTANCE, 100));
		beanEffects.add(Pair.of(MobEffects.WATER_BREATHING, 100));
		beanEffects.add(Pair.of(MobEffects.INVISIBILITY, 100));
		beanEffects.add(Pair.of(MobEffects.BLINDNESS, 100));
		beanEffects.add(Pair.of(MobEffects.NIGHT_VISION, 100));
		beanEffects.add(Pair.of(MobEffects.HUNGER, 100));
		beanEffects.add(Pair.of(MobEffects.WEAKNESS, 100));
		beanEffects.add(Pair.of(MobEffects.POISON, 100));
		beanEffects.add(Pair.of(MobEffects.WITHER, 100));
		beanEffects.add(Pair.of(MobEffects.HEALTH_BOOST, 100));
		beanEffects.add(Pair.of(MobEffects.ABSORPTION, 100));
		beanEffects.add(Pair.of(MobEffects.SATURATION, 100));
		beanEffects.add(Pair.of(MobEffects.GLOWING, 100));
		beanEffects.add(Pair.of(MobEffects.LEVITATION, 100));
		beanEffects.add(Pair.of(MobEffects.LUCK, 100));
		beanEffects.add(Pair.of(MobEffects.UNLUCK, 100));
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if (worldIn.isRemote) return;

		// Pick a random effect from the list
		int potionIndex = worldIn.rand.nextInt(beanEffects.size());

		Potion potionEffect = beanEffects.get(potionIndex).getKey();
		int potionDuration  = beanEffects.get(potionIndex).getValue();

		PotionEffect effect = new PotionEffect(potionEffect, potionDuration);
		player.addPotionEffect(effect);
	}
}
