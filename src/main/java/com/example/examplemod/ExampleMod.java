package com.example.examplemod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("examplemod")
public class ExampleMod {
	//This class just registers blocks and items & I don't think it's relevant to the bug at hand btw
	
	public ExampleMod() {
		IEventBus x = FMLJavaModLoadingContext.get().getModEventBus();
		x.addGenericListener(Block.class, Yeah::registerBlock);
		x.addGenericListener(Item.class, Yeah::registerItem);
	}
	
	public static class Yeah {
		public static final Subclass TEST = new Subclass(AbstractBlock.Properties.of(Material.STONE));
		
		public static void registerBlock(RegistryEvent.Register<Block> event) {
			IForgeRegistry<Block> r = event.getRegistry();
			
			r.register(TEST.setRegistryName(new ResourceLocation("examplemod", "test")));
		}
		
		public static void registerItem(RegistryEvent.Register<Item> event) {
			IForgeRegistry<Item> r = event.getRegistry();
			
			r.register(new BlockItem(TEST, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(new ResourceLocation("examplemod", "test")));
		}
	}
}