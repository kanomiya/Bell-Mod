/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by 和宮 葵(Kanomiya) in 2017/03.
 */
@Mod.EventBusSubscriber(modid = BellMod.MODID)
public class BellModItems {
    public static final ItemBlock ITEM_CLAPPER_BELL = (ItemBlock) new ItemBlock(BellModBlocks.CLAPPER_BELL).setRegistryName(BellModBlocks.CLAPPER_BELL.getRegistryName());
    public static final ItemBlock ITEM_STRIKE_BELL = (ItemBlock) new ItemBlock(BellModBlocks.STRIKE_BELL).setRegistryName(BellModBlocks.STRIKE_BELL.getRegistryName());
    public static final ItemBlock ITEM_STRIKE_STICK = (ItemBlock) new ItemBlock(BellModBlocks.STRIKE_STICK).setRegistryName(BellModBlocks.STRIKE_STICK.getRegistryName());

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ITEM_CLAPPER_BELL,
                ITEM_STRIKE_BELL,
                ITEM_STRIKE_STICK
        );
    }

}
