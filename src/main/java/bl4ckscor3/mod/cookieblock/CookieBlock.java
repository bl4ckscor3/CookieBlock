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
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(CookieBlock.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class CookieBlock {
	public static final String MODID = "cookieblock";
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final RegistryObject<Block> COOKIE_BLOCK = BLOCKS.register(MODID, () -> new Block(Block.Properties.of().strength(0.25F).sound(SoundType.STONE)));
	public static final RegistryObject<BlockItem> COOKIE_BLOCK_ITEM = ITEMS.register(MODID, () -> new BlockItem(COOKIE_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(18).saturationMod(0.9F).build())));

	public CookieBlock() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
			event.getEntries().putAfter(new ItemStack(Items.COOKIE), new ItemStack(COOKIE_BLOCK_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
	}
}
