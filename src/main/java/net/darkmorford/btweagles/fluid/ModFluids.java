package net.darkmorford.btweagles.fluid;

import net.darkmorford.btweagles.block.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModFluids
{
	public static final Fluid liquid_butter = createFluid(
			"liquid_butter",
			new ResourceLocation("btweagles", "blocks/liquid_butter_still"),
			new ResourceLocation("btweagles", "blocks/liquid_butter_flow"));

	private static Fluid createFluid(String fluidName, ResourceLocation stillTexture, ResourceLocation flowTexture)
	{
		Fluid fluid = new Fluid(fluidName, stillTexture, flowTexture);
		FluidRegistry.registerFluid(fluid);

		fluid.setDensity(800).setViscosity(1500);

		return fluid;
	}

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		Item item = Item.getItemFromBlock(ModBlocks.liquid_butter);

		ModelBakery.registerItemVariants(item);
		ModelResourceLocation location = new ModelResourceLocation("btweagles:fluid", "liquid_butter");
		ModelLoader.setCustomMeshDefinition(item, stack -> location);
		ModelLoader.setCustomStateMapper(ModBlocks.liquid_butter, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return location;
			}
		});
	}
}
