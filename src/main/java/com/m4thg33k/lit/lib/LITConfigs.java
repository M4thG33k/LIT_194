package com.m4thg33k.lit.lib;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class LITConfigs {

    public static Configuration config;
    public static boolean USE_ALTERNATE_CRAFTING_TABLE_RECIPE;

    public static boolean ENABLE_GRAVES;
    public static int GRAVE_RANGE;
    public static boolean ALLOW_GRAVES_IN_WATER;
    public static boolean ALLOW_GRAVES_IN_FLOWING_WATER;
    public static boolean ALLOW_GRAVES_IN_LAVA;
    public static boolean ALLOW_GRAVES_IN_FLOWING_LAVA;


    public static void preInit(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        Property useAlternateCraftingTableRecipe = config.get(Configuration.CATEGORY_GENERAL,"useAlternateCraftingTableRecipe",true);
        useAlternateCraftingTableRecipe.setComment("Set to true to disable the recipe requiring just the vanilla table and replace it with one that requires flint (defaults to true to avoid conflict with TCon");
        USE_ALTERNATE_CRAFTING_TABLE_RECIPE = useAlternateCraftingTableRecipe.getBoolean(true);

        ENABLE_GRAVES = config.get("Graves","enableGraves",true,"Set to false to disable graves spawning upon player deaths, saving their inventory. (Defaults to true)").getBoolean();
        GRAVE_RANGE = config.get("Graves","graveSearchRadius",9,"This is the radius that will be searched to find an air block to place the grave. (Radius = abs(max{x,y,z})). Note: if death happens with y<0, it will center its search around y=1 instead. (Defaults to 9)",0,25).getInt();
        ALLOW_GRAVES_IN_WATER = config.get("Graves","allowGravesInWater",true,"If this is true, graves will be able to replace still water blocks. (Defaults to true)").getBoolean();
        ALLOW_GRAVES_IN_FLOWING_WATER = config.get("Graves","allowGravesInFLOWINGWater",true,"If this is true, graves will be able to replace flowing water blocks. (Defaults to true)").getBoolean();
        ALLOW_GRAVES_IN_LAVA = config.get("Graves","allowGravesInLava",true,"If this is true, graves will be able to replace still lava blocks. (Defaults to true)").getBoolean();
        ALLOW_GRAVES_IN_FLOWING_LAVA = config.get("Graves","allowGravesInFLOWINGLava",true,"If this is true, graves will be able to replace flowing lava blocks. (Defaults to true)").getBoolean();

        config.save();
    }
}
