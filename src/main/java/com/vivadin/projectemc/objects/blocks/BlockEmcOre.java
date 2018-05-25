package com.vivadin.projectemc.objects.blocks;

import com.vivadin.projectemc.common.EnumBlock;
import com.vivadin.projectemc.interfaces.IEnumMeta;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public class BlockEmcOre extends EnumBlock<BlockEmcOre.OreType>
{
   
   public static PropertyEnum<OreType> VARIANT = PropertyEnum.create("variant", OreType.class);
   
   public BlockEmcOre() {
      super(Material.ROCK, VARIANT, OreType.class);
      this.setCreativeTab(CreativeTabs.MATERIALS);
      this.setHardness(7.0f);
      this.setSoundType(SoundType.STONE);
      this.setDefaultState(
         this.blockState.getBaseState()
            .withProperty(VARIANT, OreType.ASMIL)
      );
   }
   
   public enum OreType implements IStringSerializable, IEnumMeta
   {
      ASMIL;
      
      OreType() {
         this.meta = this.ordinal();
      }
      
      public final int meta;
   
   
      @Override
      public int getMeta()
      {
         return meta;
      }
   
      @Override
      public String getName()
      {
         return this.toString().toLowerCase(Locale.US);
      }
   }
}
