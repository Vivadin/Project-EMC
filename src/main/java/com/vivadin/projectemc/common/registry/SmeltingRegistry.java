package com.vivadin.projectemc.common.registry;

import com.vivadin.projectemc.objects.PemcBlocks;
import com.vivadin.projectemc.objects.PemcItems;
import com.vivadin.projectemc.objects.blocks.BlockEmcOre;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRegistry
{
   public static void register()
   {
      GameRegistry.addSmelting(
         PemcBlocks.emcOre.getDefaultState()
            .withProperty(BlockEmcOre.VARIANT, BlockEmcOre.OreType.ASMIL)
            .getBlock(),
         new ItemStack(PemcItems.asmilIngot),
         1
      );
   }
}
