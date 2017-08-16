package net.darkmorford.btweagles.crafting;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;

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
	}

	@Override
	public ItemStack[] getMatchingStacks()
	{
		if (foodArray == null || foodArray.length != foodItems.size())
		{
			NonNullList<ItemStack> lst = NonNullList.create();
			for (Item item : foodItems)
			{
			}
			foodArray = lst.toArray(new ItemStack[lst.size()]);
		}
		return foodArray;
	}

	private NonNullList<Item> findAllFoodItems()
	{
		NonNullList<Item> lst = NonNullList.create();

		Iterator<Item> allItems = Item.REGISTRY.iterator();
		while (allItems.hasNext())
		{
			Item item = allItems.next();
			if (item instanceof ItemFood)
			{
				lst.add(item);
			}
		}

		return lst;
	}
}
