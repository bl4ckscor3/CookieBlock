package bl4ckscor3.mod.cookieblock.forge;

import java.util.HashMap;
import java.util.function.Supplier;

import bl4ckscor3.mod.cookieblock.CookieBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class RegistryUtilImpl {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CookieBlock.MOD_ID);
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CookieBlock.MOD_ID);
  public static final HashMap<CreativeModeTab, HashMap<Item, Item>> ITEMS_TO_ADD_AFTER = new HashMap<>();

  public static void addToItemGroupAfter(CreativeModeTab itemGroup, Item item, Item after) {
    if (ITEMS_TO_ADD_AFTER.containsKey(itemGroup)) {
      ITEMS_TO_ADD_AFTER.get(itemGroup).put(item, after);
    } else {
      HashMap<Item, Item> items = new HashMap<>();
      items.put(item, after);
      ITEMS_TO_ADD_AFTER.put(itemGroup, items);
    }
  }

  public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
    return BLOCKS.register(name, block);
  }

  public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
    return ITEMS.register(name, item);
  }
}
