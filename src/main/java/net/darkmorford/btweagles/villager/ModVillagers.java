package net.darkmorford.btweagles.villager;

import net.darkmorford.btweagles.item.ModItems;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ModVillagers
{
	public static final VillagerRegistry.VillagerProfession professionKrog = new VillagerRegistry.VillagerProfession("professionKrog",
			"btweagles:textures/entity/villager/krog.png",
			"minecraft:textures/entity/villager/zombie_villager.png");

	protected static final VillagerRegistry.VillagerCareer careerKrog = new VillagerRegistry.VillagerCareer(professionKrog, "careerKrog")
			.addTrade(1, new VillagerTradeItemForItem(new ItemStack(ModItems.shiny_stone), new EntityVillager.PriceInfo(1, 1),
					new ItemStack(Items.LEATHER), new EntityVillager.PriceInfo(2, 2)));
}
