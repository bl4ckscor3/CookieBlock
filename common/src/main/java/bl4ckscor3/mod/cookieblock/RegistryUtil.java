package bl4ckscor3.mod.cookieblock;

import java.util.function.Supplier;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class RegistryUtil {
  @ExpectPlatform
  public static void addToItemGroupAfter(CreativeModeTab itemGroup, Item item, Item after) {
    throw new AssertionError();
  }

  @ExpectPlatform
  public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
    throw new AssertionError();
  }

  @ExpectPlatform
  public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
    throw new AssertionError();
  }
}
