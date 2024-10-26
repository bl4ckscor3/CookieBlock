package bl4ckscor3.mod.cookieblock.datagen;

import java.util.concurrent.CompletableFuture;

import bl4ckscor3.mod.cookieblock.CookieBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

public class RecipeGenerator extends RecipeProvider {
	public RecipeGenerator(HolderLookup.Provider lookupProvider, RecipeOutput output) {
		super(lookupProvider, output);
	}

	@Override
	protected final void buildRecipes() {
		nineBlockStorageRecipes(RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.FOOD, CookieBlock.COOKIE_BLOCK);
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
