package com.vivadin.projectemc.common.registry;

import com.vivadin.projectemc.ProjectEmc;
import com.vivadin.projectemc.common.ItemBlockVariant;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ObjectRegistry
{
   // Somewhere to store multiple item blocks - as this is much easier than
   // registering them one by one :S
   private static List<Item> _itemBlocks = new ArrayList<Item>();
   
   
   protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name)
   {
      if (!name.equals(name.toLowerCase(Locale.US)))
         throw new IllegalArgumentException(
            String.format("Unlocalised names need to be lowercase.  Block: %s", name)
         );
      
      block.setUnlocalizedName(name);
      register(registry, block, name);
      _itemBlocks.add(
         new ItemBlockVariant(block)
            .setRegistryName(block.getRegistryName())
      );
      return block;
   }
   
   protected static void registerItemsFromBlocks(IForgeRegistry<Item> registry)
   {
      registry.registerAll(
         _itemBlocks.toArray(
            new Item[0]
         )
      );
   }
   
   protected static <T extends Item> T registerItem(IForgeRegistry<Item> registry, T item, String name)
   {
      item.setUnlocalizedName(name);
      register(registry, item, name);
      return item;
   }
   
   private static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, String name)
   {
      thing.setRegistryName(new ResourceLocation(ProjectEmc.MODID, name));
      registry.register(thing);
      return thing;
   }
}
