package zaftnotameni.creatania;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import zaftnotameni.creatania.registry.BlockEntities;
import zaftnotameni.creatania.registry.Particles;
import zaftnotameni.creatania.registry.datagen.ForgeDatagenInitializer;
import zaftnotameni.creatania.setup.*;

import static zaftnotameni.creatania.Constants.MODID;

@Mod(MODID)
public class CreataniaMain {
  public CreataniaMain() {
    StaticInit.run();
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    registrySetup(bus);
    modEventBusListeners(bus);
//    Blocks.Partials.init();
    forgeEventBusListeners();
  }

  public static void forgeEventBusListeners() {
//    MinecraftForge.EVENT_BUS.register(ForgeEventBus.class);
  }
  public static void modEventBusListeners(IEventBus bus) {
    bus.addListener(FMLCommonSetup::run);
    bus.addListener(FMLClientSetup::run);
    bus.addListener(InterModQueueSetup::run);
    bus.addListener(InterModQueueProcess::run);
    bus.addListener(FMLCompleteSetup::run);
  }
  public static void registrySetup(IEventBus bus) {
//    Index.all().registerEventListeners(bus);
//    Potions.register(bus);
    Particles.register(bus);
//    Items.register(bus);
//    Blocks.register(bus);
//    Fluids.register(bus);
    BlockEntities.register(bus);
//    Recipes.register(bus);
    bus.addListener(EventPriority.LOWEST, ForgeDatagenInitializer::configureForgeDatagen);
  }
}