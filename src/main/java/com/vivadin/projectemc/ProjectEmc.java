package com.vivadin.projectemc;

import com.vivadin.projectemc.common.proxy.CommonProxy;
import com.vivadin.projectemc.common.registry.SmeltingRegistry;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ProjectEmc.MODID, name = ProjectEmc.NAME, version = ProjectEmc.VERSION)
public class ProjectEmc
{
    public static final String MODID = "pemc";
    public static final String NAME = "Project EMC";
    public static final String VERSION = "0.0.1";
    public static final String CLIENT = "com.vivadin.projectemc.common.proxy.ClientProxy";
    public static final String COMMON = "com.vivadin.projectemc.common.proxy.CommonProxy";

    private static Logger logger;
    
    @SidedProxy(clientSide = CLIENT, serverSide = COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        SmeltingRegistry.register();
    }
}
