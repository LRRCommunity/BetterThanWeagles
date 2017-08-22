package net.darkmorford.btweagles.crafting;

import net.darkmorford.btweagles.item.ModItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipeSimicSlaw extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		// Make sure the first item is a Simic Slaw
		ItemStack stack0 = inv.getStackInSlot(0);
		if (stack0.getItem() != ModItems.simic_slaw) {
			return false;
		}

		// Make sure the slaw isn't full
		if (stack0.hasTagCompound()) {
			byte foodAdditions = stack0.getTagCompound().getByte("additions");
			if (foodAdditions > 5) {
				return false;
			}
		}

		// Make sure we're putting food into the slaw
		ItemStack stack1 = inv.getStackInSlot(1);
		if (!(stack1.getItem() instanceof ItemFood)) {
			return false;
		}

		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack inputSlaw = inv.getStackInSlot(0);

		byte additions = 0;
		if (inputSlaw.hasTagCompound()) {
			additions = inputSlaw.getTagCompound().getByte("additions");
		}
		additions += 1;

		ItemStack outputStack = new ItemStack(ModItems.simic_slaw);
		outputStack.setTagCompound(new NBTTagCompound());
		outputStack.getTagCompound().setByte("additions", additions);

		return outputStack;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width >= 2 || height >= 2;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack(ModItems.simic_slaw);
	}

	@Override
	public NonNullList<Ingredient> getIngredients()
	{
		NonNullList<Ingredient> lst = NonNullList.create();

		lst.add(Ingredient.fromItem(ModItems.simic_slaw));
		lst.add(new FoodIngredient());

		return lst;
	}
}
