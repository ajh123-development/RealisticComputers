package uk.minersonline.RealisticComputers;

import com.shinyhut.vernacular.client.VernacularClient;
import com.shinyhut.vernacular.client.VernacularConfig;
import com.shinyhut.vernacular.client.rendering.ColorDepth;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import uk.minersonline.RealisticComputers.utils.ImageUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class VNCSession extends Thread {
	private final VernacularConfig config = new VernacularConfig();
	private final VernacularClient client = new VernacularClient(config);
	private final ServerPlayerEntity player;
	private boolean running = false;

	public VNCSession(ServerPlayerEntity player) {
		this.player = player;
	}

	@Override
	public void run() {
		config.setColorDepth(ColorDepth.BPP_24_TRUE);
		config.setEnableCopyrectEncoding(true);

		config.setScreenUpdateListener(this::sendImage);

		client.start("localhost", 5900);
		running = true;
		while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private void sendImage(Image image) {
		try {
			byte[] imageData = ImageUtils.convertImageToBytes(image);

			PacketByteBuf buf = PacketByteBufs.create();
			buf.writeBytes(imageData);
			ServerPlayNetworking.send(player, ModNetworking.VNC_SCREEN_DATA, buf);
		} catch (IOException e) {
			RealisticComputers.LOGGER.error(
					"An unreachable error occurred whilst rendering screen, in normal circumstances this should not happen.",
					e
			);
		}
	}

	public void end() {
		client.stop();
		running = false;
	}

	public void sendMousePos(int x, int y) {
		client.moveMouse(x, y);
	}

	public void sendMouseClick(int x, int y, int btn, boolean pressed) {
		client.moveMouse(x, y);
		client.updateMouseButton(btn, pressed);
	}

	public void handleKey(KeyEvent event) {
		client.handleKeyEvent(event);
	}
}
