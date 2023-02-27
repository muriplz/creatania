//package zaftnotameni.creatania.machines.manamotor;
//
//import com.simibubi.create.content.contraptions.base.DirectionalAxisKineticBlock;
//import com.simibubi.create.foundation.block.ITE;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.world.item.context.BlockPlaceContext;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.LevelReader;
//import net.minecraft.world.level.block.Mirror;
//import net.minecraft.world.level.block.RenderShape;
//import net.minecraft.world.level.block.Rotation;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import zaftnotameni.creatania.machines.manamachine.KineticManaMachine;
//import zaftnotameni.creatania.registry.BlockEntities;
//
//import static zaftnotameni.creatania.util.Voxel.ALMOST_FULL_BLOCK_VOXEL;
//import static zaftnotameni.creatania.util.Voxel.FULL_BLOCK_VOXEL;
//
//import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
//
//public class ManaMotorBlock extends DirectionalAxisKineticBlock implements ITE<ManaMotorBlockEntity> {
//  public ManaMotorBlock(Properties properties) {
//    super(properties);
//    registerDefaultState(defaultBlockState());
//  }
//
//  @Override
//  protected Direction getFacingForPlacement(BlockPlaceContext context) { return KineticManaMachine.getFacingForPlacement(context); }
//  @Override
//  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return BlockEntities.MANA_MOTOR_BLOCK_ENTITY.create(pos, state);  }
//  @Override
//  public Class<ManaMotorBlockEntity> getTileEntityClass() {
//    return ManaMotorBlockEntity.class;
//  }
//  @Override
//  public BlockEntityType<? extends ManaMotorBlockEntity> getTileEntityType() { return BlockEntities.MANA_MOTOR_BLOCK_ENTITY.get();  }
//  @Override
//  public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) { return KineticManaMachine.hasShaftTowards(state, face); }
//  @Override
//  public Direction.Axis getRotationAxis(BlockState state) {
//    return state.getValue(FACING).getAxis();
//  }
//  @Override
//  public boolean hideStressImpact() {
//    return false;
//  }
//  @Override
//  public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) { return ALMOST_FULL_BLOCK_VOXEL; }
//  @Override
//  public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) { return FULL_BLOCK_VOXEL; }
//  @Override
//  public BlockState rotate(BlockState pState, Rotation pRotation) { return KineticManaMachine.rotate(pState, pRotation); }
//  @Override
//  public BlockState mirror(BlockState pState, Mirror pMirror) { return pState.rotate(pMirror.getRotation(pState.getValue(FACING))); }
//  @Override
//  public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) { return KineticManaMachine.rotate(originalState, targetedFace); }
//  @Override
//  public RenderShape getRenderShape(BlockState pState) { return RenderShape.MODEL; }
//}