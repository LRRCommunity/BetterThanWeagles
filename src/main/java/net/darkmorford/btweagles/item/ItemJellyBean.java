package net.darkmorford.btweagles.item;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.darkmorford.btweagles.Config;
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

		beanEffects.add(Pair.of(MobEffects.SPEED, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.SLOWNESS, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.HASTE, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.MINING_FATIGUE, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.STRENGTH, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.INSTANT_HEALTH, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.INSTANT_DAMAGE, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.JUMP_BOOST, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.NAUSEA, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.REGENERATION, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.RESISTANCE, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.FIRE_RESISTANCE, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.WATER_BREATHING, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.INVISIBILITY, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.BLINDNESS, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.NIGHT_VISION, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.HUNGER, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.WEAKNESS, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.POISON, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.WITHER, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.HEALTH_BOOST, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.ABSORPTION, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.SATURATION, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.GLOWING, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.LEVITATION, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.LUCK, Config.jellybean_duration_generic));
		beanEffects.add(Pair.of(MobEffects.UNLUCK, Config.jellybean_duration_generic));
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
