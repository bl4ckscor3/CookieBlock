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
	public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider);
	}

	@Override
	protected final void buildRecipes(RecipeOutput recipeOutput) {
		nineBlockStorageRecipes(recipeOutput, RecipeCategory.FOOD, Items.COOKIE, RecipeCategory.FOOD, CookieBlock.COOKIE_BLOCK);
	}
}
