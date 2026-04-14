package bl4ckscor3.mod.cookieblock;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.food.FoodConstants;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CookieBlock {
	public static final String MODID = "cookieblock";
	private static Platform platform;
	public static final RegistryObject<Block> COOKIE_BLOCK = RegistryObject.block(MODID, Block::new, () -> BlockBehaviour.Properties.of().strength(0.25F).sound(SoundType.STONE));
	public static final RegistryObject<BlockItem> COOKIE_BLOCK_ITEM = RegistryObject.item(MODID, p -> new BlockItem(COOKIE_BLOCK.get(), p), () -> new Item.Properties().food(new FoodProperties(18, FoodConstants.saturationByModifier(18, 0.1F), false), Consumables.defaultFood().consumeSeconds(9.6F).build()).useBlockDescriptionPrefix());

	public synchronized static void initialize(Platform platform) {
		if (CookieBlock.platform != null) {
			throw new IllegalArgumentException(MODID + " platform has already been initialized");
		}

		CookieBlock.platform = platform;
		platform.register(Registries.BLOCK, COOKIE_BLOCK);
		platform.register(Registries.ITEM, COOKIE_BLOCK_ITEM);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MODID, path);
	}

	public static Platform platform() {
		return platform;
	}
}
