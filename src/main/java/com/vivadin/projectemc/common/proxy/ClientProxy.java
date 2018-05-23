package com.vivadin.projectemc.common.proxy;

import com.vivadin.projectemc.ProjectEmc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy
{
   @Override
   public void registerVariantRenderer(Item item, int meta, String filename, String id)
   {
      ModelLoader.setCustomModelResourceLocation(
         item,
         meta,
         new ModelResourceLocation(
            new ResourceLocation(
               ProjectEmc.MODID,
               filename
            ),
            id
         )
      );
   }
}