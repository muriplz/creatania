//package zaftnotameni.creatania.network;
//import net.minecraft.core.BlockPos;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.level.ChunkPos;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.network.NetworkRegistry;
//import net.minecraftforge.network.PacketDistributor;
//import net.minecraftforge.network.simple.SimpleChannel;
//import zaftnotameni.creatania.registry.Index;
//public class Networking {
//  public static SimpleChannel INSTANCE;
//  private static int ID = 0;
//  public static int nextID() {
//    return ID++;
//  }
//  public static void registerMessages() {
//    INSTANCE = NetworkRegistry.newSimpleChannel(Index.resource("network"), () -> "1.0", s -> true, s -> true);
//    INSTANCE.registerMessage(nextID(),
//      PacketUpdateFlight.class,
//      PacketUpdateFlight::toBytes,
//      PacketUpdateFlight::new,
//      PacketUpdateFlight::handle);
//  }
//  public static void sendToNearby(Level world, BlockPos pos, Object toSend) {
//    if (world instanceof ServerLevel ws) {
//      ws.getChunkSource().chunkMap.getPlayers(new ChunkPos(pos), false).stream()
//        .filter(p -> p.distanceToSqr(pos.getX(), pos.getY(), pos.getZ()) < 64 * 64)
//        .forEach(p -> INSTANCE.send(PacketDistributor.PLAYER.with(() -> p), toSend));
//    }
//  }
//  public static void sendToNearby(Level world, Entity e, Object toSend) {
//    sendToNearby(world, e.blockPosition(), toSend);
//  }
//  public static void sendToPlayer(Object msg, ServerPlayer player) {
//    INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
//  }
//}
//
