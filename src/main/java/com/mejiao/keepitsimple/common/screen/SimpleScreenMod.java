package com.mejiao.keepitsimple.common.screen;

import com.mejiao.keepitsimple.KeepItSimple;
import com.mejiao.keepitsimple.common.inventory.containers.SimpleBlockContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SimpleScreenMod extends ContainerScreen<SimpleBlockContainer> {
    private final ResourceLocation GUI = new ResourceLocation(KeepItSimple.MOD_ID,
            "textures/gui/generic_54.png");

    public SimpleScreenMod(SimpleBlockContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
       this.renderBackground(matrixStack);
       super.render(matrixStack,mouseX,mouseY,partialTicks);
       this.renderTooltip(matrixStack,mouseX,mouseY);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bind(GUI);
        int i = this.getGuiLeft();
        int j = this.getGuiTop();
        this.blit(matrixStack, i, j, 0, 0, this.getXSize(), this.getYSize());

    }



}
