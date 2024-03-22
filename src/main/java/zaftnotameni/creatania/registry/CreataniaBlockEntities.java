package zaftnotameni.creatania.registry;

import com.simibubi.create.content.kinetics.base.HalfShaftInstance;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.minecraftforge.eventbus.api.IEventBus;
import zaftnotameni.creatania.machines.manacondenser.ManaCondenserBlockEntity;
import zaftnotameni.creatania.machines.manacondenser.ManaCondenserRenderer;
import zaftnotameni.creatania.machines.managenerator.ManaGeneratorBlockEntity;
import zaftnotameni.creatania.machines.managenerator.ManaGeneratorRenderer;
import zaftnotameni.creatania.machines.manamotor.ManaMotorBlockEntity;
import zaftnotameni.creatania.machines.manamotor.ManaMotorRenderer;
import zaftnotameni.creatania.mana.flowers.blazunia.BlazuniaFunctionalFlowerBlockEntity;
import zaftnotameni.creatania.stress.omnibox.OmniboxBlockEntity;
import zaftnotameni.creatania.stress.omnibox.OmniboxRenderer;
import zaftnotameni.creatania.stress.xorlever.XorLeverBlockEntity;
import zaftnotameni.creatania.stress.xorlever.XorLeverInstance;
import zaftnotameni.creatania.stress.xorlever.XorLeverRenderer;
import zaftnotameni.creatania.util.Log;

public class CreataniaBlockEntities {
  
  public static final BlockEntityEntry<ManaMotorBlockEntity> MANA_MOTOR_BLOCK_ENTITY = CreataniaIndex.all()
    .blockEntity("mana_motor_block_entity", ManaMotorBlockEntity::new)
    .instance(() -> HalfShaftInstance::new)
    .validBlocks(CreataniaBlocks.MANA_MOTOR)
    .renderer(() -> ManaMotorRenderer::new)
    .register();

  public static final BlockEntityEntry<ManaGeneratorBlockEntity> MANA_GENERATOR_BLOCK_ENTITY = CreataniaIndex.all()
    .blockEntity("mana_generator_block_entity", ManaGeneratorBlockEntity::new)
    .instance(() -> HalfShaftInstance::new)
    .validBlocks(CreataniaBlocks.MANA_GENERATOR)
    .renderer(() -> ManaGeneratorRenderer::new)
    .register();

  public static final BlockEntityEntry<ManaCondenserBlockEntity> MANA_CONDENSER_BLOCK_ENTITY = CreataniaIndex.all()
    .blockEntity("mana_condenser_block_entity", ManaCondenserBlockEntity::new)
    .instance(() -> HalfShaftInstance::new)
    .validBlocks(CreataniaBlocks.MANA_CONDENSER)
    .renderer(() -> ManaCondenserRenderer::new)
    .register();

  public static final BlockEntityEntry<OmniboxBlockEntity> OMNIBOX_BLOCK_ENTITY = CreataniaIndex.all()
    .blockEntity("omnibox_block_entity", OmniboxBlockEntity::new)
    .instance(() -> HalfShaftInstance::new)
    .validBlocks(CreataniaBlocks.OMNIBOX)
    .renderer(() -> OmniboxRenderer::new)
    .register();

  public static final BlockEntityEntry<XorLeverBlockEntity> XOR_LEVER_BLOCK_ENTITY = CreataniaIndex.all()
    .blockEntity("xor_lever_block_entity", XorLeverBlockEntity::new)
    .instance(() -> XorLeverInstance::new, false)
    .validBlocks(CreataniaBlocks.XOR_LEVER)
    .renderer(() -> XorLeverRenderer::new)
    .register();

  public static final BlockEntityEntry<BlazuniaFunctionalFlowerBlockEntity> BLAZUNIA_BLOCK_ENTITY = CreataniaIndex.all()
    .blockEntity("blazunia_block_entity", BlazuniaFunctionalFlowerBlockEntity::new)
    .validBlocks(CreataniaBlocks.BLAZUNIA_BLOCK)
    .register();

  public static void register(IEventBus eventBus) {
      Log.LOGGER.debug("register block entities");
    }
}
