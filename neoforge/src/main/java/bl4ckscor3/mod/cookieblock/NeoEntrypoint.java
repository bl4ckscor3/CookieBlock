package bl4ckscor3.mod.cookieblock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(CookieBlock.MODID)
@EventBusSubscriber
public class NeoEntrypoint implements Platform {
	private final Map<ResourceKey<? extends Registry<?>>, DeferredRegister<?>> registers = new HashMap<>();
	private final IEventBus modBus;

	public NeoEntrypoint(ModContainer modContainer, IEventBus modBus) {
		this.modBus = modBus;
		CookieBlock.initialize(this);
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
			event.insertAfter(new ItemStack(Items.COOKIE), new ItemStack(CookieBlock.COOKIE_BLOCK_ITEM.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
	}

	@Override
	public <R, T extends R> void register(ResourceKey<? extends Registry<R>> registry, Supplier<T> entry, String path) {
		@SuppressWarnings("unchecked")
		DeferredRegister<R> register = (DeferredRegister<R>) registers.computeIfAbsent(
			registry,
			_ -> {
				DeferredRegister<R> r = DeferredRegister.create(registry, CookieBlock.MODID);

				r.register(modBus);
				return r;
			}
		);
		register.register(path, entry);
	}
}
