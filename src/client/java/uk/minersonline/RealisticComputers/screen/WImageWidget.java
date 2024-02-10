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
import uk.minersonline.RealisticComputers.RealisticComputers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static uk.minersonline.RealisticComputers.RealisticComputers.MOD_ID;

public class WImageWidget extends WWidget {
	private BufferedImage image = null;

	@Override
	public void paint(DrawContext context, int x, int y, int mouseX, int mouseY) {
		int color = ColorHelper.Argb.getArgb(255, 0, 0, 0);
		if (image != null) {
			Identifier id = makeImage(image);
			ScreenDrawing.texturedRect(context, x, y, getWidth(), getHeight(), new Texture(id), 0xFFFFFFFF);
			MinecraftClient.getInstance().getTextureManager().destroyTexture(id);
		} else {
			ScreenDrawing.coloredRect(context, x, y, width, height, color);
		}
	}

	@Override
	public boolean canResize() {
		return true;
	}

	public void setImage(Image image) {
		if (this.image != null) {
			this.image.flush();
		}
		this.image = (BufferedImage) image;
	}

	public Identifier makeImage(Image awtImage) {
		try {
			// Convert AWT image to BufferedImage
			BufferedImage bufferedImage = new BufferedImage(awtImage.getWidth(null), awtImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			bufferedImage.getGraphics().drawImage(awtImage, 0, 0, null);

			// Convert BufferedImage to byte array
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
			byte[] imageData = byteArrayOutputStream.toByteArray();

			// Convert byte array to InputStream
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageData);

			// Read InputStream into NativeImage
			NativeImage nativeImage = NativeImage.read(byteArrayInputStream);

			// Create a NativeImageBackedTexture
			NativeImageBackedTexture texture = new NativeImageBackedTexture(nativeImage);

			// Get Minecraft client instance
			MinecraftClient client = MinecraftClient.getInstance();

			// Return the image.
			return client.getTextureManager().registerDynamicTexture(MOD_ID+".image", texture);
		} catch (IOException e) {
			CrashReport.create(
				e,
				"An unreachable error occurred whilst rendering screen, in normal circumstances this should not happen."
			);
		}
		return null;
	}
}
