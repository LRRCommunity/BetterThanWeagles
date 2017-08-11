package net.darkmorford.btweagles.villager;

import net.darkmorford.btweagles.item.ModItems;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ModVillagers
{
	public static final VillagerRegistry.VillagerProfession professionKrog = new VillagerRegistry.VillagerProfession("btweagles:professionKrog",
			"btweagles:textures/entity/villager/krog.png",
			"minecraft:textures/entity/villager/zombie_villager.png");

	protected static final VillagerRegistry.VillagerCareer careerKrog = new VillagerRegistry.VillagerCareer(professionKrog, "careerKrog");

	public static final VillagerRegistry.VillagerProfession professionTorg = new VillagerRegistry.VillagerProfession("btweagles:profession_torg",
			"btweagles:textures/entity/villager/torg.png",
			"minecraft:textures/entity/villager/zombie_villager.png");

	protected static final VillagerRegistry.VillagerCareer careerTorg = new VillagerRegistry.VillagerCareer(professionTorg, "careerTorg");

	public static void registerVillagerTrades()
	{
		careerKrog.addTrade(1, new VillagerTradeItemForItem(new ItemStack(ModItems.shiny_stone), new EntityVillager.PriceInfo(1, 1),
				new ItemStack(Items.LEATHER), new EntityVillager.PriceInfo(2, 2)));

		careerTorg.addTrade(1, new VillagerTradeItemForItem(new ItemStack(Items.BEEF), new EntityVillager.PriceInfo(1, 3),
				new ItemStack(Blocks.SAPLING, 1, 3), new EntityVillager.PriceInfo(1, 3)));

		NBTTagCompound parrotTag = new NBTTagCompound();
		parrotTag.setString("id", "minecraft:parrot");
		ItemStack parrotEgg = new ItemStack(Items.SPAWN_EGG, 1);
		parrotEgg.setTagInfo("EntityTag", parrotTag);

		careerTorg.addTrade(2, new VillagerTradeItemForItem(new ItemStack(Items.PORKCHOP), new EntityVillager.PriceInfo(2, 4),
				parrotEgg, new EntityVillager.PriceInfo(1, 1)));
	}
}
