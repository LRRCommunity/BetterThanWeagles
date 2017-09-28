package net.darkmorford.btweagles.command;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.command.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CommandDumpForcedChunks extends CommandBase
{
	@Override
	public String getName()
	{
		return "dump_forced_chunks";
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 3;
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "dump_forced_chunks [<dim>]";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		// Parse argument if we got any
		int dim = 0;
		if (args.length > 0)
		{
			dim = parseInt(args[0]);
		}

		World world = server.getWorld(dim);
		ImmutableSetMultimap<ChunkPos, ForgeChunkManager.Ticket> forcedChunks = ForgeChunkManager.getPersistentChunksFor(world);

		Collection<ChunkData> chunkDataCollection = new ArrayList<>();

		for (ChunkPos chunk : forcedChunks.keySet())
		{
			ImmutableSet<ForgeChunkManager.Ticket> tickets = forcedChunks.get(chunk);

			ChunkData data = new ChunkData();
			data.chunkX = chunk.x;
			data.chunkZ = chunk.z;

			for (ForgeChunkManager.Ticket ticket : tickets)
			{
				TicketData tData = new TicketData();
				tData.modID = ticket.getModId();
				tData.type = ticket.getType().toString();
				tData.playerName = ticket.getPlayerName();

				data.tickets.add(tData);
			}

			chunkDataCollection.add(data);
		}

		try (Writer writer = new FileWriter("forcedChunks.json"))
		{
			Gson gson = new GsonBuilder().create();
			gson.toJson(chunkDataCollection, writer);
		}
		catch (Exception e)
		{
			sender.sendMessage(new TextComponentString("Error writing JSON file!"));
			return;
		}

		sender.sendMessage(new TextComponentString("Dumped forced chunks to file."));
	}

	private class ChunkData
	{
		int chunkX;
		int chunkZ;
		Collection<TicketData> tickets = new ArrayList<>();
	}

	private class TicketData
	{
		String type;
		String modID;
		String playerName;
	}
}
