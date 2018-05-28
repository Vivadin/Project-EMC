package com.vivadin.projectemc.objects.blocks;

import com.vivadin.projectemc.ProjectEmc;
import com.vivadin.projectemc.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockPemcPlank extends Block implements IHasModel
{
   public BlockPemcPlank(String name)
   {
      super(Material.WOOD);
      this.setSoundType(SoundType.WOOD);
      this.setHardness(2.5f);
      this.setUnlocalizedName(name);
      this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
   }
   
   @Override
   public void registerModels()
   {
      ProjectEmc.proxy.registerItemRenderer(
         Item.getItemFromBlock(this)
      );
   }
}
