package uk.minersonline.RealisticComputers;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.math.BlockPos;
import uk.minersonline.RealisticComputers.screen.VNCScreen;

public class RealisticComputersClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(ModNetworking.OPEN_VNC_SCREEN, (client, handler, buf, responseSender) -> {
			BlockPos terminalPosition = buf.readBlockPos();

			client.execute(() -> {
				client.setScreen(new CottonClientScreen(new VNCScreen(client.currentScreen, terminalPosition)));
			});
		});
	}
}