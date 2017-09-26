package net.darkmorford.btweagles.command;

import net.minecraft.command.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class CommandTestLoadedChunk extends CommandBase
{
	@Override
	public String getName()
	{
		return "test_loaded_chunk";
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 3;
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "test_loaded_chunk <chunkX> <chunkZ> [<dim>]";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		// Check to see if we got enough args
		if (args.length < 2)
			throw new SyntaxErrorException();

		// Parse arguments
		int chunkX, chunkZ, dim;
		try
		{
			chunkX = parseInt(args[0]);
			chunkZ = parseInt(args[1]);

			if (args.length == 3)
			{
				dim = parseInt(args[2]);
			}
			else
			{
				dim = 0;
			}
		}
		catch (NumberInvalidException e)
		{
			throw new SyntaxErrorException();
		}

		World world = server.getWorld(dim);
		Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);

		if (chunk.isLoaded())
		{
			sender.sendMessage(new TextComponentString("Chunk is loaded."));
		}
		else
		{
			sender.sendMessage(new TextComponentString("Chunk is not loaded."));
		}
	}
}
