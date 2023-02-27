//package zaftnotameni.creatania.registry;
//
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.jozufozu.flywheel.core.PartialModel;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.ForgeRegistries;
//import zaftnotameni.creatania.Constants;
//import zaftnotameni.creatania.util.Humanity;
//import zaftnotameni.creatania.util.Log;
//
//import static zaftnotameni.creatania.util.Humanity.keyResource;
//import static zaftnotameni.creatania.util.Humanity.lang;
//
//@SuppressWarnings("removal")
//public class Blocks {
////  public static final BlockEntry<ManaMotorBlock> MANA_MOTOR = Index.all()
////    .block(Constants.MANA_MOTOR, ManaMotorBlock::new)
////    .initialProperties(SharedProperties::stone)
////    .blockstate(BlockStateGen.directionalAxisBlockProvider())
////    .addLayer(() -> RenderType::cutoutMipped)
////    .transform(axeOrPickaxe())
////    //.transform(BlockStressDefaults.setCapacity(CommonConfig.MANA_MOTOR_SU_PER_RPM.get()))
////    .transform(BlockStressDefaults.setCapacity(10))
////    .item()
////    .transform(customItemModel())
////    .register();
////
////  public static final BlockEntry<ManaGeneratorBlock> MANA_GENERATOR = Index.all()
////    .block(Constants.MANA_GENERATOR, ManaGeneratorBlock::new)
////    .initialProperties(SharedProperties::softMetal)
////    .blockstate(BlockStateGen.directionalAxisBlockProvider())
////    .addLayer(() -> RenderType::cutoutMipped)
////    .transform(axeOrPickaxe())
////    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
////    //.transform(BlockStressDefaults.setImpact(CommonConfig.MANA_GENERATOR_SU_PER_RPM.get()))
////    .transform(BlockStressDefaults.setImpact(10))
////    .item()
////    .transform(customItemModel())
////    .register();
////
////  public static final BlockEntry<ManaCondenserBlock> MANA_CONDENSER = Index.all()
////    .block(Constants.MANA_CONDENSER, ManaCondenserBlock::new)
////    .initialProperties(SharedProperties::softMetal)
////    .blockstate(BlockStateGen.directionalAxisBlockProvider())
////    .addLayer(() -> RenderType::cutoutMipped)
////    .transform(axeOrPickaxe())
////    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
////    //.transform(BlockStressDefaults.setImpact(CommonConfig.MANA_CONDENSER_SU_PER_RPM.get()))
////    .transform(BlockStressDefaults.setImpact(10))
////    .item()
////    .transform(customItemModel())
////    .register();
////
////  public static final BlockEntry<OmniboxBlock> OMNIBOX = Index.all()
////    .block(Constants.OMNIBOX, OmniboxBlock::new)
////    .initialProperties(SharedProperties::stone)
////    .blockstate(BlockStateGen.directionalBlockProvider(false))
////    .addLayer(() -> RenderType::cutoutMipped)
////    .properties(BlockBehaviour.Properties::noOcclusion)
////    .properties(p -> p.color(MaterialColor.PODZOL))
////    .transform(BlockStressDefaults.setNoImpact())
////    .transform(axeOrPickaxe())
////    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
////    .item()
////    .transform(customItemModel())
////    .register();
////
////  public static final BlockEntry<XorLeverBlock> XOR_LEVER = Index.all()
////    .block(Constants.XOR_LEVER, XorLeverBlock::new)
////    .initialProperties(() -> net.minecraft.world.level.block.Blocks.LEVER)
////    .transform(axeOrPickaxe())
////    .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
////    .blockstate((c, p) -> p.horizontalFaceBlock(c.get(), AssetLookup.partialBaseModel(c, p)))
////    .onRegister(ItemUseOverrides::addBlock)
////    .item()
////    .transform(customItemModel())
////    .register();
////
////  public static final BlockEntry<ManasteelManaductBlock> MANASTEEL_MANADUCT_BLOCK = registerManaduct(
////    ManasteelManaductBlock.NAME, "Manasteel Manaduct", Tags.Blocks.TIER_1, ManasteelManaductBlock::new);
////
////  public static final BlockEntry<TerrasteelManaductBlock> TERRASTEEL_MANADUCT_BLOCK = registerManaduct(
////    TerrasteelManaductBlock.NAME, "Terrasteel Manaduct", Tags.Blocks.TIER_2, TerrasteelManaductBlock::new);
////
////  public static final BlockEntry<ElementiumManaductBlock> ELEMENTIUM_MANADUCT_BLOCK = registerManaduct(
////    ElementiumManaductBlock.NAME, "Elementium Manaduct", Tags.Blocks.TIER_3, ElementiumManaductBlock::new);
////
////  public static final BlockEntry<GaiaManaductBlock> GAIA_MANADUCT_BLOCK = registerManaduct(
////    GaiaManaductBlock.NAME, "Gaia Manaduct", Tags.Blocks.TIER_4, GaiaManaductBlock::new);
////
////  public static final BlockEntry<CorruptManaBlock> CORRUPT_MANA_BLOCK = registerManablock(
////    CorruptManaBlock.NAME, "Corrupt Mana Block", Tags.Blocks.CORRUPT_MANA, Tags.Blocks.INERT_MANA, CorruptManaBlock::new);
////
////  public static final BlockEntry<PureManaBlock> PURE_MANA_BLOCK = registerManablock(
////    PureManaBlock.NAME, "Pure Mana Block", Tags.Blocks.PURE_MANA, Tags.Blocks.INERT_MANA, PureManaBlock::new);
////
////  public static final BlockEntry<RealManaBlock> REAL_MANA_BLOCK = registerManablock(
////    RealManaBlock.NAME, "Real Mana Block", Tags.Blocks.REAL_MANA, Tags.Blocks.ACTIVE_MANA, RealManaBlock::new);
////
////  public static final BlockEntry<ManaCasing> MANA_CASING = ManaCasing.registerSelf();
////
////  public static final BlockEntry<BlazuniaFunctionalFlowerBlock> BLAZUNIA_BLOCK = Index.all()
////    .block("blazunia", BlazuniaFunctionalFlowerBlock::new)
////    .lang("Blazunia")
////    .transform(axeOrPickaxe())
////    .defaultBlockstate()
////    .simpleItem()
////    .simpleBlockEntity(BlazuniaFunctionalFlowerBlockEntity::new)
////    .register();
//
//  public static void register(IEventBus bus) {
//    Log.LOGGER.debug("register blocks");
//  }
//
//  public static JsonElement provideLangEntries() {
//    var json = new JsonObject();
//    Index.all().getAll(ForgeRegistries.BLOCKS.getRegistryKey()).forEach(
//      entry -> json.addProperty("block." + keyResource(entry.getId()),
//        Humanity.slashes(lang.get().getAutomaticName (entry, ForgeRegistries.BLOCKS.getRegistryKey()))));
//    return json;
//  }
//
//  public static class Partials {
//    public static final PartialModel MANA_MOTOR_FAN = block("mana_motor/mana_motor_fan");
//    private static PartialModel block(String path) {
//      return new PartialModel(new ResourceLocation(Constants.MODID + ":block/" + path));
//    }
//
//    public static void init() {}
//  }
//}
