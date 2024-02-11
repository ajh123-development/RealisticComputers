package uk.minersonline.RealisticComputers.screen;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.math.ColorHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

import static uk.minersonline.RealisticComputers.RealisticComputers.MOD_ID;

public class WImageWidget extends WWidget {
	private Texture image = null;

	@Override
	public void paint(DrawContext context, int x, int y, int mouseX, int mouseY) {
		int color = ColorHelper.Argb.getArgb(255, 0, 0, 0);
		if (image != null) {
			ScreenDrawing.texturedRect(context, x, y, getWidth(), getHeight(), image, 0xFFFFFFFF);
		} else {
			ScreenDrawing.coloredRect(context, x, y, width, height, color);
		}
	}

	@Override
	public boolean canResize() {
		return true;
	}

	public void setImage(Texture image) {
		if (this.image != null) {
			MinecraftClient.getInstance().getTextureManager().destroyTexture(this.image.image());
		}
		this.image = image;
	}
}
