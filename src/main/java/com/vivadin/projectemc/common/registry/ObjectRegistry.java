package com.vivadin.projectemc.common.registry;

import com.vivadin.projectemc.ProjectEmc;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Locale;

public class ObjectRegistry
{
   protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name)
   {
      if (!name.equals(name.toLowerCase(Locale.US)))
         throw new IllegalArgumentException(
            String.format("Unlocalised names need to be lowercase.  Block: %s", name)
         );
      
      block.setUnlocalizedName(name);
      register(registry, block, name);
      return block;
   }
   
   private static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, String name)
   {
      thing.setRegistryName(new ResourceLocation(ProjectEmc.MODID, name));
      registry.register(thing);
      return thing;
   }
}
