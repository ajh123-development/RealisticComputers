package uk.minersonline.RealisticComputers;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.math.BlockPos;
import uk.minersonline.RealisticComputers.screen.VNCScreen;
import uk.minersonline.RealisticComputers.screen.WImageWidget;
import uk.minersonline.RealisticComputers.utils.ClientImageUtils;
import uk.minersonline.RealisticComputers.utils.ImageUtils;

import java.io.IOException;

public class RealisticComputersClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(ModNetworking.OPEN_VNC_SCREEN, (client, handler, buf, responseSender) -> {
			BlockPos terminalPosition = buf.readBlockPos();

			client.execute(() -> {
				client.setScreen(new VNCScreen(client.currentScreen, terminalPosition));
			});
		});

		ClientPlayNetworking.registerGlobalReceiver(ModNetworking.VNC_SCREEN_DATA, (client, handler, buf, responseSender) -> {
			byte[] imageData = new byte[buf.readableBytes()];
			buf.readBytes(imageData);

			client.execute(() -> {
				if (client.currentScreen instanceof VNCScreen screen) {
					try {
						WImageWidget image = screen.getDescription().getImage();
						Texture texture = ClientImageUtils.convertImageToTexture(ImageUtils.convertBytesToImage(imageData));
						image.setImage(texture);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			});
		});
	}
}