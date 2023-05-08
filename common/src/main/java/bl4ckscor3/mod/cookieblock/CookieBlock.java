package bl4ckscor3.mod.cookieblock;

import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CookieBlock {
  public static final String MOD_ID = "cookieblock";
  public static final Supplier<Block> COOKIE_BLOCK = RegistryUtil.registerBlock(
    MOD_ID,
    () -> new Block(Block.Properties.of(Material.STONE).strength(0.25F).sound(SoundType.STONE)));

  /*
  Get current cookie nutrition value then multiply by 9.
  Eat one cookie block is the same eat 9 cookies.
  */
  private static final int cookieBlockNutrition = Items.COOKIE.getFoodProperties().getNutrition() * 9;
  public static final Supplier<BlockItem> COOKIE_BLOCK_ITEM = RegistryUtil.registerItem(
    MOD_ID,
    () -> new BlockItem(COOKIE_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(cookieBlockNutrition).saturationMod(0.9F).build())));

  public static void init() {}

  public static void postInit() {
    addToItemGroups();
  }

  public static ResourceLocation makeId(String path) {
    return new ResourceLocation(MOD_ID, path);
  }

  private static void addToItemGroups() {
    RegistryUtil.addToItemGroupAfter(CreativeModeTabs.FOOD_AND_DRINKS, COOKIE_BLOCK_ITEM.get(), Items.COOKIE);
  }
}
