//package zaftnotameni.creatania.advancements;
//import com.google.gson.JsonObject;
//import com.simibubi.create.Create;
//import com.simibubi.create.foundation.advancement.SimpleCreateTrigger;
//import com.simibubi.create.foundation.utility.Components;
//import com.tterrag.registrate.util.entry.ItemProviderEntry;
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.CriterionTriggerInstance;
//import net.minecraft.advancements.FrameType;
//import net.minecraft.advancements.critereon.*;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.ItemLike;
//import net.minecraft.world.level.block.Block;
//import zaftnotameni.creatania.Constants;
//import zaftnotameni.creatania.registry.Index;
//import zaftnotameni.creatania.registry.Triggers;
//
//import java.util.function.Consumer;
//import java.util.function.UnaryOperator;
//
//public class CreataniaAdvancement {
//
//  static final ResourceLocation BACKGROUND = Create.asResource("textures/gui/advancements.png");
//  static final String LANG = "advancement." + Constants.MODID + ".";
//  static final String SECRET_SUFFIX = "\u00A77\n(Hidden Advancement)";
//
//  public  Advancement.Builder builder;
//  public  SimpleCreateTrigger builtinTrigger;
//  public  CreataniaAdvancement parent;
//
//  public Advancement datagenResult;
//
//  public  String id;
//  public  String title;
//  public  String description;
//
//  public CreataniaAdvancement(String id, UnaryOperator<Builder> b) {
//    this.builder = Advancement.Builder.advancement();
//    this.id = id;
//
//    Builder t = new Builder();
//    b.apply(t);
//
//    if (!t.externalTrigger) {
//      builtinTrigger = Triggers.addSimple(id + "_builtin");
//      builder.addCriterion("0", builtinTrigger.instance());
//    }
//
//    builder.display(t.icon, Components.translatable(titleKey()),
//      Components.translatable(descriptionKey()).withStyle(s -> s.withColor(0xDBA213)),
//      id.equals("root") ? BACKGROUND : null, t.type.frame, t.type.toast, t.type.announce, t.type.hide);
//
//    if (t.type == TaskType.SECRET) description += SECRET_SUFFIX;
//
//    Advancements.ENTRIES.add(this);
//  }
//
//  private String titleKey() {
//    return LANG + id;
//  }
//
//  private String descriptionKey() {
//    return titleKey() + ".desc";
//  }
//
//  public boolean isAlreadyAwardedTo(Player player) {
//    if (!(player instanceof ServerPlayer sp))
//      return true;
//    Advancement advancement = sp.getServer()
//      .getAdvancements()
//      .getAdvancement(Index.resource(id));
//    if (advancement == null)
//      return true;
//    return sp.getAdvancements()
//      .getOrStartProgress(advancement)
//      .isDone();
//  }
//
//  public void awardTo(Player player) {
//    if (!(player instanceof ServerPlayer sp))
//      return;
//    if (builtinTrigger == null)
//      throw new UnsupportedOperationException(
//        "Advancement " + id + " uses external Triggers, it cannot be awarded directly");
//    builtinTrigger.trigger(sp);
//  }
//
//  public void save(Consumer<Advancement> t) {
//    if (parent != null) builder.parent(parent.datagenResult);
//    datagenResult = builder.save(t, Index.resource(id).toString());
//  }
//
//  public void appendToLang(JsonObject object) {
//    object.addProperty(titleKey(), title);
//    object.addProperty(descriptionKey(), description);
//  }
//
//  public static enum TaskType {
//
//    SILENT(FrameType.TASK, false, false, false),
//    NORMAL(FrameType.TASK, true, false, false),
//    NOISY(FrameType.TASK, true, true, false),
//    EXPERT(FrameType.GOAL, true, true, false),
//    SECRET(FrameType.GOAL, true, true, true),
//
//    ;
//
//    private FrameType frame;
//    private boolean toast;
//    private boolean announce;
//    private boolean hide;
//
//    private TaskType(FrameType frame, boolean toast, boolean announce, boolean hide) {
//      this.frame = frame;
//      this.toast = toast;
//      this.announce = announce;
//      this.hide = hide;
//    }
//  }
//
//  public class Builder {
//
//    private TaskType type = TaskType.NORMAL;
//    private boolean externalTrigger;
//    private int keyIndex;
//    private ItemStack icon;
//
//    public Builder special(TaskType type) {
//      this.type = type;
//      return this;
//    }
//
//    public Builder after(CreataniaAdvancement other) {
//      CreataniaAdvancement.this.parent = other;
//      return this;
//    }
//
//    public Builder icon(ItemProviderEntry<?> item) {
//      return icon(item.asStack());
//    }
//
//    public Builder icon(ItemLike item) {
//      return icon(new ItemStack(item));
//    }
//
//    public Builder icon(ItemStack stack) {
//      icon = stack;
//      return this;
//    }
//
//    public Builder title(String title) {
//      CreataniaAdvancement.this.title = title;
//      return this;
//    }
//
//    public Builder description(String description) {
//      CreataniaAdvancement.this.description = description;
//      return this;
//    }
//
//    public Builder whenBlockPlaced(Block block) {
//      return externalTrigger(PlacedBlockTrigger.TriggerInstance.placedBlock(block));
//    }
//
//    public Builder whenIconCollected() {
//      return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(icon.getItem()));
//    }
//
//    public Builder whenItemCollected(ItemProviderEntry<?> item) {
//      return whenItemCollected(item.asStack().getItem());
//    }
//
//    public Builder whenItemCollected(ItemLike itemProvider) {
//      return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(itemProvider));
//    }
//
//    public Builder whenItemCollected(TagKey<Item> tag) {
//      return externalTrigger(InventoryChangeTrigger.TriggerInstance
//        .hasItems(new ItemPredicate(tag, null, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY,
//          EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NbtPredicate.ANY)));
//    }
//
//    public Builder awardedForFree() {
//      return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] {}));
//    }
//
//    public Builder externalTrigger(CriterionTriggerInstance trigger) {
//      builder.addCriterion(String.valueOf(keyIndex), trigger);
//      externalTrigger = true;
//      keyIndex++;
//      return this;
//    }
//
//  }
//
//}
