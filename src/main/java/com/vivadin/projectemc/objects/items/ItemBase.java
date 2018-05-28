package com.vivadin.projectemc.objects.items;

import com.vivadin.projectemc.ProjectEmc;
import com.vivadin.projectemc.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
   public ItemBase(String name)
   {
      setUnlocalizedName(name);
      setCreativeTab(CreativeTabs.MATERIALS);
   }
   
   @Override
   public void registerModels()
   {
      ProjectEmc.proxy.registerItemRenderer(this);
   }
}
