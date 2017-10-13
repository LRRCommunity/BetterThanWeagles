package net.darkmorford.btweagles.sound;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSounds
{
	// Music
	public static SoundEvent rap_music = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "rap_music")).setRegistryName("rap_music");
	public static SoundEvent bus_music = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "bus_music")).setRegistryName("bus_music");
	public static SoundEvent butt_music = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "butt_music")).setRegistryName("butt_music");
	public static SoundEvent db_rap_music = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "db_rap_music")).setRegistryName("db_rap_music");
	public static SoundEvent matt_music = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "matt_music")).setRegistryName("matt_music");

	// SFX
	public static SoundEvent airhorn = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "airhorn")).setRegistryName("airhorn");
	public static SoundEvent beejdrop = new SoundEvent(new ResourceLocation(BetterThanWeagles.MODID, "beejdrop")).setRegistryName("beejdrop");
}
