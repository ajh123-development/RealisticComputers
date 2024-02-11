package uk.minersonline.RealisticComputers.utils;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import uk.minersonline.RealisticComputers.RealisticComputers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtils {
	public static Image convertBytesToImage(byte[] imageData) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
		return ImageIO.read(bis);
	}

	public static byte[] convertImageToBytes(Image image) throws IOException {
		BufferedImage bufferedImage = (BufferedImage) image;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", bos);
		return bos.toByteArray();
	}
}
