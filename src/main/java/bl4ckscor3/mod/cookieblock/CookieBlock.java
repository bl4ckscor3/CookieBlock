package bl4ckscor3.mod.cookieblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
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
		event.getRegistry().register(new Block(Block.Properties.of(Material.DIRT).strength(0.25F)) {
			@Override
			public SoundType getSoundType(BlockState state)
			{
				return SoundType.STONE;
			}

			@Override
			public SoundType getSoundType(BlockState state, IWorldReader world, BlockPos pos, Entity entity)
			{
				return SoundType.STONE;
			}
		}.setRegistryName(MODID, MODID));
	}

	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(COOKIE_BLOCK, new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(18).saturationMod(0.9F).build())).setRegistryName(COOKIE_BLOCK.getRegistryName()));
	}
}
