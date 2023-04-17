package com.darkflame.silvermod.init;

import com.darkflame.silvermod.SilverMod;
import com.google.common.base.Supplier;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SilverMod.MOD_ID);
	
	public static final RegistryObject<Item> SILVER_INGOT = register("silver_ingot", () -> new Item(new Item.Properties()
			.tab(SilverMod.CREATIVE_MODE_TAB)
			.stacksTo(64)
			.setNoRepair()
	));
	
	private static <T extends Item> RegistryObject<T> register(String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
}