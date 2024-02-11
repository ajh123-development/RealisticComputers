package uk.minersonline.RealisticComputers;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;

import static uk.minersonline.RealisticComputers.RealisticComputers.MOD_ID;

public class ModNetworking {
	public static Map<ServerPlayerEntity, BlockPos> openScreens = new HashMap<>();
	public static Map<ServerPlayerEntity, VNCSession> openSessions = new HashMap<>();
	public static final Identifier OPEN_VNC_SCREEN = new Identifier(MOD_ID, "vnc_screen_open");
	public static final Identifier CLOSE_VNC_SCREEN = new Identifier(MOD_ID, "vnc_screen_close");
	public static final Identifier VNC_SCREEN_DATA = new Identifier(MOD_ID, "vnc_screen_data");

	public static void serverInit() {
		ServerPlayNetworking.registerGlobalReceiver(CLOSE_VNC_SCREEN, (server, player, handler, buf, responseSender) -> {
			VNCSession session = openSessions.get(player);
			session.end();
			try {
				session.join();
			} catch (InterruptedException e) {
				RealisticComputers.LOGGER.error("An error occurred whilst closing VNC session.", e);
			}
			openSessions.put(player, null);

			BlockPos terminalPosition = buf.readBlockPos();
			openScreens.put(player, null);
			RealisticComputers.LOGGER.info(player.getDisplayName().getString() + " has closed the vnc terminal at " + terminalPosition);
		});
	}
}
