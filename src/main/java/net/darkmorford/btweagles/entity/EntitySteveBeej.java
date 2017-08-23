package net.darkmorford.btweagles.entity;

import net.darkmorford.btweagles.BetterThanWeagles;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySteveBeej extends EntityMob
{
	private static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.createKey(EntitySteveBeej.class, DataSerializers.BOOLEAN);
	public static final ResourceLocation LOOT_TABLE = new ResourceLocation(BetterThanWeagles.MODID, "entities/steve_beej");

	public EntitySteveBeej(World worldIn)
	{
		super(worldIn);
		setSize(0.6F, 1.95F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.getDataManager().register(ARMS_RAISED, false);
	}

	public void setArmsRaised(boolean raised)
	{
		this.getDataManager().set(ARMS_RAISED, raised);
	}

	@SideOnly(Side.CLIENT)
	public boolean areArmsRaised()
	{
		return this.getDataManager().get(ARMS_RAISED);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.13);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0);
	}

	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.applyEntityAI();
	}

	private void applyEntityAI()
	{
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	protected ResourceLocation getLootTable()
	{
		return LOOT_TABLE;
	}
}
