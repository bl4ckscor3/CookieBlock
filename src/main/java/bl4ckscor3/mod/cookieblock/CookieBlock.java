package bl4ckscor3.mod.cookieblock;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(CookieBlock.MODID)
public class CookieBlock {
	public static final String MODID = "cookieblock";
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
	public static final DeferredBlock<Block> COOKIE_BLOCK = BLOCKS.registerSimpleBlock(MODID, BlockBehaviour.Properties.of().strength(0.25F).sound(SoundType.STONE));
	public static final DeferredItem<BlockItem> COOKIE_BLOCK_ITEM = ITEMS.register(MODID, () -> new BlockItem(COOKIE_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(18).saturationMod(0.1F).build())) {
		@Override
		public int getUseDuration(ItemStack stack) {
			return 192;
		}
	});

	public CookieBlock(IEventBus modEventBus) {
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		modEventBus.addListener(CookieBlock::onCreativeModeTabBuildContents);
	}

	public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
			event.getEntries().putAfter(new ItemStack(Items.COOKIE), new ItemStack(COOKIE_BLOCK_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
	}
}
