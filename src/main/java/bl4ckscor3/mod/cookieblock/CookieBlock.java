package bl4ckscor3.mod.cookieblock;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod(CookieBlock.MODID)
@EventBusSubscriber(bus=Bus.MOD)
public class CookieBlock
{
	public static final String MODID = "cookieblock";
	@ObjectHolder(MODID + ":" + MODID)
	public static final Block COOKIE_BLOCK = null;

	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.of(Material.STONE).strength(0.25F).sound(SoundType.STONE)).setRegistryName(MODID, MODID));
	}

	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(COOKIE_BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().nutrition(18).saturationMod(0.9F).build())).setRegistryName(COOKIE_BLOCK.getRegistryName()));
	}
}
