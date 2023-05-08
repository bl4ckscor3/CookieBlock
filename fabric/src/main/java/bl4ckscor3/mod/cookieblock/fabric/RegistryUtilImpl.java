package bl4ckscor3.mod.cookieblock.fabric;

import java.util.function.Supplier;

import static bl4ckscor3.mod.cookieblock.CookieBlock.MOD_ID;

import bl4ckscor3.mod.cookieblock.CookieBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class RegistryUtilImpl {
  public static void addToItemGroupAfter(CreativeModeTab itemGroup, Item item, Item after) {
    ItemGroupEvents.modifyEntriesEvent(itemGroup).register((content) -> {
      content.addAfter(after, item.getDefaultInstance());
    });
  }

  public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
    return () -> Registry.register(BuiltInRegistries.BLOCK, MOD_ID + ":" + name, block.get());
  }

  public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
    return () -> Registry.register(BuiltInRegistries.ITEM, CookieBlock.makeId(name), item.get());
  }
}
