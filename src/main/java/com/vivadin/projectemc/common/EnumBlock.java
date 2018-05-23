package com.vivadin.projectemc.common;

import com.vivadin.projectemc.ProjectEmc;
import com.vivadin.projectemc.interfaces.IEnumMeta;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class EnumBlock<E extends Enum<E> & IEnumMeta & IStringSerializable> extends Block
{
   public final PropertyEnum<E> prop;
   private final E[] values;
   
   protected static PropertyEnum<?> tmp;
   
   public EnumBlock(Material material, PropertyEnum<E> prop, Class<E> eClass)
   {
      super(preInit(material, prop));
      this.prop = prop;
      values = eClass.getEnumConstants();
   }
   
   private static Material preInit(Material material, PropertyEnum<?> property)
   {
      tmp = property;
      return material;
   }
   
   @Override
   public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
   {
      for (E type : values) {
         items.add(new ItemStack(this, 1, type.getMeta()));
      }
   }
   
   @Nonnull
   @Override
   protected BlockStateContainer createBlockState()
   {
      if (prop == null) {
         return new BlockStateContainer(this, tmp);
      }
      return new BlockStateContainer(this, prop);
   }
   
   @Nonnull
   @Override
   public IBlockState getStateFromMeta(int meta)
   {
      return this.getDefaultState()
         .withProperty(prop, fromMeta(meta));
   }
   
   @Override
   public int getMetaFromState(IBlockState state)
   {
      return state.getValue(prop).getMeta();
   }
   
   @Override
   public int damageDropped(IBlockState state)
   {
      return getMetaFromState(state);
   }
   
   public String getMetaName(int meta)
   {
      if (meta < 0 || meta >= values.length)
         meta = 0;
      
      return values[meta].getName();
   }
   
   protected E fromMeta(int meta)
   {
      if (meta < 0 || meta >= values.length)
         meta = 0;
      
      return values[meta];
   }
   
   public void registerModels()
   {
      for (int i = 0; i < values.length; i++) {
         ProjectEmc.proxy.registerVariantRenderer(
            Item.getItemFromBlock(this),
            i,
            "ore_overworld_" + values[i].getName(),
            "inventory"
         );
      }
   }
}

