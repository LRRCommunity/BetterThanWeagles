package net.darkmorford.btweagles.sound;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSounds
{
	// Music
	public static SoundEvent rap_music = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "rap_music")).setRegistryName(BetterThanWeagles.MODID, "rap_music");

	// SFX
	public static SoundEvent beejdrop = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "beejdrop")).setRegistryName("beejdrop");
}
