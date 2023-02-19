package zaftnotameni.creatania.recipes;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import zaftnotameni.creatania.registry.Blocks;
import zaftnotameni.creatania.registry.Fluids;
import zaftnotameni.creatania.registry.Index;
public class ManaGeneratorRecipeCategory extends CreataniaRecipeCategory<ManaGeneratorRecipe> {
  public final static ResourceLocation UID = Index.resource(ManaGeneratorRecipe.Type.ID);
  public ManaGeneratorRecipeCategory(IGuiHelper helper) {
    super(helper, helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.MANA_GENERATOR.get())));
  }
  @Override
  public Component getTitle() {
    return new TextComponent("Mana Generator");
  }
  @Override
  public ResourceLocation getUid() {
    return UID;
  }
  @Override
  public Class<? extends ManaGeneratorRecipe> getRecipeClass() {
    return ManaGeneratorRecipe.class;
  }
  @Override
  public void setRecipe(IRecipeLayoutBuilder builder, ManaGeneratorRecipe recipe, IFocusGroup focuses) {
    builder.addSlot(RecipeIngredientRole.INPUT, 30, 50).addIngredient(ForgeTypes.FLUID_STACK, new FluidStack(Fluids.MANA_FLUID.fluid.get(), 1000))
      .addTooltipCallback((recipeSlotView, tooltip) -> tooltip.add(new TextComponent("Purified inert mana fluid can be converted into real mana from botania")));;
    builder.addSlot(RecipeIngredientRole.OUTPUT, 10, 10).addIngredient(ForgeTypes.FLUID_STACK, recipe.outputs.fluids.get(0))
      .addTooltipCallback((recipeSlotView, tooltip) -> tooltip.add(new TextComponent("Real mana will be generated by converting inert purified mana fluid using SU")));
    builder.addSlot(RecipeIngredientRole.OUTPUT, 10, 30).addIngredients(Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation("botania:mana_pool")).asItem()))
    .addTooltipCallback((recipeSlotView, tooltip) -> tooltip.add(new TextComponent("The mana generated in this process automatically flows into a mana pool above the machine")));
    builder.addSlot(RecipeIngredientRole.CATALYST, 10, 50).addIngredients(Ingredient.of(Blocks.MANA_GENERATOR.get()))
      .addTooltipCallback((recipeSlotView, tooltip) -> tooltip.add(new TextComponent("The mana generator takes SU and purified inert mana fluid to generate real mana")));;
    super.setRecipe(builder, recipe, focuses);
  }
}

