package com.vivadin.projectemc.world;

import com.vivadin.projectemc.objects.PemcBlocks;
import com.vivadin.projectemc.objects.blocks.BlockEmcOre;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator
{
   private WorldGenerator ore_overworld_asmil;
   
   public WorldGenCustomOres() {
      ore_overworld_asmil = new WorldGenMinable(
         PemcBlocks.emcOre.getDefaultState()
            .withProperty(BlockEmcOre.VARIANT, BlockEmcOre.OreType.ASMIL),
         9);
   }
   
   private void runGenerator(WorldGenerator gen, World world, Random random, int chunkX, int chunkY, int chance, int minHeight, int maxHeight)
   {
      if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
         throw new IllegalArgumentException("Ore generated out of bounds");
      
      int heightDiff = maxHeight - minHeight;
      for (int i = 0; i < chance; i++) {
         int x = chunkX * 16 + random.nextInt(16);
         int z = minHeight + random.nextInt(heightDiff);
         int y = chunkY * 16 + random.nextInt(16);
         
         gen.generate(world, random, new BlockPos(x, y, z));
      }
   }
   
   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
   {
      if (world.provider.getDimension() == 0)
         runGenerator(ore_overworld_asmil, world, random, chunkX, chunkZ, 15, 1, 100);
   }
}
