package uk.minersonline.RealisticComputers.utils;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import uk.minersonline.RealisticComputers.RealisticComputers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static uk.minersonline.RealisticComputers.RealisticComputers.MOD_ID;

public class ClientImageUtils {
	public static Texture convertImageToTexture(Image image) {
		try {
			// Convert AWT image to BufferedImage
			BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			bufferedImage.getGraphics().drawImage(image, 0, 0, null);

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
			Identifier identifier = client.getTextureManager().registerDynamicTexture(MOD_ID+".image", texture);
			return new Texture(identifier);
		} catch (IOException e) {
			RealisticComputers.LOGGER.error(
					"An unreachable error occurred whilst rendering screen, in normal circumstances this should not happen.",
					e
			);
		}
		return null;
	}
}
