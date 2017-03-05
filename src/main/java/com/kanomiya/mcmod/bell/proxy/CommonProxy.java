/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell.proxy;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.kanomiya.mcmod.bell.BellModBlocks.*;

/**
 * Created by Kanomiya in 2017/03.
 */
public class CommonProxy {
    public void init() {

        GameRegistry.addRecipe(new ItemStack(CLAPPER_BELL), new Object[]{
                "III",
                "IGI",
                "IqI",
                'I', Items.IRON_INGOT,
                'G', Items.GOLD_INGOT,
                'q', Items.QUARTZ,
        });

        GameRegistry.addRecipe(new ItemStack(STRIKE_BELL), new Object[]{
                "III",
                "III",
                "IqI",
                'I', Items.IRON_INGOT,
                'q', Items.QUARTZ,
        });

        GameRegistry.addRecipe(new ItemStack(STRIKE_STICK), new Object[]{
                " S ",
                "T T",
                "SSS",
                'S', Items.STICK,
                'T', Items.STRING,
        });

    }
}
