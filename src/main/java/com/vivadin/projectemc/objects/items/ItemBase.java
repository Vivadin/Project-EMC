package com.vivadin.projectemc.objects.items;

import com.vivadin.projectemc.ProjectEmc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
   public ItemBase(String name)
   {
      setUnlocalizedName(name);
      setCreativeTab(CreativeTabs.MATERIALS);
   }
   
   public void registerModel()
   {
      ProjectEmc.proxy.registerItemRenderer(this, 0, "inventory");
   }
}
