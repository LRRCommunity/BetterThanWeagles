package net.darkmorford.btweagles;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EvenMoreMobHeads
{
	static final Map<String, ItemStack> HEADS = buildHeads();

	static final List<ItemStack> WITHER_HEADS = ImmutableList.of(
			skull("Wither", "119c371b-ea16-47c9-ad7f-23b3d894520a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RmNzRlMzIzZWQ0MTQzNjk2NWY1YzU3ZGRmMjgxNWQ1MzMyZmU5OTllNjhmYmI5ZDZjZjVjOGJkNDEzOWYifX19"),
			skull("Wither Invulnerable", "b6c43469-8904-4855-a024-813ac28aa2a5", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U0ZjQ5NTM1YTI3NmFhY2M0ZGM4NDEzM2JmZTgxYmU1ZjJhNDc5OWE0YzA0ZDlhNGRkYjcyZDgxOWVjMmIyYiJ9fX0="),
			skull("Wither", "d532e209-ea0b-43da-a67d-4b735274e03c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTY0ZTFjM2UzMTVjOGQ4ZmZmYzM3OTg1YjY2ODFjNWJkMTZhNmY5N2ZmZDA3MTk5ZThhMDVlZmJlZjEwMzc5MyJ9fX0="),
			skull("Wither Invulnerable", "6943ecc3-4ffb-4d2d-803d-528eb5e9f6b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRhZmIyM2VmYzU3ZjI1MTg3OGU1MzI4ZDExY2IwZWVmODdiNzljODdiMjU0YTdlYzcyMjk2ZjkzNjNlZjdjIn19fQ==")
	);

	protected static ItemStack skull(String name, String owner, String texture)
	{
		ItemStack stack = new ItemStack(Items.SKULL, 1, 3);

		NBTTagCompound display = new NBTTagCompound();
		display.setString("LocName", name);
		stack.setTagInfo("display", display);

		NBTTagCompound skullOwner = new NBTTagCompound();
		skullOwner.setString("Id", owner);
		NBTTagCompound properties = new NBTTagCompound();
		NBTTagList textures = new NBTTagList();
		NBTTagCompound tex = new NBTTagCompound();
		tex.setString("Value", texture);
		textures.appendTag(tex);
		properties.setTag("textures", textures);
		skullOwner.setTag("Properties", properties);
		stack.setTagInfo("SkullOwner", skullOwner);

		return stack;
	}

	protected static Map<String, ItemStack> buildHeads()
	{
		ImmutableMap.Builder<String, ItemStack> heads = ImmutableMap.builder();

		heads.put("minecraft:zombie_villager;minecraft:farmer", skull("Zombie Farmer Head", "1c067ee0-f090-4f79-89f1-51b87eafa257", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ZmMDQ4MmZkMzJmYWIyY2U5ZjVmYTJlMmQ5YjRkYzc1NjFkYTQyMjE1MmM5OWZjODA0YjkxMzljYWYyNTZiIn19fQ=="));
		heads.put("minecraft:zombie_villager;minecraft:librarian", skull("Zombie Librarian Head", "17ecf859-a648-4b01-8d9c-c1403e68f680", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDRmMDhlYmQ0ZTI1Y2RhM2FkZTQ1Yjg2MzM3OGFkMzc3ZjE4YzUxMGRiNGQyOGU4MmJiMjQ0NTE0MzliMzczNCJ9fX0="));
		heads.put("minecraft:zombie_villager;minecraft:priest", skull("Zombie Priest Head", "3b980c41-7ce1-4a76-b275-6ed00cd6e98b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTI4YzJiYWQ1Mzg5Y2IzNTkyYjU2NWIzYzQ3ZWNjMTg5ZTA1NDJhODc4MzUwMjhkNjE0OGJiZTMzNDU2NDUifX19"));
		heads.put("minecraft:zombie_villager;minecraft:smith", skull("Zombie Smith Head", "7dfcfd39-21d8-4e18-8ec2-f49185562f84", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTE2MTU1ZmNmMzY2Y2Y0ZTA2Y2U1ZGZmYzQ4Y2E1NGU4ZWE0OGRmZTUyNTM1OGI2MTJkYzQ0ZmQ0MzIifX19"));
		heads.put("minecraft:zombie_villager;minecraft:butcher", skull("Zombie Butcher Head", "8315d5a2-1465-4160-a689-ecf2d91dd15d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTYxZjE5ZmZkOGFlNDI1NzkyYzRiMTgxNzU2YWRmZjhkNDgxNzRhZWVmNThhMGYzMjdhMjhjNzQyYzcyNDQyIn19fQ=="));
		heads.put("minecraft:zombie_villager;minecraft:nitwit", skull("Zombie Nitwit Head", "bcaf2b85-d421-47cc-a40a-455e77bfb60b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzdlODM4Y2NjMjY3NzZhMjE3YzY3ODM4NmY2YTY1NzkxZmU4Y2RhYjhjZTljYTRhYzZiMjgzOTdhNGQ4MWMyMiJ9fX0="));

		heads.put("minecraft:llama;0", skull("Creamy Llama Head", "dd0a3919-e919-428c-9298-6dcc416fec9d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQ2N2ZkNGJmZjI5MzI2OWNiOTA4OTc0ZGNhODNjMzM0ODVlNDM1ZWQ1YThlMWRiZDY1MjFjNjE2ODcxNDAifX19"));
		heads.put("minecraft:llama;1", skull("White Llama Head", "60d7893f-b634-48b8-8d6e-f07fa14f5115", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODAyNzdlNmIzZDlmNzgxOWVmYzdkYTRiNDI3NDVmN2FiOWE2M2JhOGYzNmQ2Yjg0YTdhMjUwYzZkMWEzNThlYiJ9fX0="));
		heads.put("minecraft:llama;2", skull("Brown Llama Head", "75fb08e5-2419-46fa-bf09-57362138f234", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzJiMWVjZmY3N2ZmZTNiNTAzYzMwYTU0OGViMjNhMWEwOGZhMjZmZDY3Y2RmZjM4OTg1NWQ3NDkyMTM2OCJ9fX0="));
		heads.put("minecraft:llama;3", skull("Gray Llama Head", "edca7a0d-770f-43d6-8ffc-f6a00e94e477", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2YyNGU1NmZkOWZmZDcxMzNkYTZkMWYzZTJmNDU1OTUyYjFkYTQ2MjY4NmY3NTNjNTk3ZWU4MjI5OWEifX19"));

		heads.put("minecraft:ocelot;0", skull("Ocelot Head", "664dd492-3fcd-443b-9e61-4c7ebd9e4e10", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY1N2NkNWMyOTg5ZmY5NzU3MGZlYzRkZGNkYzY5MjZhNjhhMzM5MzI1MGMxYmUxZjBiMTE0YTFkYjEifX19"));
		heads.put("minecraft:ocelot;1", skull("Black Cat Head", "82cf1e27-3b94-4f81-9f4a-d79f4b4b0a2a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjJhNjYyZjJhZTdkZWJlZTY1MjkyYzJiZjQyZmJiMDliOTdiMmZmYmRiMjcwNTIwYzJkYjk2ZTUxZDg5NDUifX19"));
		heads.put("minecraft:ocelot;2", skull("Ginger Cat Head", "4b386bcf-a8e6-4461-b738-d5427bae49ad", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTc1NWU3ZGYwNGQxOGIzMWQ2M2MxN2Y0YTdiNGM3MzkyNGJkNjI2NWRhNjllMTEzZWRkZDk3NTE2ZmM3In19fQ=="));
		heads.put("minecraft:ocelot;3", skull("Siamese Cat Head", "1775ad8a-06ac-4d62-a21b-593dcfcd2192", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWI4ODFjMzliM2FmZGNjNzlmOTFmZTVkZTNjZGQwMTViYzMzNTM4NDNmNTkxZjRkMjNjZDMwMjdkZTRlNiJ9fX0="));

		heads.put("minecraft:rabbit;Toast", skull("Toast Rabbit Head", "4e03f384-b31f-4803-8d74-801ecdf78869", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzJmYzNiNzQ2NjY1NDVmMmQ0MWJjMmI1MzQwZTFkZjY5ZGQyNWUyYTdlMmIzNGVmZDFhOTUzMTFhN2Q2YyJ9fX0="));
		heads.put("minecraft:rabbit;0", skull("Brown Rabbit Head", "2186bdc6-55b1-4b44-8a46-3c8a11d40f3d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2QxMTY5YjI2OTRhNmFiYTgyNjM2MDk5MjM2NWJjZGE1YTEwYzg5YTNhYTJiNDhjNDM4NTMxZGQ4Njg1YzNhNyJ9fX0="));
		heads.put("minecraft:rabbit;1", skull("White Rabbit Head", "1288e126-41dd-4608-b304-86d84464d5e4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU0MmQ3MTYwOTg3MTQ4YTVkOGUyMGU0NjliZDliM2MyYTM5NDZjN2ZiNTkyM2Y1NWI5YmVhZTk5MTg1ZiJ9fX0="));
		heads.put("minecraft:rabbit;2", skull("Black Rabbit Head", "827f5a8f-1cd7-4148-872f-d3c7f424882f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzJjNTgxMTZhMTQ3ZDFhOWEyNjI2OTIyNGE4YmUxODRmZThlNWYzZjNkZjliNjE3NTEzNjlhZDg3MzgyZWM5In19fQ=="));
		heads.put("minecraft:rabbit;3", skull("Black And White Rabbit Head", "6bafd710-5fa3-4f4d-99cf-ad47fa436e3f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2I4Y2ZmNGIxNWI4Y2EzN2UyNTc1MGYzNDU3MThmMjg5Y2IyMmM1YjNhZDIyNjI3YTcxMjIzZmFjY2MifX19"));
		heads.put("minecraft:rabbit;4", skull("Gold Rabbit Head", "dacb90db-f547-4b25-b9fd-c2aefc0b07fa", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzk3N2EzMjY2YmYzYjllYWYxN2U1YTAyZWE1ZmJiNDY4MDExNTk4NjNkZDI4OGI5M2U2YzEyYzljYiJ9fX0="));
		heads.put("minecraft:rabbit;5", skull("Salt And Pepper Rabbit Head", "02703b0c-573f-4042-a91b-659a3981b508", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmZlY2M2YjVlNmVhNWNlZDc0YzQ2ZTc2MjdiZTNmMDgyNjMyN2ZiYTI2Mzg2YzZjYzc4NjMzNzJlOWJjIn19fQ=="));

		heads.put("minecraft:parrot;0", skull("Red Parrot Head", "d890586d-3e18-41fc-a93d-9040dc25409b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTRiYThkNjZmZWNiMTk5MmU5NGI4Njg3ZDZhYjRhNTMyMGFiNzU5NGFjMTk0YTI2MTVlZDRkZjgxOGVkYmMzIn19fQ=="));
		heads.put("minecraft:parrot;1", skull("Blue Parrot Head", "3ac775c2-c701-4ccd-bec2-5cc7a5c0bb7a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWNhNTgwYjA1MWM2M2JlMjlkYTU0NWE5YWE3ZmY3ZTEzNmRmNzdhODFjNjdkYzFlZTllNjE3MGMxNGZiMzEwIn19fQ=="));
		heads.put("minecraft:parrot;2", skull("Green Parrot Head", "b95a9198-cf0b-4cfa-bf6d-2f172dc6ee65", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWI5YTM2YzU1ODlmM2EyZTU5YzFjYWE5YjNiODhmYWRhNzY3MzJiZGI0YTc5MjYzODhhOGMwODhiYmJjYiJ9fX0="));
		heads.put("minecraft:parrot;3", skull("Cyan Parrot Head", "0bd02c77-cd3f-4bf4-9d02-89cd7f58e06c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmI5NGYyMzZjNGE2NDJlYjJiY2RjMzU4OWI5YzNjNGEwYjViZDVkZjljZDVkNjhmMzdmOGM4M2Y4ZTNmMSJ9fX0="));
		heads.put("minecraft:parrot;4", skull("Gray Parrot Head", "2a8680dd-7875-4c83-810a-5b866a3d4433", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2Q2ZjRhMjFlMGQ2MmFmODI0Zjg3MDhhYzYzNDEwZjFhMDFiYmI0MWQ3ZjRhNzAyZDk0NjljNjExMzIyMiJ9fX0="));

		heads.put("minecraft:horse;0", skull("White Horse Head", "d941cb68-8842-4f78-bdf8-5f1d3c6e7ac0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBhMmRiMmYxZWI5M2U1OTc4ZDJkYzkxYTc0ZGY0M2Q3Yjc1ZDllYzBlNjk0ZmQ3ZjJhNjUyZmJkMTUifX19"));
		heads.put("minecraft:horse;1", skull("Creamy Horse Head", "65e8bd32-6f48-4b92-ab48-fe1add6b67d1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI4ZDFhYjRiZTFlMjhiN2I0NjFmZGVhNDYzODFhYzM2M2E3ZTVjMzU5MWM5ZTVkMjY4M2ZiZTFlYzlmY2QzIn19fQ=="));
		heads.put("minecraft:horse;2", skull("Chestnut Horse Head", "5a2546e1-2213-4f2a-8cbe-5ffddf3e7269", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjY2YjJiMzJkMzE1MzljNzM4M2Q5MjNiYWU0ZmFhZjY1ZGE2NzE1Y2Q1MjZjMzVkMmU0ZTY4MjVkYTExZmIifX19"));
		heads.put("minecraft:horse;3", skull("Brown Horse Head", "2dcb4f55-ab85-48ba-b7d2-7b57d3ec7bfa", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGE1ZmFiYmNiYzU0ODE5NzZmYjkzOGE1MTllYWQ1OWVlZWUyYTA3MWRmMjk3Mzg0YThmZTk2Nzg4YTlkZjVhNiJ9fX0="));
		heads.put("minecraft:horse;4", skull("Black Horse Head", "4083cd58-1325-4bfa-9efb-5b8b93a02493", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRiN2ZjNWY3YTlkZGZkZDFhYTc5MzE3NDEwZmMxOTI5ZjkxYmRkZjk4NTg1OTM4YTJhNTYxOTlhNjMzY2MifX19"));
		heads.put("minecraft:horse;5", skull("Gray Horse Head", "b600f9c3-9c3f-4e3c-828c-3ebb6414eaa7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDEzODEzZGQ0NWVkMGVmODM4NDQ4Y2Y2ZjYzMWMxNTdjMjNmOTY1MGM1YWU0NTFlOTc4YTUzMzgzMzEyZmUifX19"));
		heads.put("minecraft:horse;6", skull("Dark Brown Horse Head", "c6abc94e-a5ff-45fe-a0d7-4e479f290a6f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDJlYjk2N2FiOTRmZGQ0MWE2MzI1ZjEyNzdkNmRjMDE5MjI2ZTVjZjM0OTc3ZWVlNjk1OTdmYWZjZjVlIn19fQ=="));

		return heads.build();
	}

	public EvenMoreMobHeads()
	{
	}

	@SubscribeEvent
	public void somethingDied(LivingDropsEvent event)
	{
		if (!"player".equals(event.getSource().damageType))
		{
			return;
		}

		EntityLivingBase entity = event.getEntityLiving();
		int looting = event.getLootingLevel();
		Random rng = entity.getEntityWorld().rand;

		ItemStack skull = null;

		if (entity instanceof EntityZombieVillager)
		{
			if (rng.nextFloat() < 0.025 + looting * 0.01)
			{
				skull = HEADS.get("minecraft:zombie_villager;" + ((EntityZombieVillager) entity).getForgeProfession().getRegistryName().toString());
			}
		}
		else if (entity instanceof EntityLlama)
		{
			if (rng.nextFloat() < 0.025 + looting * 0.01)
			{
				skull = HEADS.get("minecraft:llama;" + ((EntityLlama) entity).getVariant());
			}
		}
		else if (entity instanceof EntityOcelot)
		{
			if (rng.nextFloat() < 0.05 + looting * 0.02)
			{
				skull = HEADS.get("minecraft:ocelot;" + ((EntityOcelot) entity).getTameSkin());
			}
		}
		else if (entity instanceof EntityRabbit)
		{
			if (rng.nextFloat() < 0.1 + looting * 0.05)
			{
				if ("Toast".equals(entity.getCustomNameTag()))
				{
					skull = HEADS.get("minecraft:rabbit;Toast");
				}
				else
				{
					skull = HEADS.get("minecraft:rabbit;" + ((EntityRabbit) entity).getRabbitType());
				}
			}
		}
		else if (entity instanceof EntityParrot)
		{
			skull = HEADS.get("minecraft:parrot;" + ((EntityParrot) entity).getVariant());
		}
		else if (entity instanceof EntityHorse)
		{
			if (rng.nextFloat() < 0.2 + looting * 0.1)
			{
				skull = HEADS.get("minecraft:horse;" + ((EntityHorse) entity).getHorseVariant() % 256);
			}
		}
		else if (entity instanceof EntityWither)
		{
			skull = WITHER_HEADS.get(entity.getEntityWorld().rand.nextInt(WITHER_HEADS.size()));
		}

		if (skull != null)
		{
			event.getDrops().add(new EntityItem(entity.getEntityWorld(), entity.getPosition().getX(), entity.getPosition().getY(), entity.getPosition().getZ(), skull.copy()));
		}
	}
}
