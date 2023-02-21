package zaftnotameni.creatania.util;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
public class Humanity {
  public static String digestString(String in) {
    var firstPass = StringUtils.capitalize(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(in), StringUtils.SPACE));
    var secondPass = StringUtils.split(firstPass, "_");
    var thirdPass = Arrays.stream(secondPass).map(StringUtils::trimToEmpty).filter(s -> !s.isBlank()).toArray();
    var fourthPass = StringUtils.join(thirdPass, StringUtils.SPACE);
    var fifthPass = StringUtils.replace(fourthPass, "/", ".");
    var sixthPass = StringUtils.replace(fifthPass, ":", ".");
    return sixthPass;
  }
  public static String digestResource(ResourceLocation in) {
    return digestString(in.getPath());
  }
  public static String digestBlock(Block in) { return digestString(in.getDescriptionId().toString()); }
  public static String digestItem(Item in) { return digestString(in.getDescriptionId().toString()); }
  public static String digestItem(RegistryObject<Item> entry) { return digestString(entry.getId().getPath()); }
  public static String digestBlock(RegistryObject<Block> entry) { return digestString(entry.getId().getPath()); }
  public static String digestFluid(RegistryObject<Fluid> entry) { return digestString(entry.getId().getPath()); }

  public static String keyString(String in) { return StringUtils.replace(StringUtils.replace(in, ":", "."), "/", "."); }
  public static String keyResource(ResourceLocation in) { return keyString(in.toString()); }
  public static String keyBlock(Block in) { return "item." + keyString(in.getDescriptionId().toString()); }
  public static String keyItem(Item in) { return "block." + keyString(in.getDescriptionId().toString()); }
  public static String keyItem(RegistryObject<Item> entry) { return "item." + keyString(entry.getId().toString()); }
  public static String keyBlock(RegistryObject<Block> entry) { return "block." + keyString(entry.getId().toString()); }
  public static String keyFluid(RegistryObject<Fluid> entry) { return "fluid." + keyString(entry.getId().toString()); }

  public static String keyBlock(RegistryEntry<Block> entry) { return "block." + keyString(entry.getId().toString()); }
  public static String keyItem(RegistryEntry<Item> entry) { return "block." + keyString(entry.getId().toString()); }
  public static String keyFluid(RegistryEntry<Fluid> entry) { return "block." + keyString(entry.getId().toString()); }
  public static String digestBlock(RegistryEntry<Block> entry) { return digestString(entry.get().getName().getString()); }
  public static String digestItem(RegistryEntry<Item> entry) { return digestString(entry.get().getDescription().getString()); }
  public static String digestFluid(RegistryEntry<Fluid> entry) { return digestString(entry.get().getRegistryType().getName()); }
}
