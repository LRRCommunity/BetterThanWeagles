package net.darkmorford.btweagles.entity.render;

import net.darkmorford.btweagles.entity.EntitySteveBeej;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSteveBeej extends RenderLiving<EntitySteveBeej>
{
	public static final Factory FACTORY = new Factory();

	public RenderSteveBeej(RenderManager rendermanagerIn)
	{
		super(rendermanagerIn, new ModelZombie(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySteveBeej entity)
	{
		return new ResourceLocation("btweagles:textures/entity/stevebeej.png");
	}

	public static class Factory implements IRenderFactory<EntitySteveBeej>
	{
		@Override
		public Render<? super EntitySteveBeej> createRenderFor(RenderManager manager)
		{
			return new RenderSteveBeej(manager);
		}
	}
}
