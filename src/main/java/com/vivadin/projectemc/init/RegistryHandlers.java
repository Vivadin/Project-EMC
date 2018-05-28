package com.vivadin.projectemc.init;

import com.vivadin.projectemc.common.ItemBlockVariant;
import com.vivadin.projectemc.common.registry.ObjectRegistry;
import com.vivadin.projectemc.interfaces.IHasModel;
import com.vivadin.projectemc.objects.PemcBlocks;
import com.vivadin.projectemc.objects.PemcItems;
import com.vivadin.projectemc.objects.blocks.BlockEmcOre;
import com.vivadin.projectemc.objects.blocks.BlockPemcLog;
import com.vivadin.projectemc.objects.blocks.BlockPemcPlank;
import com.vivadin.projectemc.objects.items.ItemBase;
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
      // Get the registry
      final IForgeRegistry<Block> registry = event.getRegistry();
      
      // Register Blocks
      PemcBlocks.emcOre = registerBlock(registry, new BlockEmcOre(), "ore_overworld");
      PemcBlocks.logSpellkeeper = registerBlock(registry, new BlockPemcLog("log_spellkeeper"), "log_spellkeeper");
      PemcBlocks.plankSpellkeeper = registerBlock(registry, new BlockPemcPlank("plank_spellkeeper"), "plank_spellkeeper");
   }
   
   @SubscribeEvent
   public static void registerItems(final RegistryEvent.Register<Item> event)
   {
      // Get the registry
      final IForgeRegistry<Item> registry = event.getRegistry();
      
      // New block item registration function
      registerItemsFromBlocks(registry);
      
      // Register Items
      PemcItems.asmilIngot = registerItem(registry, new ItemBase("ingot_asmil"), "ingot_asmil");
      PemcItems.asmilNugget = registerItem(registry, new ItemBase("nugget_asmil"), "nugget_asmil");
   }
   
   @SubscribeEvent
   public static void onModelRegister(ModelRegistryEvent event)
   {
      //PemcBlocks.emcOre.registerModels();
      //PemcBlocks.logSpellkeeper.registerModels();
      //PemcItems.asmilIngot.registerModel();
      //PemcItems.asmilNugget.registerModel();
   
      
      // Register Models for blocks
      for (Block block : new Block[]{
         PemcBlocks.emcOre,
         PemcBlocks.logSpellkeeper,
         PemcBlocks.plankSpellkeeper
      })
      {
         if (block instanceof IHasModel)
            ((IHasModel) block).registerModels();
      }
      
      // Register Models for Items
      for (Item item : new Item[] {
         PemcItems.asmilIngot,
         PemcItems.asmilNugget
      })
      {
         if (item instanceof IHasModel)
            ((IHasModel) item).registerModels();
      }
   }
   
   
}
