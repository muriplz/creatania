package zaftnotameni.creatania.manaiaccreate.omnibox;
import com.jozufozu.flywheel.backend.Backend;
import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.AllBlockPartials;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.base.KineticTileEntityRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
public class OmniboxRenderer extends KineticTileEntityRenderer {
  public OmniboxRenderer(BlockEntityRendererProvider.Context context) {
    super(context);
  }

  @Override
  protected void renderSafe(KineticTileEntity te, float partialTicks, PoseStack ms, MultiBufferSource buffer,
                            int light, int overlay) {
    super.renderSafe(te, partialTicks, ms, buffer, light, overlay);
    final BlockPos pos = te.getBlockPos();
    float time = AnimationTickHolder.getRenderTime(te.getLevel());

    for (Direction direction : Iterate.directions) {
      final Direction.Axis axis = direction.getAxis();
      SuperByteBuffer shaft = CachedBufferer.partialFacing(AllBlockPartials.SHAFT_HALF, te.getBlockState(), direction);
      float offset = getRotationOffsetForPosition(te, pos, axis);
      float angle = (time * te.getSpeed() * 3f / 10) % 360;

      if (te.getSpeed() != 0 && te.hasSource()) {
        BlockPos source = te.source.subtract(te.getBlockPos());
        Direction sourceFacing = Direction.getNearest(source.getX(), source.getY(), source.getZ());
        if (sourceFacing.getAxis() == direction.getAxis()) angle *= sourceFacing == direction ? 1 : 1;//-1;
        else if (sourceFacing.getAxisDirection() == direction.getAxisDirection()) angle *= 1;//-1;
      }

      angle += offset;
      angle = angle / 180f * (float) Math.PI;

      kineticRotationTransform(shaft, te, axis, angle, light);
      shaft.renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }
  }
}
