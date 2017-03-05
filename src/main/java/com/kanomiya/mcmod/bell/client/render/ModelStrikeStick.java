/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by 和宮 葵(Kanomiya) in 2017/03.
 */
@SideOnly(Side.CLIENT)
public class ModelStrikeStick extends ModelBase {
    public final ModelRenderer topBar;
    public final ModelRenderer strikeStick;

    public ModelStrikeStick() {
        textureWidth = 64;
        textureHeight = 32;

        topBar = new ModelRenderer(this, 0, 0) // topBar
                .addBox(0f, 0f, 0f, 2, 1, 14)
                .setTextureSize(64, 32);
        topBar.setRotationPoint(7f, 15f, 1f);

        strikeStick = new ModelRenderer(this, 32, 0) // strikeStick
                .addBox(0f, 0f, 0f, 2, 2, 10)
                .setTextureSize(64, 32);
    }

    @Override
    public void render(Entity entityIn, float displacement, float f1, float f2, float f3, float f4, float scale) {
        setRotationAngles(displacement, f1, f2, f3, f4, scale, entityIn);

        // topBar.render(scale);
        // strikeStick.render(scale);
    }

}
