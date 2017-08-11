package net.darkmorford.btweagles.eventhandler;

import net.darkmorford.btweagles.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandlerShears
{
	@SubscribeEvent
	public static void animalsSheared(PlayerInteractEvent.EntityInteract event)
	{
		Entity target = event.getTarget();
		if (target instanceof EntityMooshroom && !target.isDead && ((EntityMooshroom) target).hurtTime == 0)
		{
			if (isUsingShears(event.getEntityPlayer()))
			{
				World world = event.getWorld();
				if (!world.isRemote)
				{
					EntityItem item = new EntityItem(event.getEntity().getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.meatshroom));
					world.spawnEntity(item);
				}
			}
		}
	}

	private static boolean isUsingShears(EntityPlayer player)
	{
		ItemStack stack = player.getHeldItemMainhand();
		if (!stack.isEmpty() && stack.getItem() instanceof ItemShears)
		{
			return true;
		}

		stack = player.getHeldItemOffhand();
		if (!stack.isEmpty() && stack.getItem() instanceof ItemShears)
		{
			return true;
		}

		return false;
	}
}
