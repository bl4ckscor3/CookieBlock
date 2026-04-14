package bl4ckscor3.mod.cookieblock.datagen;

import java.util.Set;

import bl4ckscor3.mod.cookieblock.CookieBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

public class BlockLootTableGenerator extends BlockLootSubProvider {
	protected BlockLootTableGenerator(HolderLookup.Provider lookupProvider) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
	}

	@Override
	public void generate() {
		dropSelf(CookieBlock.COOKIE_BLOCK.get());
	}
}
