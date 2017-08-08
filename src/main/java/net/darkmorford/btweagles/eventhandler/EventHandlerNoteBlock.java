package net.darkmorford.btweagles.eventhandler;

import net.darkmorford.btweagles.block.ModBlocks;
import net.darkmorford.btweagles.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandlerNoteBlock
{
	@SubscribeEvent
	public static void playNote(NoteBlockEvent.Play event) {
		// Check the block underneath the Note Block
		Block belowBlock = event.getWorld().getBlockState(event.getPos().down()).getBlock();

		// If it's butter, cancel the regular event
		if (belowBlock == ModBlocks.butter)
		{
			int note = event.getVanillaNoteId();
			float pitch = (float)Math.pow(2.0D, (double)(note - 12) / 12.0D);

			BlockPos pos = event.getPos();
			event.getWorld().playSound(null, pos, ModSounds.airhorn, SoundCategory.RECORDS, 3.0F, pitch);
			((WorldServer)event.getWorld()).spawnParticle(EnumParticleTypes.NOTE, false, (double)pos.getX() + 0.5D, (double)pos.getY() + 1.2D, (double)pos.getZ() + 0.5D, 1, 0.0, 0.0, 0.0, (double)note / 24.0D);

			if (event.isCancelable())
			{
				event.setCanceled(true);
			}
		}
	}
}
