package com.darkflame.silvermod;

import com.darkflame.silvermod.init.BlockInit;
import com.darkflame.silvermod.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SilverMod.MOD_ID)
public class SilverMod {
	
	public static final String MOD_ID = "silvermod";
	
	public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab(MOD_ID+"_maintab") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.SILVER_INGOT.get());
		}
	};
	
	public SilverMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
