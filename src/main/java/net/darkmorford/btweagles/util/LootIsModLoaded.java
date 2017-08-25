package net.darkmorford.btweagles.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.fml.common.Loader;

import java.util.Random;

public class LootIsModLoaded implements LootCondition
{
	private final String modid;

	public LootIsModLoaded(String modidIn)
	{
		this.modid = modidIn;
	}

	@Override
	public boolean testCondition(Random rand, LootContext context)
	{
		return Loader.isModLoaded(this.modid);
	}

	public static class Serializer extends LootCondition.Serializer<LootIsModLoaded>
	{
		public Serializer()
		{
			super(new ResourceLocation("is_mod_loaded"), LootIsModLoaded.class);
		}

		@Override
		public void serialize(JsonObject json, LootIsModLoaded value, JsonSerializationContext context)
		{
			json.addProperty("modid", value.modid);
		}

		@Override
		public LootIsModLoaded deserialize(JsonObject json, JsonDeserializationContext context)
		{
			return new LootIsModLoaded(JsonUtils.getString(json, "modid"));
		}
	}
}
