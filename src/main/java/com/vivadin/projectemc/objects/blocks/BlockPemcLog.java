package com.vivadin.projectemc.objects.blocks;

import com.vivadin.projectemc.ProjectEmc;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockPemcLog extends BlockLog
{
   public BlockPemcLog(String name)
   {
      setSoundType(SoundType.WOOD);
      setUnlocalizedName(name);
      setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
      setDefaultState(
         this.blockState.getBaseState()
            .withProperty(LOG_AXIS, BlockLog.EnumAxis.Y)
      );
   }
   
   @Override
   protected BlockStateContainer createBlockState()
   {
      return new BlockStateContainer(
         this,
         LOG_AXIS
      );
   }
   
   @Override
   public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
   {
      items.add(new ItemStack(this));
   }
   
   @Override
   public IBlockState getStateFromMeta(int meta)
   {
      IBlockState state = this.getDefaultState();
      switch(meta & 12) {
         case 0:
            state = state.withProperty(LOG_AXIS, EnumAxis.Y);
            break;
         case 4:
            state = state.withProperty(LOG_AXIS, EnumAxis.X);
            break;
         case 8:
            state = state.withProperty(LOG_AXIS, EnumAxis.Z);
            break;
         default:
            state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
      }
      return state;
   }
   
   @Override
   public int getMetaFromState(IBlockState state)
   {
      int meta = 0;
      
      switch(state.getValue(LOG_AXIS))
      {
         case X:
            meta |= 4;
            break;
         case Z:
            meta |= 8;
            break;
         case NONE:
            meta |= 12;
      }
      return meta;
   }
   
   @Override
   protected ItemStack getSilkTouchDrop(IBlockState state)
   {
      return new ItemStack(Item.getItemFromBlock(this), 1);
   }
   
   @Override
   public int damageDropped(IBlockState state)
   {
      return 0;
   }
   
   public void registerModels()
   {
      ProjectEmc.proxy.registerItemRenderer(
         Item.getItemFromBlock(this),
         0,
         "inventory"
      );
   }
}
