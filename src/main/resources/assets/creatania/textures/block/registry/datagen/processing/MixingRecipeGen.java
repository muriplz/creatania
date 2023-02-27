package zaftnotameni.creatania.registry.datagen.processing;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.crafting.Ingredient;
import zaftnotameni.creatania.registry.Blocks;
import zaftnotameni.creatania.registry.CreataniaFluids;

import java.util.function.Function;

import static zaftnotameni.creatania.util.NamedItems.*;

public class MixingRecipeGen extends ForgeCreateProcessingRecipeProvider {
	public void setupRecipes() {
		create("real_botania_mana_fluid", b -> b.require(Blocks.REAL_MANA_BLOCK.get())
			.output(CreataniaFluids.REAL_MANA.get(), 250)
			.requiresHeat(HeatCondition.SUPERHEATED));
		create("corrupted_inert_mana_fluid", b -> b.require(Blocks.CORRUPT_MANA_BLOCK.get())
			.output(CreataniaFluids.CORRUPT_MANA.get(), 250)
			.requiresHeat(HeatCondition.HEATED));
		create("purified_inert_mana_fluid", b -> b.require(Blocks.PURE_MANA_BLOCK.get())
			.output(CreataniaFluids.PURE_MANA.get(), 250)
			.requiresHeat(HeatCondition.HEATED));


		create("molten_manasteel_from_ingot", b -> b.require(Ingredient.of(itemLike("botania", "manasteel_ingot")))
			.output(CreataniaFluids.MOLTEN_MANASTEEL.get(), 125)
			.requiresHeat(HeatCondition.HEATED));
		create("molten_terrasteel_from_ingot", b -> b.require(Ingredient.of(itemLike("botania", "terrasteel_ingot")))
			.output(CreataniaFluids.MOLTEN_TERRASTEEL.get(), 125)
			.requiresHeat(HeatCondition.SUPERHEATED));
		create("molten_elementium_from_ingot", b -> b.require(Ingredient.of(itemLike("botania", "elementium_ingot")))
			.output(CreataniaFluids.MOLTEN_ELEMENTIUM.get(), 125)
			.requiresHeat(HeatCondition.SUPERHEATED));
		create("molten_gaia_from_ingot", b -> b.require(Ingredient.of(itemLike("botania", "gaia_ingot")))
			.output(CreataniaFluids.MOLTEN_GAIA.get(), 125)
			.requiresHeat(HeatCondition.SUPERHEATED));

		create("molten_brass_ingot", b -> b.require(Ingredient.of(AllItems.BRASS_INGOT.get()))
			.output(CreataniaFluids.MOLTEN_BRASS.get(), 125)
			.requiresHeat(HeatCondition.HEATED));
		create("molten_zinc_ingot", b -> b.require(Ingredient.of(AllItems.ZINC_INGOT.get()))
			.output(CreataniaFluids.MOLTEN_ZINC.get(), 125)
			.requiresHeat(HeatCondition.HEATED));
		create("molten_andesite_alloy_from_ingot", b -> b.require(Ingredient.of(AllItems.ANDESITE_ALLOY.get()))
			.output(CreataniaFluids.MOLTEN_ANDESITE.get(), 125)
			.requiresHeat(HeatCondition.SUPERHEATED));

		create("molten_iron_from_ingot", b -> b.require(Ingredient.of(itemLikeOf("minecraft:iron_ingot")))
			.output(CreataniaFluids.MOLTEN_IRON.get(), 125)
			.requiresHeat(HeatCondition.SUPERHEATED));
		create("molten_gold_from_ingot", b -> b.require(Ingredient.of(itemLikeOf("minecraft:gold_ingot")))
			.output(CreataniaFluids.MOLTEN_GOLD.get(), 125)
			.requiresHeat(HeatCondition.HEATED));
		create("molten_copper_from_ingot", b -> b.require(Ingredient.of(itemLikeOf("minecraft:copper_ingot")))
			.output(CreataniaFluids.MOLTEN_COPPER.get(), 125)
			.requiresHeat(HeatCondition.HEATED));

		Function<ProcessingRecipeBuilder, ProcessingRecipeBuilder> eachFlowerOutput = b -> {
			for (var flowerId : BOTANIA_MYSTICAL_FLOWERS) b.output(1f/BOTANIA_MYSTICAL_FLOWERS.length, itemLikeOf(flowerId), 1);
			return b;
		};
		Function<ProcessingRecipeBuilder, ProcessingRecipeBuilder> eachTallFlowerOutput = b -> {
			for (var flowerId : BOTANIA_TALL_FLOWERS) b.output(1f/BOTANIA_TALL_FLOWERS.length, itemLikeOf(flowerId), 1);
			return b;
		};

		for (var shortFlower : MINECRAFT_SHORT_FLOWERS) {
			create("mystic_flowers_from_vanilla_flower_" + pathOf(shortFlower), b -> eachFlowerOutput.apply(b
			  .require(itemLikeOf(shortFlower)))
				.require(CreataniaFluids.PURE_MANA.get(), 125));
		}
		for (var tallFlower : MINECRAFT_TALL_FLOWERS) {
			create("tall_mystic_flowers_from_tall_vanilla_flower_" + pathOf(tallFlower), b -> eachTallFlowerOutput.apply(b
				.require(itemLikeOf(tallFlower)))
				.require(CreataniaFluids.PURE_MANA.get(), 125));
		}

	}
	public MixingRecipeGen(DataGenerator p_i48262_1_) {
		super(p_i48262_1_); setupRecipes();
	}

	@Override
	protected AllRecipeTypes getRecipeType() {
		return AllRecipeTypes.MIXING;
	}

}
