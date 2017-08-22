package net.darkmorford.btweagles.crafting;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntComparators;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Iterator;

public class FoodIngredient extends Ingredient
{
	private NonNullList<Item> foodItems;
	private IntList itemIds = null;
	private ItemStack[] foodArray = null;

	public FoodIngredient()
	{
		super(0);
		foodItems = findAllFoodItems();
		getMatchingStacks();
	}

	@Override
	public ItemStack[] getMatchingStacks()
	{
		if (foodArray == null || foodArray.length != foodItems.size())
		{
			NonNullList<ItemStack> lst = NonNullList.create();
			for (Item item : foodItems)
			{
				ItemStack stack = new ItemStack(item);
				lst.add(stack);
			}
			foodArray = lst.toArray(new ItemStack[lst.size()]);
		}
		return foodArray;
	}

	@Override
	public boolean apply(ItemStack stack)
	{
		if (stack == null)
		{
			return false;
		}

		return stack.getItem() instanceof ItemFood;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IntList getValidItemStacksPacked()
	{
		if (itemIds == null)
		{
			itemIds = new IntArrayList(foodArray.length);

			for (ItemStack stack : foodArray)
			{
				itemIds.add(RecipeItemHelper.pack(stack));
			}

			itemIds.sort(IntComparators.NATURAL_COMPARATOR);
		}

		return itemIds;
	}

	private NonNullList<Item> findAllFoodItems()
	{
		NonNullList<Item> lst = NonNullList.create();

		for (Item item : ForgeRegistries.ITEMS)
		{
			if (item instanceof ItemFood)
			{
				lst.add(item);
			}
		}

		return lst;
	}

	@Override
	protected void invalidate()
	{
		itemIds = null;
	}
}
