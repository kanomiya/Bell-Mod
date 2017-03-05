/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.kanomiya.mcmod.bell.BellMod.MODID;

/**
 * Created by 和宮 葵(Kanomiya) in 2017/03.
 */
@Mod.EventBusSubscriber(modid = BellMod.MODID)
public class BellModSounds {
    private static final ResourceLocation RL_SOUND_CLAPPER_BELL = new ResourceLocation(MODID, "clapper_bell");
    public static final SoundEvent SOUND_CLAPPER_BELL = new SoundEvent(RL_SOUND_CLAPPER_BELL).setRegistryName(RL_SOUND_CLAPPER_BELL);
    private static final ResourceLocation RL_SOUND_STRIKE_BELL = new ResourceLocation(MODID, "strike_bell");
    public static final SoundEvent SOUND_STRIKE_BELL = new SoundEvent(RL_SOUND_STRIKE_BELL).setRegistryName(RL_SOUND_STRIKE_BELL);

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(
                SOUND_CLAPPER_BELL,
                SOUND_STRIKE_BELL
        );
    }

}
