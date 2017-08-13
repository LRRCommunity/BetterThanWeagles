package net.darkmorford.btweagles.villager;

import cofh.thermalfoundation.init.TFFluids;
import com.pam.harvestcraft.item.ItemRegistry;
import net.darkmorford.btweagles.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.common.Loader;
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

		careerKrog.addTrade(1, new VillagerTradeItemForItem(new ItemStack(Items.PAINTING), new EntityVillager.PriceInfo(1, 1),
				new ItemStack(Blocks.CACTUS), new EntityVillager.PriceInfo(8, 16)));

		careerKrog.addTrade(1, new VillagerTradeItemForItem(new ItemStack(Items.FISHING_ROD), new EntityVillager.PriceInfo(1, 1),
				new ItemStack(Items.FISH), new EntityVillager.PriceInfo(5, 8)));

		careerKrog.addTrade(2, new VillagerTradeItemForItem(new ItemStack(Items.DYE), new EntityVillager.PriceInfo(5, 10),
				new ItemStack(Blocks.VINE), new EntityVillager.PriceInfo(2, 4)));

		if (Loader.isModLoaded("tconstruct"))
		{
			Item arrowhead = Item.REGISTRY.getObject(new ResourceLocation("tconstruct", "arrow_head"));
			if (arrowhead != null)
			{
				NBTTagCompound material = new NBTTagCompound();
				material.setString("Material", "obsidian");

				ItemStack stack = new ItemStack(arrowhead);
				stack.setTagCompound(material);

				careerKrog.addTrade(2, new VillagerTradeItemForItem(new ItemStack(Items.COAL, 1, 1), new EntityVillager.PriceInfo(10, 20),
						stack, new EntityVillager.PriceInfo(1, 1)));
			}
		}

		if (Loader.isModLoaded("thermalexpansion"))
		{
			Item crystal = Item.REGISTRY.getObject(new ResourceLocation("actuallyadditions", "item_crystal"));
			if (crystal != null)
			{
				ItemStack steamBucket = FluidUtil.getFilledBucket(new FluidStack(TFFluids.fluidSteam, 1000));
				careerKrog.addTrade(3, new VillagerTradeItemForItem(new ItemStack(crystal, 1, 4), new EntityVillager.PriceInfo(1, 1),
						steamBucket, new EntityVillager.PriceInfo(1, 1)));
			}
		}

		careerTorg.addTrade(1, new VillagerTradeItemForItem(new ItemStack(Items.BEEF), new EntityVillager.PriceInfo(1, 3),
				new ItemStack(Blocks.SAPLING, 1, 3), new EntityVillager.PriceInfo(1, 3)));

		careerTorg.addTrade(1, new VillagerTradeItemForItem(new ItemStack(Items.LEATHER), new EntityVillager.PriceInfo(2, 4),
				new ItemStack(Items.MELON_SEEDS), new EntityVillager.PriceInfo(4, 6)));

		Block net = Block.REGISTRY.getObject(new ResourceLocation("actuallyadditions", "block_fishing_net"));
		if (net != Blocks.AIR)
		{
			careerTorg.addTrade(2, new VillagerTradeItemForItem(new ItemStack(net), new EntityVillager.PriceInfo(3, 6),
					new ItemStack(Items.DYE, 1, 3), new EntityVillager.PriceInfo(3, 6)));
		}

		if (Loader.isModLoaded("harvestcraft"))
		{
			NBTTagCompound parrotTag = new NBTTagCompound();
			parrotTag.setString("id", "minecraft:parrot");
			ItemStack parrotEgg = new ItemStack(Items.SPAWN_EGG, 1);
			parrotEgg.setTagInfo("EntityTag", parrotTag);

			careerTorg.addTrade(3, new VillagerTradeItemForItem(new ItemStack(ItemRegistry.honeycombItem), new EntityVillager.PriceInfo(30, 40),
					parrotEgg, new EntityVillager.PriceInfo(1, 1)));
		}
	}
}
