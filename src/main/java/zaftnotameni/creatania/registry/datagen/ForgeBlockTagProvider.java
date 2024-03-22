package zaftnotameni.creatania.registry.datagen;
import com.simibubi.create.AllBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import zaftnotameni.creatania.Constants;
import zaftnotameni.creatania.registry.CreataniaBlocks;
import zaftnotameni.creatania.registry.Tags;
public class ForgeBlockTagProvider extends BlockTagsProvider {
  public ForgeBlockTagProvider(DataGenerator generator, ExistingFileHelper helper) {
    super(generator, Constants.MODID, helper);
  }

  @Override
  protected void addTags() {
    tag(Tags.Blocks.TIER_1).add(
      CreataniaBlocks.MANA_GENERATOR.get(),
      CreataniaBlocks.MANA_MOTOR.get(),
      CreataniaBlocks.MANA_CONDENSER.get());

    tag(Tags.Blocks.BOTANIA_TERRA_PLATE_BASE).add(
      (Block) AllBlocks.ANDESITE_CASING.get(),
      (Block) AllBlocks.COPPER_CASING.get(),
      (Block) AllBlocks.BRASS_CASING.get(),
      (Block) AllBlocks.RAILWAY_CASING.get(),
      (Block) AllBlocks.FLUID_TANK.get(),
      (Block) AllBlocks.ENCASED_FLUID_PIPE.get(),
      (Block) CreataniaBlocks.MANA_GENERATOR.get(),
      (Block) CreataniaBlocks.OMNIBOX.get(),
      (Block) AllBlocks.FLUID_PIPE.get());

    tag(Tags.Blocks.FORGE_LAPIS).add(
      AllBlocks.ANDESITE_CASING.get(),
      AllBlocks.COPPER_CASING.get(),
      AllBlocks.BRASS_CASING.get(),
      AllBlocks.RAILWAY_CASING.get(),
      AllBlocks.FLUID_TANK.get(),
      AllBlocks.ENCASED_FLUID_PIPE.get(),
      AllBlocks.FLUID_PIPE.get(),
      CreataniaBlocks.OMNIBOX.get(),
      CreataniaBlocks.MANA_GENERATOR.get());

    tag(Tags.Blocks.PREVENTS_ENDER_TELEPORTATION).add(
      CreataniaBlocks.CORRUPT_MANA_BLOCK.get());

    tag(Tags.Blocks.MANA_MACHINE).add(
      CreataniaBlocks.MANA_CONDENSER.get(),
      CreataniaBlocks.MANA_GENERATOR.get(),
      CreataniaBlocks.MANA_MOTOR.get());
  }
}
