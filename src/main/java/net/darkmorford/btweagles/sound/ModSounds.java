package net.darkmorford.btweagles.sound;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSounds
{
	// Music
	public static SoundEvent rap_music = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "rap_music")).setRegistryName("rap_music");

	// SFX
	public static SoundEvent airhorn = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "airhorn")).setRegistryName("airhorn");
	public static SoundEvent beejdrop = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "beejdrop")).setRegistryName("beejdrop");
}
