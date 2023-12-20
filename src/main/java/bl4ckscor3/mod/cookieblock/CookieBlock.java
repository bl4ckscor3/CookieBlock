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
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(CookieBlock.MODID)
public class CookieBlock {
	public static final String MODID = "cookieblock";
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final RegistryObject<Block> COOKIE_BLOCK = BLOCKS.register(MODID, () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.25F).sound(SoundType.STONE)));
	public static final RegistryObject<BlockItem> COOKIE_BLOCK_ITEM = ITEMS.register(MODID, () -> new BlockItem(COOKIE_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(18).saturationMod(0.1F).build())) {
		@Override
		public int getUseDuration(ItemStack stack) {
			return ServerConfig.CONFIG.eatingSpeed.get();
		}
	});

	public CookieBlock() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		modEventBus.addListener(CookieBlock::onCreativeModeTabBuildContents);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.CONFIG_SPEC);
	}

	public static void onCreativeModeTabBuildContents(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS)
			event.getEntries().putAfter(new ItemStack(Items.COOKIE), new ItemStack(COOKIE_BLOCK_ITEM.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
	}
}
