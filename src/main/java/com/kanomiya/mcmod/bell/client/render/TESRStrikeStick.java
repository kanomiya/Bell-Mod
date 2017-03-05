/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell.client.render;

import com.kanomiya.mcmod.bell.tileentity.TileEntityStrikeStick;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

import static com.kanomiya.mcmod.bell.BellMod.MODID;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by 和宮 葵(Kanomiya) in 2017/03.
 */
public class TESRStrikeStick extends TileEntitySpecialRenderer<TileEntityStrikeStick> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/tileentity/strike_stick.png");
    ModelStrikeStick model = new ModelStrikeStick();

    public TESRStrikeStick() {
    }

    @Override
    public void renderTileEntityAt(TileEntityStrikeStick te, double x, double y, double z, float partialTicks, int destroyStage) {
        super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);

        double scale = 0.0625d;
        glPushMatrix();
        glEnable(GL_CULL_FACE);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);


        double theta = (te.getDisplacement() - 90d) * Math.PI / 180d;

        glTranslated(x, y, z);

        glTranslated(.5d, .5d, .5d);
        EnumFacing facing = getWorld().getBlockState(te.getPos()).getValue(BlockHorizontal.FACING);
        glRotated(facing.getAxis() == EnumFacing.Axis.X ? facing.getOpposite().getHorizontalAngle() : facing.getHorizontalAngle(), 0d, 1d, 0d);
        glTranslated(-.5d, -.5d, -.5d);

        bindTexture(TEXTURE);
        model.topBar.render((float) scale);

        Vec3d vec = new Vec3d(7d * scale, 9d * scale + Math.sin(theta) / 3d, 3d * scale + Math.cos(theta) / 3d);
        glPushMatrix();
        glTranslated(vec.xCoord, vec.yCoord, vec.zCoord);

        model.strikeStick.render((float) scale);
        glPopMatrix();

        glPushMatrix();
        glDisable(GL_TEXTURE_2D);
        glColor4d(1d, 1d, 1d, 1d);

        glBegin(GL_LINES);
        glVertex3d(7d * scale, 15d * scale, 3d * scale);
        glVertex3d(vec.xCoord + 1d * scale, vec.yCoord, vec.zCoord + 2.5d * scale);
        glEnd();

        glBegin(GL_LINES);
        glVertex3d(7d * scale, 15d * scale, 13d * scale);
        glVertex3d(vec.xCoord + 1d * scale, vec.yCoord, vec.zCoord + 8.5d * scale);
        glEnd();

        glEnable(GL_TEXTURE_2D);
        glPopMatrix();

        glPopMatrix();

    }
}
