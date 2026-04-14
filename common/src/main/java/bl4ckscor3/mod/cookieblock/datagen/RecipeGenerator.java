package bl4ckscor3.mod.cookieblock.datagen;

import java.util.concurrent.CompletableFuture;

import bl4ckscor3.mod.cookieblock.CookieBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class RecipeGenerator extends RecipeProvider {
	public RecipeGenerator(HolderLookup.Provider lookupProvider, RecipeOutput output) {
		super(lookupProvider, output);
	}

	@Override
	public final void buildRecipes() {
		ItemLike packedForm = CookieBlock.COOKIE_BLOCK.get();
		shapeless(RecipeCategory.FOOD, Items.COOKIE, 9)
			.requires(packedForm)
			.unlockedBy(getHasName(packedForm), has(packedForm))
			.save(output, ResourceKey.create(Registries.RECIPE, CookieBlock.id("cookie")));
		shaped(RecipeCategory.FOOD, packedForm)
			.define('#', Items.COOKIE)
			.pattern("###")
			.pattern("###")
			.pattern("###")
			.unlockedBy(getHasName(Items.COOKIE), has(Items.COOKIE))
			.save(output, ResourceKey.create(Registries.RECIPE, CookieBlock.id(CookieBlock.MODID)));
	}

	public static final class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
			super(output, lookupProvider);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
			return new RecipeGenerator(lookupProvider, output);
		}

		@Override
		public String getName() {
			return "CookieBlock recipes";
		}
	}
}
