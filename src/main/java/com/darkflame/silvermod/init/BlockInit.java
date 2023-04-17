package com.darkflame.silvermod.init;

import java.util.function.Function;

import com.darkflame.silvermod.SilverMod;
import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SilverMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY)
				.strength(3.0f)
				.sound(SoundType.METAL)
				.requiresCorrectToolForDrops()
			),
			object -> () -> new BlockItem(object.get(), new Item.Properties()
				.tab(SilverMod.CREATIVE_MODE_TAB)
				.stacksTo(64)
				.setNoRepair()
			));

	private static <T extends Block> RegistryObject<T> registerBlock(String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}
	private static <T extends Block> RegistryObject<T> register(String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
