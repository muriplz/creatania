package zaftnotameni.creatania.registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import zaftnotameni.creatania.Constants;
public class CreativeModeTabs {
  public static final CreativeModeTab CREATANIA_ITEMS = new CreativeModeTab(Constants.MODID) {
    @Override
    public ItemStack makeIcon() { return new ItemStack(Blocks.MANA_MOTOR.get()); }
    @Override
    public Component getDisplayName() { return new TextComponent("Creatania"); }
  };
}
