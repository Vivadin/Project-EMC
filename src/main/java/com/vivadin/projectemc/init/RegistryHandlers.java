package com.vivadin.projectemc.init;

import com.vivadin.projectemc.common.ItemBlockVariant;
import com.vivadin.projectemc.common.registry.ObjectRegistry;
import com.vivadin.projectemc.objects.PemcBlocks;
import com.vivadin.projectemc.objects.blocks.BlockEmcOre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class RegistryHandlers extends ObjectRegistry
{
   @SubscribeEvent
   public static void registerBlocks(final RegistryEvent.Register<Block> event)
   {
      // Register the blocks
      final IForgeRegistry<Block> registry = event.getRegistry();
      
      PemcBlocks.emcOre = registerBlock(registry, new BlockEmcOre(), "ore_overworld");
   }
   
   @SubscribeEvent
   public static void registerItems(final RegistryEvent.Register<Item> event)
   {
      // Register the Items7
      final IForgeRegistry<Item> registry = event.getRegistry();
      
      // New block item registration function
      registerItemsFromBlocks(registry);
      
      //registerItem(
      //   registry,
      //   new ItemBlockVariant(PemcBlocks.emcOre),
           // .setRegistryName(PemcBlocks.emcOre.getRegistryName()),
      //   "ore_overworld"
      //);
   }
   
   @SubscribeEvent
   public static void onModelRegister(ModelRegistryEvent event)
   {
      PemcBlocks.emcOre.registerModels();
   }
   
   
}
