//package zaftnotameni.creatania.recipes.base;
//import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.gui.drawable.IDrawableStatic;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.Container;
//import zaftnotameni.creatania.registry.Index;
//public abstract class CreataniaRecipeProcessingCategory<T extends ProcessingRecipe<Container>> implements IRecipeCategory<T> {
//  public final IDrawableStatic background;
//  public final IDrawable icon;
//  public final static ResourceLocation TEXTURE = Index.resource("textures/gui/test.png");
//  public CreataniaRecipeProcessingCategory(IGuiHelper helper, IDrawable pIcon) {
//    this.icon = pIcon;
//    this.background = helper.createDrawable(TEXTURE, 0, 0, 70, 85);
//  }
//  @Override
//  public IDrawable getBackground() {
//    return this.background;
//  }
//  @Override
//  public IDrawable getIcon() {
//    return this.icon;
//  }
//}
